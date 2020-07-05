package project.pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Animation extends JPanel {

    //kleine animatie eigenschappen
    //bal
    private int xBall = 230;
    private int yBall = 45;
    private int xBDir = 2;
    private int yBDir = -1;
    //paddel1
    private int y1 = 35;
    private int y1Dir = 1;
    //paddel2
    private int y2 = 35;
    private int y2Dir = 1;

    private int heightCanvasDifference = 39;
    private int sizeBall = 20;
    private int heightPanel = 40;

    private ActionListener updateTask;

    final Timer time = new Timer(10, null);

    public Animation() {
        this.setLocation(0, 350);
        this.setSize(new Dimension(500, 150));
        this.setBackground(Color.GREEN);
        this.setVisible(true);

    }

    public void startTimer() {
        updateTask = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (StartScreen.isGame()) {

                    update();
                    repaint();
                }
            }
        };

        if (!time.isRunning()) {
            time.setInitialDelay(100);
            time.addActionListener(updateTask);
            time.start();
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        g.setColor(Color.WHITE);

        //paneel1
        g.fillRect(20, y1, 10, heightPanel);
        //paneel2
        g.fillRect(this.getWidth() - 30, y2, 10, heightPanel);

        g.fillRect(xBall, yBall, sizeBall, sizeBall);
        g.fillRect(0, 0, this.getWidth(), 2);
        g.fillRect(0, this.getHeight() - heightCanvasDifference, this.getWidth(), 2);
        g.dispose();


    }

    public void update() {
        //botsingen
        if (new Rectangle(xBall, yBall, sizeBall, sizeBall).intersects(new Rectangle(20, y1, 10, heightPanel)) || new Rectangle(xBall, yBall, sizeBall, sizeBall).intersects(new Rectangle(this.getWidth() - 30, y2, 10, heightPanel))) {
            xBDir = -xBDir;
        }


        //zorgt ervoor dat bal niet buiten hok gaat
        if (yBall > this.getHeight() - heightCanvasDifference - 20) {
            yBDir = -yBDir;
        }
        if (yBall < 2) {
            yBDir = -yBDir;
        }
        /* zou niet mogelijk mogen zijn*/
        //if(xBall>this.getWidth()-20){
        //	xBDir =-xBDir;
        //}

        //if(xBall<0){
        //	xBDir =-xBDir;
        //}

        //ball catching AI peddel1
        if (xBall < 250) {
            if (y1 < yBall && y1 < this.getHeight() - heightCanvasDifference - heightPanel && y1 > 0) {
                y1Dir = Math.abs(y1Dir);
            } else if (y1 > yBall && y1 < this.getHeight() - heightCanvasDifference - heightPanel && y1 > 0) {
                y1Dir = -Math.abs(y1Dir);
            }
        }
        //ball catching AI peddel2
        if (xBall > 250) {
            if (y2 < yBall && y2 < this.getHeight() - heightCanvasDifference - heightPanel && y2 > 0) {
                y2Dir = Math.abs(y2Dir);
            } else if (y2 > yBall && y2 < this.getHeight() - heightCanvasDifference - heightPanel && y2 > 0) {
                y2Dir = -Math.abs(y2Dir);
            }
        }

        //zorgt ervoor dat paddels niet buiten hok gaat

        if (y1 > this.getHeight() - heightCanvasDifference - heightPanel) {
            y1Dir = -Math.abs(y1Dir);

        }
        if (y1 < 2) {
            y1Dir = Math.abs(y1Dir);
        }
        if (y2 > this.getHeight() - heightCanvasDifference - heightPanel) {
            y2Dir = -Math.abs(y2Dir);
        }
        if (y2 < 2) {
            y2Dir = Math.abs(y2Dir);
        }

        //bal en peddel vooruitgaan
        xBall += xBDir;
        yBall += yBDir;
        if (xBall > 250 || yBall <= this.getHeight() - heightCanvasDifference - heightPanel+2) {
            y1 += y1Dir;
        }

        if (xBall < 250 || yBall <= this.getHeight() - heightCanvasDifference - heightPanel+2) {
            y2 += y2Dir;
        }
    }

    public ActionListener getUpdateTask() {
        return updateTask;
    }

    public void setUpdateTask(ActionListener updateTask) {
        this.updateTask = updateTask;
    }

    public Timer getTime() {
        return time;
    }
}
