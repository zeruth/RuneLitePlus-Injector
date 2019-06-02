package net.runelite.mixins;

import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import rs.api.RSFriend;
import rs.api.RSUsername;

@Mixin(RSFriend.class)
public abstract class RSFriendMixin implements RSFriend
{
	@Override
	@Inject
	public String getName()
	{
		return getRsName().getName();
	}

	@Override
	@Inject
	public String getPrevName()
	{
		RSUsername prevName = getRsPrevName();
		return prevName == null ? null : prevName.getName();
	}
}
