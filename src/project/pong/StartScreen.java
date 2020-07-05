package project.pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

public class StartScreen {
    //imageSwitcher
    private int quantity = 0;
    private ImageIcon ic0, ic1, ic2, ic3, ic4, ic5, ic6, ic7, ic8, ic9;

    //componenten
    private JLabel lblImage;
    private ImageIcon icon;
    private JButton btnPlay;
    private JButton btnSettings;
    private JButton btnCredits;

    //start game
    private static boolean game = true;

    //actionlisteners
    private ActionListener imgSwitcher;

    //timers
    final Timer timeImg = new Timer(10000, null);

    //holds current object
    private StartScreen star; //special
    private JFrame frame;
    private Settings settings;
    private Container cp;
    private Animation a;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    StartScreen s = new StartScreen();
                    //s.setStartScreen(s);
                    s.frame.setVisible(true);


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public StartScreen() {
        setStartScreen(this);
        frame = new JFrame("Pong Ultimate");
        cp = frame.getContentPane();
        frameStart();
        settings = new Settings(star);
        settings.getPnl().add(btnBack());
        screen();

    }

    public void screen() {

        initComponents();

        btnPlay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                cp.removeAll();
                Play p = new Play(getStartScreen());
                cp.add(p.getPnl());
                p.getPnl().add(btnBack());
                frame.revalidate();
                frame.repaint();
            }
        });

        btnSettings.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                cp.removeAll();
                cp.add(settings.getPnl());

                frame.revalidate();
                frame.repaint();
            }
        });

        btnCredits.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                cp.removeAll();
                Credits p = new Credits(getStartScreen());
                p.getPnl().add(btnBack());
                cp.add(p.getPnl());
                frame.revalidate();
                frame.repaint();
            }
        });

        labelEffect(btnPlay, true);
        labelEffect(btnSettings, false);
        labelEffect(btnCredits, false);

        startTimerSwitcher();

        a.startTimer();

        frame.setResizable(false);    //as last
    }

    public void labelEffect(JComponent comp, boolean boolPlay) {

        comp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                if (boolPlay) {
                    comp.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 52));
                } else {
                    comp.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 36));
                }
                comp.setForeground(Color.WHITE);
                game = false;
            }

            public void mouseExited(MouseEvent arg0) {
                if (boolPlay) {
                    comp.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 43));
                } else {
                    comp.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 31));
                }
                comp.setForeground(Color.LIGHT_GRAY);
                game = true;
            }
        });

    }

    public void Switcher() {

        switch (quantity) {
            case 0:
                lblImage.setIcon(ic0);
                break;
            case 1:
                lblImage.setIcon(ic1);
                break;
            case 2:
                lblImage.setIcon(ic2);
                break;
            case 3:
                lblImage.setIcon(ic3);
                break;
            case 4:
                lblImage.setIcon(ic4);
                break;
            case 5:
                lblImage.setIcon(ic5);
                break;
            case 6:
                lblImage.setIcon(ic6);
                break;
            case 7:
                lblImage.setIcon(ic7);
                break;
            case 8:
                lblImage.setIcon(ic8);
                break;
            case 9:
                lblImage.setIcon(ic9);
                break;
            default:
                lblImage.setIcon(ic0);

        }

        if (quantity != 9) {
            quantity++;
        } else {
            quantity = 0;
        }
    }

    public void startTimerSwitcher() {
        imgSwitcher = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                Switcher();
            }
        };

        if (!timeImg.isRunning()) {

            timeImg.setInitialDelay(1000);
            timeImg.addActionListener(imgSwitcher);
            timeImg.start();
        }
    }

    //returns a universal back button to this frame => reduce code
    @SuppressWarnings("serial")
    public JButton btnBack() {
        URL img60 = StartScreen.class.getResource("/back60.png");
        URL img70 = StartScreen.class.getResource("/back70.png");
        ImageIcon back60 = new ImageIcon(img60);
        ImageIcon back70 = new ImageIcon(img70);

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

                cp.removeAll();
                screen();
                game = true;
                frame.revalidate();
                frame.repaint();
            }
        });
        btnBACK.setBounds(0, 3, 86, 81);
        btnBACK.setIcon(back60);
        btnBACK.setFocusPainted(false);
        btnBACK.setBorderPainted(false);

        bindKeyStrokeTo(btnBACK, JComponent.WHEN_IN_FOCUSED_WINDOW, "backbtn", KeyStroke.getKeyStroke(settings.getGenReturn(), 0), new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {

                cp.removeAll();
                screen();
                game = true;
                frame.revalidate();
                frame.repaint();
            }

        });

        return btnBACK;
    }

    public void initComponents() {

        //icon frame
        URL iconUrl = StartScreen.class.getResource("/icon.png");
        icon = new ImageIcon(iconUrl);
        frame.setIconImage(icon.getImage());

        //button play
        btnPlay = new JButton("PLAY");
        btnPlay.setForeground(Color.LIGHT_GRAY);
        btnPlay.setFocusPainted(false);
        btnPlay.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 43));
        btnPlay.setBorder(null);
        btnPlay.setBackground(Color.BLACK);
        btnPlay.setBounds(310, 123, 137, 74);
        cp.add(btnPlay);

        //button settings
        btnSettings = new JButton("Settings");
        btnSettings.setForeground(Color.LIGHT_GRAY);
        btnSettings.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 31));
        btnSettings.setFocusPainted(false);
        btnSettings.setBorder(null);
        btnSettings.setBackground(Color.BLACK);
        btnSettings.setBounds(310, 197, 150, 74);
        cp.add(btnSettings);

        //button credits
        btnCredits = new JButton("Credits");
        btnCredits.setForeground(Color.LIGHT_GRAY);
        btnCredits.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 31));
        btnCredits.setFocusPainted(false);
        btnCredits.setBorder(null);
        btnCredits.setBackground(Color.BLACK);
        btnCredits.setBounds(310, 271, 137, 74);
        cp.add(btnCredits);

        //PONG text
        JLabel lblPong = new JLabel("PONG");
        lblPong.setForeground(Color.WHITE);
        lblPong.setFont(new Font("Snap ITC", Font.PLAIN, 60));
        lblPong.setBackground(Color.BLACK);
        lblPong.setBounds(130, 12, 250, 100);
        cp.add(lblPong);

        //urlsobjects
        URL Uic0 = StartScreen.class.getResource("/main.png");
        URL Uic1 = StartScreen.class.getResource("/hqdefault.jpg");
        URL Uic2 = StartScreen.class.getResource("/ic2.jpg");
        URL Uic3 = StartScreen.class.getResource("/ic3.jpeg");
        URL Uic4 = StartScreen.class.getResource("/ic4.jpg");
        URL Uic5 = StartScreen.class.getResource("/ic5.jpg");
        URL Uic6 = StartScreen.class.getResource("/ic6.png");
        URL Uic7 = StartScreen.class.getResource("/ic7.png");
        URL Uic8 = StartScreen.class.getResource("/ic8.png");
        URL Uic9 = StartScreen.class.getResource("/ic9.png");
        //imageSwitcherObjects
        ic0 = new ImageIcon(Uic0);
        ic1 = new ImageIcon(Uic1);
        ic2 = new ImageIcon(Uic2);
        ic3 = new ImageIcon(Uic3);
        ic4 = new ImageIcon(Uic4);
        ic5 = new ImageIcon(Uic5);
        ic6 = new ImageIcon(Uic6);
        ic7 = new ImageIcon(Uic7);
        ic8 = new ImageIcon(Uic8);
        ic9 = new ImageIcon(Uic9);
        lblImage = new JLabel(ic0);
        lblImage.setLocation(40, 120);
        lblImage.setSize(new Dimension(225, 225));
        cp.add(lblImage);
        lblImage.setBorder(BorderFactory.createRaisedBevelBorder());

        a = new Animation();
        cp.add(a);

    }

    public void bindKeyStrokeTo(JComponent comp, int condition, String name, KeyStroke keyStroke, Action action) {

        InputMap im = comp.getInputMap(condition);
        ActionMap am = comp.getActionMap();
        im.clear();
        am.clear();
        im.put(keyStroke, name);
        am.put(name, action);
		
		/*for(Object e: im.allKeys()) {
			System.out.println(e);
			
		}*/
    }

    public void frameStart() {
        //Set frame basics
        cp.setLayout(null);
        cp.setBackground(Color.BLACK);
        cp.setForeground(Color.WHITE);
        frame.setSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    /**
     * =====--------------Getters && Setters--------------=====
     */
    public StartScreen getStartScreen() {
        return star;
    }

    public void setStartScreen(StartScreen object) {
        star = object;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public static boolean isGame() {
        return game;
    }

    public void setGame(boolean game) {
        StartScreen.game = game;
    }
}
	



