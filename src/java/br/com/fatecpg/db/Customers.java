
package br.com.fatecpg.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author elois
 */
public class Customers {
    private int id;
    private String name;
    private String email;
    
    public static ArrayList<Customers> getList() throws Exception{
        ArrayList<Customers> list = new ArrayList();
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String url = "jdbc:derby://localhost:1527/sample";
        String user = "app";
        String password = "app";
        Connection con = DriverManager.getConnection(url, user, password);
        Statement stmt = con.createStatement();
        String sql = "SELECT CUSTOMER_ID, NAME, EMAIL FROM APP.CUSTOMER";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            Customers c = new Customers(
            rs.getInt("CUSTOMER_ID")
            , rs.getString("NAME")
            , rs.getString("EMAIL")
            );
            list.add(c);
        }
        rs.close();stmt.close();con.close();
        return list;
    }

    public Customers(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
