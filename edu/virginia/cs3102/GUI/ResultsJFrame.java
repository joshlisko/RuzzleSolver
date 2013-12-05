package edu.virginia.cs3102.GUI;
import java.awt.BorderLayout;

import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class ResultsJFrame extends javax.swing.JFrame {
	private JTextArea jTextAreaSolutions;
	private JTextArea jTextAreaResults;
	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	/**
	* Auto-generated main method to display this JFrame
	*/
		
	public ResultsJFrame(ArrayList<String> results) {
		super();
		initGUI(results);
		this.setVisible(true);
	}
	
	private void initGUI(ArrayList<String> results) {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{

				jTextAreaResults = new JTextArea();
				JScrollPane scrollPane = new JScrollPane(jTextAreaResults);
				
				getContentPane().add(scrollPane, BorderLayout.CENTER);
				

				if(results == null || results.size()==0 )
					jTextAreaResults.setText("No Results Found");
				else{
					StringBuilder sb = new StringBuilder();
					for(int i=0; i<results.size(); i++){
						sb.append(results.get(i)+"\n");
					}
					jTextAreaResults.setText(sb.toString());
				}
				jTextAreaResults.setCaretPosition(0);
			}
				
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
