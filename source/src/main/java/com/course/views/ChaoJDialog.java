/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.course.views;

import java.util.Date;

/**
 *
 * @author abc
 */
public final class ChaoJDialog extends javax.swing.JDialog implements Runnable {

    private static final long serialVersionUID = 1L;

    /**
     * Creates new form ChaoJDialog
     *
     * @param parent
     * @param modal
     */
    public ChaoJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(parent);
        this.toFront();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pgbloading = new javax.swing.JProgressBar();
        lblAnh = new javax.swing.JLabel();
        lblInformation = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);

        pgbloading.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pgbloading.setStringPainted(true);

        lblAnh.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/icons/polytechnic.png"))); // NOI18N

        lblInformation.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        lblInformation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInformation.setText("Quản lý đào tạo lập trình city");
        lblInformation.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblInformation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pgbloading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(pgbloading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        ChaoJDialog dialog = new ChaoJDialog(null, true);
        new Thread(dialog).start();
        dialog.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblAnh;
    private javax.swing.JLabel lblInformation;
    private javax.swing.JProgressBar pgbloading;
    // End of variables declaration//GEN-END:variables

    String[] tittle = {
        "Bắt đầu: " + new Date(),
        "Ps18107 - Ngô Duy Hòa",
        "SOF2041 - Quản lý khóa học",
    };
    int next = Math.round((100 / tittle.length)), first = next, count = 0;

    @Override
    public void run() {
        int value = pgbloading.getValue();
        // Tăng biến điếm "pgbloading" sau lần gọi tiếp.
        while (++value <= pgbloading.getMaximum()) {
            try {
                this.pgbloading.setValue(value);
                if (value == next) {
                    this.lblInformation.setText(tittle[count++]);
                    if(count == 0) Thread.sleep(200);next += first;
                }
                if (value == 99) {
                    this.lblInformation.setText(tittle[tittle.length-1]);
                    Thread.sleep(1000);
                }
                Thread.sleep(15); // số càng ít tốc độ "pgbloading" càng nhanh
            } catch (InterruptedException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        this.dispose();
    }
}
