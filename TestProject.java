import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TestProject extends JPanel
				implements ActionListener {

	protected JButton stopButton, testPrintButton;

	public TestProject() {
		stopButton = new JButton("Stop");
		stopButton.setVerticalTextPosition(SwingConstants.CENTER);
		stopButton.setHorizontalTextPosition(SwingConstants.LEADING);
		stopButton.setMnemonic(KeyEvent.VK_S);
		stopButton.setActionCommand("stopButton");
		stopButton.addActionListener(this);
		stopButton.setToolTipText("OOGA BOOGA");

		testPrintButton = new JButton("Print");
		testPrintButton.setVerticalTextPosition(SwingConstants.CENTER);
		testPrintButton.setHorizontalTextPosition(SwingConstants.LEADING);
		testPrintButton.setMnemonic(KeyEvent.VK_P);
		testPrintButton.setActionCommand("printButton");
		testPrintButton.addActionListener(this);
		testPrintButton.setToolTipText("YAAAHOOOOOO");

		add(stopButton);
		add(testPrintButton);
	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case "stopButton":
					stopButton.setEnabled(false);
					System.exit(0);
				break;
			
			case "printButton":
					System.out.println("Joe.");
				break;
		
			default:
				break;
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