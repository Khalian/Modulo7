#ifndef HOUGHTRANSFORM_H
#define HOUGHTRANSFORM_H

#include "opencv2/highgui/highgui.hpp"
#include "opencv2/imgproc/imgproc.hpp"

#if defined(_WIN32) && defined(DLL_EXPORT)
#define LIB_FUNC __declspec(dllimport)
#else
#define LIB_FUNC
#endif

class LIB_FUNC HoughLinesTransform
{
    private:

		// Matrix representations of source, destination and intermediate destination representations of
		// Images in the process of transforms being applied to it
		cv::Mat src, dst, cdst;
		 
		// place holder for file name
		char* filename;

		// Apply the hogue transform on the given file
		void getLinesFromHogueTransform();

		// Removing
		void removeLinesFromImage();

	public:
        
		// Default constructor for the hogue transform
		// Accepts file name and contstructs the matrix representation
		HoughLinesTransform(const char * filename);    
};

#endif HOUGHTRANSFORM_H