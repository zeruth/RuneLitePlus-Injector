package net.runelite.mixins;

import api.Perspective;
import api.Point;
import api.coords.Angle;
import api.coords.LocalPoint;
import java.awt.Polygon;
import java.awt.geom.Area;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import rs.api.RSClient;
import rs.api.RSEntity;
import rs.api.RSGameObject;
import rs.api.RSModel;

@Mixin(RSGameObject.class)
public abstract class RSGameObjectMixin implements RSGameObject
{
	@Shadow("client")
	private static RSClient client;

	@Inject
	@Override
	public Point getSceneMinLocation()
	{
		return new Point(getRelativeX(), getRelativeY());
	}

	@Inject
	@Override
	public Point getSceneMaxLocation()
	{
		return new Point(getOffsetX(), getOffsetY());
	}

	@Inject
	private RSModel getModel()
	{
		RSEntity renderable = getRenderable();
		if (renderable == null)
		{
			return null;
		}

		if (renderable instanceof RSModel)
		{
			return (RSModel) renderable;
		}
		else
		{
			return renderable.getModel();
		}
	}

	@Inject
	@Override
	public Area getClickbox()
	{
		return Perspective.getClickbox(client, getModel(), getRsOrientation(), getLocalLocation());
	}

	@Inject
	@Override
	public Polygon getConvexHull()
	{
		RSModel model = getModel();

		if (model == null)
		{
			return null;
		}

		int tileHeight = Perspective.getTileHeight(client, new LocalPoint(getX(), getY()), client.getPlane());
		return model.getConvexHull(getX(), getY(), getRsOrientation(), tileHeight);
	}

	@Override
	@Inject
	public Angle getOrientation()
	{
		int orientation = getRsOrientation();
		int rotation = (getFlags() >> 6) & 3;
		return new Angle(rotation * 512 + orientation);
	}
}