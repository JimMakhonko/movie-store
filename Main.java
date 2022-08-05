import models.Movie;
import models.Store;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
Movie movie = new Movie("The Shawshank Redemption","Blue-Ray",8.8);
        System.out.println(movie);
    }

    /**
     * Name: manageMovies
     * Inside the function:
     *   • 1. Starts a new instance of Scanner;
     *   • 2. In an infinite loop, the user can choose to a) purchase b) rent c) return d) exit.
     *   •        case a: ask for the name and sell.
     *   •        case b: ask for the name and rent.
     *   •        case c: ask for the name and return.
     *   • 3. call close() from the Scanner object.
     */

public static void loadMovies(String filename) throws FileNotFoundException{
    FileInputStream fileInputStream = new FileInputStream(filename);
    Scanner scanner = new Scanner(fileInputStream);
    scanner.useDelimiter("--");
    while(scanner.hasNextLine()){
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
