package com.modulo7.musicstatmodels.similarity;

import com.modulo7.common.exceptions.Modulo7VectorSizeMismatchException;
import com.modulo7.common.interfaces.AbstractSimilarity;
import com.modulo7.common.utils.Modulo7Globals;
import com.modulo7.common.utils.Modulo7Utils;
import com.modulo7.musicstatmodels.representation.Song;
import com.modulo7.musicstatmodels.statistics.datatypes.TonalHistogram;
import com.modulo7.musicstatmodels.statistics.results.StatisticResult;
import com.modulo7.musicstatmodels.statistics.results.TonalHistogramResult;
import com.modulo7.common.interfaces.AbstractStatistic;
import com.modulo7.musicstatmodels.statistics.statisticscompute.TonalHistogramStatistic;

import java.util.List;

/**
 * Created by asanyal on 8/30/15.
 *
 * Tonal histogram similarity measure is based on the fact that the tonal histogram
 * can act as an vectorized representation of the song. As such the cosine similarity
 * or any other such measure can also be used
 */
public class TonalHistogramSimilarity extends AbstractSimilarity {

    @Override
    protected double getSimilarity(final Song first, final Song second) {
        AbstractStatistic<TonalHistogramResult> statisticOne = new TonalHistogramStatistic();
        StatisticResult<TonalHistogram> resultOne = statisticOne.getStatistic(first);

        List<Integer> histogramOneVector = resultOne.getStatisticResultObject().getVectorizedRepresentation();

        AbstractStatistic<TonalHistogramResult> statisticTwo = new TonalHistogramStatistic();
        StatisticResult<TonalHistogram> resultTwo = statisticTwo.getStatistic(second);

        List<Integer> histogramTwoVector = resultTwo.getStatisticResultObject().getVectorizedRepresentation();

        try {
            return Modulo7Utils.cosineSimilarity(histogramOneVector, histogramTwoVector);
        } catch (Modulo7VectorSizeMismatchException e) {
            e.printStackTrace();
        }

        // If things fail return an unknown value, unlikely it will reach this code path
        return Modulo7Globals.UNKNOWN;
    }
}
