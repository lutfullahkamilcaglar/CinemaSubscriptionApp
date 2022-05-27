package Records.Movie;

public record Movie(int id, String name, Double price, Double imdbRate) {

    public void listMovieInfo() {
        String info = String.format("""
                %s:
                id: %d
                price: %.2f
                imdb rate: %.1f
                """, this.name, this.id, this.price, this.imdbRate);
        System.out.println(info);
    }
}
