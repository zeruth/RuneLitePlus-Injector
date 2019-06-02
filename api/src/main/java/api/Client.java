/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package api;

import api.widgets.Widget;
import callbacks.Callbacks;
import callbacks.DrawCallbacks;

import java.awt.*;
import java.awt.Point;
import java.util.Map;


/**
 * Represents the RuneScape client.
 */
public interface Client extends GameShell
{
	/**
	 * The client invokes these callbacks to communicate to
	 */
	Callbacks getCallbacks();

	DrawCallbacks getDrawCallbacks();

	int getTickCount();

	void setTickCount(int tickCount);

	BufferProvider getBufferProvider();

	Dimension getRealDimensions();

	Widget getWidget(WidgetInfo widget);

	GameState getGameState();

	int getGameCycle();

	Point getMouseCanvasPosition();

	boolean isMenuOpen();

	MenuEntry[] getMenuEntries();

	void setMenuEntries(MenuEntry[] menuEntries);

	Widget getViewportWidget();

	int getViewportXOffset();

	int getViewportYOffset();

	int getViewportWidth();

	int getViewportHeight();

	boolean isResized();

	void setGameDrawingMode(int mode);

	Player getLocalPlayer();

	int getMapAngle();

	int getCameraX();

	int getCameraY();

	int getCameraZ();

	int getCameraPitch();

	int getCameraYaw();

	int getScale();

	int getPlane();

	byte[][][] getTileSettings();

	int[][][] getTileHeights();

	int getVar(VarPlayer varPlayer);

	int getVar(Varbits varbit);

	int getVar(VarClientInt varClientInt);

	String getVar(VarClientStr varClientStr);

	int getBaseX();

	int getBaseY();

	boolean isInInstancedRegion();

	int[][][] getInstanceTemplateChunks();

	CollisionData[] getCollisionMaps();

	api.Scene getScene();

	Sprite createSpritePixels(int[] pixels, int width, int height);

	IndexedSprite createIndexedSprite();

	ItemContainer getItemContainer(InventoryID id);

	NPC[] getCachedNPCs();

	Player[] getCachedPlayers();

	RenderOverview getRenderOverview();

	boolean isFriended(String name, boolean mustBeLoggedIn);

	int getStringStackSize();

	void setStringStackSize(int stackSize);

	String[] getStringStack();

	void addChatMessage(ChatMessageType type, String name, String message, String sender);

	Map<Integer, ChatLineBuffer> getChatLineMap();

	void refreshChat();

	int getBuildID();

	boolean isInterpolatePlayerAnimations();

	@Override
	Canvas getCanvas();
}
