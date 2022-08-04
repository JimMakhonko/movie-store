package models;

import java.awt.*;
import java.util.ArrayList;

public class Store {
    ArrayList<Movie> movies;

    public Store() {
        this.movies = new ArrayList<>();
    }

    public Movie getMovies(int index) {
        return new Movie(movies.get(index));
    }

    public void setMovies(int index, Movie movie) {
        movies.set(index, new Movie(movie));
    }

    public void addMovie(Movie movie) {
        movies.add(new Movie(movie));
    }

    public void removeMovie(String name) {
        if (movies.isEmpty()) throw new IllegalStateException("Cannot remove from empty list");
        {
            for (int i = 0; i < movies.size(); i++) {
                if (movies.get(i).getName().equals(name)) {
                    movies.remove(i);
                }
            }
        }
    }

    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < movies.size(); i++) {
            temp+= movies.get(i);
            temp+="\n";
        }
        return temp;
    }
}
