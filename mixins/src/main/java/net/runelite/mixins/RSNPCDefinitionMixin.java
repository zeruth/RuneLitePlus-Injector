package net.runelite.mixins;

import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import rs.api.RSNPCDefinition;

@Mixin(RSNPCDefinition.class)
public abstract class RSNPCDefinitionMixin implements RSNPCDefinition
{

    @Inject
    @Override
    public int[] getConfigs()
    {
        return new int[1];
    }

    @Inject
    @Override
    public int getId()
    {
        return 1;
    }
}
