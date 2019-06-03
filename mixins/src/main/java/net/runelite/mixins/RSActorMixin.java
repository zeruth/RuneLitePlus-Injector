package net.runelite.mixins;

import api.Actor;
import api.NPC;
import api.NPCDefinition;
import api.Perspective;
import api.Player;
import api.Point;
import api.Sprite;
import api.coords.LocalPoint;
import api.coords.WorldArea;
import api.coords.WorldPoint;
import api.events.AnimationChanged;
import api.events.SpotAnimationChanged;
import api.events.InteractingChanged;
import api.events.OverheadTextChanged;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import net.runelite.api.mixins.FieldHook;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import rs.api.RSActor;
import rs.api.RSClient;
import rs.api.RSHealthBar;
import rs.api.RSHealthBarDefinition;
import rs.api.RSHealthBarUpdate;
import rs.api.RSIterableNodeDeque;
import rs.api.RSNode;

@Mixin(RSActor.class)
public abstract class RSActorMixin implements RSActor
{

}
