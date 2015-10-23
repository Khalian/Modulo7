package com.modulo7.acoustics;

/**
 * Created by asanyal on 10/18/15.
 *
 * Time signature estimation based on this paper :
 * http://www.terasoft.com.tw/conf/ismir2014/proceedings/T008_121_Paper.pdf
 *
 * TODO : This class is pretty hard to write I will get back to it once basic systems are online
 */
public class MidiTimeSignatureEstimator {

    private double w1 = 1.0;

    private double w2 = 20.0;

    private double w3 = 0.390625;
}
