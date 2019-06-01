package net.runelite.mixins;

import api.Actor;
import api.NPC;
import api.Player;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import rs.api.RSActor;
import rs.api.RSClient;
import rs.api.RSHealthBar;
import rs.api.RSHealthBarDefinition;
import rs.api.RSHealthBarUpdate;
import rs.api.RSIterableNodeDeque;
import rs.api.RSNode;

@Mixin(RSActor.class)
public abstract class RSActorMixin implements RSActor
{
	@Shadow("client")
	private static RSClient client;

	@Inject
	@Override
	public Actor getInteracting()
	{
		int index = getRSInteracting();
		if (index == -1 || index == 65535)
		{
			return null;
		}

		if (index < 32768)
		{
			NPC[] npcs = client.getCachedNPCs();
			return npcs[index];
		}

		index -= 32768;
		Player[] players = client.getCachedPlayers();
		return players[index];
	}

	@Inject
	public int getHealthRatio()
	{
		RSIterableNodeDeque healthBars = getHealthBars();
		if (healthBars != null)
		{
			RSNode current = healthBars.getCurrent();
			RSNode next = current.getNext();
			if (next instanceof RSHealthBar)
			{
				RSHealthBar wrapper = (RSHealthBar) next;
				RSIterableNodeDeque updates = wrapper.getUpdates();

				RSNode currentUpdate = updates.getCurrent();
				RSNode nextUpdate = currentUpdate.getNext();
				if (nextUpdate instanceof RSHealthBarUpdate)
				{
					RSHealthBarUpdate update = (RSHealthBarUpdate) nextUpdate;
					return update.getHealthRatio();
				}
			}
		}
		return -1;
	}

	@Inject
	public int getHealth()
	{
		RSIterableNodeDeque healthBars = getHealthBars();
		if (healthBars != null)
		{
			RSNode current = healthBars.getCurrent();
			RSNode next = current.getNext();
			if (next instanceof RSHealthBar)
			{
				RSHealthBar wrapper = (RSHealthBar) next;
				RSHealthBarDefinition definition = wrapper.getDefinition();
				return definition.getHealthScale();
			}
		}
		return -1;
	}
}
