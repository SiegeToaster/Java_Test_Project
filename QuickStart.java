import java.awt.*;
import javax.swing.*;

class QuickStart {
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(() -> {
			//Create and set up the window.
			JFrame frame = new JFrame("Test Window");
			frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
			
			//Create blank label in content plane
			JLabel emptyLabel = new JLabel("");
			emptyLabel.setPreferredSize(new Dimension(1000, 600));
			frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

			//Display the window.
			frame.pack();
			frame.setVisible(true);
		});
	}
}

// https://docs.oracle.com/javase/tutorial/uiswing/components/jcomponent.html