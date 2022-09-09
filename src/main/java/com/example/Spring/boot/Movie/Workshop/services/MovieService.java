package com.example.Spring.boot.Movie.Workshop.services;

import com.example.Spring.boot.Movie.Workshop.models.Movie;
import com.example.Spring.boot.Movie.Workshop.repositories.MovieRepository;

import java.util.ArrayList;

public class MovieService {

  private MovieRepository moviesrepo;

  public MovieService() {
    this.moviesrepo = new MovieRepository();
  }

  public String printMovies() {
    return printMovies(moviesrepo.getMovies());
  }

  public String printMovies(ArrayList<Movie> movies) {
    StringBuilder moviesAsTxt = new StringBuilder();
    int movieNumber = 0;
    for (Movie movie: movies) {
      String movieAsTxt = printMovie(movie);
      movieNumber++;
      moviesAsTxt.append("<br>").append(movieNumber).append(". Movie:<br>").append(movieAsTxt);

    }
    return moviesAsTxt.toString();
  }

  public String printMovie(Movie movie) {
    return "   Year = " + movie.getYear() + " - Length = " + movie.getLength() + " - Title = " + movie.getTitle()
                        + "<br>   Subject = " + movie.getSubject() + " - Popularity = " + movie.getPopularity() + " - Awards = " + movie.getAwards();
  }

  public Movie getFirst() {
    return moviesrepo.getOne(0);
  }

  public Movie getRandom() {
    return moviesrepo.getOne();
  }

  public ArrayList<Movie> getTenSortByPopularity() {
    return moviesrepo.getTenSortByPopularity();
  }

  public int howManyWonAnAward () {
    return moviesrepo.howManyMoviesWonAnAward();
  }

  public ArrayList<Movie> filteredCharAmount (char x, int n) {
    return moviesrepo.filterCharAmount(x, n);
  }

}
