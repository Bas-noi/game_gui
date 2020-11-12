
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

class Start_Game_Medium extends JPanel {

    ImageIcon Sanam = new ImageIcon(this.getClass().getResource("sanam3.jpg"));
    int Minute = 0;
    int Second = 30;
    ImageIcon youwin = new ImageIcon(this.getClass().getResource("youwin.gif"));
    ImageIcon gameover = new ImageIcon(this.getClass().getResource("gameover.gif"));
    int count = 0;
    int count1 = 0;
    int count2 = 0;
    int count3 = 0;
    int count4 = 0;
    int x = 0, z = 0;
    int sta = 0;
    int mx, my;
    Park red, green, blue, yellow, purple, blank;
    Car cred, cgreen, cblue, cyellow, cpurple;
    Thread Draw = new Thread(new Runnable() {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(10);
                    repaint();
                } catch (InterruptedException ex) {

                }

            }
        }
    });
    Thread time = new Thread(new Runnable() {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                    Second--;

                } catch (InterruptedException ex) {

                }
            }
        }
    });
    Timer Car_bun_bun = new Timer(50, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            count++;

        }
    });
    Timer Car_bun_bun1 = new Timer(100, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            count1++;
        }
    });
    Timer Car_bun_bun2 = new Timer(200, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            count2++;
        }
    });
    Timer Car_bun_bun3 = new Timer(300, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            count3++;
        }
    });
    Timer Car_bun_bun4 = new Timer(400, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            count4++;
        }
    });

    public Start_Game_Medium() {
        setLayout(null);
        setSize(1000, 800);
        time.start();
        Draw.start();
        Car_bun_bun.start();
        Car_bun_bun1.start();
        Car_bun_bun2.start();
        Car_bun_bun3.start();
        Car_bun_bun4.start();
        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                if (intesect(getbound(e.getX(), e.getY()), cred.getbound()) && !cred.status_click && !cpurple.status_click && !cyellow.status_click && !cgreen.status_click) {
                    if (z == 1) {
                        cred.status_click = false;
                    } else {
                        cred.status_click = true;
                        sta = 1;
                        System.out.println("red");
                    }

                }
                if (intesect(getbound(e.getX(), e.getY()), cpurple.getbound()) && !cpurple.status_click && !cred.status_click && !cyellow.status_click && !cgreen.status_click) {
                    if (z == 2) {
                        cpurple.status_click = false;
                    } else {
                        cpurple.status_click = true;
                        sta = 2;
                        System.out.println("purple");
                    }

                }
                if (intesect(getbound(e.getX(), e.getY()), cyellow.getbound()) && !cyellow.status_click && !cred.status_click && !cpurple.status_click && !cgreen.status_click) {
                    if (z == 3) {
                        cyellow.status_click = false;
                    } else {
                        cyellow.status_click = true;
                        sta = 3;
                        System.out.println("yellow");
                    }

                }
                if (intesect(getbound(e.getX(), e.getY()), cgreen.getbound()) && !cyellow.status_click && !cred.status_click && !cpurple.status_click && !cgreen.status_click) {
                    if (z == 4) {
                        cgreen.status_click = false;
                    } else {
                        cgreen.status_click = true;
                        sta = 4;
                        System.out.println("green");
                    }

                }
            }
        });
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                if (cred.status_click) {
                    cred.x = e.getX();
                    cred.y = e.getY();

                    if (intesect(getbound(cred.x, cred.y), getbound(purple.x, purple.y))) {
                        cred.x = 800;
                        cred.y = 635;
                        cred.status_click = false;
                        sta = 0;
                    }
                    if (intesect(getbound(cred.x, cred.y), getbound(yellow.x, yellow.y))) {
                        cred.x = 145;
                        cred.y = 170;
                        cred.status_click = false;
                        sta = 0;
                    }

                    if (intesect(getbound(cred.x, cred.y), getbound(red.x, red.y))) {
                        cred.x = 145;
                        cred.y = 635;
                        x++;
                        z=1;
                        cred.status_click = false;
                        sta = 0;
                    }
                    if (intesect(getbound(cred.x, cred.y), getbound(blank.x, blank.y))) {
                        cred.x = 800;
                        cred.y = 170;
                        cred.status_click = false;
                        sta = 0;
                    }
                    if (intesect(getbound(cred.x, cred.y), getbound(green.x, green.y))) {
                        cred.x = 465;
                        cred.y = 415;
                        cred.status_click = false;
                        sta = 0;
                    }

                }
                if (cpurple.status_click) {
                    cpurple.x = e.getX();
                    cpurple.y = e.getY();
                    if (intesect(getbound(cpurple.x, cpurple.y), getbound(purple.x, purple.y))) {
                        cpurple.x = 800;
                        cpurple.y = 635;
                        x++;
                        cpurple.status_click = false;
                        sta = 0;
                        z=2;
                    }
                    if (intesect(getbound(cpurple.x, cpurple.y), getbound(yellow.x, yellow.y))) {
                        cpurple.x = 145;
                        cpurple.y = 170;
                        cblue.status_click = false;
                        sta = 0;
                    }

                    if (intesect(getbound(cpurple.x, cpurple.y), getbound(red.x, red.y))) {
                        cpurple.x = 145;
                        cpurple.y = 635;
                        cpurple.status_click = false;
                        sta = 0;
                    }
                    if (intesect(getbound(cpurple.x, cpurple.y), getbound(blank.x, blank.y))) {
                        cpurple.x = 800;
                        cpurple.y = 170;
                        cpurple.status_click = false;
                        sta = 0;
                    }
                    if (intesect(getbound(cpurple.x, cpurple.y), getbound(green.x, green.y))) {
                        cpurple.x = 465;
                        cpurple.y = 415;
                        cpurple.status_click = false;
                        sta = 0;
                    }
                }
                if (cyellow.status_click) {
                    cyellow.x = e.getX();
                    cyellow.y = e.getY();

                    if (intesect(getbound(cyellow.x, cyellow.y), getbound(purple.x, purple.y))) {
                        cyellow.x = 800;
                        cyellow.y = 635;
                        cyellow.status_click = false;
                        sta = 0;
                    }
                    if (intesect(getbound(cyellow.x, cyellow.y), getbound(yellow.x, yellow.y))) {
                        cyellow.x = 145;
                        cyellow.y = 170;
                        x++;
                        cyellow.status_click = false;
                        sta = 0;
                        z=3;
                    }
                    if (intesect(getbound(cyellow.x, cyellow.y), getbound(red.x, red.y))) {
                        cyellow.x = 145;
                        cyellow.y = 635;
                        cyellow.status_click = false;
                        sta = 0;
                    }
                    if (intesect(getbound(cyellow.x, cyellow.y), getbound(blank.x, blank.y))) {
                        cyellow.x = 800;
                        cyellow.y = 170;
                        cyellow.status_click = false;
                        sta = 0;

                    }
                    if (intesect(getbound(cyellow.x, cyellow.y), getbound(green.x, green.y))) {
                        cyellow.x = 465;
                        cyellow.y = 415;
                        cyellow.status_click = false;
                        sta = 0;

                    }
                }
                if (cgreen.status_click) {
                    cgreen.x = e.getX();
                    cgreen.y = e.getY();

                    if (intesect(getbound(cgreen.x, cgreen.y), getbound(purple.x, purple.y))) {
                        cgreen.x = 800;
                        cgreen.y = 635;
                        cgreen.status_click = false;
                        sta = 0;
                    }
                    if (intesect(getbound(cgreen.x, cgreen.y), getbound(yellow.x, yellow.y))) {
                        cgreen.x = 145;
                        cgreen.y = 170;
                        cgreen.status_click = false;
                        sta = 0;
                    }
                    if (intesect(getbound(cgreen.x, cgreen.y), getbound(red.x, red.y))) {
                        cgreen.x = 145;
                        cgreen.y = 635;
                        cgreen.status_click = false;
                        sta = 0;
                    }
                    if (intesect(getbound(cgreen.x, cgreen.y), getbound(blank.x, blank.y))) {
                        cgreen.x = 800;
                        cgreen.y = 170;
                        cgreen.status_click = false;
                        sta = 0;
                    }
                    if (intesect(getbound(cgreen.x, cgreen.y), getbound(green.x, green.y))) {
                        cgreen.x = 465;
                        cgreen.y = 415;
                        x++;
                        cgreen.status_click = false;
                        sta = 0;
                        z=4;
                    }

                }

            }

        });

        red = new Park(145, 635, 150, 150, 2) {

            @Override
            void checkmove() {

            }
        };
        green = new Park(465, 415, 150, 150, 2) {

            @Override
            void checkmove() {

            }
        };

        purple = new Park(800, 635, 150, 150, 1) {

            @Override
            void checkmove() {

            }

        };
        yellow = new Park(145, 170, 150, 150, 3) {

            @Override
            void checkmove() {

            }

        };
        blank = new Park(800, 170, 150, 150, 0) {

            @Override
            void checkmove() {

            }

        };
        cred = new Car(465, 415, 100, 100, 2) {

            @Override
            void checkmove() {

            }

        };

        cyellow = new Car(800, 635, 100, 100, 3) {

            @Override
            void checkmove() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        };
        cgreen = new Car(145, 170, 100, 100, 1) {

            @Override
            void checkmove() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        };
        cpurple = new Car(145, 635, 100, 100, 1) {

            @Override
            void checkmove() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        };

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Sanam.getImage(), 0, 0, 1000, 800, this);
        g.setFont(new Font("Monospaced", Font.PLAIN, 40));
        g.drawString("SCORE "+String.valueOf(x), 100, 50);
        if (Second < 10) {
            g.drawString(String.valueOf(Minute) + ":0" + String.valueOf(Second), 800, 50);

        } else {
            g.drawString(String.valueOf(Minute) + ":" + String.valueOf(Second), 800, 50);
        }
        if (cred.x == 145 && cred.y == 635 && cyellow.x == 145 && cyellow.y == 170 && cpurple.x == 800 && cpurple.y == 635 && cgreen.x == 465 && cgreen.y == 415) {
            gamewin start = new gamewin();
            time.stop();
            add(start);
            start.setFocusable(true);

        }
        if (sta == 1) {
            g.setFont(new Font("Monospaced", Font.PLAIN, 40));
            g.drawString("red", 600, 50);
        }
        if (sta == 0) {
            g.setFont(new Font("Monospaced", Font.PLAIN, 40));
            g.drawString("NULL", 600, 50);
        }
        if (sta == 2) {
            g.setFont(new Font("Monospaced", Font.PLAIN, 40));
            g.drawString("purple", 600, 50);
        }
        if (sta == 3) {
            g.setFont(new Font("Monospaced", Font.PLAIN, 40));
            g.drawString("yellow", 600, 50);
        }
        if (sta == 4) {
            g.setFont(new Font("Monospaced", Font.PLAIN, 40));
            g.drawString("green", 600, 50);
        }
        if (Second == 0) {
            gameover start = new gameover();
            time.stop();
            add(start);
            start.setFocusable(true);
        }

        g.drawImage(cred.car_red[count % 32].getImage(), cred.x - 50, cred.y - 50, cred.width, cred.hight, this);
        g.drawImage(cyellow.car_yellow[count4 % 32].getImage(), cyellow.x - 50, cyellow.y - 50, cyellow.width, cyellow.hight, this);
        g.drawImage(cpurple.car_violet[count2 % 32].getImage(), cpurple.x - 50, cpurple.y - 50, cpurple.width, cpurple.hight, this);
        g.drawImage(cgreen.car_green[count3 % 32].getImage(), cgreen.x - 50, cgreen.y - 50, cgreen.width, cgreen.hight, this);

    }

    boolean intesect(Rectangle2D a, Rectangle2D b) {
        return a.intersects(b);
    }

    Rectangle2D getbound(int x, int y) {
        return new Rectangle2D.Double(x, y, 100, 100);
    }

    class gamewin extends JPanel {

        Thread Draw = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                        repaint();
                    } catch (InterruptedException ex) {

                    }

                }
            }
        });

        public gamewin() {
            setSize(1000, 800);
            Draw.start();
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

                    if (mx >= 775 && mx <= 940 && my >= 610 && my <= 670) {
                        Home_Start start = new Home_Start();
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
            g.drawImage(youwin.getImage(), 0, 0, 1000, 800, this);
            g.setFont(new Font("Monospaced", Font.PLAIN, 64));
            g.setColor(Color.white);
            g.drawString(String.valueOf(30 - Second) + " SECOUND", 50, 720);
            g.setColor(Color.white);
            g.drawString("You SCORE " + String.valueOf(x), 50, 650);
            g.setColor(Color.BLACK);
            if (mx >= 520 && mx <= 755 && my >= 610 && my <= 670) {
                g.setColor(Color.yellow);
                g.drawString("RESET", 525, 650);
            } else {
                g.setColor(Color.black);
                g.drawString("RESET", 525, 650);
            }
            if (mx >= 775 && mx <= 940 && my >= 610 && my <= 670) {
                g.setColor(Color.red);
                g.drawString("HOME", 775, 650);
            } else {
                g.setColor(Color.black);
                g.drawString("HOME", 775, 650);
            }

        }
    }

    class gameover extends JPanel {

        Thread Draw = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                        repaint();
                    } catch (InterruptedException ex) {

                    }

                }
            }
        });

        public gameover() {
            setSize(1000, 800);
            Draw.start();
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
                    if (mx >= 775 && mx <= 940 && my >= 610 && my <= 670) {
                        Home_Start start = new Home_Start();
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
            g.drawImage(gameover.getImage(), 0, 0, 1000, 800, this);
            g.setColor(Color.white);
            g.setFont(new Font("Monospaced", Font.PLAIN, 64));
            g.drawString("SCORE " + String.valueOf(x), 100, 720);
            g.drawString("TIME OUT", 100, 650);

            if (mx >= 520 && mx <= 755 && my >= 610 && my <= 670) {
                g.setColor(Color.yellow);
                g.drawString("RESET", 525, 650);
            } else {
                g.setColor(Color.black);
                g.drawString("RESET", 525, 650);
            }
            if (mx >= 775 && mx <= 940 && my >= 610 && my <= 670) {
                g.setColor(Color.red);
                g.drawString("HOME", 775, 650);
            } else {
                g.setColor(Color.black);
                g.drawString("HOME", 775, 650);
            }

        }
    }

}
