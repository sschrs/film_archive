
package film_archive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database{
    String url = "jdbc:sqlite:database.db";
    Connection con = null;
    Statement stmt;
    public Database() throws SQLException{
        con = DriverManager.getConnection(url);
        stmt = con.createStatement();
    }
    
    public Connection connect(){
        return con;
    }
    
    public void close(){
        try {
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    

    
    public void insertStar(String name) throws SQLException{
        PreparedStatement ps = con.prepareStatement("SELECT * FROM stars WHERE name = ?");
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        if (!rs.next()){
            PreparedStatement p = con.prepareStatement("INSERT INTO stars(name) VALUES (?)");
            p.setString(1, name);
            p.executeUpdate();
            System.out.println("Okey");
        }
        
    }
    public void insertDirector(String name) throws SQLException{
        PreparedStatement p = con.prepareStatement("SELECT * FROM directors WHERE name = ?");
        p.setString(1, name);
        ResultSet rs = p.executeQuery();
        if(!rs.next()){
            PreparedStatement ps = con.prepareStatement("INSERT INTO directors(name) VALUES (?)");
            ps.setString(1, name);
            ps.executeUpdate();
        }
    }
    public void insertWriter(String name) throws SQLException{
        PreparedStatement p = con.prepareStatement("SELECT * FROM writers WHERE name = ?");
        p.setString(1,name);
        ResultSet rs = p.executeQuery();
        if(!rs.next()){
            PreparedStatement ps = con.prepareStatement("INSERT INTO writers(name) VALUES (?)");
            ps.setString(1, name);
            ps.executeUpdate();
        }
    }
    
    public ArrayList<Film> selectFilm(String name,String director) throws Exception{
        try {
            ArrayList<Film> result = new ArrayList<>();
            PreparedStatement p = con.prepareStatement("SELECT * FROM films WHERE name = ? AND director = ?");
            p.setString(1, name);
            p.setString(2, director);
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                result.add(new Film(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("director"),
                        Helper.commaParse(rs.getString("cast")),
                        Helper.commaParse(rs.getString("writers")),
                        rs.getInt("year"),
                        rs.getString("picture"),
                        rs.getString("genre"),
                        rs.getInt("rate"),
                        rs.getInt("time"),
                        rs.getString("file")
                ));
            }
            return result;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }
    
    public ArrayList<Film> selectAllFilms(String query) throws Exception{
        try {
            ArrayList<Film> result = new ArrayList<>();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                result.add(new Film(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("director"),
                        Helper.commaParse(rs.getString("cast")),
                        Helper.commaParse(rs.getString("writers")),
                        rs.getInt("year"),
                        rs.getString("picture"),
                        rs.getString("genre"),
                        rs.getInt("rate"),
                        rs.getInt("time"),
                        rs.getString("file")
                ));
            }
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
    public ArrayList<Series> selectAllSeries() throws Exception{
        try {
            ArrayList<Series> result = new ArrayList<>();
            PreparedStatement pr = con.prepareStatement("SELECT * FROM series");
            ResultSet rs = pr.executeQuery();
            while(rs.next()){
                result.add(new Series(
                        selectEpisode(rs.getInt("id")),
                        rs.getInt("season"),
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("director"),
                        Helper.commaParse(rs.getString("cast")),
                        Helper.commaParse(rs.getString("writers")),
                        rs.getInt("year"),
                        rs.getString("picture"),
                        rs.getString("genre"),
                        rs.getInt("rate"),
                        rs.getInt("time")
                ));
            }
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
    
    public ArrayList<Series> selectSeries(String name,String director) throws Exception{
        try {
            ArrayList<Series> result = new ArrayList<>();
            PreparedStatement pr = con.prepareStatement("SELECT * FROM series WHERE name = ? AND director = ?");
            pr.setString(1, name);
            pr.setString(2, director);
            ResultSet rs = pr.executeQuery();
            while(rs.next()){
                result.add(new Series(
                        selectEpisode(rs.getInt("id")),
                        rs.getInt("season"),
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("director"),
                        Helper.commaParse(rs.getString("cast")),
                        Helper.commaParse(rs.getString("writers")),
                        rs.getInt("year"),
                        rs.getString("picture"),
                        rs.getString("genre"),
                        rs.getInt("rate"),
                        rs.getInt("time")
                ));
            }
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
    public ArrayList<Episode> selectEpisode(Integer idSeries){
        ArrayList<Episode> result = new ArrayList<>();
        String query = "SELECT * FROM episode WHERE seriesId = " + idSeries + " ORDER BY season";
        try {
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                result.add(new Episode(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("season"),
                        rs.getString("date"),
                        rs.getInt("time"),
                        rs.getInt("rate"),
                        rs.getInt("seriesId"),
                        rs.getString("file")
                ));
            }
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public ArrayList<Episode> selectAllEpisodes(){
        ArrayList<Episode> result = new ArrayList<>();
        String query = "SELECT * FROM episode";
        try {
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                result.add(new Episode(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("season"),
                        rs.getString("date"),
                        rs.getInt("time"),
                        rs.getInt("rate"),
                        rs.getInt("seriesId"),
                        rs.getString("file")
                ));
            }
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public Integer getTotalTime() throws SQLException{
        Integer total = 0;
        ResultSet rs = stmt.executeQuery("SELECT time FROM episode");
        while(rs.next()){
            total += rs.getInt("time");
        }
        ResultSet r = stmt.executeQuery("SELECT time FROM films");
        while(r.next()){
            total += rs.getInt("time");
        }
        return total;
    }
    
    public String getEpisodeFilePath(Integer id,String name) throws SQLException{
        PreparedStatement ps = con.prepareStatement("SELECT * FROM episode WHERE seriesId = ? AND name = ?");
        ps.setInt(1, id);
        ps.setString(2, name);
        ResultSet rs = ps.executeQuery();
        return rs.getString("file");
    }
    
    public void insertEpisode(Episode episode) throws SQLException{
        String sql = "INSERT INTO episode(name,date,time,season,rate,seriesId,file) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement pep = con.prepareStatement(sql);
        pep.setString(1, episode.getName());
        pep.setString(2, episode.getDate());
        pep.setInt(3, episode.getTime());
        pep.setInt(4, episode.getSeason());
        pep.setInt(5, episode.getRate());
        pep.setInt(6, episode.getSeriesId());
        pep.setString(7, episode.getFile());
        pep.executeUpdate();
    }
    
    public void deleteEpisodes(Integer id) throws SQLException{
        PreparedStatement p = con.prepareStatement("DELETE FROM episode WHERE seriesId = ?");
        p.setInt(1, id);
        p.executeUpdate();
    }
    
    public void initDb() throws SQLException{
        String query_series = "CREATE TABLE IF NOT EXISTS \"series\" (\n" +
"	\"id\"	INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
"	\"name\"	TEXT,\n" +
"	\"description\"	TEXT,\n" +
"	\"director\"	TEXT,\n" +
"	\"cast\"	TEXT,\n" +
"	\"writers\"	TEXT,\n" +
"	\"year\"	INTEGER,\n" +
"	\"picture\"	TEXT,\n" +
"	\"genre\"	TEXT,\n" +
"	\"rate\"	INTEGER,\n" +
"	\"time\"	INTEGER,\n" +
"	\"season\"	INTEGER\n" +
");";
        String query_films = "CREATE TABLE IF NOT EXISTS \"films\" (\n" +
"	\"id\"	INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
"	\"name\"	TEXT,\n" +
"	\"description\"	TEXT,\n" +
"	\"director\"	TEXT,\n" +
"	\"cast\"	TEXT,\n" +
"	\"writers\"	TEXT,\n" +
"	\"year\"	INTEGER,\n" +
"	\"picture\"	TEXT,\n" +
"	\"genre\"	TEXT,\n" +
"	\"rate\"	INTEGER,\n" +
"	\"time\"	INTEGER,\n" +
"	\"file\"	TEXT\n" +
");";
        
        String query_episode = "CREATE TABLE IF NOT EXISTS \"episode\" (\n" +
"	\"id\"	INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
"	\"name\"	TEXT,\n" +
"	\"date\"	TEXT,\n" +
"	\"season\"	INTEGER,\n" +                
"	\"time\"	INTEGER,\n" +
"	\"rate\"	INTEGER,\n" +
"	\"seriesId\"	INTEGER,\n" +
"	\"file\"	TEXT\n" +                
");";
        String[] queries = {query_films,query_series,query_episode};
        for (String q : queries){
            stmt.execute(q);
        }
        System.out.println("Database Initialized");
    }
}
