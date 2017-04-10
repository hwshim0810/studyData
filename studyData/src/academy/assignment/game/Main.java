package academy.assignment.game;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import academy.assignment.game.GameUi;

/**
 * @author Shim Hyun-Woo
 * @Created 2016.11
 */
public class Main {

	public static void main(String[] args) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
		GameUi gui = new GameUi();
		gui.init();
	}

}
