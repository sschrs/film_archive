
package film_archive;

import java.util.ArrayList;

public class Media {
    private Integer id;
    private String name;
    private String description;
    private String director;
    private ArrayList<String> cast;
    private ArrayList<String> writers;
    private Integer year;
    private String picture;
    private String genre;
    private Integer rate;
    private Integer time;
    private String file;

    public Media(Integer id, String name, String description, String director, ArrayList<String> cast, ArrayList<String> writers, Integer year, String picture, String genre, Integer rate, Integer time, String file) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.director = director;
        this.cast = cast;
        this.writers = writers;
        this.year = year;
        this.picture = picture;
        this.genre = genre;
        this.rate = rate;
        this.time = time;
        this.file = file;
    }

    

    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public ArrayList<String> getCast() {
        return cast;
    }

    public void setCast(ArrayList<String> cast) {
        this.cast = cast;
    }

    public ArrayList<String> getWriters() {
        return writers;
    }

    public void setWriters(ArrayList<String> writers) {
        this.writers = writers;
    }

   
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

   

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
    
    
}
