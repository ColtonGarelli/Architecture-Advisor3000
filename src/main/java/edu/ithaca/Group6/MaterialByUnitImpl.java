package edu.ithaca.Group6;

public abstract class MaterialByUnitImpl implements MaterialByUnit{
    private String materialName = "";
    private double costPerUnit = 0.00;
    private double length = 0.0;
    private double width = 0.0;
    private double height = 0.0;
    private int orientation = 0;
    private double[] startPoint = new double[3];

    public abstract String materialNameBuilder();
    public abstract double costPerUnitBuilder();
    public abstract double lengthBuilder();
    public abstract double widthBuilder();
    public abstract double heightBuilder();
    public abstract int orientationBuilder();
    public abstract double[] startPointBuilder();

    public MaterialByUnitImpl(){
        this.materialName = materialNameBuilder();
        this.costPerUnit = costPerUnitBuilder();
        this.length = lengthBuilder();
        this.width = widthBuilder();
        this.height = heightBuilder();
        this.orientation = orientationBuilder();
        this.startPoint = startPointBuilder();
    }

    @Override
    public String getMaterialName() { return this.materialName; }

    @Override
    public double getCostPerUnit() { return this.costPerUnit; }

    @Override
    public double getLength() { return this.length; }

    @Override
    public double getWidth() { return this.width; }

    @Override
    public double getHeight() { return this.height; }

    @Override
    public String toString() {
        String costStr = String.format("%.2f",this.costPerUnit);
        return this.materialName + ", $" + costStr + ", Length: " + this.length + "ft, Width: " + this.width + "ft, Height: " + this.height + "ft";
    }

    @Override
    public int getOrientation(){ return this.orientation; }

    @Override
    public void setOrientation(int newVal){
        if(newVal != 0 && newVal != 1) {
            throw new IndexOutOfBoundsException("Must be either 0 or 1");
        }
        else{
            this.orientation = newVal;
        }
    }

    @Override
    public double[] getStartPoint(){
        return this.startPoint; }

    @Override
    public void setStartPoint(double newX, double newY, double newZ){
        if (newX < 0) {
            throw new IndexOutOfBoundsException("Cannot have a negative x value");
        }
        else if (newY < 0) {
            throw new IndexOutOfBoundsException("Cannot have a negative y value");
        }
        else if (newZ < 0) {
            throw new IndexOutOfBoundsException("Cannot have a negative z value");
        }
        else{
            this.startPoint[0] = newX;
            this.startPoint[1] = newY;
            this.startPoint[2] = newZ;
        }
    }

    @Override
    public double[] getEndPoint(){
        double[] endpoint = new double[3];
        if(this.orientation == 0){
            endpoint[0] = this.startPoint[0] + this.length;
            endpoint[1] = this.startPoint[1] + this.width;
        }
        else{
            endpoint[0] = this.startPoint[0] + this.width;
            endpoint[1] = this.startPoint[1] + this.length;
        }
        endpoint[2] = this.startPoint[2] + this.height;
        return endpoint;
    }
}

class Door extends MaterialByUnitImpl {
    @Override
    public String materialNameBuilder() {
        return "Door";
    }

    @Override
    public double costPerUnitBuilder() { return 900.00; }

    @Override
    public double lengthBuilder() { return 3.0; }

    @Override
    public double widthBuilder() { return .15; }

    @Override
    public double heightBuilder() { return 6.67; }

    @Override
    public int orientationBuilder() { return 0; }

    @Override
    public double[] startPointBuilder(){
        double[] defPos = new double[]{0, 0, 0};
        return defPos;
    }
}

class InteriorDoor extends MaterialByUnitImpl {
    @Override
    public String materialNameBuilder() {
        return "Interior Door";
    }

    @Override
    public double costPerUnitBuilder() { return 377.76; }

    @Override
    public double lengthBuilder() { return 3.0; }

    @Override
    public double widthBuilder() { return .15; }

    @Override
    public double heightBuilder() { return 6.67; }

    @Override
    public int orientationBuilder() { return 0; }

    @Override
    public double[] startPointBuilder(){
        double[] defPos = new double[]{0, 0, 0};
        return defPos;
    }
}

class SlidingDoor extends MaterialByUnitImpl {
    @Override
    public String materialNameBuilder() {
        return "Sliding Door";
    }

    @Override
    public double costPerUnitBuilder() { return 84.98; }

    @Override
    public double lengthBuilder() { return 4.0; }

    @Override
    public double widthBuilder() { return 0.021; }

    @Override
    public double heightBuilder() { return 6.67; }

    @Override
    public int orientationBuilder() { return 0; }

    @Override
    public double[] startPointBuilder(){
        double[] defPos = new double[]{0, 0, 0};
        return defPos;
    }
}

