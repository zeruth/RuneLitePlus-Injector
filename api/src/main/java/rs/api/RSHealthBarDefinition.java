package rs.api;

import net.runelite.mapping.Import;

public interface RSHealthBarDefinition extends RSDualNode
{
	@Import("healthScale")
	int getHealthScale();

	@Import("getSprite1")
	RSSprite getHealthBarFrontSprite();

	@Import("getSprite2")
	RSSprite getHealthBarBackSprite();

	@Import("widthPadding")
	int setWidthPadding(int padding);
}
