package com.example.Spring.boot.Movie.Workshop.repositories;

import com.example.Spring.boot.Movie.Workshop.models.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MovieRepository {

  private List<Movie> movies;

  public MovieRepository() {
    this.movies = new ArrayList<>();
    generateMoviesList();
  }

  private void generateMoviesList() {
    // Læs fra csv file og tilføj hver Movie til Listen
    try {
      Scanner input = new Scanner(new File("resources/movies.csv"));
      input.useDelimiter(";");

      while (input.hasNext()) {

        Movie movie = generateOneMovie(input.nextLine());
        movies.add(movie);
      }

    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  private Movie generateOneMovie(String aMovie) {
    Scanner scanLine = new Scanner(aMovie);
    scanLine.useDelimiter(";");

    String year = scanLine.next();
    String length = scanLine.next();
    String title = scanLine.next();
    String subject = scanLine.next();
    String popularity = scanLine.next();
    String awards = scanLine.next();

    Movie movie = new Movie(year, length, title, subject, popularity, awards);
    return movie;
  }

  public Movie getOne() {
    int amountOfMovies = movies.size();
    Random ran = new Random();
    int randomIndex = ran.nextInt(amountOfMovies);
    if (randomIndex >= 0 && randomIndex < amountOfMovies) {
      return getOne(randomIndex);
    }
    return getOne(0);
  }

  public Movie getOne(int index) {
    return movies.get(index);
  }


  public ArrayList<Movie> getTenSortByPopularity() {
    ArrayList<Movie> sortedMovies = new ArrayList<>();
    int movieAmount = 10;
    Collections.sort(movies);
    for (int i = 0; i < movieAmount; i++) {
      sortedMovies.add(movies.get(i));
    }
    return sortedMovies;
  }

  public int howManyMoviesWonAnAward() {
    int amountOfMoviesWithAnAward = 0;
    for (Movie movie: movies) {
      if (movie.getAwards().equalsIgnoreCase("yes")) {
        amountOfMoviesWithAnAward++;
      }
    }
    return amountOfMoviesWithAnAward;
  }

  public ArrayList<Movie> filterCharAmount(char x, int n) {
    ArrayList<Movie> filteredMovies = new ArrayList<>();
    for (Movie movie: movies) {
      int charAmount = 0;
      String movieTitle = movie.getTitle();
      for (int i = 0; i < movieTitle.length(); i++) {
        char titleChar = movieTitle.charAt(i);
        if (titleChar == x) {
          charAmount++;
        }
      }
      if (charAmount == n) {
        filteredMovies.add(movie);
      }
    }
    return filteredMovies;
  }

  public ArrayList<Movie> getMovies() {
    return (ArrayList<Movie>) this.movies;
  }


}
