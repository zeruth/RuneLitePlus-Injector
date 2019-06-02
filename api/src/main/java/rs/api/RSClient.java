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

package rs.api;

import api.Client;
import api.Sprite;
import api.widgets.Widget;
import java.util.Map;
import net.runelite.mapping.Construct;
import net.runelite.mapping.Import;

public interface RSClient extends RSGameShell, Client
{
	@Import("cameraX")
	@Override
	int getCameraX();

	@Import("cameraZ") // <--- This is correct!
	@Override
	int getCameraY();

	@Import("cameraY") // <--- This is correct!
	@Override
	int getCameraZ();

	@Import("Scene_cameraX")
	@Override
	int getCameraX2();

	@Import("Scene_cameraY")
	@Override
	int getCameraY2();

	@Import("Scene_cameraZ")
	@Override
	int getCameraZ2();

	@Import("plane")
	@Override
	int getPlane();

	@Import("cameraPitch")
	@Override
	int getCameraPitch();

	@Import("cameraPitch")
	void setCameraPitch(int cameraPitch);

	@Import("cameraYaw")
	@Override
	int getCameraYaw();

	@Import("worldId")
	int getWorld();

	@Import("fps")
	@Override
	int getFPS();

	@Import("minimapOrientation")
	@Override
	int getMapAngle();

	@Import("Tiles_heights")
	@Override
	int[][][] getTileHeights();

	@Import("Tiles_renderFlags")
	@Override
	byte[][][] getTileSettings();

	@Import("Varps_main")
	@Override
	int[] getVarps();

	@Import("varcs")
	RSVarcs getVarcs();

	@Import("runEnergy")
	@Override
	int getEnergy();

	@Import("weight")
	@Override
	int getWeight();

	@Import("baseX")
	@Override
	int getBaseX();

	@Import("baseY")
	@Override
	int getBaseY();

	@Import("currentLevels")
	@Override
	int[] getBoostedSkillLevels();

	@Import("levels")
	@Override
	int[] getRealSkillLevels();

	@Import("experience")
	@Override
	int[] getSkillExperiences();

	@Import("changedSkills")
	int[] getChangedSkills();

	@Import("changedSkillsCount")
	int getChangedSkillsCount();

	@Import("changedSkillsCount")
	void setChangedSkillsCount(int i);

	@Import("gameState")
	int getRSGameState();

	@Import("checkClick")
	@Override
	void setCheckClick(boolean checkClick);

	@Import("Scene_selectedScreenX")
	void setMouseCanvasHoverPositionX(int x);

	@Import("Scene_selectedScreenY")
	void setMouseCanvasHoverPositionY(int y);

	@Import("MouseHandler_currentButton")
	@Override
	int getMouseCurrentButton();

	@Import("Scene_selectedX")
	int getSelectedSceneTileX();

	@Import("Scene_selectedX")
	void setSelectedSceneTileX(int selectedSceneTileX);

	@Import("Scene_selectedY")
	int getSelectedSceneTileY();

	@Import("Scene_selectedY")
	void setSelectedSceneTileY(int selectedSceneTileY);

	@Import("isDraggingWidget")
	@Override
	boolean isDraggingWidget();

	@Import("clickedWidget")
	@Override
	RSWidget getDraggedWidget();

	@Import("draggedOnWidget")
	@Override
	RSWidget getDraggedOnWidget();

	@Import("draggedOnWidget")
	@Override
	void setDraggedOnWidget(Widget widget);

	@Import("widgets")
	RSWidget[][] getWidgets();

	/**
	 * Gets an array of widgets that correspond to the passed group ID.
	 *
	 * @param groupId the group ID
	 * @return the widget group
	 * @see api.widgets.WidgetID
	 */
	RSWidget[] getGroup(int groupId);

	@Import("scene")
	@Override
	RSScene getScene();

	@Import("localPlayer")
	@Override
	RSPlayer getLocalPlayer();

