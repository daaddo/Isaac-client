/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.example.EldenRing.isaac.gui;

import org.example.EldenRing.isaac.models.characters.Enemy;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author trapa
 */
public class EnemyPanel extends javax.swing.JPanel {
    private String enemyImgPath;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        ImageIcon imageIcon = new ImageIcon(enemyImgPath);
        Image image = imageIcon.getImage();
        g.drawImage(image, 0, 0, null);
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        Image scaledImage = image.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        g.drawImage(scaledImage, getHeight(), 0, null);


    }

    /**
     * Creates new form JPanelEnemy
     */

    public EnemyPanel(){
        initComponents();
    }
    public EnemyPanel(Enemy enemy) {
        this.enemyImgPath = enemy.getAvatarPath();
        initComponents();
        jLabelEnemyHealth.setText(""+enemy.getCurrentHealth()+" / "+enemy.getMaxHealth());
        jLabelEnemyName.setText(enemy.getName());
        this.invalidate();
        this.validate();
        this.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelEnemyImg = new javax.swing.JPanel();
        jLabelEnemyHealth = new javax.swing.JLabel();
        jLabelEnemyName = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 51));

        jPanelEnemyImg.setBackground(new java.awt.Color(255, 255, 0));

        javax.swing.GroupLayout jPanelEnemyImgLayout = new javax.swing.GroupLayout(jPanelEnemyImg);
        jPanelEnemyImg.setLayout(jPanelEnemyImgLayout);
        jPanelEnemyImgLayout.setHorizontalGroup(
            jPanelEnemyImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelEnemyImgLayout.setVerticalGroup(
            jPanelEnemyImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 208, Short.MAX_VALUE)
        );

        jLabelEnemyHealth.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabelEnemyHealth.setForeground(new java.awt.Color(0, 0, 255));
        jLabelEnemyHealth.setText("jLabel1");

        jLabelEnemyName.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabelEnemyName.setForeground(new java.awt.Color(255, 0, 0));
        jLabelEnemyName.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelEnemyImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelEnemyName, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                    .addComponent(jLabelEnemyHealth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelEnemyImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabelEnemyName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEnemyHealth, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelEnemyHealth;
    private javax.swing.JLabel jLabelEnemyName;
    private javax.swing.JPanel jPanelEnemyImg;
    // End of variables declaration//GEN-END:variables
}