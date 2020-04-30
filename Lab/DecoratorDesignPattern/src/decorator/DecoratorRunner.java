package decorator;

public class DecoratorRunner {

    public static void main(String[] args) {
        GeometricObject c1 = new LineColorDecorator(new LineWeightDecorator (new FillColorDecorator
                (new Circle (3, 4, 5), Color.BLUE), LineWeight.LIGHT), Color.GREEN);
        c1.draw();
        System.out.println("toString of the above object:" + "\n" + c1 + "\n****************\n");

        c1 = new LineColorDecorator(new LineWeightDecorator (new FillColorDecorator
                (new Square (-3, -4, 6), Color.GREEN), LineWeight.MEDIUM), Color.PURPLE);
        c1.draw();
        System.out.println("toString of the above object:" + "\n" + c1 + "\n****************\n");

        c1 = new LineColorDecorator(new LineWeightDecorator (new FillColorDecorator
                (new Rectangle (10, 20, 5.0, 10.0), Color.BLACK), LineWeight.HEAVY), Color.PUCE);
        c1.draw();
        System.out.println("toString of the above object:" + "\n" + c1 + "\n****************\n");

        System.out.println("Completed Satisfactorily");
    }
}