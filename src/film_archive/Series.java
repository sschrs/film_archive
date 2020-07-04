package film_archive;

import java.util.ArrayList;

public class Series extends Media {
    ArrayList<Episode> episode;
    Integer season;

    public Series(ArrayList<Episode> episode, Integer season, Integer id, String name, String description, String director, ArrayList<String> cast, ArrayList<String> writers, Integer year, String picture, String genre, Integer rate, Integer time) {
        super(id, name, description, director, cast, writers, year, picture, genre, rate, time, null);
        this.episode = episode;
        this.season = season;
    }

    public ArrayList<Episode> getEpisode() {
        return episode;
    }

    public void setEpisode(ArrayList<Episode> episode) {
        this.episode = episode;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    

    
    
    
}
