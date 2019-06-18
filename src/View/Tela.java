package View;

import Control.ControleDados;
import javax.swing.JOptionPane;

/**
 * Esta classe possui os métodos e atributos que compõem a interface gráfica
 *
 * @author Leonardo Steinke e Rodrigo Valle
 * @since 09/06/2019
 *
 */
public class Tela extends javax.swing.JFrame {

    //Instanciando a classe de controle
    private ControleDados dados = new ControleDados();

    //Definindo variável de posição 
    private int pos;

    //Definindo o construtor de Tela
    private Tela() throws Exception {
        super("Cadastro de Cidade");
        initComponents();
        try {
            jTable1.setModel(dados.listar());
        } catch (Exception e) {
        }
        setLocationRelativeTo(null);
        setVisible(true);

    }

    private static Tela instance;

    public static Tela getInstance() throws Exception {
        if (instance == null) {
            instance = new Tela();
        }
        return instance;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jbcUF = new javax.swing.JComboBox<>();
        jfCEP = new javax.swing.JFormattedTextField();
        jfNome = new javax.swing.JFormattedTextField();
        btnEditar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Nome:");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("CEP:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("UF:");

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.setEnabled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jbcUF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        jbcUF.setSelectedIndex(-1);

        try {
            jfCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jfCEP.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jfCEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jfCEPActionPerformed(evt);
            }
        });

        jfNome.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jfNomeActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jfCEP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbcUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jfNome)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnEditar)
                        .addGap(40, 40, 40)
                        .addComponent(btnExcluir)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jfCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jbcUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnExcluir)
                    .addComponent(btnEditar))
                .addGap(18, 18, 18)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTable1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cidade", "CEP", "UF"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Long.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Este método recebe o valor inserido dentro do jfNome e aplica no método
     * buscarDados da classe ControleDados
     *
     * @param evt
     */

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            if (jfNome.getText().equals("")) {
                throw new Exception();
            } else {
                String[] dado = dados.buscarDados(jfNome.getText().toUpperCase());
                jfNome.setText(dado[0]);
                jfCEP.setText(dado[1]);
                jbcUF.setSelectedItem(dado[2]);
                jfNome.setEnabled(false);
                jfCEP.setEnabled(false);
                jbcUF.setEnabled(false);
                btnEditar.setEnabled(true);
                btnExcluir.setEnabled(true);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Essa cidade não existe\nou o nome foi digitado errado", "Erro", 2);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    /**
     * Este método recebe o valor inserido dentro do jfNome, aplica no método
     * buscarPosDoIndice da classe ControleDados, que posteriormente chama o
     * método excluirDados também da classe ControleDados
     *
     * @param evt
     */

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try {
            dados.excluirDados(dados.buscarPosDoIndice(jfNome.getText()));

            jTable1.setModel(dados.listar());
            jfNome.setText("");
            jfCEP.setText("");
            jbcUF.setSelectedIndex(-1);

            jfNome.setEnabled(true);
            jfCEP.setEnabled(true);
            jbcUF.setEnabled(true);
            btnExcluir.setEnabled(false);
            btnEditar.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Cidade excluida com Sucesso!", "Exclusão", 1);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Algo deu errado", "Erro", 2);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    /**
     * Este método recebe os valores inseridos nos campos e aplica no método
     * criarCidadeTELA da classe ControleDados, para criar um novo objeto
     *
     * @param evt
     */

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        if (jfNome.isEnabled()) {
            try {

                jTable1.setModel(dados.criarCidadeTELA(jfNome.getText().toUpperCase(), Integer.parseInt(jfCEP.getText()), (String) jbcUF.getSelectedItem()));
                JOptionPane.showMessageDialog(null, "Cidade cadastrada com Sucesso!", "Cadastro", 1);
                jfNome.setText("");
                jfCEP.setText("");
                jbcUF.setSelectedIndex(-1);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Algo deu errado.\n\nVerifique os campos cadastrados!\nCidade duplicada ou campos incompletos", "Erro", 2);
            }

        } else {
            btnEditar.setEnabled(false);
            btnExcluir.setEnabled(false);
            jfNome.setEnabled(true);
            jfCEP.setEnabled(true);
            jbcUF.setEnabled(true);
            jfNome.setText("");
            jfCEP.setText("");
            jbcUF.setSelectedIndex(-1);
        }

    }//GEN-LAST:event_btnNovoActionPerformed

    private void jfCEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jfCEPActionPerformed

    }//GEN-LAST:event_jfCEPActionPerformed

    private void jfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jfNomeActionPerformed

    }//GEN-LAST:event_jfNomeActionPerformed
    
    /**
     * Este método aplica o jfNome digitado no método buscarPosDoIndice da classe
     * ControleDados e posteriomente chama o método alterarDados da mesma classe 
     * para atualizar os respectivos camposF
     * 
     * @param evt 
     */
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (!jfNome.isEnabled()) {
            try {
                pos = dados.buscarPosDoIndice(jfNome.getText());
                jfNome.setEnabled(true);
                jfCEP.setEnabled(true);
                jbcUF.setEnabled(true);
                btnNovo.setEnabled(false);
                btnExcluir.setEnabled(false);
                btnBuscar.setEnabled(false);

            } catch (Exception ex) {

            }
        } else {
            try {
                dados.alterarDados(jfNome.getText().toUpperCase(), jfCEP.getText(), (String) jbcUF.getSelectedItem(), pos);
                jTable1.setModel(dados.listar());
                btnEditar.setEnabled(false);
                jfNome.setText("");
                jfCEP.setText("");
                jbcUF.setSelectedIndex(-1);
                btnNovo.setEnabled(true);
                btnBuscar.setEnabled(true);
                JOptionPane.showMessageDialog(null, "Cidade atualizada com Sucesso!", "Atualizar", 1);
            } catch (Exception ex) {
                System.out.println("erro");
            }
        }

    }//GEN-LAST:event_btnEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> jbcUF;
    private javax.swing.JFormattedTextField jfCEP;
    private javax.swing.JFormattedTextField jfNome;
    // End of variables declaration//GEN-END:variables

}
