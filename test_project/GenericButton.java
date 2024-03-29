package test_project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class GenericButton extends JButton implements ActionListener {
	public GenericButton(String buttonName) {
		this.setText(buttonName);
		this.setVerticalTextPosition(SwingConstants.CENTER);
		this.setHorizontalTextPosition(SwingConstants.LEADING);
		this.setActionCommand(buttonName);
		this.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case "Stop":
					TestProject.getStopButton().setEnabled(false);
					System.exit(0);
				break;
			
			case "Line":
					System.out.println("Draw Line.");
					// middle point = 563, 300 (x-value is not exact)
					JTextField[] inputArr = TestProject.getTextFields();
					Integer x1 = Integer.parseInt(inputArr[0].getText());
					Integer x2 = Integer.parseInt(inputArr[1].getText());
					Integer y1 = Integer.parseInt(inputArr[2].getText());
					Integer y2 = Integer.parseInt(inputArr[3].getText());
					System.out.println("(" + x1.toString() + ", " + y1.toString() + "), (" + x2.toString() + ", " + y2.toString() + ")");

					Color randomColor = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
					TestProject.getComp().addLine(x1, y1, x2, y2, randomColor);
				break;
		
			default:
				break;
		}
	}
}