/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.MenuElement;
import javax.swing.plaf.basic.BasicMenuBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import projeto.dao.FuncionarioDAO;
import projeto.dao.ProdutosDAO;
import projeto.dao.ProdutosVendaDAO;
import projeto.dao.VendasDAO;
import projeto.jdbc.ConnectFactory;
import projeto.model.Funcionarios;
import projeto.model.Item;
import projeto.model.Produtos;
import projeto.model.SessaoUsuario;
import projeto.model.Vendas;

/**
 *
 * @author vasco
 */
public class frmPVD extends javax.swing.JFrame {

    public String usuario;
    public String cargo;
    int quantidade = 1;
    Connection conect= null;

    Produtos obj = new Produtos();
    ProdutosDAO dao = new ProdutosDAO();
    

    /**
     * Creates new form frmPVD
     */
    public frmPVD() {
        initComponents();
       
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new Color(32, 136, 203));
        customizeMenuBar(jmenu);
       
            this.conect = new ConnectFactory().getConnection();
        
        
        
        for (int i = 0; i < tabelacar.getModel().getColumnCount(); i++) {
            tabelacar.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);

        }
        //TableHeader jtab = jtablecad.getTableHeader();

        tabelacar.setFont(new Font("Segoe UI", Font.BOLD, 18));
        tabelacar.getTableHeader().setOpaque(false);
        tabelacar.setRowHeight(25);
        
        

    }
    private void customizeMenuBar(JMenuBar menuBar) {

    menuBar.setUI(new BasicMenuBarUI() {

        @Override
        public void paint(Graphics g, JComponent c) {
            g.setColor(Color.white);
            g.fillRect(0, 0, c.getWidth(), c.getHeight());
        }

    });

    MenuElement[] menus = menuBar.getSubElements();

    for (MenuElement menuElement : menus) {

        JMenu menu = (JMenu) menuElement.getComponent();
        changeComponentColors(menu);
        menu.setOpaque(true);

        MenuElement[] menuElements = menu.getSubElements();

        for (MenuElement popupMenuElement : menuElements) {

            JPopupMenu popupMenu = (JPopupMenu) popupMenuElement.getComponent();
            popupMenu.setBorder(null);

            MenuElement[] menuItens = popupMenuElement.getSubElements();

            for (MenuElement menuItemElement : menuItens) {

                JMenuItem menuItem = (JMenuItem) menuItemElement.getComponent();
                changeComponentColors(menuItem);
                menuItem.setOpaque(true);

            }
        }
    }
}

