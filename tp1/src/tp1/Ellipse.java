package tp1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Ellipse extends BaseShape {
    // TODO creer une ellipse avec une largeur et une longueur.
    public Ellipse(Double widthRadius, Double heightRadius) {
        super(new HashSet<Point2d>(Arrays.asList(new Point2d(0.0, heightRadius/2))));
        for(Double i = 0.0; i <= widthRadius; i++){
            for(Double j = 0.0; j <= heightRadius; j++){
                Double ellipse = (Math.pow(i-widthRadius/2,2)/Math.pow(widthRadius/2,2)) + (Math.pow(j-heightRadius/2,2)/Math.pow(heightRadius/2,2));
                if((ellipse <= 1)&&(ellipse >= 0.6))
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
