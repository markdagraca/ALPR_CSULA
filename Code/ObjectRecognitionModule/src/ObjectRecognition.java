package application;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 * @author Ryan Peralta
 * Automatic License Plate Reader: Module 1
 * Object Recognition
 * Base image is used as an input, and a file object that references the cropped image is returned.
 */
public class ObjectRecognition implements objectRecognitionModule {
	private File highlight = null;
	
	public static void main(String[] args){
		String path = "C:/Users/rpera/Documents/Cal State LA/2018-2019/Fall Semester 2018/CS 3337/Sample_Images/image_1.jpg";
		ObjectRecognition or = new ObjectRecognition();
		File image = new File(path);
		File cropped = or.findLicensePlateInImage(image);
		try{
			File high = or.getHighlight();
			String x = cropped.getAbsolutePath();
			String y = high.getAbsolutePath();
			System.out.println("Input Image: " + path);
			System.out.println("Cropped Image: " + x);
			System.out.println("Highlighted Image: " + y);
		}
		catch(NullPointerException e){
			System.out.println("Null Pointer Exception");
			System.out.println("FindLicensePlateInImage has failed to detect a license plate.");
		}	
	}
	
	@Override
	public File findLicensePlateInImage(File image) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		String path = image.getAbsolutePath();
		
		//Allocating the space for the Mats needed to modify the original image.
		Mat imageMat = Imgcodecs.imread(path);
		Mat imageHSV = new Mat(imageMat.size(), CvType.CV_8UC4);
	    Mat imageBlurr = new Mat(imageMat.size(),CvType.CV_8UC4);
	    Mat imageA = new Mat(imageMat.size(), CvType.CV_32F);	    
	    
	    //Applying different filters to the original image and saving them as separate Mats
	    Size s = new Size(5,5);
	    double maxValue = 255;
	    int blockSize = 7;
	    double c = 5;
	    Imgproc.cvtColor(imageMat, imageHSV, Imgproc.COLOR_BGR2GRAY);
	    Imgproc.GaussianBlur(imageHSV, imageBlurr, s, 0);
	    Imgproc.adaptiveThreshold(imageBlurr, imageA, maxValue,Imgproc.ADAPTIVE_THRESH_MEAN_C, Imgproc.THRESH_BINARY,blockSize, c);
	    
	    //Resizing the image so that less obscure and not necessary lines will show
	    double threshold1 = 300;
	    double threshold2 = 600;
	    Imgproc.Canny(imageA, imageA, threshold1, threshold2);
	    
	    //Creating a list of contours for the image with the applied filters.
	    List<MatOfPoint> contours = new ArrayList<MatOfPoint>();
	    Imgproc.findContours(imageA, contours, new Mat(), Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);
	    
	    //Creating a file object that will be returned once the method has completed
	    File plate = null;
	    //Creating Mat that clones the original, for the new highlighted image
	    Mat h = imageMat.clone();
	    
	    for(int i = 0; i < contours.size(); i++){
	    	Rect rect = Imgproc.boundingRect(contours.get(i));
	    	double area = Imgproc.contourArea(contours.get(i));
	    	
	    	//Specifying for a minimum area of 100, so that small, insignificant, contours will be filtered out
	    	if(area > 100){
	    		//Standard size is 12 by 6
		    	if (rect.width >= rect.height *1.8 && rect.width <= rect.height *2.2){
		    		//Creating the highlighted image
		    		Imgproc.rectangle(h, new Point(rect.x,rect.y), new Point(rect.x+rect.width,rect.y+rect.height),new Scalar(0,0,255),5);
		    		String pathH  = "C:/Users/rpera/Documents/Cal State LA/2018-2019/Fall Semester 2018/CS 3337/Cropped_Output/highlight.jpg";
		    		Imgcodecs.imwrite(pathH,h);
		    		highlight = new File(pathH);

		    		//Cropping the license plate
		    		Mat crop = new Mat(imageMat, rect);
		    		Imgproc.rectangle(imageMat, new Point(rect.x,rect.y), new Point(rect.x+rect.width,rect.y+rect.height),new Scalar(0,0,255));
		    		String path2  = "C:/Users/rpera/Documents/Cal State LA/2018-2019/Fall Semester 2018/CS 3337/Cropped_Output/cropped_plate.jpg";
		    		Imgcodecs.imwrite(path2,crop);
		    		File f = new File(path2);
		    		plate = f;
		    		System.out.println("Cropped image saved!");
		    		return plate;
		    	}
	    	}
	    }
	    System.out.println("No license plate found!");
	    return plate;
	}
	
	public File getHighlight(){
		return highlight;	
	}
	
} 

