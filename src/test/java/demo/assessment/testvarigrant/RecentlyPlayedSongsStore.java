package demo.assessment.testvarigrant;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;

class RecentlyPlayedSongsStore {
    private final int capacity;
    private final Map<String, LinkedList<String>> songUserMap;

    public RecentlyPlayedSongsStore(int capacity) {
        this.capacity = capacity;
        this.songUserMap = new HashMap<>();
    }

    public void addSong(String song, String user) {
        LinkedList<String> songList = songUserMap.computeIfAbsent(user, k -> new LinkedList<>());

        if (songList.contains(song)) {
            songList.remove(song);
        } else if (songList.size() >= capacity) {
            songList.removeLast();
        }
        songList.addFirst(song);
    }

    public List<String> getRecentlyPlayedSongs(String user) {
        return new ArrayList<>(songUserMap.getOrDefault(user, new LinkedList<>()));
    }
}
