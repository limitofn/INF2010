package tp1;

public final class LetterFactory {
    final static Double maxHeight = 200.0;
    final static Double maxWidth = maxHeight / 2;
    final static Double halfMaxHeight = maxHeight / 2;
    final static Double halfMaxWidth = maxWidth / 2;
    final static Double stripeThickness = maxHeight / 10;

    // TODO
    public static BaseShape create_H() {
        BaseShape verticalStripeGauche = new Rectangle(stripeThickness, maxHeight);
        Double angle = Math.toRadians(90);
        BaseShape horizontalStripe = new Rectangle(stripeThickness, maxHeight/2).rotate(-angle).translate(new Point2d(0.0, halfMaxHeight));
        BaseShape verticaleStripeDroite = verticalStripeGauche.translate(new Point2d(maxWidth,0.0));
        verticalStripeGauche.add(horizontalStripe);
        verticalStripeGauche.add(verticaleStripeDroite);
        return verticalStripeGauche;
    }

    // TODO
    public static BaseShape create_e() {
        BaseShape ellispeEnFormeE = new Ellipse(maxWidth, maxHeight);
        Double angle= Math.toRadians(90);
        BaseShape rectangleMilieu= new Rectangle(stripeThickness, maxWidth-15).rotate(-angle).translate(new Point2d(0.0,halfMaxHeight));
        BaseShape rectangleDeleteUnePartieDeEllipse = new Rectangle(stripeThickness, halfMaxWidth).rotate(-angle).translate(new Point2d(halfMaxWidth,halfMaxHeight+stripeThickness));
        ellispeEnFormeE.add(rectangleMilieu);
        ellispeEnFormeE.remove(rectangleDeleteUnePartieDeEllipse);
        return ellispeEnFormeE;
    }

    // TODO
    public static BaseShape create_l() {
        BaseShape formeEnL = new Rectangle(stripeThickness, maxHeight);
        return formeEnL;
    }

    // TODO
    public static BaseShape create_o() {
        BaseShape formeEnO = new Ellipse(maxWidth, maxHeight);
        return formeEnO;
    }

    // On vous donne la lettre W comme exemple.
    public static BaseShape create_W() {
        Double degrees15 = Math.toRadians(8);
        Double spacing = stripeThickness * 2;
        BaseShape mainStripe = new Rectangle(stripeThickness, maxHeight);
        BaseShape leftStripe = mainStripe.rotate(-degrees15).translate(new Point2d(-spacing, 0.0));
        BaseShape middleLeftStripe = mainStripe.rotate(degrees15).translate(new Point2d(-spacing / 3, 0.0));
        BaseShape middleRightStripe = mainStripe.rotate(-degrees15).translate(new Point2d(spacing / 3, 0.0));
        BaseShape rightStripe = mainStripe.rotate(degrees15).translate(new Point2d(spacing, 0.0));
        leftStripe.add(middleLeftStripe);
        leftStripe.add(middleRightStripe);
        leftStripe.add(rightStripe);
        return leftStripe;
    }

    // TODO
    public static BaseShape create_r() {
        BaseShape formeEnR= new Rectangle(stripeThickness,maxHeight);
        BaseShape demiCercle = new Circle(maxWidth).translate(new Point2d(0.0,10.0));
        BaseShape eliminateurDeDemiCercle = new Square(maxWidth).translate(new Point2d(0.0,halfMaxHeight/2));
        demiCercle.remove(eliminateurDeDemiCercle);
        formeEnR.add(demiCercle);
        return formeEnR;
    }

    // TODO
    public static BaseShape create_d() {
        BaseShape formeEnD = new Rectangle(stripeThickness,maxHeight).translate(new Point2d(maxWidth,0.0));
        BaseShape circle = new Circle(maxWidth).translate(new Point2d(stripeThickness-10, maxWidth));
        formeEnD.add(circle);
        return formeEnD;
    }
}
