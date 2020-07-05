package project.pong;

import javax.swing.*;
import java.awt.*;

public class Credits {
	private StartScreen object;
	private JPanel pnl = new JPanel();
	
	public Credits(StartScreen obj) {
		object=obj;
		screen();
				
	}
	public void screen() {
		pnl.setBackground(Color.BLACK);
		pnl.setLocation(0, 0);
		pnl.setSize(new Dimension(500,500));
		pnl.setLayout(null);
		JLabel lblNewLabel = new JLabel("The Credits");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 42));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(156, 36, 242, 47);
		pnl.add(lblNewLabel);
		
		JLabel lblCredit = new JLabel("In progress");
		lblCredit.setFont(new Font("Tahoma", Font.ITALIC, 30));
		lblCredit.setForeground(Color.WHITE);
		lblCredit.setBounds(74, 138, 465, 110);
		pnl.add(lblCredit);

		JLabel lblCreator = new JLabel("Created by Maarten Vercruysse");
		lblCreator.setFont(new Font("Tahoma",Font.CENTER_BASELINE, 25));
		lblCreator.setForeground(Color.WHITE);
		lblCreator.setBounds(74, 200, 400, 110);
		pnl.add(lblCreator);
	}
	public StartScreen getObject() {
		return object;
	}
	public void setObject(StartScreen object) {
		this.object = object;
	}
	public JPanel getPnl() {
		return pnl;
	}
	public void setPnl(JPanel pnl) {
		this.pnl = pnl;
	}
}
