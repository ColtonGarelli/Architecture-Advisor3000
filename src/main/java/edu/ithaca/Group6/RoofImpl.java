package edu.ithaca.Group6;

public class RoofImpl implements Roof {
    private double length;
    private double width;
    private double height;
    private double startHeight;

    private MaterialByArea material;
    private double[] firstCornerCoordinates = new double[3];
    private double[] secondCornerCoordinates = new double[3];

    public RoofImpl(){
        this.length = 0;
        this.width = 0;
        this.height = 0;
        firstCornerCoordinates[0] = 0;//x
        firstCornerCoordinates[1] = 0;//y
        firstCornerCoordinates[2] = 0;//z

        secondCornerCoordinates[0] = 0;//x
        secondCornerCoordinates[1] = 0;//y
        secondCornerCoordinates[2] = 0;//z
    }
    public RoofImpl(double widthIn, double lengthIn, double roofThickness, double startHeight){
        this.length = lengthIn;
        this.width = widthIn;
        this.height = roofThickness;
        this.startHeight = startHeight;

        firstCornerCoordinates[0] = 0;//x
        firstCornerCoordinates[1] = 0;//y
        firstCornerCoordinates[2] = startHeight;//z

        secondCornerCoordinates[0] = lengthIn;//x
        secondCornerCoordinates[1] = widthIn;//y
        secondCornerCoordinates[2] = startHeight + roofThickness;//z
    }


    @Override
    public boolean setFirstCornerCoordinates(double x, double y, double z) {
        double[] coordArray = {x,y,z};
        return setFirstCornerCoordinates(coordArray);
    }

    @Override
    public boolean setFirstCornerCoordinates(double[] xyzCoord) {
        if(xyzCoord[2] < 0){    //no negative height
            return false;
        }
        try{firstCornerCoordinates = xyzCoord;
        return true;}
        catch(Exception e){
            return false;
        }
    }

    @Override
    public double[] getFirstCornerCoordinates() {
        return firstCornerCoordinates;
    }

    @Override
    public boolean setSecondCornerCoordinates(double x, double y, double z) {
        double[] coordArray = {x,y,z};
        return setSecondCornerCoordinates(coordArray);
    }

    @Override
    public boolean setSecondCornerCoordinates(double[] xyzCoord) {
        if(xyzCoord[2] < 0){    //no negative height
            return false;
        }
        try{secondCornerCoordinates = xyzCoord;
            return true;}
        catch(Exception e){
            return false;
        }
    }

    @Override
    public double[] getSecondCornerCoordinates() {
        return secondCornerCoordinates;
    }

    @Override
    public boolean setHeight(double height) {
        if(height > 0){
            this.height = height;
            return true;
        }else{
            return false;
        }
    }

    @Override
    public double getHeight() {
        return this.height;
    }

    @Override
    public boolean setWidth(double width) {
        if(width > 0){
            this.width = width;
            return true;
        }else{
            return false;
        }
    }

    @Override
    public double getWidth() {
        return this.width;
    }

    @Override
    public boolean setLength(double length) {
        if (length > 0) {
            this.length = length;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public double getLength() {
        return this.length;
    }

    @Override
    public boolean setMaterial(MaterialByArea wallMaterial) {
        this.material = wallMaterial;
        return true;
    }

    @Override
    public MaterialByArea getMaterial() {
        return this.material;
    }

    @Override
    public String getFirstCornerCoordString() {
        return "[" + this.firstCornerCoordinates[0] + "," + this.firstCornerCoordinates[1] + "," + this.firstCornerCoordinates[2] + "]";
    }

    @Override
    public String getSecondCornerCoordString() {
        return "[" + this.secondCornerCoordinates[0] + "," + this.secondCornerCoordinates[1] + "," + this.secondCornerCoordinates[2] + "]";
    }
}
