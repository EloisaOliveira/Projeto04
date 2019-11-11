/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecpg.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Cliente
 */
public class Compras {
    
    private int idCliente;
    private int idProduto;
    private int quantidade;
    private String frete;
    private double preco;
    
        public static ArrayList<Compras> getList(int id) throws Exception{
        ArrayList<Compras> list = new ArrayList();
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String url = "jdbc:derby://localhost:1527/sample";
        String user = "app";
        String password = "app";                
        Connection con = DriverManager.getConnection(url, user, password);
        String sql = "SELECT CUSTOMER_ID, PRODUCT_ID, QUANTITY, SHIPPING_COST, SALES_DATE, FREIGHT_COMPANY FROM APP.PURCHASE_ORDER WHERE CUSTOMER_ID = ? ";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setObject(1,id);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            Compras c = new Compras(
            rs.getInt("CUSTOMER_ID")
            , rs.getInt("PRODUCT_ID")
            , rs.getInt("QUANTITY")
            , rs.getDouble("SHIPPING_COST")
           , rs.getString("FREIGHT_COMPANY")
             
                    
            );
            list.add(c);
        }
        rs.close();stmt.close();con.close();
        return list;
    }

    public Compras(int idCliente, int idProduto, int quantidade, double preco, String frete) {
        this.idCliente = idCliente;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.preco = preco;
        this.frete = frete;
        
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getFrete() {
        return frete;
    }

    public void setFrete(String frete) {
        this.frete = frete;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

        
    
    
}
