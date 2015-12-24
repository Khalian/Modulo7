package com.modulo7.pureresearch.lastfm;

import java.util.Comparator;

/**
 * Created by asanyal on 12/22/15.
 *
 * Compares two genre mapped lyrics bag objects
 */
public class SongBagLyricsGenreComparator implements Comparator<SongBagLyricsGenreMap> {
    @Override
    public int compare(final SongBagLyricsGenreMap thisBag, final SongBagLyricsGenreMap thatBag) {
        return thisBag.getTrackID().compareTo(thatBag.getTrackID());
    }
}
