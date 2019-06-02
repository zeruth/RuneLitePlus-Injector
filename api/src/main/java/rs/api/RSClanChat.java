package rs.api;

import net.runelite.mapping.Import;

public interface RSClanChat extends RSUserList<RSClanMate>
{
	@Import("clanOwner")
	String getClanOwner();

	@Import("clanChatName")
	String getClanChatName();
}
