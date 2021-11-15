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
			
			case "Print":
					System.out.println("Joe.");
				break;

			case "Line":
					System.out.println("Draw Line.");
					int x1 = (int) (Math.random()*1000);
					int x2 = (int) (Math.random()*1000);
					int y1 = (int) (Math.random()*600);
					int y2 = (int) (Math.random()*600);
					Color randomColor = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
					TestProject.getComp().addLine(x1, y1, x2, y2, randomColor);
				break;
		
			default:
				break;
		}
	}
}