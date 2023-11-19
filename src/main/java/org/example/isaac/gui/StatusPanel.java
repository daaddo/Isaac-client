/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.example.isaac.gui;

import org.example.isaac.models.characters.interactions.type.Interaction;
import org.example.isaac.models.characters.type.Unit;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author trapa
 */
public class StatusPanel<T extends Unit> extends javax.swing.JPanel {

    /**
     * Creates new form StatusPanel
     */
    private Interaction<T> interaction;
    private String characterImgPath;
    public StatusPanel() {
        initComponents();
    }
    public StatusPanel(Interaction<T> interaction) {
        assert interaction != null;
        initComponents();
        if (interaction.getImgPath().isPresent()) {
            this.interaction = interaction;
            this.characterImgPath = interaction.getImgPath().orElse(null);
            if (characterImgPath == null) return;
            Image img = new ImageIcon(StatusPanel.class.getResource(characterImgPath)).getImage();
            System.out.println(img.getSource());
            jLabel1.setIcon(new ImageIcon(img));
        }
    }
    public boolean checkInteraction(Interaction<? extends Unit> interaction){
        if (this.interaction == null) {
            return false;
        }
        return this.interaction.equals(interaction);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
