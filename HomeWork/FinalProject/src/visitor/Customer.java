package visitor;

public class Customer {
    String m_name;
    int m_numberOfPersons;
    int m_growRatePercentage;
    Room m_room;

    Customer(String _name, int _numberOfPersons, int _growRatePercentage) {
        m_name = _name;
        m_numberOfPersons = _numberOfPersons;
        m_growRatePercentage = _growRatePercentage;
    }

    public void party() {
        if (m_growRatePercentage != 0) {
            m_numberOfPersons = m_numberOfPersons * m_growRatePercentage / 100;
        }
    }
}
