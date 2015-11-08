package enginetests;

import com.modulo7.engine.cache.Modulo7Cache;
import org.junit.Test;

import java.util.LinkedHashSet;

/**
 * Created by asanyal on 11/6/15.
 *
 * Test for the modulo7 caching mechanism
 */
public class CacheTest {

    /**
     * Test case for cache
     */
    @Test
    public void cacheTett() {
        Modulo7Cache cache = new Modulo7Cache();

        // Song similarity to class , useful for dynamically calling classes during similarity metric analysis
        LinkedHashSet<String> values = new LinkedHashSet<String>() {{
            add("blah");
            add("black");
        }};

        cache.cacheQueryResults("blah", values);
    }
}
