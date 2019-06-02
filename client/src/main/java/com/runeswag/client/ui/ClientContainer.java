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

package com.runeswag.client.ui;

import api.NPC;
import api.Node;
import api.Point;
import api.config.Constants;
import api.coords.LocalPoint;
import api.coords.WorldPoint;
import api.events.NpcSpawned;
import rs.api.RSClient;

import javax.annotation.Nullable;
import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ClientContainer extends JPanel
{
	
	public ClientContainer(Applet applet)
	{
		Dimension size = new Dimension(800,600);
		setSize(size);
		setMinimumSize(size);
		setPreferredSize(size);
		setLayout(new BorderLayout());
		setBackground(Color.DARK_GRAY);
		
		if(applet == null)
		{
			return;
		}
		
		applet.setLayout(null);
		applet.setSize(size);
		
		applet.init();
		applet.start();
		
		add(applet, BorderLayout.CENTER);
		
		if(applet instanceof RSClient)
		{
			// make the applet fully redraw every frame
			((RSClient) applet).setGameDrawingMode(2);
		}
	}
	
}
