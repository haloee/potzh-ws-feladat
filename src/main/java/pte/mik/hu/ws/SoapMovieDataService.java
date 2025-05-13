package pte.mik.hu.ws;
import jakarta.jws.WebService;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@WebService(
        endpointInterface = "pte.mik.hu.ws.MovieDataService",
        serviceName = "MovieDataService",
        targetNamespace = "http://ws.pte.mik.hu"
)
public class SoapMovieDataService implements MovieDataService {
    private final Map<String, Double> map = new HashMap();
    public SoapMovieDataService() {
    }
    public MovieDataResponse getMovieData(MovieDataRequest request) {
        return new MovieDataResponse(request.getMovieId(), this.map.computeIfAbsent(request.getMovieId(), (MovieId) -> ThreadLocalRandom.current().nextDouble(0.0, 100.0)));
    }
}
