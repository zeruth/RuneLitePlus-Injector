package net.runelite.mixins;

import api.MessageNode;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import rs.api.RSChatChannel;
import rs.api.RSDualNode;

@Mixin(RSChatChannel.class)
public abstract class RSChatChannelMixin implements RSChatChannel
{
	@Inject
	@Override
	public void removeMessageNode(MessageNode node)
	{
		MessageNode[] lines = getLines();
		final int length = getLength();
		int found = -1;

		// Find the index of the node
		for (int idx = 0; idx < length; idx++)
		{
			if (lines[idx] == node)
			{
				found = idx;
				break;
			}
		}

		if (found == -1)
		{
			return;
		}

		// Shift down all other messages
		for (int i = found; i < length - 1; i++)
		{
			lines[i] = lines[i + 1];
		}
		lines[length - 1] = null;
		setLength(length - 1);

		RSDualNode rsCacheableNode = (RSDualNode) node;
		rsCacheableNode.unlink();
		rsCacheableNode.unlinkDual();
	}
}
