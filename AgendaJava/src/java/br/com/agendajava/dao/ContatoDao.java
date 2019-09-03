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
import java.sql.SQLException;
import java.util.ArrayList;

public class ContatoDao {

    PreparedStatement pst;//prepara a conexao com obanco
    ResultSet rs; //consulta no banco
    String sql;
    Connection conexao;

    public void salvar(ContatoModelo cont) { //pega tudo do class contatoModelo e salva no banco
        //insert into mais nome da tabela do banco
        sql = "INSERT INTO contato (id, nome,email,sexo,telefone,rua,complemento,numero,barrio,cidade,uf )values(null,?,?,?,?,?,?,?,?,?,?)";

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
            pst.setString(8, cont.getBarrio());
            pst.setString(9, cont.getCidade());
            pst.setString(10, cont.getUf());
            pst.execute();// aqui joga todos os dados no  banco
            FazConexao.getConexao().close();//fecha a conexao
            System.out.println("cadastrou");
        } catch (SQLException e) {
            System.out.println("nao cadastrou" + e);
        }
    }

    public ArrayList<ContatoModelo> busca() {
        sql = "select *from contato";
        ArrayList<ContatoModelo> lista = new ArrayList<>();

        try {
            conexao = FazConexao.getConexao();
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                ContatoModelo cont = new ContatoModelo();
                cont.setNome(rs.getString("nome"));
                cont.setEmail(rs.getString("email"));
                cont.setSexo(rs.getString("sexo"));
                cont.setTelefone(rs.getString("telefone"));
                cont.setRua(rs.getString("rua"));
                cont.setComplemento(rs.getString("complemento"));
                cont.setNumero(rs.getInt("numero"));
                cont.setBarrio(rs.getString("barrio"));
                cont.setCidade(rs.getString("cidade"));
                cont.setUf(rs.getString("Uf"));
                lista.add(cont);

            }
            FazConexao.getConexao().close();
            System.out.println("buscou lista");
            return lista;
        } catch (SQLException e) {
            System.err.println("erro na consulta da lista" + e);
            return null;
        }
    }
}
