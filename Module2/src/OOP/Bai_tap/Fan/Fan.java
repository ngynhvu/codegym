package OOP.Bai_tap.Fan;

public class Fan {
    private final int SLOW = 1;
    private final int MEDIUM = 2;
    private final int FAST = 3;
    private int speed;
    private boolean status;
    private double radius;
    private String color;

    public Fan(){
        this.speed = SLOW;
        this.status = false;
        this.radius = 5;
        this.color = "blue";
    }

    public Fan(int speed,boolean status, double radius, String color){
        this.speed = speed;
        this.status = status;
        this.radius = radius;
        this.color = color;
    }
    public double getRadius() {
        return radius;
    }

    public int getSpeed() {
        return speed;
    }

    public String getColor() {
        return color;
    }

    public boolean getStatus(){
        return this.status;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setOn(boolean status) {
        this.status = status;
    }

    public String toString(){
        String speedOfFan = null;
        switch (getSpeed()){
            case 1:
                speedOfFan = "LOW";
                break;
            case 2:
                speedOfFan = "NORMAL";
                break;
            case 3:
                speedOfFan = "FAST";
                break;
        }
        if(getStatus()){
            return "Fan have speed: "+speedOfFan+" and radius: "+getRadius()+" and color: "+getColor()
                    +"- Fan is ON";
        }else{
            return "Fan have radius: "+getRadius()+" and color: "+getColor() +"- Fan is Off";
        }
    }
}
