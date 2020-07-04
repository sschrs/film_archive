
package film_archive;

import java.util.Date;

public class Episode {
    Integer id;
    String name;
    Integer season;
    String date;
    Integer time;
    Integer rate;
    Integer seriesId;
    String file;

    public Episode(Integer id, String name, Integer season, String date, Integer time, Integer rate, Integer seriesId, String file) {
        this.id = id;
        this.name = name;
        this.season = season;
        this.date = date;
        this.time = time;
        this.rate = rate;
        this.seriesId = seriesId;
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

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Integer getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Integer seriesId) {
        this.seriesId = seriesId;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

   
    
}
