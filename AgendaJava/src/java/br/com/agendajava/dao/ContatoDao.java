/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agendajava.dao;

//aqui que vai ter contato direto com o banco(vai buscar e colocar dado dentro do banco)


import br.com.agendajava.jdbc.FazConexao;
import br.com.agendajava.modelo.ContatoModelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ContatoDao {
    PreparedStatement pst;//prepara a conexao com obanco
    ResultSet  rs; //consulta no banco
    String sql;
    Connection conexao;
    
    public void salvar(ContatoModelo cont){ //pega tudo do class contatoModelo e salva no banco
        //insert into mais nome da tabela do banco
    sql = "INSERT INTO contato (nome,email,sexo,telefone,rua,complemento,numero,bairro,cidade,uf ) values(?,?,?,?,?,?,?,?,?,?)";
    
        try {
            //declarei uma variavel para receber a conexao com o banco
            Connection conectar = FazConexao.getConexao();
            //peguei a variavel this.pst para receber o conectar que recebeu a conexao com o banoc
            pst = conectar.prepareStatement(sql);
            // o pst pega os dados do contatomodelo 
            pst.setString(1, cont.getNome());
             pst.setString(2, cont.getEmail());
             pst.setString(3, cont.getSexo());
              pst.setString(4, cont.getTelefone());
               pst.setString(5, cont.getRua());
                pst.setString(6, cont.getCidade());
                pst.setInt(7, cont.getNumero());
                 pst.setString(8, cont.getBairro());
                  pst.setString(9, cont.getCidade());
                   pst.setString(10, cont.getUf());
                           pst.execute();// aqui joga todos os dados no  banco
                    FazConexao.getConexao().close();//fecha a conexao
                System.out.println("cadastrou");
        } catch (Exception e) {
            System.out.println("nao cadastrou" + e);
        }
    }
}
