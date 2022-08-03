import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import com.fasterxml.jackson.databind.ObjectMapper;

@ManagedBean(name = "movieRepository")
public class MovieRepository extends SearchBean {
	
	public List<Movie> listFavouriteMovie = new LinkedList<Movie>();
	
	
	public List<Movie> addFavouriteMovieList() {
			listFavouriteMovie.add(searchMovie());
			return listFavouriteMovie;
			
		
		
		
	}
	
	public List<Movie> getAllFavouriteForUser(List<Movie> movieList) {
		for(Movie movie:listFavouriteMovie)
		System.out.println(movie.Title);
		return listFavouriteMovie;
	}
}
