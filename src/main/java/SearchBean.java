import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import com.fasterxml.jackson.databind.ObjectMapper;

@ManagedBean(name = "searchBean")
public class SearchBean {

	private String title;

	private String year;
	
	private String titleUrl;

	private String yearUrl;
	
	private Movie movie = new Movie();
	private MovieRepository mr = new MovieRepository();
	public List<Movie> favouriteMovies = new LinkedList<>();
	
	public Movie searchMovie() {
		
		String urlApi = "http://www.omdbapi.com/?apikey=bf59f1a4&t=" + titleUrl + "&y=" + yearUrl +"?";
		try {
			URL url = new URL(urlApi);
			HttpURLConnection connection =(HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setDoOutput(true);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestProperty("Content-Type", "application/json");
			InputStream inputStream = connection.getInputStream();
			String jsonString = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
			inputStream.close();
			System.out.println(jsonString);
			
			ObjectMapper objectMapper = new ObjectMapper();
			
			movie = objectMapper.readValue(jsonString, Movie.class);
			return movie;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movie;
	}
	public void addMovie() {
			favouriteMovies.add(mr.searchMovie());
			for(Movie movie: favouriteMovies) {
				movie.Title = mr.getTitle();
			}
		
	}
	public String goToSearchPage() {
		return "search-movie?faces-redirect=true";
	}
	public String goToFavouriteMoviesPage() {
		return "favourite-movies?faces-redirect=true";
	}
	public String getTitle() {
		return title;
	}

	public String getYear() {
		return year;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	public Movie getMovie() {
		return movie;
	}
	
	public String getTitleUrl() {
		return titleUrl;
	}

	public void setTitleUrl(String titleUrl) {
		this.titleUrl = titleUrl;
	}

	public String getYearUrl() {
		return yearUrl;
	}

	public void setYearUrl(String yearUrl) {
		this.yearUrl = yearUrl;
	}

}
