package HomeWork8;

public class Row{
    String continent;
    String country;
    int cases;

    public Row(String continent, String country,int cases) {
        this.continent = continent;
        this.country = country;
        this.cases   = cases;
    }

    @Override
    public String toString() {
        return "Сontinent  = " + continent + "; Сountry = " + country + "; Cases = " + cases;
    }

    public Object getFild(int columnIndex) {
        if (columnIndex == 0) return country;
        else return cases;

    }
}