
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;

abstract class Car {
    public int sta;
    private int status;
    public int x,y,width,hight;
    public boolean status_click=false;
    ImageIcon[] car_red = new ImageIcon[32];
    ImageIcon[] car_blue = new ImageIcon[32];
    ImageIcon[] car_green = new ImageIcon[32];
    ImageIcon[] car_violet = new ImageIcon[32];
    ImageIcon[] car_yellow = new ImageIcon[32];
    Car(int x,int y,int w,int h,int p){
        this.x=x;
        this.y=y;
        this.width=w;
        this.hight=h;
        this.status=p;
        for (int i = 0; i < car_red.length; i++) {
            car_red[i] = new ImageIcon(this.getClass().getResource((i + 1) + ".png"));
        }
        for (int i = 0; i < car_blue.length; i++) {
            car_blue[i] = new ImageIcon(this.getClass().getResource((i + 33) + ".png"));
        }
        for (int i = 0; i < car_blue.length; i++) {
            car_violet[i] = new ImageIcon(this.getClass().getResource((i + 129) + ".png"));
        }
        for (int i = 0; i < car_blue.length; i++) {
            car_yellow[i] = new ImageIcon(this.getClass().getResource((i + 65) + ".png"));
        }
        for (int i = 0; i < car_blue.length; i++) {
            car_green[i] = new ImageIcon(this.getClass().getResource((i + 97) + ".png"));
        }
    } 
    abstract void checkmove();   
    public void setstatus(int x){
        this.status = x;
    }
   
    public int getstatus(){
        return this.status;
    }
    public boolean check(){
        return (this.sta == this.status);
    }
    public Rectangle2D getbound() {
        return new Rectangle2D.Double(this.x, this.y, this.width, this.hight);
    }
}
