package visitor;

import java.awt.geom.AffineTransform;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * The RentalVisitor Implementation could have some instance variables of its own that it
 * uses, for instance, to keep a running total, or do some other sort of statistical
 * calculation as it goes.  That works well if the client is disciplined and gets a new
 * visitor instance at the start of the "run" through a given collection, and then harvests
 * the accumulated data (presumably through an appropriate getter) at the end of the run.
 * @author	David Brown
 * @date	08/06/2019
 */
public class RentalVisitorImpl implements Visitor {
    Agreement m_valueDVD = null;
    Agreement m_valueCD = null;
    ArrayList<Agreement> visitedElement = new ArrayList<>();
    double averageYear = 0;
    Map<String, Integer> mapMovieGenreToInteger = new HashMap<>();
    Map<String, Integer> mapGameGenreToInteger = new HashMap<>();
    ArrayList<String> countsList = new ArrayList<>();

    @Override
    public void visit(DVD dvd) {
        double rate;
        int weeks;
        int days;
        int thisYear = LocalDate.now().getYear();
        if (thisYear - dvd.getYearReleased() > 20) {		//Old video, cheap and they can keep it
            rate = 2.5;
            weeks = 2;
            days = 0;
        } else if (thisYear - dvd.getYearReleased()> 10){	//Not as old, more expensive, shorter rental period
            rate = 4.;
            weeks = 1;
            days = 0;
        } else {											//New, expensive and short duration
            rate = 6;
            weeks = 0;
            days = 3;
        }
        averageYear += dvd.getYearReleased();
        int add;
        if (mapMovieGenreToInteger.get(dvd.getGenre().name()) == null) {
            add = 1;
        } else {
            add = mapMovieGenreToInteger.get(dvd.getGenre().name()) + 1;
        }
        mapMovieGenreToInteger.put(dvd.getGenre().name(), add);
        m_valueDVD = new Agreement(rate, weeks, days);
        visitedElement.add(m_valueDVD);
    }

    @Override
    public void visit(Game game) {
        double rate = 0;
        int weeks = 0;
        int days = 0;
        int thisYear = LocalDate.now().getYear();			//Get this year
        if (thisYear - game.getYearPublished() > 20) {		//Old game, virtually free
            rate = 1.0;
            weeks = 3;
            days = 0;
        } else if (thisYear - game.getYearPublished() > 10) {
            rate = 4.0;
            weeks = 2;
            days = 2;
        } else {
            weeks = 1;										//default duration of rental
            days = 0;
            switch (game.getRating()) {
                case EARLY_CHILDHOOD: {
                    rate = 8;								//High demand for these.
                    break;
                } case EVERYONE: {
                    break;									//Nothing special here.
                } case TEEN: {
                    rate = 8;
                    weeks = 1;								//High demand
                    break;
                } case MATURE: {
                    rate = 8;
                    weeks = 0;
                    days = 3;
                } case ADULTS_ONLY: {
                    rate = 7;
                    weeks = 0;
                    days = 4;
                    break;
                } default: {
                    rate = 7.5;
                    break;
                }
            }
        }
        averageYear += game.getYearPublished();
        int add = 0;
        if (mapGameGenreToInteger.get(game.getGenre().name()) == null) {
            add = 1;
        } else {
            add = mapGameGenreToInteger.get(game.getGenre().name()) + 1;
        }
        mapGameGenreToInteger.put(game.getGenre().name(), add);
        m_valueCD = new Agreement (rate, weeks, days);
        visitedElement.add(m_valueCD);
    }

    @Override
    public String averageYear() {
        if (visitedElement.size() == 0) {
            return "0";
        }
        return Double.toString(averageYear / visitedElement.size());
    }

    @Override
    public ArrayList<String> counts() {
        countsList.add("Counts for the Movies");
        for (MovieGenre movieGenre : MovieGenre.values()) {
            if (mapMovieGenreToInteger.containsKey(movieGenre.name())) {
                countsList.add("Genre: " + movieGenre.name() + " came up: " + mapMovieGenreToInteger.get(movieGenre.name()));
            }
        }

        countsList.add("Counts for the Games");
        for (GameGenre gameGenre : GameGenre.values()) {
            if (mapGameGenreToInteger.containsKey(gameGenre.name())) {
                countsList.add("Genre: " + gameGenre.name() + " came up: " + mapGameGenreToInteger.get(gameGenre.name()));
            }
        }
        return countsList;
    }
}