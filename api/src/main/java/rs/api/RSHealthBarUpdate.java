package rs.api;

import net.runelite.mapping.Import;

public interface RSHealthBarUpdate
{
	@Import("health")
	int getHealthRatio();

	//@Import("health")
	//int getHealth();
}
