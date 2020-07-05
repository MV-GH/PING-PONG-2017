package project.pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Play {
	
	//standard objects
	private JPanel pnl = new JPanel();
		
	//objects of this class
	JLabel lbltxtSingle;
	JLabel lbltxtMulti;
	//stored objects
	private StartScreen ss = null;
	public Play(StartScreen st) {
		ss = st;
		screen();
	}
	public void screen() {
				
		//panel props
		pnl.setBackground(Color.BLACK);
		pnl.setLocation(0, 0);
		pnl.setSize(new Dimension(500,500));
		pnl.setLayout(null);		
		
		JLabel lblSinglePlayer = new JLabel("SinglePlayer");
		lblSinglePlayer.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				ss.getFrame().getContentPane().removeAll();
				PlayUniversalGamemodeChooser p = new PlayUniversalGamemodeChooser(ss,true);
				ss.getFrame().add(p.getPnl());
				ss.getFrame().revalidate();
				ss.getFrame().repaint();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSinglePlayer.setForeground(Color.white);
				lbltxtSingle.setForeground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblSinglePlayer.setForeground(Color.LIGHT_GRAY);
				lbltxtSingle.setForeground(Color.lightGray);
			}
		});
		lblSinglePlayer.setHorizontalAlignment(SwingConstants.LEFT);
		lblSinglePlayer.setFont(new Font("Stencil", Font.PLAIN, 24));
		lblSinglePlayer.setForeground(Color.LIGHT_GRAY);
		lblSinglePlayer.setBackground(Color.BLACK);
		lblSinglePlayer.setBounds(49, 140, 175, 150);
		pnl.add(lblSinglePlayer);
		
		JLabel lblMultiPlayer = new JLabel("MultiPlayer");
		lblMultiPlayer.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ss.getFrame().getContentPane().removeAll();
				PlayUniversalGamemodeChooser p = new PlayUniversalGamemodeChooser(ss,false);
				ss.getFrame().add(p.getPnl());
				ss.getFrame().revalidate();
				ss.getFrame().repaint();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblMultiPlayer.setForeground(Color.white);
				lbltxtMulti.setForeground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblMultiPlayer.setForeground(Color.LIGHT_GRAY);
				lbltxtMulti.setForeground(Color.lightGray);
			}
		});
		lblMultiPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		lblMultiPlayer.setFont(new Font("Stencil", Font.PLAIN, 24));
		lblMultiPlayer.setForeground(Color.lightGray);
		lblMultiPlayer.setBackground(Color.BLACK);
		lblMultiPlayer.setBounds(260, 140, 175, 150);
		pnl.add(lblMultiPlayer);
		
		lbltxtSingle = new JLabel("\"Player versus AI\"");
		lbltxtSingle.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 15));
		lbltxtSingle.setHorizontalAlignment(SwingConstants.CENTER);
		lbltxtSingle.setForeground(Color.lightGray);
		lbltxtSingle.setBackground(Color.BLACK);
		lbltxtSingle.setBounds(64, 222, 133, 21);
		pnl.add(lbltxtSingle);
		
		lbltxtMulti = new JLabel("\"Player vs Player\"");
		lbltxtMulti.setHorizontalAlignment(SwingConstants.CENTER);
		lbltxtMulti.setForeground(Color.lightGray);
		lbltxtMulti.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 15));
		lbltxtMulti.setBackground(Color.BLACK);
		lbltxtMulti.setBounds(281, 222, 133, 21);
		pnl.add(lbltxtMulti);
		
		JLabel lblPong = new JLabel("PONG");
		lblPong.setForeground(Color.WHITE);
		lblPong.setFont(new Font("Snap ITC", Font.PLAIN, 60));
		lblPong.setBackground(Color.BLACK);
		lblPong.setBounds(130, 12, 250, 100);
		pnl.add(lblPong);
		
}
	public JPanel getPnl() {return pnl;}
	public void setPnl(JPanel pnl) {this.pnl = pnl;}
	public StartScreen getSs() {return ss;}
	public void setSs(StartScreen ss) {this.ss = ss;}
}
