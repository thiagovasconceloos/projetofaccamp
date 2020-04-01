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
import projeto.model.Vendas;
import projeto.model.Item;
import projeto.model.Produtos;
/**
 *
 * @author vasco
 */
public class ProdutosVendaDAO {
    
        private Connection con= null;

    
    public ProdutosVendaDAO(){
            
            
            this.con = new ConnectFactory().getConnection();
    
    
    }
    
    
 public void cadastrarItem(Item obj) {

        try {

            String sql = "INSERT INTO  tb_itensvendas (venda_id,produto_id,qtd,subtotal) values (?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, obj.getVenda().getId());
            stmt.setLong(2,obj.getProduto().getId());
            stmt.setInt(3, obj.getQtd());
            stmt.setDouble(4, obj.getSubtotal());
            stmt.execute();
            stmt.close();

          

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Item" + e);

        }

    }   
    
    
     public List<Item> listarItens(int venda) {
        try {

            //1 passo criar a lista
            List<Item> lista = new ArrayList<>();

            //2 passo - criar o sql , organizar e executar.
            String sql = "select i.id,p.descricao,i.qtd,p.preco,i.subtotal from tb_itensvendas as i inner join tb_produtos "
                    + "as p on (i.produto_id=p.id) where i.venda_id =? ";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1,venda);
          

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) { 
                
             Item obj = new Item();
             Produtos p = new Produtos();
             
             obj.setId(rs.getInt("i.id"));
             p.setDescricao(rs.getString("p.descricao"));
             obj.setQtd(rs.getInt("i.qtd"));
             p.setPreco(rs.getDouble("p.preco"));
              obj.setSubtotal(rs.getDouble("i.subtotal"));
             
             obj.setProduto(p);
             
               lista.add(obj);
            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro :" + erro);
            return null;
        }

    }
    
    
    
}
