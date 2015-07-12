__author__ = 'asanyal'

import cv2
import numpy as np

def getHoughLines(imgFile):
    img = cv2.imread(imgFile)
    print img.shape
    gray = cv2.cvtColor(img,cv2.COLOR_BGR2GRAY)
    edges = cv2.Canny(gray,50,150,apertureSize = 3)

    lines = cv2.HoughLines(edges, 1, np.pi/180, 200)

    for line in lines:
        for rho,theta in line:
            a = np.cos(theta)
            b = np.sin(theta)
            x0 = a*rho
            y0 = b*rho
            x1 = int(x0 + 1000*(-b))
            y1 = int(y0 + 1000*(a))
            x2 = int(x0 - 1000*(-b))
            y2 = int(y0 - 1000*(a))

            cv2.line(img,(x1,y1),(x2,y2),(0,0,255),2)

    cv2.imwrite('image2.png',img)

def removeLinesFromSheet(imgFile):

    img = cv2.imread(imgFile)
    gray=cv2.cvtColor(img,cv2.COLOR_BGR2GRAY)

    linek = np.zeros((11,11),dtype=np.uint8)
    linek[5,...]=1

    x=cv2.morphologyEx(gray, cv2.MORPH_OPEN, linek ,iterations=1)

    gray-=x

    cv2.imshow('gray',gray)
    cv2.waitKey(0)

# Running a test case
def main():
    getHoughLines("jinglebells.png")

main()