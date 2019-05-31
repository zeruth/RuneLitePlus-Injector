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

package com.runeswag.client.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@Slf4j
public class WebUtils
{
	
	public static String downloadUrlContent(String url)
	{
		URLConnection conn;
		try
		{
			conn = new URL(url).openConnection();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
			String ret = reader.lines().collect(Collectors.joining("\n"));
			reader.close();
			return ret;
		}
		catch (IOException e)
		{
			log.error("Failed to open URL: {}\n{}", url, e);
			return null;
		}
	}
	
	public static byte[] downloadFile(String url)
	{
		try
		{
			ReadableByteChannel readChannel = Channels.newChannel(new URL(url).openStream());
			ByteArrayOutputStream baos = new ByteArrayOutputStream(1024 * 1024 * 8); // 8mb
			ByteBuffer buf = ByteBuffer.allocate(1024 * 8); // 8k
			WritableByteChannel writeChannel = Channels.newChannel(baos);
			while (readChannel.read(buf) > 0)
			{
				buf.flip();
				writeChannel.write(buf);
				buf.clear();
			}
			return baos.toByteArray();
		}
		catch(IOException e)
		{
			log.error("Failed to open URL: {}\n{}", url, e);
			return null;
		}
	}
}
