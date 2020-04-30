package visitor;

public class DVD implements Visited{
    private String name;
    private int yearReleased;
    private MovieGenre genre;

    public DVD (String name, int yearReleased, MovieGenre genre) {
        this.name = name;
        this.yearReleased = yearReleased;
        this.genre = genre;
    }

    /**
     * Return the name of the DVD title.
     * @return	Title of the dvd.
     */
    public String getName() {return this.name; }

    /**
     * Return the year released.
     * @return	Year that the DVD was released.
     */
    public int getYearReleased () {return this.yearReleased; }

    /**
     * Return the genre for this movie.
     * @return	The genre.
     */
    public MovieGenre getGenre() {return this.genre; }

    @Override
    public String toString () {
        return "DVD - Name: " + this.getName() + " Released: " + this.getYearReleased() +
                " Genre: " + this.getGenre();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }


}
