/*
 * BSD 2-Clause License
 *
 * Copyright (c) 2019, ThatGamerBlue <thatgamerblue@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 *  Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.runeswag.client.rs;

import com.runeswag.client.utils.WebUtils;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Singleton;
import java.util.Arrays;

@Singleton
@Slf4j
public class JagexConfigLoader
{
	
	private static final String CONFIG_URI = "https://oldschool1.runescape.com/jav_config.ws";
	
	public JagexConfig downloadConfig()
	{
		String configContent = WebUtils.downloadUrlContent(CONFIG_URI);
		
		if (configContent == null)
		{
			return null;
		}
		
		JagexConfig config = new JagexConfig();
		
		for (String line : configContent.split("\n"))
		{
			if (!line.contains("="))
			{
				continue;
			}
			String[] split = line.split("=", 3);
			switch(split[0])
			{
				case "param":
					try
					{
						config.getAppletProps().put(split[1], split[2]);
					}
					catch(ArrayIndexOutOfBoundsException ex)
					{
						config.getAppletProps().put(split[1], "");
					}
				case "msg":
					break;
				default:
					config.getLoaderProps().put(split[0], split[1]);
					break;
			}
		}
		
		return config;
	}
	
}
