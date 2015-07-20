__author__ = 'asanyal'

import cv2
import numpy as np

"""
Operations specific to a particular line based operation
"""
class LineOperations:

    """
    Basic consutructor for accepting an image
    file for morpohological operations
    """
    def __init__(self, imgFile):
        self.lines_polar_rep = []
        self.lines_cartesian_rep = []
        self.houghLinesTransformApplied = False

        self.img = cv2.imread(imgFile)
        self.gray_img = cv2.cvtColor(self.img, cv2.COLOR_BGR2GRAY)
        self.edges = cv2.Canny(self.gray_img, 50, 150, apertureSize = 3)

        # Sets of four staff lines
        self.staff_line_blocks = []


    """
    Method to acquire the hogue transform lines
    in both cartesian and polar representations
    """
    def get_hough_lines(self):

        self.lines_polar_rep = cv2.HoughLines(self.edges, 1, np.pi/180, 200)

        for line in self.lines_cartesian_rep:
            for rho, theta in line:
                a = np.cos(theta)
                b = np.sin(theta)
                x0 = a*rho
                y0 = b*rho
                x1 = int(x0 + 1000*(-b))
                y1 = int(y0 + 1000*(a))
                x2 = int(x0 - 1000*(-b))
                y2 = int(y0 - 1000*(a))
                self.lines_cartesian_rep.append(((x1, y1), (x2, y2)))

        self.houghLinesTransformApplied = True

    # Each staff location will be returned as a simple
    def get_staves(self):

        for line in self.lines_cartesian_rep:

            staff_line_set = []

            for (x1, y1), (x2, y2) in line:

                #thresh hold for number of pixels to separate by
                th = 10
                too_close = False

                # only appends lines if they're a reasonable distance
                # from other lines would be better if used averaging between
                # close lines instead of just taking the first one we see and
                # tossing the other, for a given piece of sheet, its generally 4 lines
                # one after the other followed by

                for y in staff_line_set:
                    if abs(y - y1) <= th:
                        too_close = True

                if not too_close:
                    staff_line_set.append(y1)

            self.staff_line_blocks.append(staff_line_set)