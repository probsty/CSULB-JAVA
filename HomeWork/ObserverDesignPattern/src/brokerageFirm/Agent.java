package brokerageFirm;

public class Agent implements Observer {

    private Stock stock;

    private String m_name;

    Agent(String _name,  Stock stock) {
        m_name = _name;
        this.stock = stock;

    }

    @Override
    public void update(Subject subject) {
        stock = (Stock)subject;
        System.out.println(stock.getBid().toString());
    }

    @Override
    public String toString() {
        return "Agent - name: " + m_name + " alerted to Bid - ";
    }

}