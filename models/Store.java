package models;

import java.awt.*;
import java.util.ArrayList;

public class Store {
    ArrayList<Movie> movies;

    public Store() {
        this.movies = new ArrayList<Movie>();
    }

    public Movie getMovie(String name) {
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getName().equals(name)) {
                return new Movie(movies.get(i));
            }
        }
        return null;
    }

    public Movie getMovies(int index) {
        return new Movie(movies.get(index));
    }

    public void setMovie(int index, Movie movie) {
        movies.set(index, new Movie(movie));
    }

    public void addMovie(Movie movie) {
        movies.add(new Movie(movie));
    }

    public void action(String name, String action) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Invalid name");
        if (!(action.equals("sellMovie") || action.equals("rentMovie") || action.equals("returnMovie")))
            throw new IllegalArgumentException("Invalid action");
        if (movies.isEmpty())
            throw new IllegalStateException("Can't remove from empty list");
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getName().equals(name)) {
                switch (action) {
                    case "sellMovie" -> {
                        if (!(movies.get(i).isAvailable()))
                            throw new IllegalStateException("Can't sell rented movie");
                        movies.remove(i);
                    }
                    case "rentMovie" -> movies.get(i).setAvailable(false);
                    case "returnMovie" -> movies.get(i).setAvailable(true);
                }
            }
        }
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < movies.size(); i++) {
            temp += movies.get(i);
            temp += "\n";
        }
        return temp;
    }
}
