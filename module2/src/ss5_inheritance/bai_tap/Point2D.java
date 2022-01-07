package ss5_inheritance.bai_tap;

public class Point2D {
    float x = 0.0f;
    float y = 0.0f;

    public Point2D() {
    }

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }


    public float [] getXY() {
        float[] array = new float[]{getX(),getY()};
        return array;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +", x,y="+getXY()[0]+","+getXY()[1]+
                '}';
    }
}
