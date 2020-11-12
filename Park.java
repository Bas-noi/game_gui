
import java.awt.geom.Rectangle2D;

abstract class Park {
    private  int status;
    public int x,y,width,height;
    Park(int x, int y,int w, int h,int p){
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.status=p;
    }
    abstract void checkmove();   
    public void setstatus(int x){
        this.status = x;
    }
    public int getstatus(){
        return this.status;
    }
     public boolean check(Car car){
        return (car.getstatus() == this.status && car.getbound().intersects(this.getbound()));
    }
    public Rectangle2D getbound() {
        return new Rectangle2D.Double(this.x-50, this.y-50, this.width, this.height);
    }

}
