package game.engine;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import game.gui.Central;

public class CommandController_old implements PropertyChangeListener {
	// TODO: Maybe fuse with AdventureController
	//private final Enum<?> command;
	protected Central c;

	public CommandController_old(Central c) {
		this.c = c;
	}

	public void propertyChange(PropertyChangeEvent e) {
		switch((Command) e.getNewValue()) {
		case MEDITATE:
			break;
			/*
			REMEMBER 	
			REBIRTH 	
			SUICIDE 	
			THINK 		
			AWAKE		

			CHECK		

			STATUS		
			MIND		
			ATTRIBUTES	
			INVENTORY	
			SKILLS		
			TRAITS		
			FOCUS 		
			BLOODTYPE 	
			APPEARANCE	


			OPEN		
			BREACH 		
			UNLOCK 		
			SHUT		
			TAKE		
			CRAFT 		
			CONCOCT 	
			COOK 		
			LEECH 		
			CONJURE		
			PILLAGE 	
			LOOT 		
			EQUIP 		
			DROP
			USE	
			LOOKAROUND 	
			EXAMINE		
			MEMORIZE	
			SYNAPSIS	
			READ		
			WRITE 		
			JUMP
			HOP 		
			CROUCH
			HIDE		
			SNEAK 		
			WALK		
			JOG 		
			SPRINT 		
			RIDE
			STEAL 		
			STRIKE		
			CRUSH 		
			SLASH		
			SHATTER 	
			SPARE		
			EVADE		
			EXECUTE		
			WOUND 		
			SLAUGHTER 	
			MUTILATE	
			ABUSE 		
			MUTATE 		


			TALK
			LOOK
			PURCHASE 	
			RETAIL 		
			TRADE 		
			INSULT
			SCREAM
			WHISPER
			BARGAIN 	
			INTIMIDATE 	
			DECEIT 		
			CHARM 		
			SEDUCE 		
			MANIPULATE 	
			ANALYZE 	


			NORTH
			SOUTH
			EAST
			WEST
			case NORTHEAST
			case NORTHWEST
			case SOUTHEAST
			case SOUTHWEST
			case UP 			
			case DOWN 		
			case LEFT 		
			case RIGHT 		
			 */
		default:
			break;
		}
	}
}