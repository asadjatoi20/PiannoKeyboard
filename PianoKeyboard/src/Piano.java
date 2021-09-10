import javax.sound.midi.*; 
import javax.swing.*;
import javax.swing.*; 
import javax.swing.event.*; 
import java.awt.event.*; 
import java.awt.*;
public class Piano {
	Synthesizer synth;
	int previousNoteValue=0; // used to noteOff previous tone 
	MidiChannel[] mChannels;
	JFrame frame;
	JLayeredPane panel;
		Piano(){   
			frame = new JFrame("Pea-Air-Know");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
			frame.setSize(500, 320);   
			frame.setFocusable(true); // so that the focus is on the frame and in order to hear the key press
			frame.setResizable(false);  
			
			setMusic(); // initializing synth and mChannels
			JButton[] w = new JButton[7];   
			JButton[] b = new JButton[6];
			panel = new JLayeredPane(); // will hold the buttons   
			frame.add(panel);
			for (int i = 0; i < 7; i++) {    
				w[i] = new JButton();    
				w[i].setBackground(Color.WHITE);    
				w[i].setLocation(i * 70, 0);    
				w[i].setSize(70, 300);
				w[i].setName("w"+i); // setting name to w0,w1,w2
				panel.add(w[i], 0, -1); 
			} 
		 
			for (int i = 0; i < 6; i++) {    
			  if (i==2)     
				  continue;
			  b[i] = new JButton();
			  b[i].setBackground(Color.BLACK);
			  b[i].setLocation(35 + i * 70, 0); 
			  b[i].setSize(70, 150); 
			  b[i].setName("b"+i); // setting name to i-e b0,b1,b3 
			  panel.add(b[i], 1, -1);   
			}				
			addAction(); // for button actions
			frame.addKeyListener(new KeyboardKeyListener(panel));
			frame.setVisible(true);
			
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
		public void addAction() { // method to control all the Actions
			Component[] components = panel.getComponents();
			for(Component comp: components) {
				if(comp instanceof JButton) {
					JButton btn = (JButton) comp;
					btn.addChangeListener(new ChangeListener() {

						@Override
						public void stateChanged(ChangeEvent e) {
							// ButtonModel used to check the type of StateChange
							ButtonModel model = (ButtonModel) btn.getModel();
							//variable to hold the name of current button 
							String value = btn.getName(); // obtained the name of the button
								switch(value) { // All 12 buttons are here
									case "w0" : {
										if(model.isPressed()) {
											// if this button is pressed then first noteOff the previous running note 
											synth.getChannels()[0].noteOff(previousNoteValue);
											// then  noteOn the pressed tone
											synth.getChannels()[0].noteOn(60, 127);
											// save this as prevviousNoteValue
											previousNoteValue = 60;
											btn.setFocusable(false); // after action button will be un foccused and frame will be focused again so that user can do both at the same time use cursor to press button or press any key from keyboard
											frame.setFocusable(true);
										}
										break;
									} 
									case "w1" : {
										if(model.isPressed()) {
											synth.getChannels()[0].noteOff(previousNoteValue);
											synth.getChannels()[0].noteOn(62, 127);
											previousNoteValue = 62;
											btn.setFocusable(false);
											frame.setFocusable(true);
										}
										break;
									}
									case "w2" : {
										if(model.isPressed()) {
											synth.getChannels()[0].noteOff(previousNoteValue);
											synth.getChannels()[0].noteOn(64, 127);
											previousNoteValue = 64;
											btn.setFocusable(false);
											frame.setFocusable(true);
										}
										break;
									} 
									case "w3" : {
										if(model.isPressed()) {
											synth.getChannels()[0].noteOff(previousNoteValue);
											synth.getChannels()[0].noteOn(65, 127);
											previousNoteValue = 65;
											btn.setFocusable(false);
											frame.setFocusable(true);
										}
										break;
									}
									
									case "w4" : {
										if(model.isPressed()) {
											synth.getChannels()[0].noteOff(previousNoteValue);
											synth.getChannels()[0].noteOn(67, 127);
											previousNoteValue = 67;
											btn.setFocusable(false);
											frame.setFocusable(true);
										}
										break;
									} 
									case "w5" : {
										if(model.isPressed()) {
											synth.getChannels()[0].noteOff(previousNoteValue);
											synth.getChannels()[0].noteOn(69, 127);
											previousNoteValue = 69;
											btn.setFocusable(false);
											frame.setFocusable(true);
										}
										break;
									}
									case "w6" : {
										if(model.isPressed()) {
											synth.getChannels()[0].noteOff(previousNoteValue);
											synth.getChannels()[0].noteOn(71, 127);
											previousNoteValue = 71;
											btn.setFocusable(false);
											frame.setFocusable(true);
										}
										break;
									} 
									case "b0" : {
										if(model.isPressed()) {
											synth.getChannels()[0].noteOff(previousNoteValue);
											synth.getChannels()[0].noteOn(61, 127);
											previousNoteValue = 61;
											btn.setFocusable(false);
											frame.setFocusable(true);
										}
									}
									case "b1" : {
										if(model.isPressed()) {
											synth.getChannels()[0].noteOff(previousNoteValue);
											synth.getChannels()[0].noteOn(63, 127);
											previousNoteValue = 63;
											btn.setFocusable(false);
											frame.setFocusable(true);
										}
										break;
									} 
									case "b3" : {
										if(model.isPressed()) {
											synth.getChannels()[0].noteOff(previousNoteValue);
											synth.getChannels()[0].noteOn(66, 127);
											previousNoteValue = 66;
											btn.setFocusable(false);
											frame.setFocusable(true);
										}
										break;
									}
									case "b4" : {
										if(model.isPressed()) {
											synth.getChannels()[0].noteOff(previousNoteValue);
											synth.getChannels()[0].noteOn(68, 127);
											previousNoteValue = 68;
											btn.setFocusable(false);
											frame.setFocusable(true);
										}
										break;
									} 
									case "b5" : {
										if(model.isPressed()) {
											synth.getChannels()[0].noteOff(previousNoteValue);
											synth.getChannels()[0].noteOn(70, 127);
											previousNoteValue = 70;
											btn.setFocusable(false);
											frame.setFocusable(true);
										}
										break;
									}
									
								}
						}
						
					});
				}
			}
		}
		public static void main(String[] args) {   
			new Piano();  
			
		} 
}