	@Import("npcCount")
	int getNpcIndexesCount();

	@Import("npcIndices")
	int[] getNpcIndices();

	@Import("npcs")
	@Override
	RSNPC[] getCachedNPCs();

	@Import("collisionMaps")
	RSCollisionMap[] getCollisionMaps();

	@Import("Players_count")
	int getPlayerIndexesCount();

	@Import("Players_indices")
	int[] getPlayerIndices();

	@Import("players")
	@Override
	RSPlayer[] getCachedPlayers();

	@Import("combatTargetPlayerIndex")
	int getLocalInteractingIndex();

	@Import("groundItems")
	RSNodeDeque[][][] getGroundItemDeque();

	@Import("projectiles")
	RSNodeDeque getProjectilesDeque();

	@Import("graphicsObjects")
	RSNodeDeque getGraphicsObjectDeque();

	@Import("Login_username")
	@Override
	String getUsername();

	@Import("Login_username")
	@Override
	void setUsername(String username);

	@Import("Login_password")
	@Override
	void setPassword(String password);

	@Import("currentLoginField")
	@Override
	int getCurrentLoginField();

	@Import("playerMenuActions")
	@Override
	String[] getPlayerOptions();

	@Import("playerOptionsPriorities")
	@Override
	boolean[] getPlayerOptionsPriorities();

	@Import("playerMenuOpcodes")
	@Override
	int[] getPlayerMenuTypes();

	@Import("MouseHandler_x0")
	int getMouseX();

	@Import("MouseHandler_y0")
	int getMouseY();

	@Import("Scene_selectedScreenX")
	int getMouseX2();

	@Import("Scene_selectedScreenY")
	int getMouseY2();

	@Import("containsBounds")
	boolean containsBounds(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7);

	@Import("checkClick")
	boolean isCheckClick();

	@Import("menuOptionsCount")
	int getMenuOptionCount();

	@Import("menuOptionsCount")
	void setMenuOptionCount(int menuOptionCount);

	@Import("menuActions")
	String[] getMenuOptions();

	@Import("menuTargetNames")
	String[] getMenuTargets();

	@Import("menuArguments0")
	int[] getMenuIdentifiers();

	@Import("menuOpcodes")
	int[] getMenuTypes();

	@Import("menuArguments1")
	int[] getMenuActionParams0();

	@Import("menuArguments2")
	int[] getMenuActionParams1();

	@Import("menuShiftClick")
	boolean[] getMenuForceLeftClick();

	@Import("worlds")
	@Override
	RSWorld[] getWorldList();

	@Import("addMessage")
	void addChatMessage(int type, String name, String message, String sender);

	@Override
	@Import("getObjectDefinition")
	RSObjectDefinition getObjectDefinition(int objectId);

	@Override
	@Import("getNpcDefinition")
	RSNPCDefinition getNpcDefinition(int npcId);

	@Import("viewportZoom")
	@Override
	int getScale();

	@Import("canvasHeight")
	@Override
	int getCanvasHeight();

	@Import("canvasWidth")
	@Override
	int getCanvasWidth();

	@Import("viewportHeight")
	@Override
	int getViewportHeight();

	@Import("viewportWidth")
	@Override
	int getViewportWidth();

	@Import("viewportOffsetX")
	@Override
	int getViewportXOffset();

	@Import("viewportOffsetY")
	@Override
	int getViewportYOffset();

	@Import("isResizable")
	@Override
	boolean isResized();

	@Import("rootWidgetXs")
	@Override
	int[] getWidgetPositionsX();

	@Import("rootWidgetYs")
	@Override
	int[] getWidgetPositionsY();

	@Import("itemContainers")
	RSNodeHashTable getItemContainers();

	@Import("getItemDefinition")
	@Override
	RSItemDefinition getItemDefinition(int itemId);

	@Import("getItemSprite")
	RSSprite createItemSprite(int itemId, int quantity, int thickness, int borderColor, int stackable, boolean noted);

