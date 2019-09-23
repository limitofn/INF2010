package tp1;

import java.awt.geom.Point2D;

public class Point2d extends AbstractPoint {
    private final Integer X = 0;
    private final Integer Y = 1;


    public Point2d(Double x, Double y) {
        super(new Double[] {x, y});
    }


    public Point2d(Double[] vector) {
        super(vector.clone());
    }

    public Double X() { return vector[X];}
    public Double Y() { return vector[Y];}


    @Override
    public Point2d translate(Double[] translateVector) {
        return new Point2d (PointOperator.translate( vector.clone(), translateVector));
    }

    // TODO prendre un point et appliquer la translation.
    public Point2d translate(Point2d translateVector) {
        return translateVector;
       // return new Point2d(PointOperator.translate());
    }


    @Override
    public Point2d rotate(Double[][] rotationMatrix) {
        return new Point2d(PointOperator.rotate(vector.clone(), rotationMatrix));
    }


    public Point2d rotate(Double angle) {
        Double cosRotate = Math.cos (angle);
        Double sinRotate = Math.sin (angle);
        Double[][] matrixRotation = new Double[][] {{cosRotate, -sinRotate}, {sinRotate, cosRotate}};
        return new Point2d(PointOperator.rotate(vector.clone(), matrixRotation));
    }


    @Override
    public Point2d divide(Double divider) {
        return new Point2d(PointOperator.divide(vector.clone(), divider));
    }


    @Override
    public Point2d multiply(Double multiplier) {
        return new Point2d(PointOperator.multiply(vector.clone(), multiplier));
    }


    @Override
    public Point2d add(Double adder) {
        return  new Point2d(PointOperator.add(vector.clone(), adder));
    }


    @Override
    public Point2d clone() {
        Point2d monClone = new Point2d(vector);
        return monClone;
    }
}
