package visitor;

/**
 * An Enum with the option choice and the associated price.
 * Final Project Assignment:
 *
 * @author Yann Probst
 * @version 1.01 05/01/2020
 */
public enum Options {
    FOODBAR(10),
    SPA(20),
    AUTOREFILL(5),
    SPRAYRESISTANTSHOWER(25)
    ;

    /** The price of the options */
    private int price;

    private Options(int _price) {
        this.price = _price;
    }

    /** Get the enum's price value
     * @param _option's price enum that need to be returned
     * @return the enum price of the options
     * */
    public int getPrice(Options _option) {
        return _option.price;
    }

}
