import java.io.File;

public interface OpticalCharacterRecognition {

    /**
     *
     * @param image
     * @return returns the String of the license plate text found within the image
     */
    public String findLicencePlateText(File image);

}
