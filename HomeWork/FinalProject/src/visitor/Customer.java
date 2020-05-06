package visitor;

public class Customer {
    String name;
    int population;
    double growthRate;
    Room m_room;


    Customer() {
        this.name = "default";
        this.population = 0;
        this.growthRate = 1.0;
    }

    Customer(String _name, int _numberOfPersons, double _growRatePercentage) {
        this.name = _name;
        this.population = _numberOfPersons;
        this.growthRate = _growRatePercentage;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return this.population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getGrowthRate() {
        return this.growthRate;
    }

    public void setGrowthRate(double growthRate) {
        this.growthRate = growthRate;
    }

    public void party() {
        if (growthRate != 0) {
            population = (int) (population * growthRate / 100);
        }
    }
}
