package rs.api;

import api.Scene;
import api.Tile;
import net.runelite.mapping.Import;

public interface RSScene extends Scene
{
	@Import("gameObjects")
	RSGameObject[] getObjects();

	@Import("tiles")
	@Override
	RSTile[][][] getTiles();

	@Import("draw")
	void draw(Tile tile, boolean var2);

	@Import("tileHeights")
	int[][][] getTileHeights();

	@Import("drawTile")
	void drawTile(int[] pixels, int pixelOffset, int width, int z, int x, int y);

	@Import("occlude")
	void updateOccluders();

	@Import("xSize")
	int getMaxX();

	@Import("ySize")
	int getMaxY();

	@Import("planes")
	int getMaxZ();

	@Import("minPlane")
	int getMinLevel();
}
