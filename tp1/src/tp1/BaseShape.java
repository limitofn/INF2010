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
       this.coords= new HashSet <Point2d>(coords);
    }

    // TODO ajouter ou retirer des coordonnees a la liste de points.
    public void add(Point2d coord) {
        this.coords.add(coord);
    }

    public void add(BaseShape shape) {
        this.addAll(shape.coords);
    }

    public void addAll(Collection<Point2d> coords) {
        for(Point2d element : coords){
            this.add(element);
        }
    }
    public void remove(Point2d coord) {
        this.coords.remove(coord);
    }

    public void remove(BaseShape shape) {
        this.coords.removeAll(shape.coords);
    }
    public void removeAll(Collection<Point2d> coords) {
        this.coords.removeAll(coords);
    }

    // TODO retourne les coordonnees de la liste.
    public Set<Point2d> getCoords() {
        Set<Point2d> copy = new HashSet<>();
        copy.addAll(coords);
        return copy;
    }

    // TODO appliquer la translation sur la forme.
    public BaseShape translate(Point2d point) {
        return new BaseShape(translateAll(point));
    }

    // TODO appliquer la translation sur la liste.
    public Set<Point2d> translateAll(Point2d point) {

        Set<Point2d> setTampon = new HashSet <Point2d>();
        for (Point2d coordsTampon: coords)
        {
            setTampon.add(coordsTampon.translate(point));
        }
        return setTampon;
    }

    // TODO appliquer la rotation sur la forme.
    public BaseShape rotate(Double angle) {
        return new BaseShape(rotateAll(angle));
    }

    // TODO appliquer la rotation sur la liste.
    public Set<Point2d> rotateAll(Double angle) {

        Set<Point2d> setTampon = new HashSet <Point2d>();
        for (Point2d coordsTampon: coords) {
            setTampon.add(coordsTampon.rotate(angle));
        }
        return setTampon;
    }

    // TODO retourner une nouvelle forme.
    public BaseShape clone() {
        BaseShape monClone = new BaseShape(this.coords);
        return monClone;
    }
}
