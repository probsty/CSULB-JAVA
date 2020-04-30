package visitor;

/**
 * A game that we rent.
 * @author	David Brown
 * @date	08/06/2019
 */
public class Game implements Visited{
    private GameRating rating;
    private GameGenre genre;
    private int yearPublished;
    private String name;

    public Game (GameRating rating, GameGenre genre, int yearPublished, String name) {
        this.rating = rating;
        this.genre = genre;
        this.yearPublished = yearPublished;
        this.name = name;
    }

    public GameRating getRating() {
        return rating;
    }

    public GameGenre getGenre() {
        return genre;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString () {
        return "Game - " + this.name +" Publication year: " + this.getYearPublished() +
                " Rating: " + this.getRating() + " Genre: " + this.getGenre();
    }
}
