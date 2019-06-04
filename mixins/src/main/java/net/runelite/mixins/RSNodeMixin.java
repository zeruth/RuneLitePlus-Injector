package net.runelite.mixins;

import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.MethodHook;
import net.runelite.api.mixins.Mixin;
import rs.api.RSNode;

@Mixin(RSNode.class)
public abstract class RSNodeMixin implements RSNode
{
	@Inject
	public void onUnlink()
	{
	}

	@Inject
	@MethodHook("unlink")
	public void rl$unlink()
	{
		onUnlink();
	}
}