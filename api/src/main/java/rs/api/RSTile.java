package rs.api;

import api.DecorativeObject;
import api.GameObject;
import api.GroundObject;
import api.ItemLayer;
import api.SceneTileModel;
import api.SceneTilePaint;
import api.Tile;
import api.WallObject;
import net.runelite.mapping.Import;

public interface RSTile extends Tile
{
	@Import("gameObjects")
	@Override
	GameObject[] getGameObjects();

	@Import("groundItemPile")
	@Override
	ItemLayer getItemLayer();

	@Import("decorativeObject")
	@Override
	DecorativeObject getDecorativeObject();

	@Import("floorDecoration")
	@Override
	GroundObject getGroundObject();

	@Import("wallObject")
	@Override
	WallObject getWallObject();

	@Import("paint")
	@Override
	SceneTilePaint getSceneTilePaint();

	@Import("overlay")
	@Override
	SceneTileModel getSceneTileModel();

	@Import("x")
	int getX();

	@Import("y")
	int getY();

	@Import("plane")
	@Override
	int getPlane();

	@Import("renderLevel")
	@Override
	int getRenderLevel();

	@Import("physicalLevel")
	int getPhysicalLevel();

	@Import("flags")
	int getFlags();

	@Import("bridge")
	@Override
	RSTile getBridge();

	@Import("draw")
	boolean isDraw();

	@Import("draw")
	void setDraw(boolean draw);

	@Import("visible")
	boolean isVisible();

	@Import("visible")
	void setVisible(boolean visible);

	@Import("drawEntities")
	void setDrawEntities(boolean drawEntities);

	@Import("wallCullDirection")
	void setWallCullDirection(int wallCullDirection);
}
