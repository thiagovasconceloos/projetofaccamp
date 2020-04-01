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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import projeto.jdbc.ConnectFactory;
import projeto.model.Fornecedores;
import projeto.model.Produtos;
import projeto.model.Vendas;


/**
 *
 * @author vasco
 */
public class VendasDAO {

    private Connection con = null;

    public VendasDAO() {

        this.con = new ConnectFactory().getConnection();
    }

    public void efetuarVenda(Vendas obj) {

        try {

            String sql = "INSERT INTO  tb_vendas (data_venda,total_venda,fun) values (?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, obj.getData_venda());
            stmt.setDouble(2, obj.getTotal_venda());
            stmt.setString(3, obj.getFun());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Cliente" + e);

        }

    }

    public int ultimaVenda() {

        try {

            int idvenda = 0;
            String sql = "select max(id) id from tb_vendas";
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {

                Vendas ved = new Vendas();

                ved.setId(rs.getInt("id"));
                idvenda = ved.getId();

            }

            return idvenda;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Vendas> listarVendas(LocalDate di, LocalDate df) {
        try {

            //1 passo criar a lista
            List<Vendas> lista = new ArrayList<>();

            //2 passo - criar o sql , organizar e executar.
            String sql = "select id, date_format(data_venda,'%d/%m/%Y') as data_formatada,total_venda,fun from  tb_vendas where data_venda BETWEEN ? AND ?";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, di.toString());
            stmt.setString(2, df.toString());

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Vendas obj = new Vendas();

                obj.setId(rs.getInt("id"));
                obj.setData_venda(rs.getString("data_formatada"));
                obj.setTotal_venda(rs.getDouble("total_venda"));
                obj.setFun(rs.getString("fun"));

                lista.add(obj);
            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro :" + erro);
            return null;
        }

    }

    public double listarVendas() {

        try {

           double qntd=0;

            String sql = "SELECT id, COUNT(id) "
                    + "from tb_vendas ";

            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
              
                qntd = rs.getDouble("count(id)");
                
                

              
            }

            return qntd;
        } catch (SQLException erro) {
            
            throw new RuntimeException(erro);

        
            
        }

    } 


public double listarVendasHoje() {

        try {

           double qntd=0;

            String sql = "SELECT id, COUNT(id) "
                    + "from tb_vendas  where data_venda = CURRENT_DATE";

            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
              
                qntd = rs.getDouble("count(id)");
                
                

              
            }

            return qntd;
        } catch (SQLException erro) {
            
            throw new RuntimeException(erro);

        
            
        }

    } 


   public double listarSomarValorAtual() {

        try {

           double qntd=0;

            String sql = "SELECT id, sum(total_venda) "
                    + "from tb_vendas  where data_venda = CURRENT_DATE";

            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
              
                qntd = rs.getDouble("sum(total_venda)");
                
                

              
            }

            return qntd;
        } catch (SQLException erro) {
            
            throw new RuntimeException(erro);

        
            
        }

    } 

 public double somarVendas() {

        try {

           double qntd=0;

            String sql = "SELECT id, sum(total_venda) "
                    + "from tb_vendas ";

            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
              
                qntd = rs.getDouble("sum(total_venda)");
                
                

              
            }

            return qntd;
        } catch (SQLException erro) {
            
            throw new RuntimeException(erro);

        
            
        }

    } } 