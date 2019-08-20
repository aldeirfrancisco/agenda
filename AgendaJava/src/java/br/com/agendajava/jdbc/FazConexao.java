/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agendajava.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;


public class FazConexao {
    public Connection conexao;
    
    public  Connection getConexao(){ //metodo que vai ser chamado em outra class
    
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");// drive de conexao
          //a variavel vai receber o caminho do banco
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/agendajava?useTimezone=true&serverTimezone=UTC","root","");
            System.out.println("estar conectado");
        } catch (Exception e) {
            System.err.println("erro na conexao"  +e);
        }
    return conexao;
    }
    public static void main(String[] a){ //testando para ver si ta conectado
        FazConexao con = new FazConexao();
        con.getConexao();
    
    }
    
       
}