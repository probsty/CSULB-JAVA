package visitor;

import java.util.ArrayList;

/**
 * The key to this interface is that it has a separate method for each type of ItemElement that we
 * will deal with.  If we add a new ItemElement type, we have to update this interface, and then any
 * implementations of this interface have to be updated to have a new method for visiting the new
 * type.  The way that we calculate the rate and the duration of the rent varies from one type of
 * ItemElement to the next, but we do calculate the rate and the duration for each.
 * @author	David Brown
 * @date	08/06/2019
 */
public interface Visitor {
    /**
     * Visit a DVD and return the rental rate and the duration of the rental.
     * @param	dvd		The DVD that you want to visit.
     */
    public void visit (DVD dvd);

    /**
     * Visit a Game and return the rate and duration of the rental.
     * @param	game	The game to get the rate and rent duration for.
     */
    public void visit (Game game);

    /**
     * Average publication year
     * @return average publication year/release of all the elements
     * that the visor has visited
     */
    public String averageYear();

    /**
     * Listing of the frequencies of the genres of film and game
     * @return arraylist of the frequencies of the genres of Movie/Game
     */
    public ArrayList<String> counts();
}
