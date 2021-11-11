import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.LinkedList;

class TestProject extends JPanel {

	protected JButton stopButton, testPrintButton, lineButton;
	private final LinkedList<Line> lines = new LinkedList<>();
	static final TestProject comp = new TestProject();

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
						int x1 = (int) (Math.random()*1000);
						int x2 = (int) (Math.random()*1000);
						int y1 = (int) (Math.random()*600);
						int y2 = (int) (Math.random()*600);
						Color randomColor = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
						comp.addLine(x1, y1, x2, y2, randomColor);
					break;
			
				default:
					break;
			}
		}		
	}

	private static class Line {
		final int x1; 
		final int y1;
		final int x2;
		final int y2;   
		final Color color;
	
		public Line(int x1, int y1, int x2, int y2, Color color) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
			this.color = color;
		}
	}

	public void addLine(int x1, int x2, int x3, int x4) {
		addLine(x1, x2, x3, x4, Color.black);
	}
	
	public void addLine(int x1, int x2, int x3, int x4, Color color) {
		lines.add(new Line(x1,x2,x3,x4, color));        
		repaint();
	}

	public void clearLines() {
		lines.clear();
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Line line : lines) {
			g.setColor(line.color);
			g.drawLine(line.x1, line.y1, line.x2, line.y2);
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
			frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

			//Create blank label in content plane
			comp.setPreferredSize(new Dimension(1000, 600));
			frame.getContentPane().add(comp, BorderLayout.CENTER);

			//Display the window.
			frame.pack();
			frame.setVisible(true);
		});
	}
}

// https://docs.oracle.com/javase/tutorial/uiswing/components/jcomponent.html