package com.modulo7.cli;

/**
 * Created by asanyal on 9/17/15.
 *
 * The set of choices that are present for Modulo7
 * an enum makes it easier to manage the choices of the query set
 * exposed to the consumer
 */
public enum Modulo7CLIChoice {

    RET_SONGS_FOR_GIVEN_ARTIST(1),
    RANK_ON_SIMILARITY_ORDER(2),
    RET_SONGS_FOR_GIVEN_KEY_SIGNATURE(3),
    RET_SONGS_FOR_GIVEN_TIME_SIGNATURE(4),
    RET_LYRICS_GIVEN_SONG(5),
    LIST_NUM_SONGS_INDEXED(6),
    INPUT_CUSTOM_QUERY(7),
    LYRICS_QUERY(8),
    MELODIC_ALIGNMENT_ANALYSIS(9),
    SERIALIZE_DATABASE(10),
    PLAYBACK_SONG(11),
    EXIT(12),
    INVALID_CHOICE(-1);

    final int choice;

    Modulo7CLIChoice(int choice) {
        this.choice = choice;
    }

    /**
     * Parse an integer choice and then returns the enum variant, easier for readability
     * @param choiceNum
     * @return
     */
    public static Modulo7CLIChoice parseChoice(final int choiceNum) {
        switch (choiceNum) {
            case 1: return RET_SONGS_FOR_GIVEN_ARTIST;
            case 2: return RANK_ON_SIMILARITY_ORDER;
            case 3: return RET_SONGS_FOR_GIVEN_KEY_SIGNATURE;
            case 4: return RET_SONGS_FOR_GIVEN_TIME_SIGNATURE;
            case 5: return RET_LYRICS_GIVEN_SONG;
            case 6: return LIST_NUM_SONGS_INDEXED;
            case 7: return INPUT_CUSTOM_QUERY;
            case 8: return LYRICS_QUERY;
            case 9: return MELODIC_ALIGNMENT_ANALYSIS;
            case 10: return SERIALIZE_DATABASE;
            case 11: return PLAYBACK_SONG;
            case 12: return EXIT;
            default: return INVALID_CHOICE;
        }
    }
}