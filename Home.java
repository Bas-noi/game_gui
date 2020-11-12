
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Home extends JFrame {

    Home() {
        add(new Home_Start());
        setTitle("BAS");
        setSize(1000, 800);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Home();
    }
}

class Home_Start extends JPanel {

    int mx, my;
    ImageIcon Home_Screen = new ImageIcon(this.getClass().getResource("home.gif"));
    ImageIcon Homec = new ImageIcon(this.getClass().getResource("1.png"));
    Timer listen = new Timer(10, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }
    });

    public Home_Start() {
        setSize(1000, 800);
        listen.start();
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                mx = e.getX();
                my = e.getY();
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println(mx);
                System.out.println(my);
                if (mx >= 775 && mx <= 940 && my >= 610 && my <= 670) {
                    Start_Game_Hard start = new Start_Game_Hard();
                    add(start);
                    start.setFocusable(true);
                } else if (mx >= 350 && mx <= 500 && my >= 610 && my <= 670) {
                    easy start = new easy();
                    add(start);
                    start.setFocusable(true);
                } else if (mx >= 520 && mx <= 755 && my >= 610 && my <= 670) {
                    Start_Game_Medium start = new Start_Game_Medium();
                    add(start);
                    start.setFocusable(true);
                }

            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Home_Screen.getImage(), 0, 0, 1000, 800, this);

        g.setFont(new Font("Monospaced", Font.PLAIN, 70));
        g.setColor(Color.white);
        g.drawString("CAR PARKING TO COLOR", 100, 80);
        g.setFont(new Font("Monospaced", Font.PLAIN, 64));
        if (mx >= 350 && mx <= 500 && my >= 610 && my <= 670) {
            g.setColor(Color.green);
            g.drawString("EASY", 350, 650);
        } else {
            g.setColor(Color.white);
            g.drawString("EASY", 350, 650);
        }
        if (mx >= 520 && mx <= 755 && my >= 610 && my <= 670) {
            g.setColor(Color.yellow);
            g.drawString("MEDIUM", 525, 650);
        } else {
            g.setColor(Color.white);
            g.drawString("MEDIUM", 525, 650);
        }
        if (mx >= 775 && mx <= 940 && my >= 610 && my <= 670) {
            g.setColor(Color.red);
            g.drawString("HARD", 775, 650);
        } else {
            g.setColor(Color.white);
            g.drawString("HARD", 775, 650);
        }
    }
}





