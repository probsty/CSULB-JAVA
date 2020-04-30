package brokerageFirm;

public class ObserverRunner {

    public static void main(String[] args) {
        Stock stock = new Stock();
        Agent agent1 = new Agent("Tom Clancey", stock);
        Agent agent2 = new Agent("Robert Mitchner", stock);
        Agent agent3 = new Agent("Noah ben Shea", stock);
        Agent agent4 = new Agent("Richard Rohr", stock);


        Bid bid = new Bid("ORCL", 20, 3421.0f, TransactionTypes.BUY, agent1);
        Bid bid2 = new Bid("BA", 10, 50.0f, TransactionTypes.SELL, agent2);
        Bid bid3 = new Bid("TRKX", 30, 204.36f, TransactionTypes.BUY, agent3);

        stock.registerObserver(agent4);

        stock.trade(bid);
        stock.trade(bid2);
        stock.trade(bid3);

        bid = new Bid("ORCL", 20, 3421.0f, TransactionTypes.BUY, agent3);
        bid2 = new Bid("BA", 10, 50.0f, TransactionTypes.SELL, agent1);
        bid3 = new Bid("TRKX", 30, 204.36f, TransactionTypes.BUY, agent2);
        stock.trade(bid);
        stock.trade(bid2);
        stock.trade(bid3);

    }
}