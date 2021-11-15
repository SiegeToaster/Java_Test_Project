package test_project;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class TestProject extends JPanel {

	protected static JButton stopButton;
	protected JButton testPrintButton;
	protected JButton lineButton;
	private static final LinkedList<Line> lines = new LinkedList<>();
	public static final TestProject comp = new TestProject();

	public static JButton getStopButton() {
		return stopButton;
	}

	public static TestProject getComp() {
		return comp;
	}

	public static List<Line> getLines() {
		return lines;
	}

	public void addLine(int x1, int x2, int x3, int x4) {
		addLine(x1, x2, x3, x4, Color.black);
	}
	
	public void addLine(int x1, int x2, int x3, int x4, Color color) {
		TestProject.getLines().add(new Line(x1,x2,x3,x4, color));        
		repaint();
	}

	public void clearLines() {
		TestProject.getLines().clear();
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Line line : TestProject.getLines()) {
			g.setColor(line.color);
			g.drawLine(line.x1, line.y1, line.x2, line.y2);
		}
	}

	public TestProject() {
		stopButton = new test_project.GenericButton("Stop");
		lineButton = new test_project.GenericButton("Line");
		testPrintButton = new test_project.GenericButton("Print");

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