package com.example.Spring.boot.Movie.Workshop.models;

public class Movie implements Comparable {

  private String year;
  private String length;
  private String title;
  private String subject;
  private String popularity;
  private String awards;


  public Movie() {
  }

  public Movie(String year, String length, String title, String subject, String popularity, String awards) {
    this.year = year;
    this.length = length;
    this.title = title;
    this.subject =subject;
    this.popularity = popularity;
    this.awards = awards;
  }




  public String getLength() {
    return length;
  }

  public void setLength(String length) {
    this.length = length;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getPopularity() {
    return popularity;
  }

  public void setPopularity(String popularity) {
    this.popularity = popularity;
  }

  public String getAwards() {
    return awards;
  }

  public void setAwards(String awards) {
    this.awards = awards;
  }

  @Override
  public String toString() {
    return "Movie{\n" +
        "\tyear = '" + year + "\'\n" +
        "\tlength = '" + length + "\'\n" +
        "\ttitle = '" + title + "\'\n" +
        "\tsubject = '" + subject + "\'\n" +
        "\tpopularity = '" + popularity + "\'\n" +
        "\tawards = '" + awards + '\'' +
        "}\n";
  }

  @Override
  public int compareTo(Object o) {
    Movie movie = (Movie) o;
    return Integer.parseInt(this.popularity) - Integer.parseInt(movie.popularity);
  }
}
