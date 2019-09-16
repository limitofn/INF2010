package tp1;

import java.util.Set;

public class Ellipse extends BaseShape {
    // TODO creer une ellipse avec une largeur et une longueur.
    public Ellipse(Double widthRadius, Double heightRadius) {
        for (Double i = -widthRadius; i <= widthRadius; i++){
            for (Double j = -heightRadius; i <= heightRadius; j++ )
                if (Math.pow(i,2)/Math.pow(widthRadius,2) + Math.pow(j,2)/Math.pow(heightRadius,2) <= 1){
                    this.add(new Point2d(i,j));
                }

        }
    }

    private Ellipse(Set<Point2d> coords) {
        super(coords);
    }

    // TODO appliquer la translation sur la forme.
    @Override
    public Ellipse translate(Point2d point) {
        return new Ellipse(translateAll(point));
    }

    // TODO appliquer la rotation sur la forme.
    @Override
    public Ellipse rotate(Double angle) {
        return new Ellipse(rotateAll(angle));
    }

    // TODO retourner une nouvelle forme.
    @Override
    public Ellipse clone() { return new Ellipse(getCoords()); }
}