	@Import("menuAction")
	@Override
	void invokeMenuAction(int n2, int n3, int n4, int n5, String string, String string2, int n6, int n7);

	@Import("decodeSprite")
	void decodeSprite(byte[] data);

	@Import("indexedSpriteCount")
	int getIndexedSpriteCount();

	@Import("indexedSpriteWidth")
	int getIndexedSpriteWidth();

	@Import("indexedSpriteHeight")
	int getIndexedSpriteHeight();

	@Import("indexedSpriteOffsetXs")
	int[] getIndexedSpriteOffsetXs();

	@Import("indexedSpriteOffsetXs")
	void setIndexedSpriteOffsetXs(int[] indexedSpriteOffsetXs);

	@Import("indexedSpriteOffsetYs")
	int[] getIndexedSpriteOffsetYs();

	@Import("indexedSpriteOffsetYs")
	void setIndexedSpriteOffsetYs(int[] indexedSpriteOffsetYs);

	@Import("indexedSpriteWidths")
	int[] getIndexedSpriteWidths();

	@Import("indexedSpriteWidths")
	void setIndexedSpriteWidths(int[] indexedSpriteWidths);

	@Import("indexedSpriteHeights")
	int[] getIndexedSpriteHeights();

	@Import("indexedSpriteHeights")
	void setIndexedSpriteHeights(int[] indexedSpriteHeights);

	@Import("spritePixels")
	byte[][] getSpritePixels();

	@Import("spritePixels")
	void setSpritePixels(byte[][] spritePixels);

	@Import("indexedSpritePalette")
	int[] getIndexedSpritePalette();

	@Import("indexedSpritePalette")
	void setIndexedSpritePalette(int[] indexedSpritePalette);

	@Import("indexCache8")
	@Override
	RSAbstractIndexCache getIndexSprites();

	@Import("indexCache12")
	@Override
	RSAbstractIndexCache getIndexScripts();

	@Import("widgetClickMasks")
	@Override
	RSNodeHashTable getWidgetFlags();

	@Import("widgetGroupParents")
	@Override
	RSNodeHashTable getComponentTable();

	@Import("grandExchangeOffers")
	RSGrandExchangeOffer[] getGrandExchangeOffers();

	@Import("isMenuOpen")
	@Override
	boolean isMenuOpen();

	@Import("cycle")
	@Override
	int getGameCycle();

	// unused
	//@Import("packetHandler")
	//void packetHandler();

	@Import("Messages_channels")
	@Override
	Map getChatLineMap();

	@Import("messages")
	@Override
	RSIterableNodeHashTable getMessages();

	@Import("revision")
	@Override
	int getRevision();

	@Import("regions")
	@Override
	int[] getMapRegions();

	@Import("instanceChunkTemplates")
	@Override
	int[][][] getInstanceTemplateChunks();

	@Import("xteaKeys")
	@Override
	int[][] getXteaKeys();

	@Import("gameDrawingMode")
	@Override
	int getGameDrawingMode();

	@Import("gameDrawingMode")
	@Override
	void setGameDrawingMode(int gameDrawingMode);

	@Import("cycleCntr")
	int getCycleCntr();

	@Import("chatCycle")
	void setChatCycle(int value);

	/**
	 * Get the widget top group. widgets[topGroup] contains widgets with
	 * parentId -1, which are the widget roots.
	 *
	 * @return
	 */
	@Import("rootWidgetGroup")
	int getWidgetRoot();
// ----------------------------------------------------------------------------
	@Import("mapElementConfigs")
	@Override
	RSMapElementConfig[] getMapElementConfigs();

	@Import("mapscene")
	@Override
	RSIndexedSprite[] getMapScene();

	@Import("mapIcons")
	@Override
	RSSprite[] getMapIcons();

	@Import("mapDots")
	RSSprite[] getMapDots();

	@Import("modIcons")
	@Override
	RSIndexedSprite[] getModIcons();

