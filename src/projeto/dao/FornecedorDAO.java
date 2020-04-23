/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import projeto.jdbc.ConnectFactory;
import projeto.model.Fornecedores;
import projeto.model.WebServiceCep;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author vasco
 */
public class FornecedorDAO {

    private Connection con= null;
   
    
    public void LimpaTela(JPanel container){
        
        Component components[]= container.getComponents();
        for(Component component: components){
            
            if(component instanceof JTextField){
                
                ((JTextField)component).setText(null);
            }
            
        } }
    

    public FornecedorDAO() {
        
        this.con = new ConnectFactory().getConnection();
    }

    public List<Fornecedores> listarFornecedores() {

        try {

        
            //1 passo criar a lista
            List<Fornecedores> lista = new ArrayList<>();

            //2 passo - criar o sql , organizar e executar.
            String sql = "select * from tb_fornecedores";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Fornecedores obj = new Fornecedores();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));             
                obj.setCnpj(rs.getString("cnpj"));
                obj.setUser(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                lista.add(obj);
            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro :" + erro);
            return null;
        }

    }


    public void cadastrarFornecedor(Fornecedores obj) {

        try {

            String sql = "INSERT INTO  tb_fornecedores (nome,cnpj,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)\n"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCnpj());
            stmt.setString(3, obj.getUser());
            stmt.setString(4, obj.getTelefone());
            stmt.setString(5, obj.getCelular());
            stmt.setString(6, obj.getCep());
            stmt.setString(7, obj.getEndereco());
            stmt.setInt(8, obj.getNumero());
            stmt.setString(9, obj.getComplemento());
            stmt.setString(10, obj.getBairro());
            stmt.setString(11, obj.getCidade());
            stmt.setString(12, obj.getUf());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Fornecedor Cadastrado");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Erro ao cadastrar fornecedor" + e);

        }

    }

    public void alterarFonecedor(Fornecedores obj) {
             
             
             
              
         
        try {    String sql = "update tb_fornecedores set nome = ?,cnpj = ?,email =?,telefone=?,celular=?,cep=?,endereco=?,numero=?,complemento=?,bairro=?,cidade=?,estado=?"
                    + "where id = ? ";

        
            PreparedStatement stmt = con.prepareStatement(sql);
           

            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCnpj());
            stmt.setString(3, obj.getUser());
            stmt.setString(4, obj.getTelefone());
            stmt.setString(5, obj.getCelular());
            stmt.setString(6, obj.getCep());
            stmt.setString(7, obj.getEndereco());
            stmt.setInt(8, obj.getNumero());
            stmt.setString(9, obj.getComplemento());
            stmt.setString(10, obj.getBairro());
            stmt.setString(11, obj.getCidade());
            stmt.setString(12, obj.getUf());
            stmt.setInt(13, obj.getId());
            stmt.executeUpdate();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Alteração efetuada");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Erro ao alterar dados do  Fornecedor" + e);

        }

    }

    public void excluirFornecedor(Fornecedores obj) {

        try {

            String sql = "DELETE FROM tb_fornecedores where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Erro ao excluir" + e);

        }

    }

    public List<Fornecedores> buscarFornecedores(String cnpj) {

        try {

            //1 passo criar a lista
            List<Fornecedores> lista = new ArrayList<>();

            //2 passo - criar o sql , organizar e executar.
            String sql = "select * from tb_fornecedores where cnpj like?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cnpj);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Fornecedores obj = new Fornecedores();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setUser(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                lista.add(obj);
            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro :" + erro);
            return null;
        }

    }

    public Fornecedores consultarporCNPJ(String cnpj) {

        try {
            String sql = "select * from tb_fornecedores where cnpj = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cnpj);
            ResultSet rs = stmt.executeQuery();
            Fornecedores obj = new Fornecedores();
            if (rs.next()) {

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setUser(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

            }

            return obj;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Fornecedor  não encontrado.");

            return null;
        }

    }

    public Fornecedores buscaCep(String cep) {

        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);

        Fornecedores obj = new Fornecedores();

        if (webServiceCep.wasSuccessful()) {
            obj.setEndereco(webServiceCep.getLogradouroFull());
            obj.setCidade(webServiceCep.getCidade());
            obj.setBairro(webServiceCep.getBairro());
            obj.setUf(webServiceCep.getUf());
            return obj;
        } else {
            JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());
            JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
            return null;
        }

    }
}
