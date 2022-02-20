package com.example.movies2.models;

public class Movie implements Comparable<Movie>{

    //Year;Length;Title;Subject;Popularity;Awards

    private int year;
    private int length;
    private String title;
    private String subject;
    private int popularity;
    private boolean hasAward;





    public Movie (int year, int length, String title, String subject, int popularity, boolean hasAward){

        this.year = year;
        this.length = length;
        this.title = title;
        this.subject = subject;
        this.popularity = popularity;
        this.hasAward = hasAward;


    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public int getPopularity() {
        return popularity;
    }

    public int getYear() {
        return year;
    }

    public String getSubject() {
        return subject;
    }

    public boolean isHasAward() {
        return hasAward;
    }

    @Override
    public int compareTo(Movie o) {
        return Integer.compare(this.popularity, o.getPopularity());
    }

    @Override
    public String toString() {
        return "Movie{" +
                "year=" + year +
                ", length=" + length +
                ", title='" + title + '\'' +
                ", subject='" + subject + '\'' +
                ", popularity=" + popularity +
                ", hasAward=" + hasAward +
                '}';
    }
}
