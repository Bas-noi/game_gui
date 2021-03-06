
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

class Start_Game_Hard extends JPanel {

    ImageIcon Sanam = new ImageIcon(this.getClass().getResource("sanam.jpg"));
    int Minute = 0;
    int Second = 40;
    ImageIcon youwin = new ImageIcon(this.getClass().getResource("youwin.gif"));
    ImageIcon gameover = new ImageIcon(this.getClass().getResource("gameover.gif"));
    int count = 0;
    int count1 = 0;
    int count2 = 0;
    int count3 = 0;
    int count4 = 0;
    int sta = 0;
    int x = 0, z = 0;
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

    public Start_Game_Hard() {
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

                if (intesect(getbound(e.getX(), e.getY()), cred.getbound()) && !cred.status_click && !cblue.status_click && !cgreen.status_click && !cpurple.status_click && !cyellow.status_click) {
                    if (z == 1) {
                        cred.status_click = false;
                    } else {
                        cred.status_click = true;
                        sta = 1;
                        System.out.println("red");
                    }

                }
                if (intesect(getbound(e.getX(), e.getY()), cblue.getbound()) && !cblue.status_click && !cred.status_click && !cgreen.status_click && !cpurple.status_click && !cyellow.status_click) {
                    if (z == 2) {
                        cblue.status_click = false;
                    } else {
                        cblue.status_click = true;
                        sta = 2;
                        System.out.println("blue");
                    }

                }
                if (intesect(getbound(e.getX(), e.getY()), cgreen.getbound()) && !cgreen.status_click && !cred.status_click && !cblue.status_click && !cpurple.status_click && !cyellow.status_click) {
                    if (z == 3) {
                        cgreen.status_click = false;
                    } else {
                        cgreen.status_click = true;
                        sta = 3;
                        System.out.println("green");
                    }

                }
                if (intesect(getbound(e.getX(), e.getY()), cpurple.getbound()) && !cpurple.status_click && !cred.status_click && !cblue.status_click && !cgreen.status_click && !cyellow.status_click) {
                    if (z == 4) {
                        cpurple.status_click = false;
                    } else {
                        cpurple.status_click = true;
                        sta = 4;
                        System.out.println("purple");
                    }

                }
                if (intesect(getbound(e.getX(), e.getY()), cyellow.getbound()) && !cyellow.status_click && !cred.status_click && !cblue.status_click && !cgreen.status_click && !cpurple.status_click) {
                    if (z == 5) {
                        cyellow.status_click = false;
                    } else {
                        cyellow.status_click = true;
                        sta = 5;
                        System.out.println("yellow");
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
                    if (intesect(getbound(cred.x, cred.y), getbound(green.x, green.y))) {
                        cred.x = 270;
                        cred.y = 230;
                        cred.status_click = false;
                        sta = 0;
                    }
                    if (intesect(getbound(cred.x, cred.y), getbound(purple.x, purple.y))) {
                        cred.x = 735;
                        cred.y = 230;
                        cred.status_click = false;
                        sta = 0;
                    }
                    if (intesect(getbound(cred.x, cred.y), getbound(yellow.x, yellow.y))) {
                        cred.x = 500;
                        cred.y = 690;
                        cred.status_click = false;
                        sta = 0;
                    }
                    if (intesect(getbound(cred.x, cred.y), getbound(blue.x, blue.y))) {
                        cred.x = 265;
                        cred.y = 555;
                        cred.status_click = false;
                        sta = 0;
                    }
                    if (intesect(getbound(cred.x, cred.y), getbound(red.x, red.y))) {
                        cred.x = 740;
                        cred.y = 555;
                        cred.status_click = false;
                        sta = 0;
                        x++;
                        z=1;
                    }
                    if (intesect(getbound(cred.x, cred.y), getbound(blank.x, blank.y))) {
                        cred.x = 500;
                        cred.y = 100;
                        cred.status_click = false;
                        sta = 0;
                    }
                }
                if (cgreen.status_click) {
                    cgreen.x = e.getX();
                    cgreen.y = e.getY();
                    if (intesect(getbound(cgreen.x, cgreen.y), getbound(green.x, green.y))) {
                        cgreen.x = 270;
                        cgreen.y = 230;
                        cgreen.status_click = false;
                        sta = 0;
                        x++;
                        z=3;
                    }
                    if (intesect(getbound(cgreen.x, cgreen.y), getbound(purple.x, purple.y))) {
                        cgreen.x = 735;
                        cgreen.y = 230;
                        cgreen.status_click = false;
                        sta = 0;
                    }
                    if (intesect(getbound(cgreen.x, cgreen.y), getbound(yellow.x, yellow.y))) {
                        cgreen.x = 500;
                        cgreen.y = 690;
                        cgreen.status_click = false;
                        sta = 0;
                    }
                    if (intesect(getbound(cgreen.x, cgreen.y), getbound(blue.x, blue.y))) {
                        cgreen.x = 265;
                        cgreen.y = 555;
                        cgreen.status_click = false;
                        sta = 0;
                    }
                    if (intesect(getbound(cgreen.x, cgreen.y), getbound(red.x, red.y))) {
                        cgreen.x = 740;
                        cgreen.y = 555;
                        cgreen.status_click = false;
                        sta = 0;
                    }
                    if (intesect(getbound(cgreen.x, cgreen.y), getbound(blank.x, blank.y))) {
                        cgreen.x = 500;
                        cgreen.y = 100;
                        cgreen.status_click = false;
                        sta = 0;
                    }

                }
                if (cblue.status_click) {
                    cblue.x = e.getX();
                    cblue.y = e.getY();
                    if (intesect(getbound(cblue.x, cblue.y), getbound(green.x, green.y))) {
                        cblue.x = 270;
                        cblue.y = 230;
                        cblue.status_click = false;
                        sta = 0;
                    }
                    if (intesect(getbound(cblue.x, cblue.y), getbound(purple.x, purple.y))) {
                        cblue.x = 735;
                        cblue.y = 230;
                        cblue.status_click = false;
                        sta = 0;
                    }
                    if (intesect(getbound(cblue.x, cblue.y), getbound(yellow.x, yellow.y))) {
                        cblue.x = 500;
                        cblue.y = 690;
                        cblue.status_click = false;
                        sta = 0;
                    }
                    if (intesect(getbound(cblue.x, cblue.y), getbound(blue.x, blue.y))) {
                        cblue.x = 265;
                        cblue.y = 555;
                        cblue.status_click = false;
                        sta = 0;
                        x++;
                        z=2;
                    }
                    if (intesect(getbound(cblue.x, cblue.y), getbound(red.x, red.y))) {
                        cblue.x = 740;
                        cblue.y = 555;
                        cblue.status_click = false;
                        sta = 0;
                    }
                    if (intesect(getbound(cblue.x, cblue.y), getbound(blank.x, blank.y))) {
                        cblue.x = 500;
                        cblue.y = 100;
                        cblue.status_click = false;
                        sta = 0;
                    }
                }
                if (cpurple.status_click) {
                    cpurple.x = e.getX();
                    cpurple.y = e.getY();
                    if (intesect(getbound(cpurple.x, cpurple.y), getbound(green.x, green.y))) {
                        cpurple.x = 270;
                        cpurple.y = 230;
                        cpurple.status_click = false;
                        sta = 0;
                    }
                    if (intesect(getbound(cpurple.x, cpurple.y), getbound(purple.x, purple.y))) {
                        cpurple.x = 735;
                        cpurple.y = 230;
                        cpurple.status_click = false;
                        sta = 0;
                        x++;
                        z=4;
                    }
                    if (intesect(getbound(cpurple.x, cpurple.y), getbound(yellow.x, yellow.y))) {
                        cpurple.x = 500;
                        cpurple.y = 690;
                        cblue.status_click = false;
                        sta = 0;
                    }
                    if (intesect(getbound(cpurple.x, cpurple.y), getbound(blue.x, blue.y))) {
                        cpurple.x = 265;
                        cpurple.y = 555;
                        cpurple.status_click = false;
                        sta = 0;
                    }
                    if (intesect(getbound(cpurple.x, cpurple.y), getbound(red.x, red.y))) {
                        cpurple.x = 740;
                        cpurple.y = 555;
                        cpurple.status_click = false;
                        sta = 0;
                    }
                    if (intesect(getbound(cpurple.x, cpurple.y), getbound(blank.x, blank.y))) {
                        cpurple.x = 500;
                        cpurple.y = 100;
                        cpurple.status_click = false;
                        sta = 0;
                    }
                }
                if (cyellow.status_click) {
                    cyellow.x = e.getX();
                    cyellow.y = e.getY();
                    if (intesect(getbound(cyellow.x, cyellow.y), getbound(green.x, green.y))) {
                        cyellow.x = 270;
                        cyellow.y = 230;
                        cyellow.status_click = false;
                        sta = 0;
                    }
                    if (intesect(getbound(cyellow.x, cyellow.y), getbound(purple.x, purple.y))) {
                        cyellow.x = 735;
                        cyellow.y = 230;
                        cyellow.status_click = false;
                        sta = 0;
                    }
                    if (intesect(getbound(cyellow.x, cyellow.y), getbound(yellow.x, yellow.y))) {
                        cyellow.x = 500;
                        cyellow.y = 690;
                        cyellow.status_click = false;
                        sta = 0;
                        x++;
                        z=5;
                    }
                    if (intesect(getbound(cyellow.x, cyellow.y), getbound(blue.x, blue.y))) {
                        cyellow.x = 265;
                        cyellow.y = 555;
                        cyellow.status_click = false;
                        sta = 0;
                    }
                    if (intesect(getbound(cyellow.x, cyellow.y), getbound(red.x, red.y))) {
                        cyellow.x = 740;
                        cyellow.y = 555;
                        cyellow.status_click = false;
                        sta = 0;
                    }
                    if (intesect(getbound(cyellow.x, cyellow.y), getbound(blank.x, blank.y))) {
                        cyellow.x = 500;
                        cyellow.y = 100;
                        cyellow.status_click = false;
                        sta = 0;
                    }

                }

            }

        });

        red = new Park(740, 555, 150, 150, 2) {

            @Override
            void checkmove() {

            }
        };
        green = new Park(270, 230, 150, 150, 5) {

            @Override
            void checkmove() {

            }

        };
        blue = new Park(265, 555, 150, 150, 4) {

            @Override
            void checkmove() {

            }

        };
        purple = new Park(735, 230, 150, 150, 1) {

            @Override
            void checkmove() {

            }

        };
        yellow = new Park(500, 690, 150, 150, 3) {

            @Override
            void checkmove() {

            }

        };
        blank = new Park(500, 100, 150, 150, 0) {

            @Override
            void checkmove() {

            }

        };
        cred = new Car(500, 690, 100, 100, 2) {

            @Override
            void checkmove() {

            }

        };
        cblue = new Car(270, 230, 100, 100, 4) {

            @Override
            void checkmove() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        };
        cgreen = new Car(735, 230, 100, 100, 5) {

            @Override
            void checkmove() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        };
        cyellow = new Car(740, 555, 100, 100, 3) {

            @Override
            void checkmove() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        };
        cpurple = new Car(265, 555, 100, 100, 1) {

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
            g.drawString("blue", 600, 50);
        }
        if (sta == 4) {
            g.setFont(new Font("Monospaced", Font.PLAIN, 40));
            g.drawString("purple", 600, 50);
        }
        if (sta == 5) {
            g.setFont(new Font("Monospaced", Font.PLAIN, 40));
            g.drawString("yellow", 600, 50);
        }
        if (sta == 3) {
            g.setFont(new Font("Monospaced", Font.PLAIN, 40));
            g.drawString("green", 600, 50);
        }
        if (cred.x == 740 && cred.y == 555 && cyellow.x == 500 && cyellow.y == 690 && cpurple.x == 735 && cpurple.y == 230 && cgreen.x == 270 && cgreen.y == 230 && cblue.x == 265 && cblue.y == 555) {
            gamewin start = new gamewin();
            time.stop();
            add(start);
            start.setFocusable(true);

        }
        if (Second == 0) {
            gameover start = new gameover();
            time.stop();
            add(start);
            start.setFocusable(true);
        }

        g.drawImage(cred.car_red[count % 32].getImage(), cred.x - 50, cred.y - 50, cred.width, cred.hight, this);

        g.drawImage(cblue.car_blue[count1 % 32].getImage(), cblue.x - 50, cblue.y - 50, cblue.width, cblue.hight, this);

        g.drawImage(cgreen.car_green[count3 % 32].getImage(), cgreen.x - 50, cgreen.y - 50, cgreen.width, cgreen.hight, this);

        g.drawImage(cyellow.car_yellow[count4 % 32].getImage(), cyellow.x - 50, cyellow.y - 50, cyellow.width, cyellow.hight, this);

        g.drawImage(cpurple.car_violet[count2 % 32].getImage(), cpurple.x - 50, cpurple.y - 50, cpurple.width, cpurple.hight, this);

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
                        Start_Game_Hard start = new Start_Game_Hard();
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
            g.drawString(String.valueOf(40 - Second) + " SECOUND", 50, 720);
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
                        Start_Game_Hard start= new Start_Game_Hard();
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
