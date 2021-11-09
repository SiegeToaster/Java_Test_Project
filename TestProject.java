import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TestProject extends JPanel
				implements ActionListener {

	protected JButton testButton;

	public TestProject() {
		testButton = new JButton("test");
		testButton.setVerticalTextPosition(SwingConstants.CENTER);
		testButton.setHorizontalTextPosition(SwingConstants.LEADING);
		testButton.setMnemonic(KeyEvent.VK_D);
		testButton.setActionCommand("disable");

		testButton.addActionListener(this);
		testButton.setToolTipText("OOGA BOOGA");
		add(testButton);
	}

	public void actionPerformed(ActionEvent e) {
		if ("disable".equals(e.getActionCommand())) {
			testButton.setEnabled(false);
		} else {
			testButton.setEnabled(true);
		}
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(() -> {
			//Create and set up the window.
			JFrame frame = new JFrame("Test Window");
			frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
			
			TestProject newContentPane = new TestProject();
			newContentPane.setOpaque(true);
			frame.setContentPane(newContentPane);


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