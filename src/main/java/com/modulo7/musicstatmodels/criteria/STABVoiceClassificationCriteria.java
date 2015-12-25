package com.modulo7.musicstatmodels.criteria;

import com.modulo7.common.interfaces.AbstractCriteria;
import com.modulo7.musicstatmodels.representation.monophonic.Voice;
import com.modulo7.musicstatmodels.representation.monophonic.VoiceClass;
import com.modulo7.musicstatmodels.representation.polyphonic.Song;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by asanyal on 10/18/15.
 *
 * Most choral music have the nice stab voice classification, but most pop and rock
 * songs dont follow into that purview. Hence
 */
public class STABVoiceClassificationCriteria implements AbstractCriteria {

    @Override
    public boolean getCriteriaEvaluation(final Song song) {
        //Set<VoiceClass> voiceTypesPresent = song.getVoices().stream().map(Voice::estimateVoiceClass).collect(Collectors.toSet());

        Set<VoiceClass> voiceTypesPresent = new HashSet<>();
        for (final Voice voice : song.getVoices()) {
            voiceTypesPresent.add(voice.estimateVoiceClass());
        }

        return !voiceTypesPresent.contains(VoiceClass.GENERIC) && voiceTypesPresent.size() == 4;
    }
}
