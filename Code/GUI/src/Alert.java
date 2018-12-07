import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Alert {
   static File audioFile;
    AudioInputStream audioInputStream;
    AudioFormat format;
    DataLine.Info info;
    Clip audio;

    public Alert(String path) {
        audioFile = new File(path);
        System.out.println("audio file: "+audioFile.getAbsolutePath() );
        try {
            audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            format = audioInputStream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            audio = (Clip) AudioSystem.getLine(info);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

    }

    public void play() {
        try {
            audio.open(audioInputStream);
//            audio.loop(Clip.LOOP_CONTINUOUSLY);
            audio.start();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
       audio.close();
    }
}

