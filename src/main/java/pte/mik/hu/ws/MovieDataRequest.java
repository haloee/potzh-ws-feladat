package pte.mik.hu.ws;
import java.util.Objects;
public class MovieDataRequest {
    private String movieId;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MovieDataRequest that = (MovieDataRequest) o;
        return Objects.equals(movieId, that.movieId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(movieId);
    }

    public MovieDataRequest() {}
    public String getMovieId() {return this.movieId;}
    public void setMovieId(String movieId) {this.movieId = movieId;}
}
