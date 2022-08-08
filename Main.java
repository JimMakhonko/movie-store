import models.Movie;
import models.Store;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static Store store = new Store();

    public static void main(String[] args) {
        System.out.println("\n**********************JAVA VIDEO STORE**********************\n");
        Movie movie = new Movie("The Shawshank Redemption", "Blue-Ray", 8.8);
        Movie movie1 = new Movie("Idiocracy", "Blue-Ray", 9.9);
        Movie movie2 = new Movie("Lol", "DVD", 9.2);
        store.addMovie(movie);
        store.addMovie(movie1);
        store.addMovie(movie2);
        store.action("Idiocracy", "rentMovie");
        System.out.println(store);
        store.action("Idiocracy","sellMovie");
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

    public static void loadMovies(String filename) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(filename);
        Scanner scanner = new Scanner(fileInputStream);
        scanner.useDelimiter("--");
        while (scanner.hasNextLine()) {
            Movie movie = new Movie(scanner.next(), scanner.next(), scanner.nextDouble());
        }
    }
    /**
     * Name: loadMovies
     * @param fileName (String)
     * @throws FileNotFoundException
     *
     * Inside the function:
     *   • 1. loads movies from <fileName>.txt.
     *   • 2. adds all movies to the store object's movie field.
     *        Hint: You will need to 'split' a String into three Strings.
     */

}
