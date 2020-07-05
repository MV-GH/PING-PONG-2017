package project.pong;


import javax.swing.*;

public class Pong  {

	
	private final static int WIDTH = 500;
	public static int getWidth() {
		return WIDTH;
	}

	public static int getHeight() {
		return HEIGHT;
	}

	private final static int HEIGHT = 500;
	
	public void mainPong(){
		JFrame frame = new JFrame();
		Gameplay gp = new Gameplay();
		frame.setBounds(10,10,WIDTH, HEIGHT);
		frame.setTitle("Pong");
		
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(gp);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
	
	
}

	
