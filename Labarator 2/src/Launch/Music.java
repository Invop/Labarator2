package Launch;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;
import javax.swing.JOptionPane;
public class Music {
	private static Clip clip;
    private static AudioInputStream sound;
    public static void playMusic(String path) {
		try {
			AudioInputStream iputStream = AudioSystem.getAudioInputStream(new File(path));
			clip = AudioSystem.getClip();
			clip.open(iputStream);

			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error");
		}
	}
    
    public static void play() {
        clip.start();
        
    }
    public static void loop(int loop) {
    	if(loop==1)clip.loop(Clip.LOOP_CONTINUOUSLY);
    	else clip.loop(0);
    }
    public static void stop() throws IOException {
        sound.close();
        clip.close();
        clip.stop();
    }

}
