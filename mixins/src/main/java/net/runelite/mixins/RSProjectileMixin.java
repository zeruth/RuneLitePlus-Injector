package net.runelite.mixins;

import api.Actor;
import api.coords.LocalPoint;
import api.events.ProjectileMoved;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.MethodHook;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import rs.api.RSClient;
import rs.api.RSNPC;
import rs.api.RSPlayer;
import rs.api.RSProjectile;

@Mixin(RSProjectile.class)
public abstract class RSProjectileMixin implements RSProjectile
{
	@Shadow("client")
	private static RSClient client;

	@Inject
	@Override
	public int getRemainingCycles()
	{
		int currentGameCycle = client.getGameCycle();

		return getEndCycle() - currentGameCycle;
	}

	@Inject
	@Override
	public Actor getInteracting()
	{
		int interactingIndex = getRsInteracting();
		if (interactingIndex == 0)
		{
			return null;
		}

		if (interactingIndex > 0)
		{
			int idx = interactingIndex - 1;
			RSNPC[] npcs = client.getCachedNPCs();
			return npcs[idx];
		}
		else
		{
			int idx = -interactingIndex - 1;

			if (idx == client.getLocalInteractingIndex())
			{
				return client.getLocalPlayer();
			}

			RSPlayer[] players = client.getCachedPlayers();
			return players[idx];
		}
	}

	/**
	 * Called when a projectile is set to move towards a point. For
	 * projectiles that target the ground, like AoE projectiles from
	 * Lizardman Shamans, this is only called once
	 *
	 * @param targetX X position of where the projectile is being moved to
	 * @param targetY Y position of where the projectile is being moved to
	 * @param targetZ Z position of where the projectile is being moved to
	 * @param cycle
	 */
	@Inject
	@MethodHook("setDestination")
	public void projectileMoved(int targetX, int targetY, int targetZ, int cycle)
	{
		final LocalPoint position = new LocalPoint(targetX, targetY);
		final ProjectileMoved projectileMoved = new ProjectileMoved();
		projectileMoved.setProjectile(this);
		projectileMoved.setPosition(position);
		projectileMoved.setZ(targetZ);
		client.getCallbacks().post(projectileMoved);
	}
}