private void changeComponentColors(Component comp) {
    comp.setBackground(Color.white);
    comp.setForeground(Color.black);
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelacar = new javax.swing.JTable();
        txtCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        logado = new javax.swing.JLabel();
        cargousuario = new javax.swing.JLabel();
        logado1 = new javax.swing.JLabel();
        txtValorTotal = new javax.swing.JTextField();
        txtroco = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Grana = new javax.swing.JTextField();
        logado2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        logado3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        logado4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        logado5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        logado6 = new javax.swing.JLabel();
        txtdescricao = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        logado7 = new javax.swing.JLabel();
        jmenu = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        Quantidade = new javax.swing.JMenuItem();
        buscarpro = new javax.swing.JMenuItem();
        excluiritem = new javax.swing.JMenuItem();
        finalizarvenda = new javax.swing.JMenuItem();
        esvaziar = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        sair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        tabelacar.setBackground(new java.awt.Color(204, 204, 204));
        tabelacar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tabelacar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Codigo", "Produto", "Qtd", "Preço", "SubTotal"
            }
        ));
        tabelacar.setGridColor(new java.awt.Color(255, 255, 255));
        tabelacar.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(tabelacar);

        txtCodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCodigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Usuario:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("F9 : ");

        logado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logado.setText("jLabel8");

        cargousuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cargousuario.setText("jLabel8");

        logado1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        logado1.setText("Comandos");

        txtValorTotal.setEditable(false);

        txtroco.setEditable(false);

        jLabel4.setText("Troco:");

        jLabel5.setText("Valor recebido:");

        Grana.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                GranaKeyPressed(evt);
            }
        });

        logado2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        logado2.setText("Valor Total");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Cargo:");

        logado3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logado3.setText("Sair");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("F3 : ");

        logado4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logado4.setText("Buscar Produto");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("F4 : ");

        logado5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logado5.setText("Informar Quantidade");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("F5 : ");

        logado6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logado6.setText("Excluir Item");

        txtdescricao.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("F6 : ");

        logado7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logado7.setText("Finalizar Venda");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtdescricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCodigo)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4)
                                .addComponent(Grana)
                                .addComponent(txtValorTotal)
                                .addComponent(txtroco, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(logado))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(cargousuario)))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(logado3)
                                    .addComponent(logado6)
                                    .addComponent(logado7, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(38, 38, 38))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(logado2)
                        .addGap(16, 16, 16))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(logado5)
                            .addComponent(logado1)
                            .addComponent(logado4))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtdescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(logado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cargousuario)
                            .addComponent(jLabel3))
                        .addGap(38, 38, 38)
                        .addComponent(logado2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Grana, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtroco, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(logado1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(logado5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(logado4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(logado6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(logado7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(logado3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jmenu.setBackground(new java.awt.Color(255, 255, 255));
        jmenu.setBorderPainted(false);
        jmenu.setFocusable(false);

        jMenu4.setText("Comandos");
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });

        Quantidade.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        Quantidade.setText("Quantidade");
        Quantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuantidadeActionPerformed(evt);
            }
        });
        jMenu4.add(Quantidade);

        buscarpro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        buscarpro.setText("Buscar produto");
        buscarpro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarproActionPerformed(evt);
            }
        });
        jMenu4.add(buscarpro);

        excluiritem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        excluiritem.setText("Excluir Item");
        excluiritem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluiritemActionPerformed(evt);
            }
        });
        jMenu4.add(excluiritem);

        finalizarvenda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        finalizarvenda.setText("Finalizar Venda");
        finalizarvenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizarvendaActionPerformed(evt);
            }
        });
        jMenu4.add(finalizarvenda);

        esvaziar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        esvaziar.setText("Esvaziar Carrinho");
        esvaziar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                esvaziarActionPerformed(evt);
            }
        });
        jMenu4.add(esvaziar);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
        jMenuItem1.setText("Imprimir Pedido");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        sair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
        sair.setText("Sair");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });
        jMenu4.add(sair);

        jmenu.add(jMenu4);

        setJMenuBar(jmenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

        Date agora = new Date();
        SimpleDateFormat databr = new SimpleDateFormat("dd/MM/yy");
        String dataformada = databr.format(agora);

        FuncionarioDAO dao = new FuncionarioDAO();
        Funcionarios obj = new Funcionarios();
        SessaoUsuario user = new SessaoUsuario();
        logado.setText(user.getNome());
        cargousuario.setText(user.getCargo());

        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private double valorTotal() {
        double soma = 0, valor = 0;
        int cont = tabelacar.getRowCount();
        for (int i = 0; i < cont; i++) {

            valor = Double.parseDouble(String.valueOf(tabelacar.getValueAt(i, 5)));
            soma += valor;

        }

        return soma;

    }


    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed

        DefaultTableModel model = (DefaultTableModel) tabelacar.getModel();

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
            obj = dao.consultaProduto(Long.parseLong(txtCodigo.getText()));
            txtdescricao.setText(obj.getDescricao() + "=" + obj.getPreco());
            model.addRow(new Object[]{
                model.getRowCount() + 1,
                obj.getId(),
                obj.getDescricao(),
                quantidade,
                obj.getPreco(),
                obj.getPreco() * quantidade

            });
            txtValorTotal.setText(valorTotal() + "");
            txtCodigo.setText("");
            quantidade = 1;
            } catch (Exception e) {
                
                
                
                 JOptionPane.showMessageDialog(this,"Digite um valor inteiro","Erro",JOptionPane.ERROR_MESSAGE);
            }
           

        }


    }//GEN-LAST:event_txtCodigoKeyPressed


    private void GranaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GranaKeyPressed
        double pagoDinheiro = 0;
        double troco = 0;
        double soma = 0;
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            pagoDinheiro = Double.parseDouble(Grana.getText());

            troco = pagoDinheiro - valorTotal();

            txtroco.setText(String.valueOf(troco));

        }
    }

    private void finalizarCompra() {
         String obs = SessaoUsuario.user;
        Vendas ved = new Vendas();
        int qtd, qtd_compra, qtd_atualiza = 0;

        Date agora = new Date();
        SimpleDateFormat dataeua = new SimpleDateFormat("yyyy-MM-dd");
        String dataformada = dataeua.format(agora);
        ved.setTotal_venda(valorTotal());
        ved.setData_venda(dataformada);
        ved.setFun(obs);

        DefaultTableModel model = (DefaultTableModel) tabelacar.getModel();

        ProdutosDAO dao = new ProdutosDAO();
        VendasDAO vedDAO = new VendasDAO();
                vedDAO.efetuarVenda(ved);
                ved.setId(vedDAO.ultimaVenda());
        for (int i = 0; i < model.getRowCount(); i++) {
            Produtos pro = new Produtos();
         
                

                Item venda = new Item();
                venda.setVenda(ved);
                pro.setId(Integer.parseInt(model.getValueAt(i, 1).toString()));
                venda.setProduto(pro);
                venda.setQtd(Integer.parseInt(model.getValueAt(i, 3).toString()));
                venda.setSubtotal(Double.parseDouble(model.getValueAt(i, 5).toString()));

                qtd = dao.estoqueAtual(Integer.parseInt(model.getValueAt(i, 1).toString()));
                qtd_compra = Integer.parseInt(model.getValueAt(i, 3).toString());
                qtd_atualiza = qtd - qtd_compra;

                dao.diminuirEstoque(Integer.parseInt(model.getValueAt(i, 1).toString()), qtd_atualiza);

                ProdutosVendaDAO PVendaDAO = new ProdutosVendaDAO();
                PVendaDAO.cadastrarItem(venda);
               
            }


        // TODO add your handling code here:
    }//GEN-LAST:event_GranaKeyPressed

    private void QuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuantidadeActionPerformed
        
        try {  quantidade = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade"));
            
        } catch (Exception e) {
            
             JOptionPane.showMessageDialog(this,"Quantidade não informada","Erro", JOptionPane.ERROR_MESSAGE);
        }
        


    }//GEN-LAST:event_QuantidadeActionPerformed

    private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu4ActionPerformed

    private void finalizarvendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarvendaActionPerformed
                
                    finalizarCompra();
                   esvaziarCarrinho();
        // TODO add your handling code here:
    }//GEN-LAST:event_finalizarvendaActionPerformed

    private void buscarproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarproActionPerformed
                   frmVisualizarProduto pro = new frmVisualizarProduto();
                   pro.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_buscarproActionPerformed

    private void excluiritemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluiritemActionPerformed
                 excluir();        // TODO add your handling code here:
    }//GEN-LAST:event_excluiritemActionPerformed

    private void esvaziarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_esvaziarActionPerformed
               esvaziarCarrinho();        // TODO add your handling code here:
    }//GEN-LAST:event_esvaziarActionPerformed

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
                 this.dispose();  
                 // TODO add your handling code here:
    }//GEN-LAST:event_sairActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
                       int confirma= JOptionPane.showConfirmDialog(null, "Confirma impressão do pedido?","Atenção",JOptionPane.YES_NO_OPTION);
              
        if(confirma==JOptionPane.YES_OPTION){
            
            try {
                     HashMap filtro = new HashMap();
                         VendasDAO dao = new VendasDAO();
                          Vendas ved = new Vendas();
                   ved.setId(dao.ultimaVenda());
                     Item venda = new Item();
                venda.setVenda(ved);
                  
                     filtro.put("venda_id",venda.getVenda().getId());
                JasperPrint print = JasperFillManager.fillReport("C:/iReports/Imprimir.jasper", filtro,conect);             
           
             JasperViewer.viewReport(print, false);
             
            
            } catch (Exception e) {
            
             JOptionPane.showMessageDialog(null, e);
             
            }
            
            
            
        }             // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed
  public void excluir(){
      
      
          int qntLinha = tabelacar.getRowCount();
        try {
            
         if (qntLinha < 1) {

            JOptionPane.showMessageDialog(this, "Carrinho está vazio,não há o que excluir.","Erro",JOptionPane.ERROR_MESSAGE);
        } else {

            for (int i = 0; i < qntLinha; i++) {

                DefaultTableModel model = (DefaultTableModel) tabelacar.getModel();
                int linha = Integer.parseInt((JOptionPane.showInputDialog(null, "Digite o item a ser excluir")));
                model.removeRow(linha - 1);
                txtValorTotal.setText(valorTotal() + "");
                model.setValueAt(i + 1, i, 0);

            }
        }  } catch (Exception e) {
        }

      
      
  }
  
  
  
  public void imprimirPedido(){
      
       int confirma= JOptionPane.showConfirmDialog(null, "Confirma impressão deste relátorio","Atenção",JOptionPane.YES_NO_OPTION);
              
        if(confirma==JOptionPane.YES_OPTION){
            
            try {
                     HashMap filtro = new HashMap();
                         VendasDAO dao = new VendasDAO();
                          Vendas ved = new Vendas();
                   ved.setId(dao.ultimaVenda());
                     Item venda = new Item();
                venda.setVenda(ved);
                  
                     filtro.put("venda_id",venda.getVenda().getId());
                JasperPrint print = JasperFillManager.fillReport("C:/iReports/ImprimirVenda.jasper", filtro,conect);             
           
             JasperViewer.viewReport(print, false);
             
            
            } catch (Exception e) {
            
             JOptionPane.showMessageDialog(null, e);
             
            }
            
            
            
        }             // 
      
  }
  
  public void esvaziarCarrinho(){
      
      
      int qntLinha = tabelacar.getRowCount();
        try {
            
         if (qntLinha < 1) {

            JOptionPane.showMessageDialog(this, "Carrinho está vazio,não há o que excluir.","Erro",JOptionPane.ERROR_MESSAGE);
        } else {

           
            while (tabelacar.getModel().getRowCount() > 0) {  
           ((DefaultTableModel) tabelacar.getModel()).removeRow(0); 
           
           
           txtdescricao.setText("");
            txtValorTotal.setText(valorTotal() + "");
           
            }
            
        }  } catch (Exception e) {
        }  }

   
      
  
   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPVD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPVD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPVD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPVD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPVD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Grana;
    private javax.swing.JMenuItem Quantidade;
    private javax.swing.JMenuItem buscarpro;
    private javax.swing.JLabel cargousuario;
    private javax.swing.JMenuItem esvaziar;
    private javax.swing.JMenuItem excluiritem;
    private javax.swing.JMenuItem finalizarvenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuBar jmenu;
    private javax.swing.JLabel logado;
    private javax.swing.JLabel logado1;
    private javax.swing.JLabel logado2;
    private javax.swing.JLabel logado3;
    private javax.swing.JLabel logado4;
    private javax.swing.JLabel logado5;
    private javax.swing.JLabel logado6;
    private javax.swing.JLabel logado7;
    private javax.swing.JMenuItem sair;
    private javax.swing.JTable tabelacar;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtValorTotal;
    private javax.swing.JLabel txtdescricao;
    private javax.swing.JTextField txtroco;
    // End of variables declaration//GEN-END:variables
}
