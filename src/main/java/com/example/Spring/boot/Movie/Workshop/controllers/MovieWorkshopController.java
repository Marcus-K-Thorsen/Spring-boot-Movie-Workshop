package com.example.Spring.boot.Movie.Workshop.controllers;

import com.example.Spring.boot.Movie.Workshop.models.Movie;
import com.example.Spring.boot.Movie.Workshop.repositories.MovieRepository;
import com.example.Spring.boot.Movie.Workshop.services.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieWorkshopController {

  private MovieService movieService;

  public MovieWorkshopController() {
    this.movieService = new MovieService();
  }

  public String makeTxtGreen(String txt) {
    String str
        = "<html><body><font color=\"green\">"
        + "<h1>" + txt + "</h1>"
        + "</font></body></html>";
    return str;
  }


  @GetMapping("/")
  public String home()
  {
    String str = makeTxtGreen("WELCOME To My Movie Workshop!");
    return str;
  }

  // ex2. get first movie

  @GetMapping("/getfirst")
  public String getFirst() {
    return makeTxtGreen(movieService.getFirst().toString());
  }

  // ex3. get random movie

  @GetMapping("/getrandom")
  public String getRandom() {
    Movie randomMovie = movieService.getRandom();
    return makeTxtGreen("This is af Random Movie:<br>" + movieService.printMovie(randomMovie));
  }

  // ex4. get ten sorted in ascending order by popularity

  @GetMapping("/gettensortbypopularity")
  public String getTenSortByPopularity () {
    ArrayList<Movie> tenMovies = movieService.getTenSortByPopularity();
    return makeTxtGreen(movieService.printMovies(tenMovies));
  }

  // ex5. get how many movies won an award

  @GetMapping("/howmanywonanaward")
  public String howManyWonAnAward () {
    String txt = "The amount of movies with an award is: " + movieService.howManyWonAnAward();
    return makeTxtGreen(txt);
  }

  // ex6. print movies filtered by amount a char occurs in their title

  @GetMapping("/filter")
  public String filterCharAmount (@RequestParam char x, int n) {
    ArrayList<Movie> filteredMovies = movieService.filteredCharAmount(x, n);
    return makeTxtGreen(movieService.printMovies(filteredMovies));

  }


}
