package rs.api;

import net.runelite.mapping.Import;

public interface RSHealthBar extends RSNode
{
	@Import("definition")
	RSHealthBarDefinition getDefinition();

	@Import("updates")
	RSIterableNodeDeque getUpdates();
}
