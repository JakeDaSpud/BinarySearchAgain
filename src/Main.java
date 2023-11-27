import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void print(ArrayList<Country> count)
    {
        System.out.printf("%-15s %-10s %-10s %-15s %-10s\n",
                "Country", "Population", "Area", "Capital",
                "Continent");
        for(Country c: count)
        {
            System.out.printf("%-15s %-10d %-10.1f %-15s %-10s\n",
                    c.getName(), c.getPopulation(),
                    c.getArea(), c.getCapital(),
                    c.getContinent());
        }
    }
    public static void main(String[] args)
    {
        Country c1 = new Country("Ireland",4500000, 84421, "Dublin", Continent.EUROPE);
        Country c2 = new Country("France",9000000, 250000, "Paris", Continent.EUROPE);
        Country c3 = new Country("Germany",9000000, 250000, "Brussels", Continent.EUROPE);
        Country c4 = new Country("Mexico",4500000, 500000, "Mexico City", Continent.SOUTH_AMERICA);

        System.out.println(c2.compareTo(c1));
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(c1);
        countries.add(c2);
        countries.add(c3);
        countries.add(c4);
        System.out.println("************** Natural Ordering ***************");
        Collections.sort(countries);
        print(countries);

        System.out.println("************** Named Comparator ***************");
        Collections.sort(countries, new CountryNameComparator());
        print(countries);

        System.out.println("************** Annomomous Inner Class ***************");
        Collections.sort(countries, new Comparator<Country>() {
            @Override
            public int compare(Country o1, Country o2) {
                return o1.getCapital().compareTo
                        (o2.getCapital());
            }
        });
        print(countries);

        System.out.println("************** Lambda Expression ***************");
        Collections.sort(countries, (country1, country2)->{
            return country1.getContinent().compareTo(country2.getContinent()); });
        print(countries);

        System.out.println("************** Lambda Expression ***************");
        Collections.sort(countries);

        Country key = new Country();
        key.setName("Ireland");
        key.setPopulation(4500000);
        key.setArea(84421);
        int index = Collections.binarySearch(countries,
                key);
        System.out.println(index);
        System.out.println(countries.get(index));

        Country c5 = new Country("O",4500000, 500000, "Mexico City", Continent.SOUTH_AMERICA);

        countries.add(c5);

        //Continent -> Name comparator
        Collections.sort(countries, (countrye1, countrye2) -> {
            if (countrye1.getContinent() == countrye2.getContinent())
            {
                if (countrye1.getName() == countrye2.getName()) {
                    return countrye1.getName().compareTo(countrye2.getName());
                }

                return countrye1.getName().compareTo(countrye2.getName());
            }

            return countrye1.getContinent().compareTo(countrye2.getContinent());
        });

        System.out.println("************** Lambda Expression Continent -> Name Comparator ***************");
        print(countries);

        //DOING CONTAINERS NOW
        System.out.println("\nDOING CONTAINERS NOW...");

        ArrayList<Container> containers = new ArrayList<Container>();
        containers.add(new Cylinder("cy01", "Huh", 20, 10));
        containers.add(new Cuboid("cb01", "Nuffin'", 7, 2, 4));
        containers.add(new Cylinder("cy02", "Another Cylinder", 50, 10));
        containers.add(new Cuboid("cb02", "Water'", 7, 8, 5));
        containers.add(new Cylinder("cy03", "Uisce", 20, 1110));
        containers.add(new Cuboid("cb03", "Nothing'", 6, 4, 400));

        double totalVolume = 0;
        for (Container c: containers) {
            totalVolume += c.volume();
        }
        System.out.println("Total Volume: " + totalVolume);

        System.out.println("\nAll Cylinder Dimensions:");
        for (Container c: containers) {
            if (c instanceof Cylinder) {
                c.printDimensions();
            }
        }

    }
}