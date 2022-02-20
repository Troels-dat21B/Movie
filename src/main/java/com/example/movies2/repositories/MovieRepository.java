package com.example.movies2.repositories;

import com.example.movies2.models.Movie;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class MovieRepository {

    private ArrayList<Movie> movieList;
    Random random = new Random();

    public MovieRepository() { this.movieList = new ArrayList<>();

        try {
            File file = new ClassPathResource("imdb-data.csv").getFile();
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] stringArray = scanner.nextLine().split(";");

                boolean hasAward;
                hasAward = stringArray[5].equalsIgnoreCase("yes");


                this.movieList.add(new Movie(Integer.parseInt(stringArray[0]), Integer.parseInt(stringArray[1]),
                        stringArray[2], stringArray[3], Integer.parseInt(stringArray[4]), hasAward));
            }


        } catch (IOException e) {
            System.out.println("Noget gik galt:" + e);
        }

    }


    public ArrayList<Movie> findall() {

        return this.movieList;
    }

    public Movie getFirst() {

        return this.movieList.get(0);
    }

    public Movie getRandom() {

        return this.movieList.get(random.nextInt(movieList.size()));
    }

    public ArrayList<Movie> topTenPop() {
        ArrayList<Movie> popList = new ArrayList<>();

        while (popList.size() <= 10)
        popList.add(movieList.get(random.nextInt(movieList.size())));

        Collections.sort(popList);

        return popList;
    }

    public ArrayList<Movie> awardWinners(){
        ArrayList<Movie> awardWinners = new ArrayList<>();

        for (int i = 0; i < movieList.size(); i++) {
            if(movieList.get(i).isHasAward()){
                awardWinners.add(movieList.get(i));
            }
        }

        return awardWinners;
    }

}
