package tp1;

import java.util.*;
import java.util.stream.Collectors;

public class BaseShape {
    // Vous aller apprendre plus en details le fonctionnement d'un Set lors
    // du cours sur les fonctions de hashage, vous pouvez considerez ceci comme une liste normale.
    private Set<Point2d> coords;

    // TODO Initialiser les points.
    public BaseShape() {
        coords = new HashSet<Point2d>();
    }

    // TODO prendre une liste de points et creer une nouvelle forme.
    public BaseShape(Collection<Point2d> coords) {
        for (Point2d element: coords) {
            this.add(element);
        }
    }

    // TODO ajouter ou retirer des coordonnees a la liste de points.
    public void add(Point2d coord) {
        coords.add(coord);
    }
    public void add(BaseShape shape) {
        this.add(shape);
    }
    public void addAll(Collection<Point2d> coords) {
        for(Point2d element : coords){
            this.addAll(coords);
        }
    }
    public void remove(Point2d coord) {
        coords.remove(coord);
    }
    public void remove(BaseShape shape) {

    }
    public void removeAll(Collection<Point2d> coords) {
        this.removeAll(coords);
    }

    // TODO retourne les coordonnees de la liste.
    public Set<Point2d> getCoords() {
        return coords;
    }

    // TODO appliquer la translation sur la forme.
    public BaseShape translate(Point2d point) {
        this.translate(point);
        return this;
    }

    // TODO appliquer la translation sur la liste.
    public Set<Point2d> translateAll(Point2d point) {
        for (Point2d element: coords) {
            element.translate(point);
        }
        return null;
    }

    // TODO appliquer la rotation sur la forme.
    public BaseShape rotate(Double angle) {
        this.rotate(angle);
        return this;
    }

    // TODO appliquer la rotation sur la liste.
    public Set<Point2d> rotateAll(Double angle) {
        for (Point2d element: coords) {
            element.rotate(angle);
        }
        return null;
    }

    // TODO retourner une nouvelle forme.
    public BaseShape clone() {
        BaseShape monClone = new BaseShape(coords);
        return monClone;
    }
}
