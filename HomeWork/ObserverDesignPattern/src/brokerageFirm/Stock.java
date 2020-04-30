package brokerageFirm;

import java.util.ArrayList;

public class Stock implements Subject {
    private Bid m_bid = null;
    private ArrayList<Observer> m_observers;

    Stock() {
        m_observers = new ArrayList<>();
    }

    public Bid getBid() {
        return m_bid;
    }

    /*
    * Update the stock instance
     */
    public void trade(Bid _bid) {
        m_bid = _bid;
        notifyObservers();
    }

    @Override
    public boolean registerObserver(Observer _observer) {
        if (m_observers.contains(_observer)) {
            return false;
        } else {
            m_observers.add(_observer);
        }
        return true;
    }

    @Override
    public boolean removeObserver(Observer _observer) {
        if (m_observers.contains(_observer)) {
            m_observers.remove(_observer);
            return true;
        }
        return false;
    }

    @Override
    public void notifyObservers() {
        for (Observer m_observer : m_observers) {
            m_observer.update(this);
        }
    }
}
