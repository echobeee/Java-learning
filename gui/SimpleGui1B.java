import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGui1B implements ActionListener {

	JFrame frame = new JFrame();

	JButton button = new JButton("click me");
	JCheckBox box = new JCheckBox("choose me");
	public static void main (String[] args) {
		SimpleGui1B gui = new SimpleGui1B();
		gui.go();
	}

	public void go() {
		button.addActionListener(this); // arguments must be an object from a class that implements ActionListener!

		frame.getContentPane().add(BorderLayout.SOUTH, button);
		frame.getContentPane().add(BorderLayout.CENTER, box);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close the window -> quit the program
		frame.setSize(300, 300);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {
		button.setText("I am clicked!");
		frame.repaint();
	}

}