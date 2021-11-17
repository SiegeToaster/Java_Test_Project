package test_project;

import javax.swing.*;
import java.awt.*;

// Don't really know what is going on here.  Basically just adding the text boxes and labels
public class AddLabelTextRows {
	// "Add a private constructor to hide the implicit public one."
	//  No.
	public static void main
		(
			JLabel[] labels,
			JTextField[] textFields,
			GridBagLayout gridbag, // remove if not needed
			Container container
		) {
			GridBagConstraints c = new GridBagConstraints();
			c.anchor = GridBagConstraints.EAST;
			int numLabels = labels.length;

			for (int i = 0; i < numLabels; i++) {
				c.gridwidth = GridBagConstraints.RELATIVE; //next-to-last
				c.fill = GridBagConstraints.NONE;      //reset to default
				c.weightx = 0.0;                       //reset to default
				container.add(labels[i], c);
	
				c.gridwidth = GridBagConstraints.REMAINDER;     //end row
				c.fill = GridBagConstraints.HORIZONTAL;
				c.weightx = 1.0;
				container.add(textFields[i], c);
			}
		}
}
