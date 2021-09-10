// Class to implement KeyListeners 
// A,B,C,D,E,F,G -> White Buttons
/*
 *  C <- w0
	D <- w1 
	E <- w2
	F <- w3
	G <- w4
	A <- w5
	B <- w6
*/
// 1,2,3,4,5 -> Black Buttons
/*
 *  1 <- b0
	2 <- b1 
	3 <- b3
	4 <- b4
	5 <- b5
	
*/
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

public class KeyboardKeyListener implements KeyListener {
	JButton[] btns = new JButton[12];
	JLayeredPane panel; // used to get names of all buttons
	Synthesizer synth; // for music
	int previousNoteValue=0; // used to noteOff previous tone 
	MidiChannel[] mChannels;
	KeyboardKeyListener(JLayeredPane p){
		panel = p;
		getComponents(); // all buttons obtained and saved in btns array
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// not mentioned to implement
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode(); // getting the pressed key
		setMusic(); // Synth initialized
		switch(keyCode) { // getting the pressed key, and performing action as per pressedKey
			// VK format 
			// If the key is C first Button will be pressed indirectlyy the StateChange is mapped here
			case KeyEvent.VK_C:{ //wo // btns[5] represents the w0 button
				previousNoteValue = 60; //since w0 has 60 tone number
				btns[5].doClick(80); // this method will auto map the StateChange method of the Piano Class Button Listener 
				break;	
				
			}
			case KeyEvent.VK_D:{ //w1
				previousNoteValue = 62; //since w0 has 60 tone number
				btns[6].doClick(80); // this method will auto map the StateChange method of the Piano Class Button Listener 
				break;
			}
			case KeyEvent.VK_E:{ //w2
				previousNoteValue = 64; //since w0 has 60 tone number
				btns[7].doClick(80); // this method will auto map the StateChange method of the Piano Class Button Listener 
				break;
			}
			case KeyEvent.VK_F:{ //w3
				previousNoteValue = 65; //since w0 has 60 tone number
				btns[8].doClick(80); // this method will auto map the StateChange method of the Piano Class Button Listener 
				break;
			}
			case KeyEvent.VK_G:{ //w4
	
				previousNoteValue = 67; //since w0 has 60 tone number
				btns[9].doClick(80); // this method will auto map the StateChange method of the Piano Class Button Listener 
				break;
			}
			case KeyEvent.VK_A:{ //w5
				previousNoteValue = 69; //since w0 has 60 tone number
				btns[10].doClick(80); // this method will auto map the StateChange method of the Piano Class Button Listener 
				break;
			}
			case KeyEvent.VK_B:{ //w6
				previousNoteValue = 71; //since w0 has 60 tone number
				btns[11].doClick(80); // this method will auto map the StateChange method of the Piano Class Button Listener 
				break;
			}
			case KeyEvent.VK_1:{ //b0
				previousNoteValue = 61; //since w0 has 60 tone number
				btns[0].doClick(80); // this method will auto map the StateChange method of the Piano Class Button Listener 
				break;
			}
			case KeyEvent.VK_2:{ //b1
				previousNoteValue = 63; //since w0 has 60 tone number
				btns[1].doClick(80); // this method will auto map the StateChange method of the Piano Class Button Listener 
				break;
			}
			case KeyEvent.VK_3:{ //b3
				previousNoteValue = 66; //since w0 has 60 tone number
				btns[2].doClick(80); // this method will auto map the StateChange method of the Piano Class Button Listener 
				break;
			}
			case KeyEvent.VK_4:{ //b4
				previousNoteValue = 68; //since w0 has 60 tone number
				btns[3].doClick(80); // this method will auto map the StateChange method of the Piano Class Button Listener 
				break;
			}
			case KeyEvent.VK_5:{ //b5
				previousNoteValue =70; //since w0 has 60 tone number
				btns[4].doClick(80); // this method will auto map the StateChange method of the Piano Class Button Listener 
			break;	
			}		
		
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// noteOff when key is released
		synth.getChannels()[0].noteOff(previousNoteValue);
		// noteOff last running tone
		
	}
	public void getComponents() {
		int index = 0;
		Component[] components = panel.getComponents();
		for(Component comp: components) {
			if(comp instanceof JButton) {
				JButton btn = (JButton) comp;
				btns[index] = btn; // start from b0 - w6
				index++;
			}
		}	
				
	}
	public void setMusic() {
		try { 
				synth=MidiSystem.getSynthesizer();   
				synth.open();   
				mChannels = synth.getChannels(); 
				}catch (MidiUnavailableException e){ 
					JOptionPane.showMessageDialog(null,"Unable to open MIDI."); 
		}
	}

}
