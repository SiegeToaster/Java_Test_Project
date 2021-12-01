package test_project;

import java.awt.*;
// import java.awt.event.*;
import java.util.LinkedList;
import java.util.List;
import javax.swing.*;
// import javax.swing.text.*;

class TestProject extends JPanel {

	protected static JButton stopButton, testPrintButton, lineButton;
	protected static JTextField x1Input, y1Input, x2Input, y2Input;
	protected static JLabel x1InputLabel, y1InputLabel, x2InputLabel, y2InputLabel, actionLabel;

	private static final LinkedList<Line> lines = new LinkedList<>();
	public static final TestProject comp = new TestProject();
	protected static JTextField[] textFieldArr = {x1Input, y1Input, x2Input, y2Input};

	public static JButton getStopButton() {
		return stopButton;
	}

	public static TestProject getComp() {
		return comp;
	}

	public static List<Line> getLines() {
		return lines;
	}

	public static JTextField[] getTextFields() {
		return textFieldArr;
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

	public void buildGrid() {
		// addLine(x1, y1, x2, y2, (color))
		// left boundry = 150px
		// right boundry = 974
		// top boundry = 25px
		// bottom boundry = 575
		// midVertical = 562
		// midHorizontal = 300
		// middle point = 275, 300
		addLine(150, 25, 150, 575); // left
		addLine(150, 25, 974, 25); // top
		addLine(974, 25, 974, 575); // right
		addLine(974, 575, 150, 575); // bottom
		addLine(150, 300, 974, 300); // midHorizontal
		addLine(562, 25, 562, 575); // midVertical
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
		setLayout(new BorderLayout());

		// create coordinate input labels
		x1InputLabel = new JLabel("X1: ");
		y1InputLabel = new JLabel("Y1: ");
		x2InputLabel = new JLabel("X2: ");
		y2InputLabel = new JLabel("Y2: ");
		JLabel[] inputLabels = {x1InputLabel, y1InputLabel, x2InputLabel, y2InputLabel};

		// create coordinate inputs
		x1Input = new test_project.GenericTextBox(x1InputLabel, "x1", 5);
		y1Input = new test_project.GenericTextBox(y1InputLabel, "y1", 5);
		x2Input = new test_project.GenericTextBox(x2InputLabel, "x2", 5);
		y2Input = new test_project.GenericTextBox(y2InputLabel, "y2", 5);
		JTextField[] inputFields = {x1Input, x2Input, y1Input, y2Input}; //ToDo: find a way to put this at top level and make getInputFields() thing

		actionLabel = new JLabel("Type text in a field and press Enter.");
        actionLabel.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));

		// create buttons
		stopButton = new test_project.GenericButton("Stop");
		lineButton = new test_project.GenericButton("Line");
		JButton[] buttons = {stopButton, lineButton};

		// Lay out the text controls and the labels.
        JPanel textControlsPane = new JPanel();
        GridBagLayout gridbag = new GridBagLayout();
		textControlsPane.setLayout(gridbag);
        BuildJPanel.labelTextRows(inputLabels, inputFields, textControlsPane);

		// Lay out buttons
		JPanel buttonsPane = new JPanel();
		buttonsPane.setLayout(gridbag);
		BuildJPanel.buttons(buttons, buttonsPane);

		// Construct main control JPanel
		JPanel leftPane = new JPanel(new BorderLayout());
        leftPane.add(
			textControlsPane, 
			BorderLayout.PAGE_START
		);
		leftPane.add(
			buttonsPane,
			BorderLayout.CENTER
		);

		// add everything
		add(leftPane, BorderLayout.LINE_START);
	}
}

// https://docs.oracle.com/javase/tutorial/uiswing/components/jcomponent.html