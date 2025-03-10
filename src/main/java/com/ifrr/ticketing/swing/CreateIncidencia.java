/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.ifrr.ticketing.swing;

import com.ifrr.ticketing.entities.Dispositivo;
import com.ifrr.ticketing.entities.Espacio;
import com.ifrr.ticketing.entities.Incidencia;
import com.ifrr.ticketing.service.ServiceDispositivo;
import com.ifrr.ticketing.service.ServiceEspacio;
import com.ifrr.ticketing.service.ServiceIncidencia;
import com.ifrr.ticketing.service.ServiceUsuario;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author nakayoshi_dango
 */
public class CreateIncidencia extends javax.swing.JDialog {

    private final ServiceDispositivo sd;
    private final ServiceEspacio se;
    private final ServiceUsuario su;
    private final ServiceIncidencia si;
    private final Integer usuarioId;

    /**
     * Creates new form CreateIncidencia
     */
    public CreateIncidencia(java.awt.Frame parent, boolean modal, ServiceDispositivo sd, ServiceEspacio se, ServiceUsuario su, ServiceIncidencia si, Integer usuarioId) {
        super(parent, modal);
        this.sd = sd;
        this.se = se;
        this.su = su;
        this.si = si;
        this.usuarioId = usuarioId;
        initComponents();
        loadComboBoxData();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        errorLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        dispositivoComboBox = new javax.swing.JComboBox<>();
        espacioComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(914, 243));

        jLabel2.setForeground(new java.awt.Color(242, 242, 242));
        jLabel2.setText("Descripción Incidencia");

        jLabel3.setForeground(new java.awt.Color(242, 242, 242));
        jLabel3.setText("Dispositivo");

        jLabel4.setForeground(new java.awt.Color(242, 242, 242));
        jLabel4.setText("Espacio");

        jButton1.setBackground(new java.awt.Color(153, 204, 255));
        jButton1.setText("Crear Incidencia");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField2.setPreferredSize(new java.awt.Dimension(600, 23));

        jLabel5.setForeground(new java.awt.Color(242, 242, 242));
        jLabel5.setText("Tipo Incidencia");

        jTextField5.setPreferredSize(new java.awt.Dimension(450, 23));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(errorLabel))
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1))
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(dispositivoComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 450, Short.MAX_VALUE)
                        .addComponent(espacioComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dispositivoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(espacioComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(errorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jButton1)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!jTextField2.getText().isBlank() && !jTextField5.getText().isBlank()) {
            Incidencia in = new Incidencia(LocalDate.now().toString(), "", "espera", jTextField5.getText(), su.getUsuarioById(2), su.getUsuarioById(usuarioId), su.getUsuarioById(1), jTextField2.getText(), "");

            int dispositivoIndex = dispositivoComboBox.getSelectedIndex();
            int espacioIndex = espacioComboBox.getSelectedIndex();
            if (dispositivoIndex >= 0) {
                Dispositivo dispositivo = sd.getAllDispositivos().get(dispositivoIndex);
                in.setDispositivo(dispositivo);
            }
            if (espacioIndex >= 0) {
                Espacio espacio = se.getAllEspacios().get(espacioIndex);
                in.setEspacio(espacio);
            }

            in = si.createIncidencia(in);
            if (in != null) {
                dispose();
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "No se pudo crear la incidencia.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Por favor, rellena los campos obligatorios: descripción y tipo de incidencia.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void loadComboBoxData() {
        List<Dispositivo> dispositivos = sd.getAllDispositivos();
        for (Dispositivo d : dispositivos) {
            dispositivoComboBox.addItem(d.getTipo() + " " + d.getMarca() + " " + d.getModelo() + " " + d.getDescripcion());
        }

        List<Espacio> espacios = se.getAllEspacios();
        for (Espacio e : espacios) {
            espacioComboBox.addItem(e.getDescripcion());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> dispositivoComboBox;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JComboBox<String> espacioComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
