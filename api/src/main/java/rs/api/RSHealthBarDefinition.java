package rs.api;

import api.HealthBar;
import net.runelite.mapping.Import;

public interface RSHealthBarDefinition extends RSDualNode, HealthBar
{
	@Import("healthScale")
	int getHealthScale();

	@Import("getSprite1")
	RSSprite getHealthBarFrontSprite();

	@Import("getSprite2")
	RSSprite getHealthBarBackSprite();

	@Import("widthPadding")
	@Override
	void setPadding(int padding);
}
