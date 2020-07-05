package project.pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gameplay extends JPanel implements KeyListener,ActionListener {


	private static final long serialVersionUID = 1L;
	
	private boolean play = false;
	private int xPosBall= 250;
	private int yPosBall= 250;
	private int xBallDir = -1;
	private int yBallDir = -1;
	private int delay = 8;
	private int yPlayer = 250; 
	private int yAI =250;
	
	private Timer timer ;
	
	public Gameplay(){
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		requestFocusInWindow();
		timer = new Timer(delay, this);
		timer.start();
		
	}
	public void move() {
        xPosBall += xBallDir;
        yPosBall += yBallDir;
    }
	public void paint(Graphics g){
		//background
		g.fillRect(0, 0, getWidth(), getHeight());	
		g.setColor(Color.BLACK);
		
		//borders
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), 10);
		g.fillRect(0,getHeight()-10, getWidth(), 10);
		
		//humanpaddle
		g.fillRect(15, yPlayer, 10, 50);
		
		//ball
		g.fillOval(xPosBall , yPosBall, 14, 14);
		
		//enemypaddle
		g.fillRect(475, yAI, 10, 50);
		
		
		g.dispose();
		
	}
	public void update(Graphics g) {
		paint(g);
	}

	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()== KeyEvent.VK_UP)
		{
			if(yPlayer > 10)
			{
				yPlayer -= 10;
				play =true;
			}
		}
		if(e.getKeyCode()== KeyEvent.VK_DOWN)
		{
			if(yPlayer < 410)
			{
				yPlayer += 10;
				play = true;
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		timer.start();
		yAI = yPosBall-25;
		if(play) {
			if(new Rectangle(15, yPlayer, 10, 50).intersects(new Rectangle(xPosBall , yPosBall, 14, 14)))
			{
				xBallDir = -xBallDir;
			}
						
			if(new Rectangle(475, yAI, 10, 50).intersects(new Rectangle(xPosBall , yPosBall, 14, 14)))
			{
				xBallDir = -xBallDir;
			}
			move();
			if(yPosBall <10) {
				yBallDir = -yBallDir;
				
			}
			if(yPosBall >450) {
				yBallDir = -yBallDir;
				
			}
		}
	
		
		repaint();
		
	}

}

