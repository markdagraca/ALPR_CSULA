import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import refrenceCode.OpticalCharacterRecognition;
import refrenceCode.Profile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class OcrModule implements OpticalCharacterRecognition{

    public static void main(String[] args) {
        Profile profile = new Profile();
        profile.setFirstName("Mark ");
//        File file1=new File("C:\\Users\\Mark D\\Dropbox\\School 2018-19\\Fall\\CS 3337\\ALPR_CSULA\\Sample Plates\\california_plate_bmw_330i-397000.png");
//        File file2=new File("C:\\Users\\Mark D\\Dropbox\\School 2018-19\\Fall\\CS 3337\\ALPR_CSULA\\Sample Plates\\Car 1 Cropped.png");
//        File file3=new File("C:\\Users\\Mark D\\Dropbox\\School 2018-19\\Fall\\CS 3337\\ALPR_CSULA\\Sample Plates\\2018-02-27 14.25.35.jpg");
//        File file4=new File("C:\\Users\\Mark D\\Dropbox\\School 2018-19\\Fall\\CS 3337\\ALPR_CSULA\\Sample Plates\\ca2011-2.jpg");
        File file5=new File("C:\\Users\\Mark D\\Dropbox\\School 2018-19\\Fall\\CS 3337\\ALPR_CSULA\\Sample Plates\\trump.jpg");
//        File file6=new File("C:\\Users\\Mark D\\Dropbox\\School 2018-19\\Fall\\CS 3337\\ALPR_CSULA\\Sample Plates\\file 6.jpg");
//        File file7=new File("C:\\Users\\Mark D\\Dropbox\\School 2018-19\\Fall\\CS 3337\\ALPR_CSULA\\Sample Plates\\034motorsport-metal-license-plate-frame-automotive-accessory-034-a03-0001-2.jpg");
//        File file8=new File("C:\\Users\\Mark D\\Dropbox\\School 2018-19\\Fall\\CS 3337\\ALPR_CSULA\\Sample Plates\\ca2008-2.jpg");


        OcrModule mod=new OcrModule();

//
//        System.out.println( mod.findLicencePlateText(file1));
//        System.out.println( mod.findLicencePlateText(file2));
//        System.out.println( mod.findLicencePlateText(file3));
//        System.out.println( mod.findLicencePlateText(file4));
        System.out.println( mod.findLicencePlateText(file5));
//        System.out.println( mod.findLicencePlateText(file6));
//        System.out.println( mod.findLicencePlateText(file7));
//        System.out.println( mod.findLicencePlateText(file8));

//        mod.findLicencePlateText(file1);
//        mod.findLicencePlateText(file2);
//        mod.findLicencePlateText(file3);
//        mod.findLicencePlateText(file4);
//        mod.findLicencePlateText(file5);
//        mod.findLicencePlateText(file6);
//        mod.findLicencePlateText(file7);




    }




    @Override
    public String findLicencePlateText(File image) {
        Tesseract tesseract = new Tesseract();

        try {

            tesseract.setDatapath("OCRmodule\\Tess4J\\tessdata");
            tesseract.setLanguage("lus");
            tesseract.setPageSegMode(11);
            tesseract.setOcrEngineMode(3);
            ArrayList<String> config=new ArrayList<String>();


            String text = null;


                text = tesseract.doOCR(processImage(image));

            System.out.print(text);
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
            switch (endOfLineOccurance)
            {
                case 1:
                    return output;
                case 2:
                    return output.substring(output.indexOf('\n'));
                case 3:
                    output=output.substring(output.indexOf('\n'));
                    return output.substring(0,output.indexOf('\n'));
                default:
                    return String.valueOf(text.length());




            }

        } catch (TesseractException e) {
            e.printStackTrace();
            return null;
        }

    }
    private static BufferedImage color2BlackandWhite(BufferedImage image)
    {
        BufferedImage output=new BufferedImage(image.getWidth(),image.getHeight(),BufferedImage.TYPE_BYTE_BINARY);
        Graphics2D graph=output.createGraphics();
        graph.drawImage(image,0,0,Color.WHITE,null);
        graph.dispose();
        return output;
    }
    private static BufferedImage resizeImage(BufferedImage input) throws IOException {

        int width=0;
        int height=0;

        width=4000;
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
            File file=new File("output.jpg");
            ImageIO.write(output,"jpg",file);

            return output;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
    private static BufferedImage increaseContrast(BufferedImage input)
    {
        ColorAdjust colorAdjust=new ColorAdjust();
        colorAdjust.setContrast(0.2);
        Image image=new Image(input.getSource().toString());

        return null;

    }
    private static BufferedImage cropImage(BufferedImage image)
    {
        BufferedImage output=image.getSubimage(0, (int) (image.getHeight()*0.2), image.getWidth(), (int) (image.getHeight()*(0.8-0.2)));

        return output;

    }


}

