import java.awt.*;
import javax.swing.*;

class QuickStart {
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(() -> {
			//Create and set up the window.
			JFrame frame = new JFrame("Test Window");
			// add stop program on exit
			

			//Create blank label in content plane
			JLabel emptyLabel = new JLabel("");
			emptyLabel.setPreferredSize(new Dimension(1000, 600));
			frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

			// JComponent contentPlaneBorder = new JComponent();

			JPanel contentPlane = new JPanel(new BorderLayout());
			// contentPlane.setBorder();

			frame.setContentPane(contentPlane);

			//Display the window.
			frame.pack();
			frame.setVisible(true);
		});
	}
}

// https://docs.oracle.com/javase/tutorial/uiswing/components/jcomponent.html;