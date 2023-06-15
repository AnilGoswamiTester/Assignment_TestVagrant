package demo.assessment.testvarigrant;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RecentlyPlayedSongsTest {
    private RecentlyPlayedSongsStore store;

    @BeforeMethod
    public void setUp() {
        store = new RecentlyPlayedSongsStore(3);
    }

    @Test
    public void testRecentlyPlayedSongs() {
        store.addSong("S1", "User1");
        store.addSong("S2", "User1");
        store.addSong("S3", "User1");

        List<String> user1Songs = store.getRecentlyPlayedSongs("User1");
        Assert.assertEquals(user1Songs, Arrays.asList("S3", "S2", "S1"));

        store.addSong("S4", "User1");
        store.addSong("S2", "User1");
        store.addSong("S1", "User1");

        user1Songs = store.getRecentlyPlayedSongs("User1");
        Assert.assertEquals(user1Songs, Arrays.asList("S1", "S2", "S4"));

        store.addSong("S5", "User2");
        store.addSong("S6", "User2");

        List<String> user2Songs = store.getRecentlyPlayedSongs("User2");
        Assert.assertEquals(user2Songs, Arrays.asList("S6", "S5"));

        store.addSong("S7", "User3");

        List<String> user3Songs = store.getRecentlyPlayedSongs("User3");
        Assert.assertEquals(user3Songs, Collections.singletonList("S7"));
    }
}