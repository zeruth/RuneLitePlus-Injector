package net.runelite.mixins;

import api.NPCDefinition;
import api.Perspective;
import api.coords.LocalPoint;
import api.events.NpcDespawned;
import java.awt.Polygon;
import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.FieldHook;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import rs.api.RSClient;
import rs.api.RSModel;
import rs.api.RSNPC;
import rs.api.RSNPCDefinition;

@Mixin(RSNPC.class)
public abstract class RSNPCMixin implements RSNPC
{
	@Shadow("client")
	private static RSClient client;

	@Inject
	private int npcIndex;

	@Inject
	private boolean dead;

	@Inject
	@Override
	public int getId()
	{
		RSNPCDefinition composition = getDefinition();
		if (composition != null && composition.getConfigs() != null)
		{
			composition = composition.transform();
		}
		return composition == null ? -1 : composition.getId();
	}

	@Inject
	@Override
	public String getName()
	{
		RSNPCDefinition composition = getDefinition();
		if (composition != null && composition.getConfigs() != null)
		{
			composition = composition.transform();
		}
		return composition == null ? null : composition.getName().replace('\u00A0', ' ');
	}

	@Inject
	@Override
	public int getCombatLevel()
	{
		RSNPCDefinition composition = getDefinition();
		if (composition != null && composition.getConfigs() != null)
		{
			composition = composition.transform();
		}
		return composition == null ? -1 : composition.getCombatLevel();
	}

	@Inject
	@Override
	public int getIndex()
	{
		return npcIndex;
	}

	@Inject
	@Override
	public void setIndex(int id)
	{
		npcIndex = id;
	}

	@FieldHook(value = "definition", before = true)
	@Inject
	public void onCompositionChanged(RSNPCDefinition composition)
	{
		if (composition == null)
		{
			client.getCallbacks().post(new NpcDespawned(this));
		}
	}

	/*@Copy("getModel")
	public abstract RSModel rs$getModel();

	@Replace("getModel")
	public RSModel rl$getModel()
	{
		if (!client.isInterpolateNpcAnimations()
			|| getAnimation() == AnimationID.HELLHOUND_DEFENCE)
		{
			return rs$getModel();
		}
		int actionFrame = getActionFrame();
		int poseFrame = getPoseFrame();
		int spotAnimFrame = getSpotAnimFrame();
		try
		{
			// combine the frames with the frame cycle so we can access this information in the sequence methods
			// without having to change method calls
			setActionFrame(Integer.MIN_VALUE | getActionFrameCycle() << 16 | actionFrame);
			setPoseFrame(Integer.MIN_VALUE | getPoseFrameCycle() << 16 | poseFrame);
			setSpotAnimFrame(Integer.MIN_VALUE | getSpotAnimFrameCycle() << 16 | spotAnimFrame);
			return rs$getModel();
		}
		finally
		{
			// reset frames
			setActionFrame(actionFrame);
			setPoseFrame(poseFrame);
			setSpotAnimFrame(spotAnimFrame);
		}
	}*/

	@Inject
	@Override
	public NPCDefinition getTransformedDefinition()
	{
		RSNPCDefinition composition = getDefinition();
		if (composition != null && composition.getConfigs() != null)
		{
			composition = composition.transform();
		}
		return composition;
	}

	@Inject
	@Override
	public boolean isDead()
	{
		return dead;
	}

	@Inject
	@Override
	public void setDead(boolean dead)
	{
		this.dead = dead;
	}

	@Inject
	@Override
	public Polygon getConvexHull()
	{
		RSModel model = getModel();
		if (model == null)
		{
			return null;
		}

		int size = getDefinition().getSize();
		LocalPoint tileHeightPoint = new LocalPoint(
			size * Perspective.LOCAL_HALF_TILE_SIZE - Perspective.LOCAL_HALF_TILE_SIZE + getX(),
			size * Perspective.LOCAL_HALF_TILE_SIZE - Perspective.LOCAL_HALF_TILE_SIZE + getY());

		int tileHeight = Perspective.getTileHeight(client, tileHeightPoint, client.getPlane());
		return model.getConvexHull(getX(), getY(), getOrientation(), tileHeight);
	}
}
