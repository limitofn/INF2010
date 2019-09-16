package tp1;

import java.util.*;

public final class PointOperator {
    // TODO appliquer la translation sur le vecteur d'entree.
    public static Double[] translate(Double[] vector, Double[] translateVector) {

        for (int i=0; i<vector.length; i++){
            vector[i] += translateVector[i];
        }
        return vector;
    }

    // TODO appliquer la rotation sur le vecteur d'entree.
    public static Double[] rotate(Double[] vector, Double[][] rotationMatrix) {
        Double[] rotatedVector= new Double[vector.length];
        Arrays.fill(rotatedVector, 0);
        for (int colonne=0; colonne<rotationMatrix.length; colonne++){
            for(int ligne=0; ligne<rotationMatrix[colonne].length; ligne++){
                rotatedVector[colonne]+= (vector[ligne] * rotationMatrix[ligne][colonne]);
            }
        }

        return rotatedVector;
    }

    // TODO appliquer le facteur de division sur le vecteur d'entree.
    public static Double[] divide(Double[] vector, Double divider) {
        for(int i=0; i<vector.length; i++){
            vector[i]= vector[i]/divider;
        }
        return vector;
    }

    // TODO appliquer le facteur de multiplication sur le vecteur d'entree.
    public static Double[] multiply(Double[] vector, Double multiplier) {
        for(int i=0; i<vector.length; i++){
            vector[i]= vector[i]*multiplier;
        }
        return vector;
    }

    // TODO appliquer le facteur d'addition sur le vecteur d'entree.
    public static Double[] add(Double[] vector, Double adder) {

        for(int i=0; i<vector.length; i++) {
            vector[i] = vector[i] + adder;
        }
        return vector;
    }

    // TODO retourne la coordonnee avec les plus grandes valeurs en X et en Y.
    public static Point2d getMaxCoord(Collection<Point2d> coords) {
        Double x;
        Double y;

        for (int i=0; i<coords.size(); )
        coords[i] ;

        Double vector = new Double [] {x,y};
        return new Point2d(vector);
    }

    // TODO retourne la coordonnee avec les plus petites valeurs en X et en Y.
    public static Point2d getMinCoord(Collection<Point2d> coords) {

        return null;
    }
}
