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

import com.runeswag.client.RuneSwag;
import com.runeswag.client.utils.SwingUtils;
import rs.api.RSClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.*;
import java.applet.Applet;
import java.awt.*;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

@Slf4j
@Singleton
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class RuneSwagContainer
{
	
	private final Applet client;
	
	public static ContainableFrame frame;
	
	private JPanel container;
	
	private static final int CLIENT_WELL_HIDDEN_MARGIN = 160;
	private static final int CLIENT_WELL_HIDDEN_MARGIN_TOP = 10;
	
	public void openClient(RuneSwag main) throws Exception
	{
			frame = new ContainableFrame();

			frame.setTitle("RuneSwag");
			frame.getLayeredPane().setCursor(Cursor.getDefaultCursor());
			frame.setLocationRelativeTo(frame.getOwner());
			frame.setResizable(true);

			SwingUtils.setExitCallback(frame, () -> {
				main.shutdown();
			}, () -> true);

			container = new JPanel();
			container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
			container.add(new ClientContainer(client));

			frame.add(container);

			frame.pack();
			frame.revalidateMinimumSize();

			Rectangle clientBounds = frame.getBounds();
			Rectangle screenBounds = frame.getGraphicsConfiguration().getBounds();
			if (clientBounds.x + clientBounds.width - CLIENT_WELL_HIDDEN_MARGIN < screenBounds.getX() ||
					clientBounds.x + CLIENT_WELL_HIDDEN_MARGIN > screenBounds.getX() + screenBounds.getWidth() ||
					clientBounds.y + CLIENT_WELL_HIDDEN_MARGIN_TOP < screenBounds.getY() ||
					clientBounds.y + CLIENT_WELL_HIDDEN_MARGIN > screenBounds.getY() + screenBounds.getHeight())
			{
				frame.setLocationRelativeTo(frame.getOwner());
			}

			frame.setVisible(true);
			frame.toFront();
		
		if (client == null)
		{
			SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(frame,
					"Error loading client! Check your logs for more details.",
					"Unable to load client",
					ERROR_MESSAGE));
			//System.exit(-1);
		}
		else if (!(client instanceof RSClient))
		{
			SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(frame,
					"RuneSwag has not yet been updated to work with the latest\n"
							+ "game update, it work with a reduced feature set.",
					"RuneSwag", INFORMATION_MESSAGE));
			//System.exit(-1);
		}
	}
	
}
