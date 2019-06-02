package rs.api;

import api.NPCDefinition;
import net.runelite.mapping.Import;

public interface RSNPCDefinition extends NPCDefinition
{
	@Import("transform")
	@Override
	RSNPCDefinition transform();

	@Import("configs")
	@Override
	int[] getConfigs();
}
