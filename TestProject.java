import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TestProject extends JPanel {

	protected JButton stopButton, testPrintButton, lineButton;

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
						stopButton.setEnabled(false);
						System.exit(0);
					break;
				
				case "Print":
						System.out.println("Joe.");
					break;

				case "Line":
						System.out.println("Draw Line.");
					break;
			
				default:
					break;
			}
		}		
	}

	public TestProject() {
		stopButton = new GenericButton("Stop");
		lineButton = new GenericButton("Line");
		testPrintButton = new GenericButton("Print");

		add(stopButton);
		add(testPrintButton);
		add(lineButton);
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