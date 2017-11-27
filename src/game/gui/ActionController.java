package game.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import game.engine.CommandController;

public class ActionController implements KeyListener {
	private String input;
	private final int USER_INPUT = 10;
	private final int D = 68;
	private final int E = 69;
	private final int B = 66;
	private final int U = 85;
	private final int G = 71;
	private boolean[] debug;
	private Enum<?> command;
	private Central c;
	private CommandController cc;
	// TODO: Probably better solution for debug-mode possible

	public ActionController(Central c) {
		debug = new boolean[5];
		this.c = c;
	}

	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case USER_INPUT:
			c.parseUserInput(((JTextField) e.getSource()).getText());
			input = c.getUserInput();
			
			// TODO: Debug
			/*#############################################*/
			System.out.println("ActionController: " + input);
			/*#############################################*/
			
			for(boolean b : debug) {
				if(b) {
					// TODO: Insert activation of debug mode
				}
			}
			break;
		case D:
			debug[0] = true;
			break;
		case E:
			debug[1] = true;
			break;
		case B:
			debug[2] = true;
			break;
		case U:
			debug[3] = true;
			break;
		case G:
			debug[4] = true;
			break;
		default: 
			for(boolean b : debug) {
				b = false;
			}
			break;
		}
//		validateCommand();
	}
	
	private void validateCommand() {
		switch(input) {		
		
		}
	}

	public void keyReleased(KeyEvent e) {
	}
	
	public void keyTyped(KeyEvent e) {
	}
}