class StormDoor extends MaterialByUnitImpl {
    @Override
    public String materialNameBuilder() {
        return "Storm Door";
    }

    @Override
    public double costPerUnitBuilder() { return 199.00; }

    @Override
    public double lengthBuilder() { return 3.0; }

    @Override
    public double widthBuilder() { return .083; }

    @Override
    public double heightBuilder() { return 6.67; }

    @Override
    public int orientationBuilder() { return 0; }

    @Override
    public double[] startPointBuilder(){
        double[] defPos = new double[]{0, 0, 0};
        return defPos;
    }
}

class ScreenDoor extends MaterialByUnitImpl {
    @Override
    public String materialNameBuilder() {
        return "Screen Door";
    }

    @Override
    public double costPerUnitBuilder() { return 179.00; }

    @Override
    public double lengthBuilder() { return 3.0; }

    @Override
    public double widthBuilder() { return .167; }

    @Override
    public double heightBuilder() { return 6.67; }

    @Override
    public int orientationBuilder() { return 0; }

    @Override
    public double[] startPointBuilder(){
        double[] defPos = new double[]{0, 0, 0};
        return defPos;
    }
}

class GarageDoor extends MaterialByUnitImpl {
    @Override
    public String materialNameBuilder() {
        return "Garage Door";
    }

    @Override
    public double costPerUnitBuilder() { return 264.00; }

    @Override
    public double lengthBuilder() { return 9.0; }

    @Override
    public double widthBuilder() { return .167; }

    @Override
    public double heightBuilder() { return 7.00; }

    @Override
    public int orientationBuilder() { return 0; }

    @Override
    public double[] startPointBuilder(){
        double[] defPos = new double[]{0, 0, 0};
        return defPos;
    }
}

class PictureWindow extends MaterialByUnitImpl {
    @Override
    public String materialNameBuilder() {
        return "Picture Window";
    }

    @Override
    public double costPerUnitBuilder() { return 252.00; }

    @Override
    public double lengthBuilder() { return 4.0; }

    @Override
    public double widthBuilder() { return .27; }

    @Override
    public double heightBuilder() { return 4.00; }

    @Override
    public int orientationBuilder() { return 0; }

    @Override
    public double[] startPointBuilder(){
        double[] defPos = new double[]{0, 0, 0};
        return defPos;
    }
}

class SingleHungWindow extends MaterialByUnitImpl {
    @Override
    public String materialNameBuilder() {
        return "Single Hung Window";
    }

    @Override
    public double costPerUnitBuilder() { return 68.75; }

    @Override
    public double lengthBuilder() { return 2.0; }

    @Override
    public double widthBuilder() { return 0.1875; }

    @Override
    public double heightBuilder() { return 4.00; }

    @Override
    public int orientationBuilder() { return 0; }

    @Override
    public double[] startPointBuilder(){
        double[] defPos = new double[]{0, 0, 0};
        return defPos;
    }
}

class DoubleHungWindow extends MaterialByUnitImpl {
    @Override
    public String materialNameBuilder() {
        return "Double Hung Window";
    }

    @Override
    public double costPerUnitBuilder() { return 167.00; }

    @Override
    public double lengthBuilder() { return 2.48; }

    @Override
    public double widthBuilder() { return .375; }

    @Override
    public double heightBuilder() { return 4.4375; }

    @Override
    public int orientationBuilder() { return 0; }

    @Override
    public double[] startPointBuilder(){
        double[] defPos = new double[]{0, 0, 0};
        return defPos;
    }
}

class BayWindow extends MaterialByUnitImpl {
    @Override
    public String materialNameBuilder() {
        return "Bay Window";
    }

    @Override
    public double costPerUnitBuilder() { return 1198.66; }

    @Override
    public double lengthBuilder() { return 6.125; }

    @Override
    public double widthBuilder() { return 1.0; }

    @Override
    public double heightBuilder() { return 5.083; }

    @Override
    public int orientationBuilder() { return 0; }

    @Override
    public double[] startPointBuilder(){
        double[] defPos = new double[]{0, 0, 0};
        return defPos;
    }
}

class SlidingWindow extends MaterialByUnitImpl {
    @Override
    public String materialNameBuilder() {
        return "Sliding Window";
    }

    @Override
    public double costPerUnitBuilder() { return 104.00; }

    @Override
    public double lengthBuilder() { return 2.583; }

    @Override
    public double widthBuilder() { return .375; }

    @Override
    public double heightBuilder() { return 1.583; }

    @Override
    public int orientationBuilder() { return 0; }

    @Override
    public double[] startPointBuilder(){
        double[] defPos = new double[]{0, 0, 0};
        return defPos;
    }
}