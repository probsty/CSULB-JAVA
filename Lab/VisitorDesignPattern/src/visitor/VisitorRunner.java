package visitor;

import java.util.ArrayList;

public class VisitorRunner {

    public static void main(String[] args) {
        Visited [] items = {
                new DVD ("Jurasic Park", 1993, MovieGenre.ADVENTURE),
                new Game(GameRating.MATURE, GameGenre.ROAD_RAGE, 2005, "Fast and Furiously"),
                new DVD ("Indiana Jones and the Last Crusade", 1989, MovieGenre.ADVENTURE),
                new DVD ("The Goonies", 1985, MovieGenre.ADVENTURE),
                new Game(GameRating.TEEN, GameGenre.SCIENCE_FICTION, 2012, "Star Wars 1st Class"),
                new Game(GameRating.RATING_PENDING, GameGenre.SCIENCE_FICTION, 2019, "They Came From Space")
        };
        Visitor visitor = new RentalVisitorImpl();
        for (Visited element: items) {
            System.out.println (element);
            element.accept(visitor);
        }
        System.out.println("Now for the statistics");
        System.out.println("Average year published was " + visitor.averageYear());
        ArrayList<String> list = visitor.counts();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("Completed satisfactorily.");
    }

}