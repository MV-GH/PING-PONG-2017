package project.pong;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class Settings {
	
	private JCheckBox chkBoxSounds = new JCheckBox("",true);
	
	//settings props
	private boolean soundsClassic = true;
	private int p1Up = KeyEvent.VK_UP, 
			    p1Down = KeyEvent.VK_DOWN, 
			    p2Up = KeyEvent.VK_Z, 
			    p2Down = KeyEvent.VK_S,
			    genReturn= KeyEvent.VK_ESCAPE;
	
	private boolean ignore = true;
	
	//compononts
	private JPanel pnl = new JPanel(),
				   tab1 = new JPanel(),
			       tab2 = new JPanel(),
			       tab3 = new JPanel(),
			       tab4 = new JPanel(),
			       tab5 = new JPanel();
	private JTabbedPane tabbedPane;
	private JLabel lbltitle,lblPlayer,lblPlayer2,lblp1Up,lblp1Down,lblp2Up,lblp2Down,lblGenReturn;
	
	private StartScreen startscreen;
			
	public Settings(StartScreen ss) {
		startscreen = ss;
		mainPanel();
	}
	
	public void mainPanel() {
		
		initComponents();
				
		keyChanger(lblp1Up,1);
		keyChanger(lblp1Down,2);
		keyChanger(lblp2Up,3);
		keyChanger(lblp2Down,4);
		keyChanger(lblGenReturn,5);
		
		checkboxUpdater(chkBoxSounds,1);
		
	}
	
	public void initComponents() {
		//Initial Components
		pnl.setBackground(Color.BLACK);
		pnl.setLocation(0, 0);
		pnl.setSize(new Dimension(500,500));
		pnl.setLayout(null);
		
		tabbedPane = new JTabbedPane();
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setForeground(Color.BLACK);
		tabbedPane.setBounds(0, 92, 500, 397);
		
		tab1.setForeground(Color.WHITE);
		tab1.setBackground(Color.BLACK);
		tab1.setLayout(null);
		tabbedPane.addTab("Classic", tab1);
		
		tab2.setBackground(Color.BLACK);
		tab2.setForeground(Color.WHITE);
		tab2.setLayout(null);
		tabbedPane.addTab("Modern", tab2);
		
		tab3.setBackground(Color.BLACK);
		tab3.setForeground(Color.WHITE);
		tab3.setLayout(null);
		tabbedPane.addTab("Pong of the hill", tab3);
		
		tab4.setForeground(Color.WHITE);
		tab4.setBackground(Color.BLACK);
		tab4.setLayout(null);
		tabbedPane.addTab("Reborn", tab4);
		
		tab5.setForeground(Color.WHITE);
		tab5.setBackground(Color.BLACK);
		tab5.setLayout(null);
		tabbedPane.addTab("Keybindings", tab5);
		
		chkBoxSounds.setBackground(Color.BLACK);
		chkBoxSounds.setBounds(89, 38, 21, 21);
		tab1.add(chkBoxSounds);
		
		JLabel lblSoundClassic = new JLabel("Sounds ");
		lblSoundClassic.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblSoundClassic.setForeground(Color.WHITE);
		lblSoundClassic.setBackground(new Color(240, 240, 240));
		lblSoundClassic.setBounds(10, 38, 73, 21);
		tab1.add(lblSoundClassic);
								
		pnl.add(tabbedPane);
				
		JPanel pnlRight = new JPanel();
		pnlRight.setBounds(245, 162, 274, 232);
		pnlRight.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
		pnlRight.setForeground(Color.WHITE);
		pnlRight.setBackground(Color.BLACK);
		pnlRight.setLayout(null);
		tab5.add(pnlRight);
		
		lblPlayer2 = new JLabel();
		lblPlayer2.setBounds(72, 11, 128, 31);
		lblPlayer2.setText("PLAYER 2");
		lblPlayer2.setForeground(Color.WHITE);
		lblPlayer2.setFont(new Font("Tahoma", Font.PLAIN, 25));	
		lblPlayer2.setBorder(null);
		lblPlayer2.setBackground(Color.BLACK);
		pnlRight.add(lblPlayer2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255)), "Paddle", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(21, 40, 210, 73);
		pnlRight.add(panel_1);
		
		JLabel lblToGoUp = new JLabel("To go up:");
		lblToGoUp.setForeground(Color.WHITE);
		lblToGoUp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblToGoUp.setBounds(22, 17, 74, 16);
		panel_1.add(lblToGoUp);
		
		JLabel lblToGoDown = new JLabel("To go down:");
		lblToGoDown.setBounds(22, 42, 74, 18);
		panel_1.add(lblToGoDown);
		lblToGoDown.setForeground(Color.WHITE);
		lblToGoDown.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		lblp2Up = new JLabel();
		lblp2Up.setBounds(106, 16, 86, 20);
		panel_1.add(lblp2Up);
		lblp2Up.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblp2Up.setText(KeyEvent.getKeyText(p2Up));
		lblp2Up.setForeground(Color.WHITE);
		lblp2Up.setBorder(null);
		lblp2Up.setBackground(Color.BLACK);
		
		lblp2Down = new JLabel();
		lblp2Down.setBounds(106, 42, 96, 20);
		panel_1.add(lblp2Down);
		lblp2Down.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblp2Down.setText(KeyEvent.getKeyText(p2Down));
		lblp2Down.setForeground(Color.WHITE);
		lblp2Down.setBorder(null);
		lblp2Down.setBackground(Color.BLACK);
		
		JPanel pnlLeft = new JPanel();
		pnlLeft.setBorder(new LineBorder(Color.WHITE, 2));
		pnlLeft.setBounds(-11, 162, 260, 221);
		pnlLeft.setBackground(Color.BLACK);
		pnlLeft.setLayout(null);
		tab5.add(pnlLeft);
		
		lblPlayer = new JLabel();
		lblPlayer.setBounds(62, 11, 113, 31);
		lblPlayer.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPlayer.setBorder(null);
		lblPlayer.setForeground(Color.WHITE);
		lblPlayer.setBackground(Color.BLACK);
		lblPlayer.setText("PLAYER 1");
		pnlLeft.add(lblPlayer);
		
		JPanel panel = new JPanel();
		panel.setBounds(23, 39, 216, 73);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255)), "Paddle", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel.setBackground(Color.BLACK);
		panel.setLayout(null);
		pnlLeft.add(panel);
		
		JLabel lblPaddleUp = new JLabel("To go up:");
		lblPaddleUp.setBounds(22, 17, 80, 16);
		panel.add(lblPaddleUp);
		lblPaddleUp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPaddleUp.setForeground(Color.WHITE);
		
		lblp1Up = new JLabel();
		lblp1Up.setBounds(110, 16, 86, 20);
		panel.add(lblp1Up);
		lblp1Up.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblp1Up.setText(KeyEvent.getKeyText(p1Up));
		lblp1Up.setBorder(null);
		lblp1Up.setForeground(Color.WHITE);
		lblp1Up.setBackground(Color.BLACK);
		
		JLabel lblPaddleDown = new JLabel("To go Down:");
		lblPaddleDown.setBounds(22, 42, 80, 18);
		panel.add(lblPaddleDown);
		lblPaddleDown.setForeground(Color.WHITE);
		lblPaddleDown.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		lblp1Down = new JLabel();
		lblp1Down.setBounds(110, 42, 98, 20);
		panel.add(lblp1Down);
		lblp1Down.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblp1Down.setText(KeyEvent.getKeyText(p1Down));
		lblp1Down.setForeground(Color.WHITE);
		lblp1Down.setBorder(null);
		lblp1Down.setBackground(Color.BLACK);
		
		lbltitle = new JLabel("Settings");
		lbltitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitle.setFont(new Font("Lucida Handwriting", Font.BOLD, 39));
		lbltitle.setForeground(Color.WHITE);
		lbltitle.setBounds(43, 27, 404, 54);
		pnl.add(lbltitle);
		
		JPanel pnlTop = new JPanel();
		pnlTop.setBackground(Color.BLACK);
		pnlTop.setBounds(0, 0, 495, 173);
		pnlTop.setLayout(null);
		tab5.add(pnlTop);
				
		JLabel lblGeneral = new JLabel();
		lblGeneral.setBounds(188, 5, 118, 34);
		lblGeneral.setText("GENERAL");
		lblGeneral.setForeground(Color.WHITE);
		lblGeneral.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblGeneral.setBorder(null);
		lblGeneral.setBackground(Color.BLACK);
		pnlTop.add(lblGeneral);
		
		JLabel lblReturn = new JLabel(" Previous page:");
		lblReturn.setToolTipText("Go to previous page button:");
		lblReturn.setForeground(Color.WHITE);
		lblReturn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblReturn.setBounds(10, 33, 97, 16);
		pnlTop.add(lblReturn);
		
		lblGenReturn = new JLabel();
		lblGenReturn.setText(KeyEvent.getKeyText(genReturn));
		lblGenReturn.setForeground(Color.WHITE);
		lblGenReturn.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGenReturn.setBorder(null);
		lblGenReturn.setBackground(Color.BLACK);
		lblGenReturn.setBounds(117, 32, 86, 20);
		pnlTop.add(lblGenReturn);
	}		
	
	//makes Jlabel keychangeable needs a Jlabel and int to store value; parameter: the JLabel and number corresponding case
	public void keyChanger(JLabel comp,int box) {
		comp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				comp.setForeground(Color.GREEN);
				ignore= false;
				comp.setFocusable(true);
				comp.setFocusTraversalKeysEnabled(false);
				comp.requestFocusInWindow();
			}
		});
		
		comp.addKeyListener(new KeyAdapter(){
			@Override
			public void keyReleased(KeyEvent e) {
				if(!ignore){
					
					if(box==5) {
					//System.out.println(startscreen);	
					System.out.println(startscreen.btnBack().getInputMap(2).size());
						
					startscreen.btnBack().getInputMap(2).remove(startscreen.btnBack().getInputMap().allKeys()[0]);
					System.out.println(startscreen.btnBack().getInputMap(2).size());
					//comp.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(keyStroke, actionMapKey);
					}
					
					ignore = true;
					comp.setText(KeyEvent.getKeyText(e.getKeyCode()));
					comp.setForeground(Color.WHITE);
					
					switch(box) {
					case 1: p1Up= e.getKeyCode();break;
					case 2: p1Down= e.getKeyCode();break;
					case 3: p2Up= e.getKeyCode();break;
					case 4: p2Down= e.getKeyCode();break;
					case 5: genReturn= e.getKeyCode();break;
					default: ;
					
					}
				}
			}
		});
	}
	
	public void checkboxUpdater(JCheckBox chkBox, int box) {
		chkBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				
				switch(box) {
				case 1: soundsClassic = chkBox.isSelected(); break;
				}
			}
		});
	}
	
	/**	=====--------------Getters && Setters--------------===== */
	public boolean isSoundsClassic() {return soundsClassic;}
	public JPanel getPnl() {return pnl;}
	public int getP1Up() {return p1Up;}
	public int getP1Down() {return p1Down;}
	public int getP2Up() {return p2Up;}	
	public int getP2Down() {return p2Down;}
	public int getGenReturn() { return genReturn; }
	public void setSoundsClassic(boolean soundsClassic) {this.soundsClassic = soundsClassic;}
	public void setPnl(JPanel pnl) {this.pnl = pnl;}
	public void setP1Up(int p1Up) {this.p1Up = p1Up;}
	public void setP1Down(int p1Down) {this.p1Down = p1Down;}
	public void setP2Up(int p2Up) {this.p2Up = p2Up;}
	public void setP2Down(int p2Down) {this.p2Down = p2Down;}
	public void setGenReturn(int genReturn) { this.genReturn = genReturn; }
}
