package test_project;

import javax.swing.*;
import java.awt.*;

public class QuickStart {
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(() -> {
			//Create and set up the window.
			JFrame frame = new JFrame("Test Window");
			frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

			//Create blank label in content plane
			TestProject comp = TestProject.getComp();
			comp.setPreferredSize(new Dimension(1000, 600));
			frame.getContentPane().add(comp);

			//Display the window.
			frame.pack();
			comp.buildGrid();
			frame.setVisible(true);
		});
	}
}
