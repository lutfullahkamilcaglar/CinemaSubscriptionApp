package Records.Movie;

import java.util.ArrayList;

public class CurrentMovies {

    public ArrayList<Movie> movies = new ArrayList<>();

    public CurrentMovies() {
        this.movies.add(new Movie(1, "Godzilla", 42.0, 4.3)); // same impl
        addMovie(new Movie(2,"Deadpool", 42.0, 7.3)); // same impl
        addMovie(new Movie(3,"Deadpool 2", 42.0, 8.1)); // same impl
    }

    private void addMovie(Movie movie) {
        this.movies.add(movie);
    }
}
