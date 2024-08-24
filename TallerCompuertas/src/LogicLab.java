
import javax.swing.JOptionPane;
import tallercompuertas.And;
import tallercompuertas.Or;
import tallercompuertas.Not;


public class LogicLab extends javax.swing.JFrame {

    public LogicLab() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botones = new javax.swing.ButtonGroup();
        panelFondo = new javax.swing.JPanel();
        panelDibujo = new javax.swing.JPanel();
        txtEntrada = new javax.swing.JTextField();
        lblEntrada = new javax.swing.JLabel();
        btLimpiar = new javax.swing.JButton();
        btAñadir = new javax.swing.JButton();
        btDibujar = new javax.swing.JButton();
        panelBotones = new javax.swing.JPanel();
        RbtnAnd = new javax.swing.JRadioButton();
        RbtnOr = new javax.swing.JRadioButton();
        RbtnNot = new javax.swing.JRadioButton();
        lblSalida = new javax.swing.JLabel();
        txtSalida = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelFondo.setBackground(new java.awt.Color(153, 153, 153));

        panelDibujo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        javax.swing.GroupLayout panelDibujoLayout = new javax.swing.GroupLayout(panelDibujo);
        panelDibujo.setLayout(panelDibujoLayout);
        panelDibujoLayout.setHorizontalGroup(
            panelDibujoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelDibujoLayout.setVerticalGroup(
            panelDibujoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 216, Short.MAX_VALUE)
        );

        lblEntrada.setFont(new java.awt.Font("Centaur", 1, 18)); // NOI18N
        lblEntrada.setText("Entradas:");

        btLimpiar.setText("Limpiar");
        btLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiarActionPerformed(evt);
            }
        });

        btAñadir.setText("Añadir");
        btAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAñadirActionPerformed(evt);
            }
        });

        btDibujar.setText("Dibujar");
        btDibujar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDibujarActionPerformed(evt);
            }
        });

        panelBotones.setBackground(new java.awt.Color(153, 153, 153));
        panelBotones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        botones.add(RbtnAnd);
        RbtnAnd.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        RbtnAnd.setText("AND");

        botones.add(RbtnOr);
        RbtnOr.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        RbtnOr.setText("OR");

        botones.add(RbtnNot);
        RbtnNot.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        RbtnNot.setText("NOT");

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RbtnAnd)
                    .addComponent(RbtnOr)
                    .addComponent(RbtnNot))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RbtnAnd)
                .addGap(18, 18, 18)
                .addComponent(RbtnOr)
                .addGap(18, 18, 18)
                .addComponent(RbtnNot)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblSalida.setFont(new java.awt.Font("Centaur", 1, 18)); // NOI18N
        lblSalida.setText("Salida:");

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LogicLab 1.0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelFondoLayout = new javax.swing.GroupLayout(panelFondo);
        panelFondo.setLayout(panelFondoLayout);
        panelFondoLayout.setHorizontalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelFondoLayout.createSequentialGroup()
                                .addComponent(txtSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panelFondoLayout.createSequentialGroup()
                                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSalida)
                                    .addComponent(lblEntrada)
                                    .addGroup(panelFondoLayout.createSequentialGroup()
                                        .addComponent(txtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btAñadir)))
                                .addContainerGap(48, Short.MAX_VALUE))))
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelDibujo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelFondoLayout.createSequentialGroup()
                                .addComponent(btDibujar)
                                .addGap(18, 18, 18)
                                .addComponent(btLimpiar)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        panelFondoLayout.setVerticalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btDibujar)
                            .addComponent(btLimpiar)))
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addComponent(lblEntrada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btAñadir))
                        .addGap(18, 18, 18)
                        .addComponent(lblSalida)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addComponent(panelDibujo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Variables  publicas
    public static  int[] vector;
    public  int indice=0;
    
    //Objetos publicos
    public Or compuertaOr;
    public Not compuertaNot;
    public And compuertaAnd;
    
    public boolean allRight()
    {
        boolean done = true;
        
        if(RbtnAnd.isSelected() || RbtnOr.isSelected())
        {
            vector = new int[2];
        }
        else if(RbtnNot.isSelected())
        {
            vector = new int[1];
        }
        else
        {
            done = false;
        }
        return done;
    }
    
    private void btAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAñadirActionPerformed
        // TODO add your handling code here:
        int entrada;
        
        if(RbtnAnd.isSelected() || RbtnNot.isSelected() || RbtnOr.isSelected())
        {
            try
            {
                entrada = Integer.parseInt(txtEntrada.getText().trim());
                if (entrada ==0 || entrada ==1)
                {
                    if(RbtnNot.isSelected())
                    { vector = new int [1]; }
                    else if(RbtnAnd.isSelected() || RbtnOr.isSelected())
                    {vector = new int [2]; }
                    
                    vector[indice++] = entrada;
                    txtEntrada.setText("");
                    if(indice == vector.length)
                    {
                        btAñadir.setEnabled(false);
                        
                        if(RbtnAnd.isSelected())
                        {
                            compuertaAnd = new And(vector);
                            txtSalida.setText(""+compuertaAnd.getSalida());
                        }
                        else if(RbtnOr.isSelected())
                        {
                            compuertaOr = new Or(vector);
                            txtSalida.setText(""+compuertaOr.getSalida());
                        }
                        else if(RbtnNot.isSelected())
                        {
                            compuertaNot = new Not(vector[0]);
                            txtSalida.setText("" + compuertaNot.getSalida());
                        }
                    }
                    txtEntrada.grabFocus();
                    
                    
                }
                else{JOptionPane.showMessageDialog(null, "Debes ingresar un componente binario (0, 1)", "Error", JOptionPane.ERROR_MESSAGE);
                txtEntrada.selectAll();
                }
            } catch (Exception e){JOptionPane.showMessageDialog(null, "Debes ingresar un digito binario", "Error", JOptionPane.ERROR_MESSAGE); }
        }
        else{
            JOptionPane.showMessageDialog(null, "Seleccione la compuerta con la que desea trabajar", "Error",  JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btAñadirActionPerformed

    private void btDibujarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDibujarActionPerformed
        // TODO add your handling code here:
        
        //Implementar el metodo de dibujo de cada compuerta
    }//GEN-LAST:event_btDibujarActionPerformed

    private void btLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiarActionPerformed
        // TODO add your handling code here:
        
        //Borrar dibujo   #"panelDibujo"
        //Vacias vector   #"vector"
        //Activar boton añadir  #"btAñadir"
    }//GEN-LAST:event_btLimpiarActionPerformed

    
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
            java.util.logging.Logger.getLogger(LogicLab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogicLab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogicLab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogicLab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogicLab().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RbtnAnd;
    private javax.swing.JRadioButton RbtnNot;
    private javax.swing.JRadioButton RbtnOr;
    private javax.swing.ButtonGroup botones;
    private javax.swing.JButton btAñadir;
    private javax.swing.JButton btDibujar;
    private javax.swing.JButton btLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblEntrada;
    private javax.swing.JLabel lblSalida;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelDibujo;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JTextField txtEntrada;
    private javax.swing.JTextField txtSalida;
    // End of variables declaration//GEN-END:variables
}
