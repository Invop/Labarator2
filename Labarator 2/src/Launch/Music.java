package Launch;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;
import javax.swing.JOptionPane;
public class Music {
	Clip clip;
    AudioInputStream sound;
    public static void playMusic(String path) {
		try {
			AudioInputStream iputStream = AudioSystem.getAudioInputStream(new File(path));
			Clip clip = AudioSystem.getClip();
			clip.open(iputStream);
			clip.loop(0);
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error");
		}
	}
    
    public void play() {
        clip.start();
    }
    public void stop() throws IOException {
        sound.close();
        clip.close();
        clip.stop();
    }

}
