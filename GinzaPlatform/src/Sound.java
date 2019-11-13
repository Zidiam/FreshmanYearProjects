import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/*
 * 
 */
public class Sound {
	private Clip audioClip;
	
	public Sound() {
		
	}
	
	public void startMusic() {
        
        File f = new File("src\\PlatForm_Resources//Sound/backgroundTech.wav");
        try {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(f);
                AudioFormat format = audioStream.getFormat();
                DataLine.Info info = new DataLine.Info(Clip.class, format);
                audioClip = (Clip) AudioSystem.getLine(info);
                audioClip.open(audioStream);
        }
        catch (IOException exception) {
            System.err.println(exception);
        } catch (UnsupportedAudioFileException exception) {
            System.err.println(exception);
        } catch (LineUnavailableException exception) {
            System.err.println(exception);
        }
        audioClip.start();
    }
}