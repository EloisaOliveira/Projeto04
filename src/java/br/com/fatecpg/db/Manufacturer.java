
package br.com.fatecpg.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Manufacturer {
    private int id;
    private String name;
    private String email;
    private String cidade;
    private String estado;
    
        public static ArrayList<Manufacturer> getList() throws Exception{
        ArrayList<Manufacturer> list = new ArrayList();
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String url = "jdbc:derby://localhost:1527/sample";
        String user = "app";
        String password = "app";
        Connection con = DriverManager.getConnection(url, user, password);
        Statement stmt = con.createStatement();
        String sql = "SELECT MANUFACTURER_ID, NAME, EMAIL, CITY, STATE FROM APP.MANUFACTURER";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            Manufacturer m = new Manufacturer(
            rs.getInt("MANUFACTURER_ID")
            , rs.getString("NAME")
            , rs.getString("EMAIL")
            , rs.getString("CITY")
            , rs.getString("STATE")
            );
            list.add(m);
        }
        rs.close();stmt.close();con.close();
        return list;
    }
    
    public Manufacturer(int id, String name, String email, String cidade, String estado) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cidade = cidade;
        this.estado = estado;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
