import java.awt.*;
import javax.swing.*;

class MyDrawPanel extends JPanel {
	public void paintComponent(Graphics g) {
		// 2D
		g.setColor(Color.orange);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		Image image = new ImageIcon("bg.jpg").getImage();
		g.drawImage(image, 120, 150, this);

		//3D
		Graphics2D g2d = (Graphics2D) g;

		GradientPaint gradient = new GradientPaint(70, 70, Color.black, 150, 150, Color.orange );
		//starting point, starting color, ending point, ending color
		
		g2d.setPaint(gradient);// this sets the virtual paint brush to a gradient instead of a solid color
		g2d.fillOval(70, 70, 100, 100);

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Graphics");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(new MyDrawPanel());
	}

}