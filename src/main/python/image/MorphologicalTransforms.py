__author__ = 'asanyal'

import cv2
import numpy as np

"""
This class allows for a set of morphological transforms to be applied
on an image

Typically this is used to remove lines from an image without affecting the image
"""
class MorphologicalTranforms:

    def __init__(self, imgFile):
        self.img = cv2.imread(imgFile)
        self.gray_img = cv2.cvtColor(self.img, cv2.COLOR_BGR2GRAY)
        self.edges = cv2.Canny(self.gray_img, 50, 150, apertureSize = 3)

        self.smoothed_line_removed_img = None

    # Removes lines from sheet music and keeps a an in memory numpy copy
    # of the image
    def remove_lines_from_sheet(self, imgFile):

        adaptiveThreshHoldImage = cv2.adaptiveThreshold(~self.gray_img, 255, cv2.ADAPTIVE_THRESH_MEAN_C, cv2.THRESH_BINARY, 15, -2)

        # cv2.imshow('gray', adaptiveThreshHoldImage)

        # The sizes of the images
        vertical = adaptiveThreshHoldImage.copy()

        (rows, cols) = adaptiveThreshHoldImage.shape

        verticalStructure = cv2.getStructuringElement(cv2.MORPH_RECT,(1, 3))

        vertical = cv2.erode(vertical, verticalStructure, iterations = 1);
        vertical = cv2.dilate(vertical, verticalStructure, iterations = 1);

        vertical = cv2.bitwise_not(vertical)

        self.smoothed_line_removed_img = \
            cv2.adaptiveThreshold(vertical, 255, cv2.ADAPTIVE_THRESH_MEAN_C, cv2.THRESH_BINARY, 3, -2)
