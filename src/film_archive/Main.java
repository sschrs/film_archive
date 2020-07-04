
package film_archive;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) throws SQLException, Exception {
       Database db = new Database();
       db.initDb();
       FilmArchive window = new FilmArchive();
       window.setLocation(100, 100);
       window.setVisible(true);    
       
       
    }
}
