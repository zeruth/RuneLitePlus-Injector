/*
 * RuneLitePlus
 * Copyright (C) 2019 runelite-extended
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.runeswag.client;

import api.Client;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.runeswag.client.config.ConfigManager;
import com.runeswag.client.events.EventBus;
import com.runeswag.client.misc.PluginManager;
import com.runeswag.client.ui.ClientUI;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Nullable;
import java.io.File;
import java.util.Locale;

@Slf4j
public class RuneLitePlus
{

	public static final File RUNESWAG_DIR = new File(System.getProperty("user.home"), ".runeliteplus");
	public static final File PROFILES_DIR = new File(RUNESWAG_DIR, "profiles");
	public static final File PLUGIN_DIR = new File(RUNESWAG_DIR, "plugins");
	static final RuneLitePlusProperties RUNE_LITE_PLUS_PROPERTIES = new RuneLitePlusProperties();
	
	@Getter
	private static Injector injector;

	@Inject
	@Nullable
	private Client client;

	@Inject
	private ClientUI clientUI;
	
	@Inject
	private ConfigManager configManager;

	@Inject
	private PluginManager c;
	
	@Inject
	public static EventBus eventBus;
	
	@Inject
	private PluginManager pluginManager;
	
	public static void main(String[] args) throws Exception
	{
		Locale.setDefault(Locale.ENGLISH);

		PROFILES_DIR.mkdirs();
		
		OptionParser optionParser = new OptionParser();
		
		optionParser.accepts("dev-mode", "Enable developer mode (extra tools)");
		optionParser.accepts("redownload-gamepack", "Redownload the gamepack (dev mode only)");
		
		OptionSet options = optionParser.parse(args);
		
		boolean devMode = options.has("dev-mode");
		boolean redownloadGamepack = options.has("redownload-gamepack") && devMode;
		
		Thread.setDefaultUncaughtExceptionHandler((thread, throwable) ->
		{
			log.error("Uncaught exception:", throwable);
			if (throwable instanceof AbstractMethodError)
			{
				log.error("Classes are out of date; I need to fix this shit.");
			}
		});

		injector = Guice.createInjector(new RuneLitePlusModule(true));
		
		injector.getInstance(RuneLitePlus.class).startClient();
		injector.getInstance(RuneLitePlus.class).pluginManager.loadCorePlugins();
	}
	
	private void startClient() throws Exception
	{
		boolean outdated = client == null;
		
		if(!outdated)
		{
			injector.injectMembers(client);
		}
		else
		{
			log.error("Client outdated!");
		}
		
		configManager.load();

		pluginManager.loadCorePlugins();
		pluginManager.startCorePlugins();
		
		clientUI.open(this);
	}
	
	public void shutdown()
	{
	
	}
	
}
