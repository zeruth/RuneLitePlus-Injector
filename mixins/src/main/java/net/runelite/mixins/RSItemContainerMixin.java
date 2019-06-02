package net.runelite.mixins;

import api.Item;
import api.events.ItemContainerChanged;
import net.runelite.api.mixins.FieldHook;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import rs.api.RSClient;
import rs.api.RSGroundItem;
import rs.api.RSItemContainer;

@Mixin(RSItemContainer.class)
public abstract class RSItemContainerMixin implements RSItemContainer
{
	@Shadow("client")
	private static RSClient client;

	@Inject
	private int rl$lastCycle;

	@Inject
	@Override
	public Item[] getItems()
	{
		int[] itemIds = getItemIds();
		int[] stackSizes = getStackSizes();
		Item[] items = new Item[itemIds.length];

		for (int i = 0; i < itemIds.length; ++i)
		{
			RSGroundItem item = client.createItem();
			item.setId(itemIds[i]);
			item.setQuantity(stackSizes[i]);
			items[i] = item;
		}

		return items;
	}

	@FieldHook("quantities")
	@Inject
	public void stackSizesChanged(int idx)
	{
		int cycle = client.getGameCycle();
		if (rl$lastCycle == cycle)
		{
			// Limit item container updates to one per cycle
			return;
		}

		rl$lastCycle = cycle;

		ItemContainerChanged event = new ItemContainerChanged(this);
		client.getCallbacks().postDeferred(event);
	}

}
