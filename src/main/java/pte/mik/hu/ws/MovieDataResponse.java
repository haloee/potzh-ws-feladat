package pte.mik.hu.ws;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class MovieDataResponse {
    public MovieDataResponse(String id, Double rating) {
        this.id = id;
        this.map.put(id, rating);
    }
    private String id;
    private final Map<String,Double> map=new HashMap<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, Double> getMap() {
        return map;
    }

    public MovieDataResponse getMovieData(MovieDataRequest request)
    {
        return new MovieDataResponse(request.getMovieId(),this.map.computeIfAbsent(request.getMovieId(),movieId -> Math.round(ThreadLocalRandom.current().nextDouble(1,10)*10)/10.0 ));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MovieDataResponse that = (MovieDataResponse) o;
        return Objects.equals(id, that.id) && Objects.equals(map, that.map);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, map);
    }
}
