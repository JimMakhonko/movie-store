import models.Movie;
import models.Store;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static Store store = new Store();

    public static void main(String[] args) {
        System.out.println("\n**********************JAVA VIDEO STORE**********************\n");
        try {
            loadMovies("movies.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("MOVIES LOADED");
            System.out.println(store);
            manageMovies();
        }
    }

    /**
     * Name: manageMovies
     * Inside the function:
     * • 1. Starts a new instance of Scanner;
     * • 2. In an infinite loop, the user can choose to a) purchase b) rent c) return d) exit.
     * •        case a: ask for the name and sell.
     * •        case b: ask for the name and rent.
     * •        case c: ask for the name and return.
     * • 3. call close() from the Scanner object.
     */
public static void manageMovies(){
    Scanner scanner = new Scanner(System.in);
    while (true){

        System.out.print("Would you like to\n\ta) purchase\n\tb) rent\n\tc) return\n");
        String response = scanner.nextLine();
        System.out.print("\tEnter the name of the movie : ");
        String name = scanner.nextLine();
        if (name.isBlank()){
            System.out.println("\n\nThe input you've provided is not valid. Please try again.\n");
            continue;
        }
        switch (response) {
            case "a" -> {
                if (!(store.getMovie(name).isAvailable())){
                    System.out.println("\n\n\n\nThe movie is not available for purchase. Please try again\n");
                    continue;
                }
                    store.action(name, "sellMovie");
            }
            case "b" -> store.action(name, "rentMovie");
            case "c" -> store.action(name, "returnMovie");
        }
        System.out.println("\n\nUPDATED MOVIES\n\n" + store);
    }
}

    /**
     * Name: loadMovies
     *
     * @param fileName (String)
     * @throws FileNotFoundException Inside the function:
     *                               • 1. loads movies from <fileName>.txt.
     *                               • 2. adds all movies to the store object's movie field.
     *                               Hint: You will need to 'split' a String into three Strings.
     */
    public static void loadMovies(String fileName) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        Scanner scanner = new Scanner(fileInputStream);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] words = line.split("--");
            store.addMovie(new Movie(words[0], words[1], Double.parseDouble(words[2])));
        }
        scanner.close();
    }
}
