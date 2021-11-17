package test_project;

import javax.swing.*;
import java.awt.event.*;


public class GenericTextBox extends JTextField implements ActionListener {
	public GenericTextBox(JLabel label, String actionCommandString, Integer columns) {
		this.setColumns(columns);
		this.setActionCommand(actionCommandString);
		this.addActionListener(this);

		label.setLabelFor(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// ToDo
	}
	
}
