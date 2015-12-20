package com.modulo7.pureresearch.lastfm;

import java.util.Comparator;

/**
 * Created by asanyal on 12/19/15.
 *
 * Compatator for song bag lyrics
 */
public class SongBagLyricsComparator implements Comparator<SongBagLyricsAndMetadata> {

    @Override
    public int compare(SongBagLyricsAndMetadata thisBag, SongBagLyricsAndMetadata thatBag) {
        return thisBag.getTrackID().compareTo(thatBag.getTrackID());
    }
}
