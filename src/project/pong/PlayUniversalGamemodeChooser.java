package project.pong;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

public class PlayUniversalGamemodeChooser {
	//default objects
	private JPanel pnl = new JPanel();
	
	URL img60 = StartScreen.class.getResource("/back60.png");
	URL img70 = StartScreen.class.getResource("/back70.png");
	ImageIcon back60 = new ImageIcon(img60);
	ImageIcon back70 = new ImageIcon(img70);
	
	URL uclassic = StartScreen.class.getResource("/pongClassic.png");
	URL umodern = StartScreen.class.getResource("/pongModern.png");
	URL utime = StartScreen.class.getResource("/pongTime.png");
	URL ureborn = StartScreen.class.getResource("/pongReborn.png");
	
	private ImageIcon classic = new ImageIcon(uclassic);
	private ImageIcon modern = new ImageIcon(umodern);
	private ImageIcon time = new ImageIcon(utime);
	private ImageIcon reborn = new ImageIcon(ureborn);
	
	private StartScreen ss = null;
	
	private boolean single;
	public PlayUniversalGamemodeChooser(StartScreen st, boolean s) {
		ss = st;
		single = s;
		playScreen();
	}
	
	public void playScreen(){
		//panel props
		pnl.setBackground(Color.BLACK);
		pnl.setLocation(0, 0);
		pnl.setSize(new Dimension(500,500));
		pnl.setLayout(null);
		

		JButton btnBACK = new JButton();
		btnBACK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnBACK.setIcon(back70);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBACK.setIcon(back60);
			}
		});
		btnBACK.setBackground(Color.BLACK);
		btnBACK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				ss.getFrame().getContentPane().removeAll();
				Play p =new Play(ss);
				ss.getFrame().add(p.getPnl());
				p.getPnl().add(ss.btnBack());
				ss.getFrame().revalidate();
				ss.getFrame().repaint();
			
			}
		});
		btnBACK.setBounds(0, 3, 86, 81);
		btnBACK.setIcon(back60);
		btnBACK.setFocusPainted(false);
		btnBACK.setBorderPainted(false);
		pnl.add(btnBACK);
		
		Border border = BorderFactory.createEtchedBorder();
				
		JLabel lblClassicPong = new JLabel();
		lblClassicPong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblClassicPong.setBorder(null);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblClassicPong.setBorder(border);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(single) {
					
				}else {
					
				} 
			}
		});
		
		lblClassicPong.setIcon(classic);
		lblClassicPong.setBorder(border);
		lblClassicPong.setBounds(90, 115, 150, 150);
		pnl.add(lblClassicPong);
		
		JLabel lblModern = new JLabel();
		lblModern.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblModern.setBorder(null);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblModern.setBorder(border);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(single) {
					
				}else {
					
				} 
			}
		});
		
		lblModern.setIcon(modern);
		lblModern.setBorder(border);
		lblModern.setBounds(250, 115, 150, 150);
		pnl.add(lblModern);
		
		JLabel lblHowLongCan = new JLabel();
		lblHowLongCan.setBorder(border);
		lblHowLongCan.setIcon(time);
		lblHowLongCan.setBounds(90, 300, 150, 150);
		lblHowLongCan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblHowLongCan.setBorder(null);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblHowLongCan.setBorder(border);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(single) {
					
				}else {
					
				} 
			}
		});
		pnl.add(lblHowLongCan);
		
		JLabel lblPongReborn = new JLabel();
		lblPongReborn.setBorder(border);
		lblPongReborn.setIcon(reborn);
		lblPongReborn.setBounds(250, 300, 150, 150);
		lblPongReborn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblPongReborn.setBorder(null);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblPongReborn.setBorder(border);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(single) {
					
				}else {
					
				} 
			}
		});
		pnl.add(lblPongReborn);
		
		JLabel lbltxtPong = new JLabel("Classic Pong");
		lbltxtPong.setHorizontalAlignment(SwingConstants.CENTER);
		lbltxtPong.setFont(new Font("Lucida Fax", Font.BOLD, 18));
		lbltxtPong.setForeground(Color.WHITE);
		lbltxtPong.setBackground(Color.BLACK);
		lbltxtPong.setBounds(89, 90, 151, 22);
		pnl.add(lbltxtPong);
		
		JLabel lblModernPong = new JLabel("Modern Pong");
		lblModernPong.setHorizontalAlignment(SwingConstants.CENTER);
		lblModernPong.setForeground(Color.WHITE);
		lblModernPong.setFont(new Font("Lucida Fax", Font.BOLD, 18));
		lblModernPong.setBackground(Color.BLACK);
		lblModernPong.setBounds(250, 90, 151, 22);
		pnl.add(lblModernPong);
		
		JLabel lblPongOfThe = new JLabel("Pong of the Hill");
		lblPongOfThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblPongOfThe.setForeground(Color.WHITE);
		lblPongOfThe.setFont(new Font("Lucida Fax", Font.BOLD, 18));
		lblPongOfThe.setBackground(Color.BLACK);
		lblPongOfThe.setBounds(90, 275, 151, 22);
		pnl.add(lblPongOfThe);
		
		JLabel lblPongReborn_1 = new JLabel("Pong REBORN");
		lblPongReborn_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPongReborn_1.setForeground(Color.WHITE);
		lblPongReborn_1.setFont(new Font("Lucida Fax", Font.BOLD, 18));
		lblPongReborn_1.setBackground(Color.BLACK);
		lblPongReborn_1.setBounds(249, 275, 151, 22);
		pnl.add(lblPongReborn_1);
		
		JLabel lblTitle = new JLabel("Pong MultiPlayer");	
		if(single) {
			lblTitle.setText("Pong SinglePlayer");
		}
		lblTitle.setFont(new Font("Viner Hand ITC", Font.BOLD, 39));
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(90, 11, 384, 73);
		pnl.add(lblTitle);
		
	}
	
	public JPanel getPnl() {
		return pnl;
	}
	
	public void setPnl(JPanel pnl) {
		this.pnl = pnl;
	}
}
