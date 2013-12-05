package edu.virginia.cs3102.GUI;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;

import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
public class RuzzleJFrame extends javax.swing.JFrame {
	private JTextField jTextFieldPuzzle;
	private JTextArea jTextAreaPuzzleInput;
	private JButton jButtonSolve;
	private JLabel jLabelManualInput;
	private JLabel jLabelDictionary;
	private JTextField jTextFieldDictionary;
	private JLabel jLabelPuzzle;

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
		
	public RuzzleJFrame() {
		super();
		initGUI();
		this.setVisible(true);
	}
	
	private void initGUI() {
		try {
			this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			this.setResizable(false);
			this.setTitle("Ruzzle Solver");
			{
				jButtonSolve = new JButton();
				getContentPane().add(jButtonSolve, new AnchorConstraint(887, 552, 964, 436, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jButtonSolve.setText("Solve!");
			}
			{
				jLabelManualInput = new JLabel();
				getContentPane().add(jLabelManualInput, new AnchorConstraint(64, 712, 107, 532, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabelManualInput.setText("Manual Puzzle Input");
			}
			{
				jTextAreaPuzzleInput = new JTextArea();
				getContentPane().add(jTextAreaPuzzleInput, new AnchorConstraint(123, 992, 805, 532, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jTextAreaPuzzleInput.setPreferredSize(new java.awt.Dimension(322, 258));
				jTextAreaPuzzleInput.addFocusListener(new FocusAdapter() {
					public void focusGained(FocusEvent evt) {
						jTextAreaPuzzleInputFocusGained(evt);
					}
				});
			}
			{
				jLabelDictionary = new JLabel();
				getContentPane().add(jLabelDictionary, new AnchorConstraint(265, 139, 308, 9, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabelDictionary.setText("Dictionary File");
				jLabelDictionary.setPreferredSize(new java.awt.Dimension(91, 16));
			}
			{
				jTextFieldDictionary = new JTextField();
				getContentPane().add(jTextFieldDictionary, new AnchorConstraint(324, 436, 398, 9, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jTextFieldDictionary.setPreferredSize(new java.awt.Dimension(299, 28));
			}
			{
				jLabelPuzzle = new JLabel();
				getContentPane().add(jLabelPuzzle, new AnchorConstraint(64, 103, 107, 9, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabelPuzzle.setText("Puzzle File");
			}
			{
				jTextFieldPuzzle = new JTextField();
				getContentPane().add(jTextFieldPuzzle, new AnchorConstraint(123, 437, 197, 9, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jTextFieldPuzzle.setPreferredSize(new java.awt.Dimension(300, 28));
				jTextFieldPuzzle.addFocusListener(new FocusAdapter() {
					public void focusGained(FocusEvent evt) {
						jTextFieldPuzzleFocusGained(evt);
					}
				});
			}
			pack();
			this.setSize(700, 400);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void jTextAreaPuzzleInputFocusGained(FocusEvent evt) {
		jTextFieldPuzzle.setText("");
	}
	
	private void jTextFieldPuzzleFocusGained(FocusEvent evt) {
		jTextAreaPuzzleInput.setText("");
	}

	public void addButtonListener(ActionListener b){
		jButtonSolve.addActionListener(b);
	}
	
	public String getPuzzleLocation(){
		return jTextFieldPuzzle.getText();
	}
	
	public String getDictionaryLocation(){
		return jTextFieldDictionary.getText();
	}
	
	public String getManualPuzzleInput(){
		return jTextAreaPuzzleInput.getText();
	}
}
