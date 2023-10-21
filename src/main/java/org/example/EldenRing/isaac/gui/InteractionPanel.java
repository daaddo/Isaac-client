/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.example.EldenRing.isaac.gui;

import org.example.EldenRing.isaac.events.FightEventListner;
import org.example.EldenRing.isaac.manager.FightManager;
import org.example.EldenRing.isaac.manager.GameManager;
import org.example.EldenRing.isaac.models.characters.Character;
import org.example.EldenRing.isaac.models.characters.Fightable;
import org.example.EldenRing.isaac.models.characters.Target;
import org.example.EldenRing.isaac.models.characters.interactions.Skill;

import java.awt.*;

/**
 *
 * @author trapa
 */
public class InteractionPanel extends javax.swing.JPanel {

    private boolean isActive = false;
    private Skill skill;
    /**
     * Creates new form InteractionPanel
     */
    public InteractionPanel() {
        initComponents();
    }
    public InteractionPanel(Skill skill) {
        initComponents();
        this.skill = skill;
        this.jButton1.setToolTipText("<html><b> ciccio</b> <br> <font color = red> frasetta rossa</font>");
        this.jButton1.setText("<html> <b> <font color = yellow>"+skill.getName()+"</font></b> <br> <font color = red>");
        switch (skill.getTarget()) {
            case SELF -> {
                this.jButton1.setBackground(java.awt.Color.GREEN);
            }
            case ENEMY -> {
                this.jButton1.setBackground(java.awt.Color.RED);
            }
            case DEAD -> {
                this.jButton1.setBackground(Color.yellow);

            }
            case ALLYTEAM -> {
                this.jButton1.setBackground(Color.BLUE);
            }
            case ENEMYTEAM -> {
                this.jButton1.setBackground(Color.ORANGE);
            }
            case ALL -> {
                this.jButton1.setBackground(new Color(128,0,128));
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        jButton1.setText("jButton1");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        isActive = !isActive;
        if (isActive){
            FightManager.getInstance().highLightTarget(skill.getTarget());
        }
        else{
            FightManager.getInstance().reset();
        }
    }//GEN-LAST:event_jButton1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
//prendo da qua la abilità che devo usare poi la passo su Game Manager e da li