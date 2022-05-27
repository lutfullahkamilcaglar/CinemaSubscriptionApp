package Controller;

import InputManager.InputManager;
import Records.Movie.CurrentMovies;
import Records.Movie.Movie;

import java.util.concurrent.atomic.AtomicReference;

public class Controller {

    private final InputManager inputManager;
    private final CurrentMovies currentMovies;

    public Controller(InputManager inputManager) {
        this.inputManager = inputManager;
        this.currentMovies = new CurrentMovies();
    }

    public void startApplication() {
        boolean continueLoop = true;
        do {
            String listing = """
                    Welcome to cinema ticket program. Please make a chose
                    Your options:
                    1. List movies
                    7. Exit
                    To make the chose insert the number of the option.
                    """;
            int selection = inputManager.getIntWithDescription(listing);

            switch (selection) {
                case 1 -> continueLoop = listMovies();
                case 7 -> {
                    continueLoop = false;
                    System.out.println("Exit selected...");
                }
                default -> System.out.println("There is no such options...");
            }
        } while(continueLoop);
    }

    private boolean listMovies() {
        currentMovies.movies.forEach(Movie::listMovieInfo);
        int selection = inputManager.getIntWithDescription("Insert the id number of the movie, 0 if want to return back");
        if (selection == 0) {
            return true;
        } else {
            int ticketCount = inputManager.getIntWithDescription("How many ticket you want to buy");
            AtomicReference<Double> moviePrice = new AtomicReference<>(0.0);
            currentMovies.movies.forEach( movie -> {
                if (movie.id() == selection) {
                    moviePrice.set(movie.price());
                }
            });
            double totalCost = moviePrice.get() * ticketCount;
            System.out.println("borcunu ode pic: " + totalCost);
            return false;
        }
    }

}
