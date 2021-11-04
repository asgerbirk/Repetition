import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Integer> listOfNumber = new ArrayList<>();

    public static void main(String[] args) {
        Penne pennePasta = new Penne();
        Spaghetti spaghetti = new Spaghetti();
        Rigatoni rigatoni = new Rigatoni();

//bruger metoderne fra pasta sub klassen
        Spaghetti.pastaHistory();
        Spaghetti.spaghettiShape();
//Bruger metoden fra penne underklassen
        spaghetti.spaghettiHistory();


        System.out.println("Exercise 2 -----------------------------------------------------------------------------");
        File f = new File("files/1-1000.csv");
        try {
            int count = 0;
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
                count++;
            }
            System.out.println("number of words in the file is: " + count);
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found");
            e.printStackTrace();
        }
        System.out.println("Exercise 4---------------------------------------------------------------------");

        int birthSeconds = 7;
        int deathSeconds = 13;
        int population = 331002651;
        int years = 5;
        int populationIn5Years = calculatePopulation(birthSeconds, deathSeconds, population, years);
        System.out.println(populationIn5Years);

        System.out.println("Exercise 6 -------------------------------------------------------------------");

        for (int i = 1; i <= 100; i++) {
            listOfNumber.add(i);
        }
        System.out.println(listOfNumber);

        listToRemove();

    }


    public static int calculatePopulation(int birthSeconds, int deathSeconds, int population, int years) {
        int dayInAYear = 365;
        int hoursInADay = 24;
        int minutesToHours = 60;
        int secondsToMinuts = 60;

        int currentPopulation = population + years * dayInAYear * hoursInADay * minutesToHours * secondsToMinuts / birthSeconds - years * dayInAYear * hoursInADay * minutesToHours * secondsToMinuts / deathSeconds;

        return currentPopulation;
    }

    public static ArrayList<Integer> listToRemove() {
        System.out.println("What number would you like to remove?");
        int numberToRemove = scanner.nextInt();
        ArrayList<Integer> listToRemove = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            if (i % numberToRemove == 0) {
                listToRemove.add(i);
            }
        }
        listToRemove.remove(0);
        listOfNumber.removeAll(listToRemove);
        System.out.println(listOfNumber);

        return listOfNumber;

    }
}

