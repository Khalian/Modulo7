#include "HoughTransform.hpp"
#include <iostream>

using namespace cv;
using namespace std;

void debug()
{
	cout << "\nThis program demonstrates line finding with the Hough transform.\n"
			"Usage:\n"
			"./houghlines <image_name>, Default is pic1.jpg\n" << endl;
}

/**
*  This class is responsible for the hogue lines transform
*  operations and its associated
**/
HoughLinesTransform::HoughLinesTransform(const char *filename) 
{		
	// Read the file
	src = imread(filename, 0);

	if (src.empty()) 
	{
		debug();
		cout << "can not open " << filename << endl;
	}
}
 
void HoughLinesTransform::getLinesFromHogueTransform() {

	Canny(src, dst, 50, 200, 3);
	cvtColor(dst, cdst, CV_GRAY2BGR);

#if 0
	vector<Vec2f> lines;
	HoughLines(dst, lines, 1, CV_PI/180, 100, 0, 0 );

	for (size_t i = 0; i < lines.size(); i++ )
	{
		float rho = lines[i][0], theta = lines[i][1];
		Point pt1, pt2;
		double a = cos(theta), b = sin(theta);
		double x0 = a*rho, y0 = b*rho;
		pt1.x = cvRound(x0 + 1000*(-b));
		pt1.y = cvRound(y0 + 1000*(a));
		pt2.x = cvRound(x0 - 1000*(-b));
		pt2.y = cvRound(y0 - 1000*(a));
		line( cdst, pt1, pt2, Scalar(0,0,255), 3, CV_AA);
	}

#else
	vector<Vec4i> lines;
		 
	HoughLinesP(dst, lines, 1, CV_PI/180, 50, 50, 10 );
	for( size_t i = 0; i < lines.size(); i++ )
	{
	Vec4i l = lines[i];
	line( cdst, Point(l[0], l[1]), Point(l[2], l[3]), Scalar(0,0,255), 3, CV_AA);
	}
		 
#endif
	imshow("source", src);
	imshow("detected lines", cdst);	
}

int main(int argc, char **argv) {
	// Do nothing
}