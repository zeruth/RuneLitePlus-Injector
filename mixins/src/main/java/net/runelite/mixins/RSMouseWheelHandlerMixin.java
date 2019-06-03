package net.runelite.mixins;

import java.awt.event.MouseWheelEvent;
import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import rs.api.RSClient;
import rs.api.RSMouseWheelHandler;

@Mixin(RSMouseWheelHandler.class)
public abstract class RSMouseWheelHandlerMixin implements RSMouseWheelHandler
{
	@Shadow("client")
	private static RSClient client;

	@Copy("mouseWheelMoved")
	abstract void rs$mouseWheelMoved(MouseWheelEvent event);

	@Override
	@Replace("mouseWheelMoved")
	public void mouseWheelMoved(MouseWheelEvent event)
	{
		event = client.getCallbacks().mouseWheelMoved(event);
		if (!event.isConsumed())
		{
			rs$mouseWheelMoved(event);
		}
	}
}