import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.junit.Test;
import refrenceCode.OpticalCharacterRecognition;
import refrenceCode.Profile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Mark D
 *
 */
public class OcrModule implements OpticalCharacterRecognition{


    public static void main(String[] args) {
        File file1=new File("..\\Sample Plates\\trump.jpg");
        File file2=new File("..\\Sample Plates\\ca2008-2.jpg");
        File file3=new File("..\\Sample Plates\\boring-california-6c.jpg");
        File file4=new File("..\\Sample Plates\\cropped_plate.jpg");
        ObjectRecognition or=new ObjectRecognition();
        OcrModule ocr=new OcrModule();
        for(int i=0;i<7;i++)
        {
            String path = "../Sample Plates/image_"+String.valueOf(i+1)+".jpg";
            File file=new File(path);
            System.out.println(String.valueOf(i+1)+": "+ocr.findLicencePlateText(or.findLicensePlateInImage(file)));
        }



        OcrModule mod=new OcrModule();

//        System.out.println( mod.findLicencePlateText(file1));
//        System.out.println( mod.findLicencePlateText(file2));
//        System.out.println( mod.findLicencePlateText(file3));
//        System.out.println( mod.findLicencePlateText(file4));
//




    }




    @Override
    public String findLicencePlateText(File image) {
        Tesseract tesseract = new Tesseract();
        if(image==null)
        {
            return "";
        }

        try {

            tesseract.setDatapath("OCRmodule\\Tess4J\\tessdata");
            tesseract.setLanguage("lus");
            tesseract.setPageSegMode(11);
            tesseract.setOcrEngineMode(3);


            String text = null;


            text = tesseract.doOCR(processImage(image));

//            System.out.print(text);
            String output="";
            int endOfLineOccurance=0;
            boolean lastEndOfLine=false;
            for(int i=0;i<text.length();i++)
            {

                if(text.charAt(i)=='\n')
                {
                    if(!lastEndOfLine)
                    {
                       lastEndOfLine=true;
                       output+=text.charAt(i);
                       endOfLineOccurance++;

                    }

                }
                else
                {
                    output+=text.charAt(i);
                    lastEndOfLine=false;

                }
            }


//            switch (endOfLineOccurance)
//            {
//                case 1:
//                    return output;
//                case 2:
//                    return output.substring(output.indexOf('\n'));
//                case 3:
//                    output=output.substring(output.indexOf('\n'));
//                    return output.substring(0,output.indexOf('\n'));
//                default:
//                    return String.valueOf(text.length());
//
//
//
//
//            }
            String returnString="";

            for(int i=0;i<output.length();i++)
            {
                if(output.charAt(i)=='\n'&&(i+1==output.length()))
                {
                    break;
                }
                else if(output.charAt(i)=='\n')
                {
                    returnString="";
                }
                else
                {
                    returnString+=output.charAt(i);

                }

            }
            returnString=returnString.trim();
            returnString=returnString.replaceAll(" ","");
            if(returnString.length()==7)
            {
                returnString=returnString.replaceAll("T","7");
            }
            else if(returnString.length()==8)
            {
                if(returnString.charAt(0)=='1')
                {
                    return returnString.substring(1);

                }
                if(returnString.charAt(7)=='1')
                {
                    return returnString.substring(0,6);

                }
            }

            return returnString;


        } catch (TesseractException e) {
            e.printStackTrace();
            return null;
        }


    }
    private static BufferedImage color2BlackandWhite(BufferedImage image)
    {
        BufferedImage output=new BufferedImage(image.getWidth(),image.getHeight(),BufferedImage.TYPE_BYTE_GRAY);
        Graphics2D graph=output.createGraphics();
        graph.drawImage(image,0,0,Color.WHITE,null);
        graph.dispose();
        return output;
    }
    private static BufferedImage resizeImage(BufferedImage input) throws IOException {

        int width=0;
        int height=0;

        width=5500;
        height=(int)(((double)width/(double)input.getWidth())*(double)input.getHeight());
        BufferedImage output=new BufferedImage(width, (int) height,input.getType());
        Graphics2D grap=output.createGraphics();
        grap.drawImage(input,0,0,width, (int) height,null);
        grap.dispose();
        return output;
    }
    private static BufferedImage processImage(File image)
    {

        try {
            BufferedImage output = ImageIO.read(image);
            output=resizeImage(output);
            output=color2BlackandWhite(output);
            output=cropImage(output);
//            File file=new File("output.jpg");
//            ImageIO.write(output,"jpg",file);

            return output;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    private static BufferedImage cropImage(BufferedImage image)
    {
        BufferedImage output=image.getSubimage(0, (int) (image.getHeight()*0), image.getWidth(), (int) (image.getHeight()*(0.85)));

        return output;

    }


}