	@Import("modIcons")
	void setRSModIcons(RSIndexedSprite[] modIcons);

	@Construct
	@Override
	RSIndexedSprite createIndexedSprite();

	@Construct
	@Override
	RSSprite createSpritePixels(int[] pixels, int width, int height);

	@Import("destinationX")
	int getDestinationX();

	@Import("destinationY")
	int getDestinationY();

	@Import("audioEffects")
	RSSoundEffect[] getAudioEffects();

	@Import("queuedSoundEffectIDs")
	int[] getQueuedSoundEffectIDs();

	@Import("soundLocations")
	int[] getSoundLocations();

	@Import("unknownSoundValues1")
	int[] getUnknownSoundValues1();

	@Import("queuedSoundEffectDelays")
	int[] getQueuedSoundEffectDelays();

	@Import("queuedSoundEffectCount")
	int getQueuedSoundEffectCount();

	@Import("queuedSoundEffectCount")
	void setQueuedSoundEffectCount(int queuedSoundEffectCount);

	@Import("rasterProvider")
	@Override
	RSBufferProvider getBufferProvider();

	@Import("mouseIdleTicks")
	@Override
	int getMouseIdleTicks();

	@Import("mouseLastPressedTimeMillis")
	@Override
	long getMouseLastPressedMillis();

	@Import("keyboardIdleTicks")
	@Override
	int getKeyboardIdleTicks();

	@Import("lowMemory")
	void setLowMemory(boolean lowMemory);

	@Import("sceneLowMemory")
	void setSceneLowMemory(boolean lowMemory);

	@Import("audioHighMemory")
	void setAudioHighMemory(boolean highMemory);

	@Import("objectDefinitionLowDetail")
	void setObjectDefinitionLowDetail(boolean lowDetail);

	@Construct
	RSItem createItem();

	@Import("intStackSize")
	@Override
	int getIntStackSize();

	@Import("intStackSize")
	@Override
	void setIntStackSize(int stackSize);

	@Import("intStack")
	@Override
	int[] getIntStack();

	@Import("scriptStringStackSize")
	@Override
	int getStringStackSize();

	@Import("scriptStringStackSize")
	@Override
	void setStringStackSize(int stackSize);

	@Import("scriptStringStack")
	@Override
	String[] getStringStack();

	@Import("friendManager")
	RSFriendManager getFriendManager();

	@Import("clanMemberManager")
	RSClanMemberManager getClanMemberManager();

	@Import("loginType")
	RSJagexLoginType getLoginType();

	@Construct
	RSName createName(String name, RSJagexLoginType type);

	@Import("getVarbit")
	int getVarbit(int varbitId);

	@Import("varbits")
	RSNodeCache getVarbitCache();

	@Import("preferences")
	@Override
	RSPreferences getPreferences();

	/**
	 * This is the pitch the user has set the camera to.
	 * It should be between 128 and (pitchUnlimiter?512:383) JAUs(1).
	 * The difference between this and cameraPitch is that cameraPitch has a lower limit, imposed by the surrounding
	 * terrain.
	 *
	 * (1) JAU - Jagex Angle Unit; 1/1024 of a revolution
	 */
	@Import("cameraPitchTarget")
	int getCameraPitchTarget();

	@Import("cameraPitchTarget")
	void setCameraPitchTarget(int pitch);

	@Import("pitchSin")
	void setPitchSin(int v);

	@Import("pitchCos")
	void setPitchCos(int v);

	@Import("yawSin")
	void setYawSin(int v);

	@Import("yawCos")
	void setYawCos(int v);

	@Import("Rasterizer3D_zoom")
	@Override
	int get3dZoom();

	@Import("Rasterizer3D_zoom")
	void set3dZoom(int zoom);

	@Import("Rasterizer3D_clipMidX2")
	@Override
	int getRasterizer3D_clipMidX2();

