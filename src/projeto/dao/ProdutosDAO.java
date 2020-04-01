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
import projeto.model.Produtos;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author vasco
 */
public class ProdutosDAO {
    private Connection conn;
    
    
    
    
     public ProdutosDAO(){ 
        this.conn = new ConnectFactory().getConnection();
     }
     
     
     public void LimpaTela(JPanel container){
        
        Component components[]= container.getComponents();
        for(Component component: components){
            
            if(component instanceof JTextField){
                
                ((JTextField)component).setText(null);
            }
            
        } }
     
      public void cadastraProduto(Produtos obj){
        
        try {
            
            String sql = "INSERT INTO  tb_produtos (descricao,preco,qtd_estoque,for_id,codigobarras,estoquemin) "
                    + "values (?,?,?,?,?,?)";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1,obj.getDescricao());
            stmt.setDouble(2,obj.getPreco());
            stmt.setInt(3,obj.getQntd());
            stmt.setInt(4,obj.getFornecedor().getId());
            stmt.setLong(5,obj.getCodigobarras());
            stmt.setInt(6,obj.getEstoquemin());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cadastro efetuado");
            
            
            
            
            
            
        } catch (SQLException e) {
            
            
             
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto"+e);
            
        }
     
     
    
}


public List<Produtos> listarProdutos() {

        try {


          
            List<Produtos> lista = new ArrayList<>();

            
            String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome, p.codigobarras,p.estoquemin from tb_produtos as p "
                    + "inner join tb_fornecedores as f on (p.for_id = f.id)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Produtos obj = new Produtos();
                Fornecedores f = new Fornecedores();
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQntd(rs.getInt("p.qtd_estoque"));

                f.setNome(rs.getString(("f.nome")));
                obj.setCodigobarras(rs.getLong("p.codigobarras"));
                                obj.setEstoquemin(rs.getInt("p.estoquemin"));

              

                obj.setFornecedor(f);

                lista.add(obj);
            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro :" + erro);
            return null;
        }

    }  
 


 public void excluirProduto(Produtos obj){
        
        
        
         try {
            
            String sql = "DELETE FROM tb_produtos WHERE id=? ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setLong(1,obj.getId());
            
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
            
            
            
            
            
            
        } catch (SQLException e) {
            
            
             
            JOptionPane.showMessageDialog(null, "Erro ao excluir produto."+e);
            
        }
        
        
        
        
        
        
        
    }
 
  public void alterarProduto(Produtos obj){
          
           
        
        
         
         
         
         try {
            
          String sql = "update tb_produtos set descricao = ?,preco = ?, qtd_estoque =?,for_id =?, codigobarras =?, estoquemin =? where id = ? ";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getPreco());
            stmt.setInt(3, obj.getQntd());
            stmt.setInt(4, obj.getFornecedor().getId());
            stmt.setLong(5,obj.getCodigobarras());
            stmt.setInt(6,obj.getEstoquemin());
            stmt.setLong(7, obj.getId());
            //3 passo - executar o comando sql
            stmt.executeUpdate();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        




} }    public List<Produtos> listarProdutosPorNome(String nome) {
        try {

            //1 passo criar a lista
            List<Produtos> lista = new ArrayList<>();

            //2 passo - criar o sql , organizar e executar.
            String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome, p.codigobarras from tb_produtos as p "
                    + "inner join tb_fornecedores as f on (p.for_id = f.id) where p.descricao like ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Produtos obj = new Produtos();
                Fornecedores f = new Fornecedores();
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQntd(rs.getInt("p.qtd_estoque"));
                f.setNome(rs.getString(("f.nome")));
                obj.setCodigobarras(rs.getLong("p.codigobarras"));
                obj.setFornecedor(f);

                lista.add(obj);
            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro :" + erro);
            return null;
        }

    }

    //metodo consultaProduto por Nome
    public Produtos consultaPorNome(String nome) {
        try {
            //1 passo - criar o sql , organizar e executar.

            String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome ,p.codigobarras, p.estoquemin from tb_produtos as p "
                    + "inner join tb_fornecedores as f on (p.for_id = f.id) where p.descricao =  ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();
            Produtos obj = new Produtos();
            Fornecedores f = new Fornecedores();

            if (rs.next()) {

                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQntd(rs.getInt("p.qtd_estoque"));

                f.setNome(rs.getString(("f.nome")));
                obj.setCodigobarras(rs.getLong("p.codigobarras"));
                obj.setEstoquemin(rs.getInt("p.estoquemin"));

                obj.setFornecedor(f);
            }

            return obj;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado!");
            return null;
        }
    }


public Produtos consultaProduto(Long codigo) {
        try {
            //1 passo - criar o sql , organizar e executar.

            String sql = "select * from tb_produtos where id=? or codigobarras=? ";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, codigo);
            stmt.setLong(2, codigo);

            ResultSet rs = stmt.executeQuery();
            Produtos obj = new Produtos();

            if (rs.next()) {

                obj.setId(rs.getInt("id"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setPreco(rs.getDouble("preco"));
                obj.setQntd(rs.getInt("qtd_estoque"));
                obj.setCodigobarras(rs.getLong("codigobarras"));
                

            
            }

            return obj;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado!"+e);
            return null;
        }
    }


  public void diminuirEstoque(int id ,int qtd){
            
               try {
            
              String sql = "update tb_produtos set  qtd_estoque=?  where id =?";

            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, qtd);
            stmt.setInt(2, id);

            stmt.executeUpdate();
            stmt.close();

          

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        




} 
      
      
      
  } 
  
   public int estoqueAtual(int id){
      try { 
          
          int qtd_estoque = 0 ;
        String sql = "SELECT qtd_estoque from tb_produtos  where id =?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        
        ResultSet rs = stmt.executeQuery();
        if(rs.next()){
            
            Produtos pro =  new Produtos();
            qtd_estoque = (rs.getInt("qtd_estoque"));
            
            
            
        }
        
        
         return qtd_estoque;
        
        
   }catch (SQLException erro) {
           
        throw new RuntimeException(erro);
       
       
      

        




} 
                
      
      
      



}     
   
  
                
      
      
      



 
    
   
    public List<Produtos> listarProdutosCodigo(Long codigo) {
        try {

            //1 passo criar a lista
            List<Produtos> lista = new ArrayList<>();

            //2 passo - criar o sql , organizar e executar.
            String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome, p.codigobarras, p.estoquemin from tb_produtos as p "
                    + "inner join tb_fornecedores as f on (p.for_id = f.id) where p.id=? or p.codigobarras=? ";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, codigo);
            stmt.setLong(2, codigo);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Produtos obj = new Produtos();
                Fornecedores f = new Fornecedores();
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQntd(rs.getInt("p.qtd_estoque"));
                f.setNome(rs.getString(("f.nome")));
                obj.setCodigobarras(rs.getLong("p.codigobarras"));
                obj.setEstoquemin(rs.getInt("p.estoquemin"));
                obj.setFornecedor(f);

                lista.add(obj);
            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro :" + erro);
            return null;
        }

    }
   
   
   
 
} 