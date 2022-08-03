import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {
	public String Title;
	public String year;
	public String Plot;
	
	public String Genre;
	
	public String Director;
	
	public String Poster;
	
	public boolean favouriteMovie;
	

	public boolean isFavouriteMovie() {
		return favouriteMovie;
	}

	public void setFavouriteMovie(boolean favouriteMovie) {
		this.favouriteMovie = true;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		this.Title = title;
	}

	public String getPlot() {
		return Plot;
	}

	public void setPlot(String plot) {
		this.Plot = plot;
	}

	public String getGenre() {
		return Genre;
	}

	public void setGenre(String genre) {
		this.Genre = genre;
	}

	public String getDirector() {
		return Director;
	}

	public void setDirector(String director) {
		this.Director = director;
	}

	public String getPoster() {
		return Poster;
	}

	public void setPoster(String poster) {
		this.Poster = poster;
	}
	
	
	
	
}