	@Import("Rasterizer3D_clipNegativeMidX")
	@Override
	int getRasterizer3D_clipNegativeMidX();

	@Import("Rasterizer3D_clipNegativeMidY")
	@Override
	int getRasterizer3D_clipNegativeMidY();

	@Import("Rasterizer3D_clipMidY2")
	@Override
	int getRasterizer3D_clipMidY2();

	@Import("centerX")
	@Override
	int getCenterX();

	@Import("centerY")
	@Override
	int getCenterY();

	@Import("renderOverview")
	RSRenderOverview getRenderOverview();

	@Import("changeWorld")
	@Override
	void changeWorld(World world);

	@Construct
	@Override
	RSWorld createWorld();

	@Import("animOffsetX")
	void setAnimOffsetX(int animOffsetX);

	@Import("animOffsetY")
	void setAnimOffsetY(int animOffsetY);

	@Import("animOffsetZ")
	void setAnimOffsetZ(int animOffsetZ);

	@Import("getFrames")
	RSFrames getFrames(int frameId);

	@Import("minimapSprite")
	RSSprite getMinimapSprite();

	@Import("minimapSprite")
	void setMinimapSprite(Sprite spritePixels);

	@Import("drawObject")
	void drawObject(int z, int x, int y, int randomColor1, int randomColor2);

	@Construct
	RSScriptEvent createScriptEvent();

	@Import("runScript")
	void runScript(RSScriptEvent ev, int ex);

	@Import("hintArrowTargetType")
	void setHintArrowTargetType(int value);

	@Import("hintArrowTargetType")
	int getHintArrowTargetType();

	@Import("hintArrowX")
	void setHintArrowX(int value);

	@Import("hintArrowX")
	int getHintArrowX();

	@Import("hintArrowY")
	void setHintArrowY(int value);

	@Import("hintArrowY")
	int getHintArrowY();

	@Import("hintArrowOffsetX")
	void setHintArrowOffsetX(int value);

	@Import("hintArrowOffsetY")
	void setHintArrowOffsetY(int value);

	@Import("hintArrowNpcTargetIdx")
	void setHintArrowNpcTargetIdx(int value);

	@Import("hintArrowNpcTargetIdx")
	int getHintArrowNpcTargetIdx();

	@Import("hintArrowPlayerTargetIdx")
	void setHintArrowPlayerTargetIdx(int value);

	@Import("hintArrowPlayerTargetIdx")
	int getHintArrowPlayerTargetIdx();

	@Import("isDynamicRegion")
	@Override
	boolean isInInstancedRegion();

	@Import("itemPressedDuration")
	int getItemPressedDuration();

	@Import("itemPressedDuration")
	void setItemPressedDuration(int duration);

	@Import("flags")
	int getFlags();

	@Import("compass")
	void setCompass(Sprite spritePixels);

	//@Import("widgetSpriteCache")
	//@Override
	//RSNodeCache getWidgetSpriteCache();

	//@Import("items")
	//@Override
	//RSNodeCache getItemDefinitionCache();

	@Import("oculusOrbState")
	@Override
	int getOculusOrbState();

	@Import("oculusOrbState")
	@Override
	void setOculusOrbState(int state);

	@Import("oculusOrbNormalSpeed")
	@Override
	void setOculusOrbNormalSpeed(int state);

	@Import("lookingAtX")
	@Override
	int getOculusOrbFocalPointX();

	@Import("lookingAtY")
	@Override
	int getOculusOrbFocalPointY();

	//RSItem getLastItemDespawn();

	//void setLastItemDespawn(RSItem lastItemDespawn);

	//@Construct
	//RSWidget createWidget();

	@Import("revalidateWidget")
	void revalidateWidget(Widget w);

	@Import("revalidateWidgetScroll")
	void revalidateWidgetScroll(Widget[] group, Widget w, boolean postEvent);

