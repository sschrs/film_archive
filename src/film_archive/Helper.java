
package film_archive;

import java.util.ArrayList;
import java.util.Arrays;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Helper {
    Database db;
    
    public Helper() throws SQLException{
        
    }
    
    public static ArrayList<String> commaParse(String str) throws Exception{
        ArrayList<String> result = new ArrayList();
        result.addAll(Arrays.asList(str.split(",")));
        return result;
    }
   
    
}
