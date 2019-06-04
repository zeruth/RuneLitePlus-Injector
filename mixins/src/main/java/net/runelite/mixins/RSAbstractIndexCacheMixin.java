package net.runelite.mixins;

import api.overlay.OverlayIndex;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.io.BaseEncoding;
import com.google.common.io.ByteStreams;
import com.google.common.io.CharStreams;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import org.slf4j.Logger;
import rs.api.RSAbstractIndexCache;
import rs.api.RSClient;
import rs.api.RSIndexCache;

@Mixin(RSAbstractIndexCache.class)
public abstract class RSAbstractIndexCacheMixin implements RSAbstractIndexCache
{

}
