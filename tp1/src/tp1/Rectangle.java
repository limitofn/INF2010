package tp1;

import java.util.Set;

public class Rectangle extends BaseShape {
    // TODO creer un rectangle avec une largeur et une longueur.
    public Rectangle(Double width, Double height) {

        Double halfWidth = width * 0.5;
        Double halfHeight = height *0.5;
        for (Double i = -halfWidth; i <= halfWidth; i++){
            for (Double j = -halfHeight; j <= halfHeight; j++)
                this.add(new Point2d(i,j));
        }


    }

    // TODO creer un rectangle avec un point contenant la largeur et longueur.
    public Rectangle(Point2d dimensions) {
        this(dimensions.X(),dimensions.Y());
    }

    private Rectangle(Set<Point2d> coords) {
        super(coords);
    }

    // TODO appliquer la translation sur la forme.
    @Override
    public Rectangle translate(Point2d point) {

        return new Rectangle(translateAll(point));
    }

    // TODO appliquer la rotation sur la forme.
    @Override
    public Rectangle rotate(Double angle) {
        return new Rectangle(rotateAll(angle));
    }

    // TODO retourner une nouvelle forme.
    @Override
    public Rectangle clone() {
        return new Rectangle(getCoords());
    }
}