	@Import("menuAction")
	void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7);

	@Import("Viewport_entityCountAtMouse")
	int getEntitiesAtMouseCount();

	@Import("Viewport_entityCountAtMouse")
	void setEntitiesAtMouseCount(int i);

	@Import("Viewport_entitiesAtMouse")
	long[] getEntitiesAtMouse();

	@Import("Viewport_mouseX")
	int getViewportMouseX();

	@Import("Viewport_mouseY")
	int getViewportMouseY();

	//@Import("textureProvider")
	//@Override
	//RSTextureProvider getTextureProvider();

	@Import("occupiedTilesTick")
	int[][] getOccupiedTilesTick();

	//@Import("cachedModels2")
	//RSNodeCache getCachedModels2();

	@Import("cycle")
	int getCycle();

	@Import("cycle")
	void setCycle(int cycle);

	@Import("visibilityMaps")
	boolean[][][][] getVisibilityMaps();

	@Import("renderArea")
	void setRenderArea(boolean[][] renderArea);

	@Import("cameraX2")
	void setCameraX2(int cameraX2);

	@Import("cameraY2")
	void setCameraY2(int cameraY2);

	@Import("cameraZ2")
	void setCameraZ2(int cameraZ2);

	@Import("screenCenterX")
	void setScreenCenterX(int screenCenterX);

	@Import("screenCenterZ")
	void setScreenCenterZ(int screenCenterZ);

	@Import("Scene_plane")
	void setScenePlane(int scenePlane);

	@Import("minTileX")
	void setMinTileX(int i);

	@Import("minTileZ")
	void setMinTileZ(int i);

	@Import("maxTileX")
	void setMaxTileX(int i);

	@Import("maxTileZ")
	void setMaxTileZ(int i);

	@Import("tileUpdateCount")
	int getTileUpdateCount();

	@Import("tileUpdateCount")
	void setTileUpdateCount(int tileUpdateCount);

	@Import("Viewport_containsMouse")
	boolean getViewportContainsMouse();

	@Import("graphicsPixels")
	int[] getGraphicsPixels();

	@Import("graphicsPixelsWidth")
	int getGraphicsPixelsWidth();

	@Import("graphicsPixelsHeight")
	int getGraphicsPixelsHeight();

	@Import("fillRectangle")
	void RasterizerFillRectangle(int x, int y, int w, int h, int rgb);

	@Import("startX")
	int getStartX();

	@Import("startY")
	int getStartY();

	@Import("endX")
	int getEndX();

	@Import("endY")
	int getEndY();

	@Import("spellSelected")
	@Override
	void setSpellSelected(boolean selected);

	//@Import("getEnum")
	//RSEnum getRsEnum(int id);

	@Import("menuX")
	int getMenuX();

	@Import("menuY")
	int getMenuY();

	@Import("menuHeight")
	int getMenuHeight();

	@Import("menuWidth")
	int getMenuWidth();

	@Import("fontBold12")
	RSFont getFontBold12();

	@Import("drawHorizontalLine")
	void RasterizerDrawHorizontalLine(int x, int y, int w, int rgb);

	@Import("drawVerticalLine")
	void RasterizerDrawVerticalLine(int x, int y, int h, int rgb);

	@Import("drawGradient")
	void RasterizerDrawGradient(int x, int y, int w, int h, int rgbTop, int rgbBottom);

	@Import("fillRectangleAlpha")
	void RasterizerFillRectangleAlpha(int x, int y, int w, int h, int rgb, int a);

	@Import("drawRectangle")
	void RasterizerDrawRectangle(int x, int y, int w, int h, int rgb);

	@Import("drawCircle")
	void RasterizerDrawCircle(int x, int y, int r, int rgb);

	//@Import("healthbarCache")
	//@Override
	//RSNodeCache getHealthBarCache();

	@Import("renderSelf")
	void toggleRenderSelf();

	//@Import("mouseRecorder")
	//RSMouseRecorder getMouseRecorder();

	@Import("printMenuActions")
	void setPrintMenuActions(boolean b);
}
