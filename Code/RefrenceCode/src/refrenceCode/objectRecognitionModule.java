package refrenceCode;

import java.io.File;
import java.util.ArrayList;

public interface objectRecognitionModule {
    /**
     *
     * @param image
     * @return returns a cropped section of any license plate found within an image
     */
    public ArrayList<File> findLicencePlateinImage(File image);
}
