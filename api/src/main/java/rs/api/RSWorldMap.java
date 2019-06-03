package rs.api;

import api.RenderOverview;
import net.runelite.mapping.Import;

public interface RSWorldMap extends RenderOverview
{
	// TODO: FIX THIS
	@Import("worldMapX")
	int getWorldMapX();

	@Import("worldMapY")
	int getWorldMapY();

	@Import("zoomTarget")
	float getWorldMapZoom();

	@Import("worldMapTargetX")
	int getWorldMapTargetX();

	@Import("worldMapTargetY")
	int getWorldMapTargetY();

	@Import("worldMapDisplayWidth")
	int getWorldMapDisplayWidth();

	@Import("worldMapDisplayHeight")
	int getWorldMapDisplayHeight();

	@Import("worldMapDisplayX")
	int getWorldMapDisplayX();

	@Import("worldMapDisplayY")
	int getWorldMapDisplayY();

	@Import("setWorldMapPosition")
	void setWorldMapPosition(int worldMapX, int worldMapY, boolean changedSurface);

	@Import("setWorldMapPositionTargetWorldPoint")
	void setWorldMapPositionTarget(int worldPointX, int worldPointY);

	@Import("worldMapManager")
	@Override
	RSWorldMapManager getWorldMapManager();

	@Import("initializeWorldMap")
	@Override
	void initializeWorldMap(WorldMapData var1);

	@Import("worldMapData")
	@Override
	RSWorldMapData getWorldMapData();
}
