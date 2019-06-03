package rs.api;

import api.WorldMapManager;
import net.runelite.mapping.Import;

public interface RSWorldMapManager extends WorldMapManager
{
	@Import("isLoaded0")
	@Override
	boolean isLoaded();

	@Import("mapSurfaceBaseOffsetX")
	int getSurfaceOffsetX();

	@Import("mapSurfaceBaseOffsetY")
	int getSurfaceOffsetY();

	@Import("getPixelsPerTile")
	float getPixelsPerTile(int graphicsDiff, int worldDiff);
}
