package net.runelite.mixins;

import api.NPCDefinition;
import api.Perspective;
import api.coords.LocalPoint;
import api.events.NpcDespawned;
import java.awt.Polygon;
import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.FieldHook;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import rs.api.RSClient;
import rs.api.RSModel;
import rs.api.RSNPC;
import rs.api.RSNPCDefinition;

@Mixin(RSNPC.class)
public abstract class RSNPCMixin implements RSNPC
{
}
