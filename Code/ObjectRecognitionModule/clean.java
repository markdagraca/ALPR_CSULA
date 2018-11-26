package application;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.imgproc.Moments;



//YOU FUCKED SOMETHING UP, NOW IT DOESNT WORK, NEED TO GET OUTPUT TO MATCH output_z.jpg in Test_Output folder
//This works now, (10:01AM 11/26/2018)
//Dont touch anything on this version
//Upload to GitHub ASAP!!!



public class clean {
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat image = Imgcodecs.imread("C:/Users/rpera/Documents/Cal State LA/2018-2019/Fall Semester 2018/CS 3337/Sample_Images/image_2.jpg");
		Mat imageHSV = new Mat(image.size(), CvType.CV_8UC4);
	    Mat imageBlurr = new Mat(image.size(),CvType.CV_8UC4);
	    Mat imageA = new Mat(image.size(), CvType.CV_32F);
	    Imgproc.cvtColor(image, imageHSV, Imgproc.COLOR_BGR2GRAY);
	    Imgproc.GaussianBlur(imageHSV, imageBlurr, new Size(5,5), 0);
	    Imgproc.adaptiveThreshold(imageBlurr, imageA, 255,Imgproc.ADAPTIVE_THRESH_MEAN_C, Imgproc.THRESH_BINARY,7, 5);
	    Imgproc.Canny(imageA, imageA, 300, 600);
		//
	   // Imgcodecs.imwrite("C:/Users/rpera/Documents/Cal State LA/2018-2019/Fall Semester 2018/CS 3337/Clean_Output/canny_test2.jpg",imageA);
	    //
	    //System.out.println("Uploaded");
	    List<MatOfPoint> contours = new ArrayList<MatOfPoint>();
	    Imgproc.findContours(imageA, contours, new Mat(), Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);
	    for(int i = 0; i < contours.size(); i++){
	    	System.out.println(i);
	    	Rect rect = Imgproc.boundingRect(contours.get(i));
	    	double area = Imgproc.contourArea(contours.get(i));
			//Imgproc.rectangle(image,new Point(rect.x,rect.y), new Point(rect.x+rect.width,rect.y+rect.height),new Scalar(0,0,255));
	    	if(area > 100){
		    	if (rect.width >= rect.height *1.8 && rect.width <= rect.height *2.2){	//Standard size is 	12 by 6          {
		    		Imgproc.rectangle(image, new Point(rect.x,rect.y), new Point(rect.x+rect.width,rect.y+rect.height),new Scalar(0,0,255));
		    	}
	    	}
//	    	if(area > 50){
//	    		if(rect.width >= rect.height *1.88){
//	    			Imgproc.rectangle(image,new Point(rect.x,rect.y), new Point(rect.x+rect.width,rect.y+rect.height),new Scalar(0,0,255));
//	    		}
//	    	}
	    }
	    
	    Imgcodecs.imwrite("C:/Users/rpera/Documents/Cal State LA/2018-2019/Fall Semester 2018/CS 3337/Clean_Output/output_imcrying.jpg",image);
	    System.out.println("Uploaded!");
	    
	    
	    
	}
}




