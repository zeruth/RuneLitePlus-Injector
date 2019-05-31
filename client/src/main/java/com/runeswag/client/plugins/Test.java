/*
 * Copyright (c) 2018, https://runelitepl.us
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.runeswag.client.plugins;

import api.Client;
import api.events.ChatMessage;
import api.events.GameTick;
import api.events.VarbitChanged;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Binder;
import javax.inject.Inject;
import javax.inject.Singleton;
import com.runeswag.client.misc.Plugin;
import com.runeswag.client.misc.PluginDescriptor;
import lombok.extern.slf4j.Slf4j;

/**
 * Authors gazivodag longstreet
 */
@PluginDescriptor(
        name = "Test",
        description = "Uses chat messages and tick timers instead of animations to read",
        tags = {"blackjack", "thieving"}
)
@Singleton
@Slf4j
public class Test extends Plugin
{
    private static final String PICKPOCKET = "Pickpocket";
    private static final String KNOCK_OUT = "Knock-out";
    private static final String LURE = "Lure";
    private static final String BANDIT = "Bandit";
    private static final String MENAPHITE = "Menaphite Thug";

    @Inject
    private Client client;

    private int lastKnockout;
    private boolean pickpocketing;
    private boolean ableToBlackJack;

    @Override
    public void configure(Binder binder)
    {
    }

    @Override
    protected void startUp() throws Exception
    {
        System.out.println("Test Plugin started");
    }

    @Override
    protected void shutDown() throws Exception
    {

    }

    @Subscribe
    public void onGameTick(GameTick gameTick)
    {
        System.out.println("Game Tick");
    }

    @Subscribe
    public void onChatMessage(ChatMessage chatMessage)
    {
        System.out.println("Chat Message");
    }

    @Subscribe
    public void onVarbitChanged(VarbitChanged event)
    {
        System.out.println("VarbitChanged");
    }
}