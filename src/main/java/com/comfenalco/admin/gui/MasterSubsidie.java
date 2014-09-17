/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comfenalco.admin.gui;

import com.comfenalco.admin.service.MasterSubsidieGenerator;
import com.comfenalco.admin.utils.FileManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author rockerW7
 */
public class MasterSubsidie extends javax.swing.JPanel {

    private Home home;
    private MasterSubsidieGenerator masterSubsidieGenerator;

    private final static Logger LOGGER = Logger.
            getLogger(MasterAffiliate.class.getName());

    /**
     * Creates new form MasterSubsidie
     *
     * @param parent
     */
    public MasterSubsidie(Home parent) {

        this.home = parent;
        initComponents();
        this.progressBar.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSaveFileAs = new javax.swing.JButton();
        txtPathToSaveFile = new javax.swing.JTextField();
        btnGenerate = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();
        lblMaestroSubsidio = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(551, 180));
        setRequestFocusEnabled(false);

        btnSaveFileAs.setText("Seleccionar ruta");
        btnSaveFileAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveFileAsActionPerformed(evt);
            }
        });

        txtPathToSaveFile.setEnabled(false);

        btnGenerate.setText("Generar archivo plano");
        btnGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateActionPerformed(evt);
            }
        });

        progressBar.setStringPainted(true);

        lblMaestroSubsidio.setText("Generacion del archivo plano \"Maestro de subsidio\"");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGenerate)
                .addGap(202, 202, 202))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSaveFileAs)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPathToSaveFile)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(lblMaestroSubsidio)
                                .addGap(0, 149, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblMaestroSubsidio)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveFileAs)
                    .addComponent(txtPathToSaveFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnGenerate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateActionPerformed
        // TODO add your handling code here:

        if (txtPathToSaveFile.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "No ha seleccionado una ruta valida",
                    ":(", JOptionPane.WARNING_MESSAGE);
        } else {

            this.enabledGUI(false);

            this.masterSubsidieGenerator = new MasterSubsidieGenerator();
            this.masterSubsidieGenerator.start();

            this.showProgressBar();

            Runnable r = new Runnable() {
                public void run() {

                    progressBar.setIndeterminate(true);

                    while (masterSubsidieGenerator.isAlive()) {
                    }

                    FileManager.saveFile(txtPathToSaveFile.getText() + "/" + masterSubsidieGenerator.getFileName() + ".txt",
                            masterSubsidieGenerator.getInfo());

                    progressBar.setIndeterminate(false);
                    progressBar.setString("Archivo generado con éxito!");

                    btnGenerate.setEnabled(true);
                    home.pack();
                }
            };
            Thread t = new Thread(r);
            t.start();
        }
    }//GEN-LAST:event_btnGenerateActionPerformed

    /*@summary: Metodo que habilita/deshabilita los controles del panel una vez se ha comenzado la generacion de los archivos*/
    private void enabledGUI(boolean flag) {

        this.btnGenerate.setEnabled(flag);
        this.btnSaveFileAs.setEnabled(flag);
        this.home.getMasterFilesMenu().setEnabled(flag);
    }

    private void btnSaveFileAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveFileAsActionPerformed

        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jFileChooser.showSaveDialog(this);

        try {
            String absolutePath = jFileChooser.getSelectedFile()
                    .getAbsolutePath();

            this.txtPathToSaveFile.setText(absolutePath);

        } catch (NullPointerException ex) {
            LOGGER.log(Level.INFO,
                    "No se ha seleccionado ninguna ruta donde almacenar el archivo de salida");
        }
    }//GEN-LAST:event_btnSaveFileAsActionPerformed

    private void showProgressBar() {
        this.progressBar.setVisible(true);
        this.progressBar.setString("Construyendo el archivo. Por favor espere un momento ...");
        this.home.pack();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerate;
    private javax.swing.JButton btnSaveFileAs;
    private javax.swing.JLabel lblMaestroSubsidio;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JTextField txtPathToSaveFile;
    // End of variables declaration//GEN-END:variables
}