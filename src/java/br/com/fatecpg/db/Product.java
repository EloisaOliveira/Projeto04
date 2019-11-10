package br.com.fatecpg.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author elois
 */
public class Product {
    private int id;
    private int idFabricante;
    private String codigo;
    private String disponibilidade;
    private String descricao;
    private double preco;
    
        public static ArrayList<Product> getList(int id) throws Exception{
        ArrayList<Product> list = new ArrayList();
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String url = "jdbc:derby://localhost:1527/sample";
        String user = "app";
        String password = "app";                
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "SELECT PRODUCT_ID, PRODUCT_CODE, PURCHASE_COST, AVAILABLE, DESCRIPTION, MANUFACTURER_ID FROM APP.PRODUCT WHERE MANUFACTURER_ID = ? ";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setObject(1,id);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            Product p = new Product(
            rs.getInt("PRODUCT_ID")
            , rs.getInt("MANUFACTURER_ID")
            , rs.getString("PRODUCT_CODE")
            , rs.getString("AVAILABLE")
            , rs.getString("DESCRIPTION")
            , rs.getDouble("PURCHASE_COST")        
            );
            list.add(p);
        }
        rs.close();stmt.close();con.close();
        return list;
    }

    public Product(int id, int idFabricante, String codigo, String disponibilidade, String descricao, double preco) {
        this.id = id;
        this.idFabricante = idFabricante;
        this.codigo = codigo;
        this.disponibilidade = disponibilidade;
        this.descricao = descricao;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFabricante() {
        return idFabricante;
    }

    public void setIdFabricante(int idFabricante) {
        this.idFabricante = idFabricante;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    
}
