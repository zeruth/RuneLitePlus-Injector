package rs.api;

import api.Nameable;
import net.runelite.mapping.Import;

public interface RSUser extends Nameable, Comparable
{
	@Import("name")
	RSUsername getRsName();

	@Import("previousUsername")
	RSUsername getRsPrevName();
}
