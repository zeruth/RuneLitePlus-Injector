package net.runelite.mixins;

import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.FieldHook;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import rs.api.RSClient;
import rs.api.RSDynamicObject;
import rs.api.RSModel;

@Mixin(RSDynamicObject.class)
public abstract class RSDynamicObjectMixin implements RSDynamicObject
{
	@Shadow("client")
	private static RSClient client;

	@Copy("getModel")
	public abstract RSModel rs$getModel();

	@Replace("getModel")
	public RSModel rl$getModel()
	{
		try
		{
			// reset frame because it may have been set from the constructor
			// it should be set again inside the getModel method
			int animFrame = getAnimFrame();
			if (animFrame < 0)
			{
				setAnimFrame((animFrame ^ Integer.MIN_VALUE) & 0xFFFF);
			}
			return rs$getModel();
		}
		finally
		{
			int animFrame = getAnimFrame();
			if (animFrame < 0)
			{
				setAnimFrame((animFrame ^ Integer.MIN_VALUE) & 0xFFFF);
			}
		}
	}

	@FieldHook("cycleStart")
	@Inject
	public void onAnimCycleCountChanged(int idx)
	{
		if (client.isInterpolateObjectAnimations())
		{
			// sets the packed anim frame with the frame cycle
			int objectFrameCycle = client.getGameCycle() - getAnimCycleCount();
			setAnimFrame(Integer.MIN_VALUE | objectFrameCycle << 16 | getAnimFrame());
		}
	}
}
