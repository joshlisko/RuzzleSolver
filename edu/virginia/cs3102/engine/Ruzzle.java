package edu.virginia.cs3102.engine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import edu.virginia.cs3102.GUI.ResultsJFrame;
import edu.virginia.cs3102.GUI.RuzzleJFrame;


public class Ruzzle {

	Engine engine;
	RuzzleJFrame ruzzleGUI;
	
	
	public static void main(String[] args) {
		new Ruzzle();
	}
	
	public Ruzzle(){
		ruzzleGUI = new RuzzleJFrame();
		ruzzleGUI.addButtonListener(new ButtonListener());
	}
	
	
	class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String dictLocation = ruzzleGUI.getDictionaryLocation();
			String puzzleLocation = ruzzleGUI.getPuzzleLocation();
			
			if(ruzzleGUI.getManualPuzzleInput().length()>0){
				
				 try{
					 BufferedWriter fileWriter = new BufferedWriter(new FileWriter("puzzle"));
					 fileWriter.write(ruzzleGUI.getManualPuzzleInput());
					 fileWriter.close();
				 }
				 catch(Exception e){
					JOptionPane.showMessageDialog(
						    null, "Could not read in manual input",
						    "Input Error",
						    JOptionPane.ERROR_MESSAGE);
				 }
				 puzzleLocation = "puzzle";
			}
			
			System.out.println(puzzleLocation);
			
			engine = new Engine(dictLocation, puzzleLocation, 2);
			ArrayList<String> solutions = engine.getSolutions(0);
			if(!(solutions==null || solutions.size()==0))
				new ResultsJFrame(engine.getSolutions(0));
		}
		
	}

}


