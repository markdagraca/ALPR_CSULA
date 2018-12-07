package refrenceCode;

import java.io.File;
/**
 * @author Mark D
 *
 */
public interface objectRecognitionModule {
    /**
     *
     * @param image
     * @return returns a cropped section of any license plate found within an image
     */
    public File findLicensePlateInImage(File image);

}
