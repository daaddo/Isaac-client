/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.example.EldenRing.isaac.gui;

import org.example.EldenRing.isaac.events.FightEventListner;
import org.example.EldenRing.isaac.manager.FightManager;
import org.example.EldenRing.isaac.manager.GameManager;
import org.example.EldenRing.isaac.models.characters.*;
import org.example.EldenRing.isaac.models.characters.Character;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 *
 * @author trapa
 */
public class CharacterPanel extends javax.swing.JPanel implements FightEventListner {
    private Character character;
    private String characterImgPath;



    @Override
    public void paint(Graphics g) {
        super.paint(g);
        URL imageUrl = getClass().getResource(characterImgPath);
        ImageIcon icon = new ImageIcon(imageUrl);
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        g.drawImage(scaledImage, getHeight(), 0, null);
    }

    /**
     * Creates new form JPanelEnemy
     */

    public CharacterPanel(){
        initComponents();
    }
    public CharacterPanel(Character character) {
        this.character = character;
        GameManager.getInstance().subscribeFightListner(this);
        FightManager.getInstance().subscribeFightListner(this);
        this.characterImgPath = character.getAvatarPath();
        initComponents();
        jLabelCharacterHealth.setText(""+character.getCurrentHealth()+" / "+character.getMaxHealth());
        jLabelCharacterName.setText(character.getName());
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

        jPanelCharacterImg = new javax.swing.JPanel();
        jLabelCharacterImg = new javax.swing.JLabel();
        jLabelCharacterHealth = new javax.swing.JLabel();
        jLabelCharacterName = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 51));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jPanelCharacterImg.setBackground(new java.awt.Color(255, 255, 0));

        jLabelCharacterImg.setText("jLabel1");

        javax.swing.GroupLayout jPanelEnemyImgLayout = new javax.swing.GroupLayout(jPanelCharacterImg);
        jPanelCharacterImg.setLayout(jPanelEnemyImgLayout);
        jPanelEnemyImgLayout.setHorizontalGroup(
            jPanelEnemyImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelCharacterImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelEnemyImgLayout.setVerticalGroup(
            jPanelEnemyImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelCharacterImg, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
        );

        jLabelCharacterHealth.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabelCharacterHealth.setForeground(new java.awt.Color(0, 0, 255));
        jLabelCharacterHealth.setText("jLabel1");

        jLabelCharacterName.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabelCharacterName.setForeground(new java.awt.Color(255, 0, 0));
        jLabelCharacterName.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCharacterImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCharacterName, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                    .addComponent(jLabelCharacterHealth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelCharacterImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabelCharacterName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCharacterHealth, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelCharacterImg;
    private javax.swing.JLabel jLabelCharacterHealth;
    private javax.swing.JLabel jLabelCharacterName;
    private javax.swing.JPanel jPanelCharacterImg;

    @Override
    public void startTurn(Character character, Boolean isally) {
        if (character.equals(this.character)){
            if (character instanceof MainCharacter) {
                this.jLabelCharacterHealth.setText(character.getCurrentHealth() + "/" + character.getMaxHealth());

            }
            this.jPanelCharacterImg.removeAll();
            this.jPanelCharacterImg.revalidate();
            this.jPanelCharacterImg.repaint();

        }

    }




    @Override
    public void setTarget(Target target) {
        if (target.target().equals(this.character)){
            this.setBackground(Color.RED);
        }
    }

    @Override
    public void resetTarget(Target target) {

        if (target.target().equals(this.character)){
            // set backgrounf to transparent
            this.setBackground(null);
        }
    }
    // End of variables declaration//GEN-END:variables

}
