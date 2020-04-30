package brokerageFirm;

public class Bid {

    private String symbol;

    private int numberShares;

    private float price;

    private TransactionTypes transactionType;

    private Agent agent;

    public Bid(String symbol, int numberShares, float price, TransactionTypes transactionType, Agent agent) {
        this.symbol = symbol;
        this.numberShares = numberShares;
        this.price = price;
        this.transactionType = transactionType;
        this.agent = agent;
    }

    @Override
    public String toString() {
        return agent.toString() + "Symbol:" + symbol + (transactionType == TransactionTypes.BUY ? " Buying " : " Selling ") + numberShares + " shares for the amount: " + price;
    }
}
