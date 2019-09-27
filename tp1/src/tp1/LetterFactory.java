package tp1;

public final class LetterFactory {
    final static Double maxHeight = 200.0;
    final static Double maxWidth = maxHeight / 2;
    final static Double halfMaxHeight = maxHeight / 2;
    final static Double halfMaxWidth = maxWidth / 2;
    final static Double stripeThickness = maxHeight / 10;

    // TODO
    public static BaseShape create_H() {
        BaseShape mainStripe = new Rectangle(stripeThickness, maxHeight);
        BaseShape smallStripe = new Rectangle(stripeThickness, maxWidth);
        Double angle = Math.toRadians(90);
        BaseShape middleStripe = smallStripe.rotate(-angle).translate(new Point2d(-halfMaxWidth, halfMaxHeight));
        BaseShape rightSide = mainStripe.translate(new Point2d(-halfMaxWidth,0.0));
        BaseShape leftSide = mainStripe.translate(new Point2d(halfMaxWidth,0.0));
        leftSide.add(middleStripe);
        leftSide.add(rightSide);
        return leftSide;
    }

    // TODO
    public static BaseShape create_e() {
        BaseShape ellipse = new Ellipse(maxWidth, maxHeight).translate(new Point2d(-halfMaxWidth,0.0));
        BaseShape mainStripe = new Rectangle(stripeThickness, halfMaxHeight-5);
        Double angle = Math.toRadians(90);
        BaseShape addedStripe = mainStripe.rotate(-angle).translate(new Point2d(-halfMaxWidth,halfMaxHeight));
        BaseShape deletedStripe = mainStripe.rotate(-angle).translate(new Point2d((maxWidth/2)-halfMaxWidth,halfMaxHeight+stripeThickness));
        ellipse.add(addedStripe);
        ellipse.remove(deletedStripe);
        return ellipse;
    }

    // TODO
    public static BaseShape create_l() {
        BaseShape formeEnL = new Rectangle(stripeThickness, maxHeight).translate(new Point2d(-halfMaxWidth/4,0.0));
        return formeEnL;
    }

    // TODO
    public static BaseShape create_o() {
        BaseShape circle = new Ellipse(maxWidth, maxHeight).translate(new Point2d(-halfMaxWidth,0.0));
        return circle;
    }

    // On vous donne la lettre W comme exemple.
    public static BaseShape create_W() {
        Double degrees15 = Math.toRadians(8);
        Double spacing = halfMaxWidth/2;
        BaseShape mainStripe = new Rectangle(stripeThickness, maxHeight);
        BaseShape leftStripe = mainStripe.rotate(-degrees15).translate(new Point2d(-spacing*2.5, 0.0));
        BaseShape middleLeftStripe = mainStripe.rotate(degrees15).translate(new Point2d(spacing/8, 0.0));
        BaseShape middleRightStripe = mainStripe.rotate(-degrees15).translate(new Point2d(spacing / 6, 3.0));
        BaseShape rightStripe = mainStripe.rotate(degrees15).translate(new Point2d(spacing*2.7, 0.0));
        leftStripe.add(middleLeftStripe);
        leftStripe.add(middleRightStripe);
        leftStripe.add(rightStripe);
        return leftStripe;
    }

    // TODO
    public static BaseShape create_r() {
        BaseShape mainStripe = new Rectangle(stripeThickness, maxHeight);
        BaseShape mainCircle = new Circle(maxWidth);
        BaseShape mainSquare = new Square(maxWidth);
        BaseShape verticalStripe = mainStripe.translate(new Point2d(-halfMaxWidth,0.0));
        BaseShape circle = mainCircle.translate(new Point2d(-halfMaxWidth,10.0));;
        BaseShape square = mainSquare.translate(new Point2d(-halfMaxWidth,halfMaxHeight/2));
        circle.remove(square);
        verticalStripe.add(circle);
        return verticalStripe;
    }

    // TODO
    public static BaseShape create_d() {
        BaseShape mainStripe = new Rectangle(stripeThickness, maxHeight);
        BaseShape mainCircle = new Circle(maxWidth);
        BaseShape verticalStripe = mainStripe.translate(new Point2d(halfMaxWidth-12,0.0));
        BaseShape circle = mainCircle.translate(new Point2d(stripeThickness-22-halfMaxWidth,maxHeight - maxWidth));
        verticalStripe.add(circle);
        return verticalStripe;
    }
}
