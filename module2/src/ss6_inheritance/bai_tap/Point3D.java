package ss6_inheritance.bai_tap;

public class Point3D extends Point2D{
    float z=0.0f;
    public Point3D(){}
    public Point3D(float x,float y,float z){
       super(x,y);
        this.z=z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public float [] getXYZ(){
        float []array=new float[]{getX(),getY(),getZ()};
        return array;
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +", x,y,z="+getXYZ()[0]+","+getXYZ()[1]+","+getXYZ()[2]+
                '}';
    }
}
