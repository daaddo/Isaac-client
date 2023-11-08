/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.example.isaac.gui;

import org.example.isaac.events.FightEventListner;
import org.example.isaac.factory.RandomEnemiesForARoomFactory;
import org.example.isaac.manager.FightManager;
import org.example.isaac.manager.GameManager;
import org.example.isaac.models.characters.type.*;
import org.example.isaac.models.characters.interactions.Skill;
import org.example.isaac.models.nextCharacter;
import org.example.isaac.models.characters.Target;


import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author trapa
 */
public class BattleFrame<T extends Unit> extends javax.swing.JFrame implements FightEventListner<T> {
    /**
     * Creates new form BattleFrame
     */
    private HashMap<Unit,Boolean> turnMap = new HashMap<>();
    private nextCharacter nextCharacter;

    public BattleFrame(List<MainUnit> character) {
        initComponents();
        GameManager.getInstance().subscribeFightListner(this);
        FightManager.getInstance().subscribeFightListner(this);
        List<NormalEnemy> enemies = new RandomEnemiesForARoomFactory().normalEnemiesRandomGenerator();
        addAlly(character);
        addEnemy(enemies);
        turnMap = FightManager.getInstance().getNextTurnCharacters();
        Unit unit1 = turnMap.keySet().stream().findFirst().get();
        Boolean b = turnMap.get(unit1);
        nextCharacter = new nextCharacter(unit1,b);
        FightManager.getInstance().setCurrentCharacter(nextCharacter.unit());
        GameManager.getInstance().giveTurn(nextCharacter.unit(), nextCharacter.isAlly());
        invalidate();
        validate();
        repaint();
        setVisible(true);

    }
//MAYBE HERE
    public void goNextRound(){
        turnMap.remove(turnMap.keySet().stream().findFirst().get());
        if (turnMap.isEmpty()){
            turnMap = FightManager.getInstance().getNextTurnCharacters();
        }
        nextCharacter = new nextCharacter(turnMap.keySet().stream().findFirst().get(),turnMap.get(turnMap.keySet().stream().findFirst().get()));
        GameManager.getInstance().giveTurn(nextCharacter.unit(), nextCharacter.isAlly());

    }

    public void setEnemiesBackground(Skill.TargetType type){

    }
    public boolean isAlly(Unit unit){
        return turnMap.get(unit);
    }
    public static void startTurn(){
        FightManager.getInstance().getNextTurnCharacters();
    }

    private void addAlly(List<MainUnit> character) {
        for (int i = 0; i < character.size(); i++) {
            jPanelContainerPersonalCharacters.add(new CharacterPanel(character.get(i),true));
            FightManager.getInstance().addAlly(character.get(i));

        }
    }

    private void addEnemy(List<NormalEnemy> enemies) {
        for (int i = 0; i < enemies.size(); i++) {
            jPanelContainer.add(new CharacterPanel(enemies.get(i),false));
            FightManager.getInstance().addEnemy(enemies.get(i));
        }

    }

    public Fightable getCurrentCharacter(){
        return (Fightable) turnMap.keySet().stream().findFirst().get();
    }
    public BattleFrame(){
        initComponents();
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
        jPanelContainer = new javax.swing.JPanel();
        jPanelContainerPersonalCharacters = new javax.swing.JPanel();
        jPanelCharacterOption = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 4, 5, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 0));

        jPanelContainer.setLayout(new java.awt.GridLayout(1, 4));

        jPanelContainerPersonalCharacters.setLayout(new java.awt.GridLayout(1, 0));

        jPanelCharacterOption.setLayout(new java.awt.GridLayout(4, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                    .addComponent(jPanelContainerPersonalCharacters, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanelCharacterOption, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanelContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelContainerPersonalCharacters, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(jPanelCharacterOption, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(118, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelCharacterOption;
    private javax.swing.JPanel jPanelContainer;
    private javax.swing.JPanel jPanelContainerPersonalCharacters;
    // End of variables declaration//GEN-END:variables
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
            java.util.logging.Logger.getLogger(BattleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BattleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BattleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BattleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BattleFrame().setVisible(true);
            }
        });
    }


    @Override
    public void getNextTurns(Unit unit, Boolean isally) {
         if (unit instanceof Fightable){
            if(unit instanceof MainUnit mainCharacter) {
                for (Skill skill : mainCharacter.getSkills()) {
                    jPanelCharacterOption.add(new InteractionPanel(skill));
                }
            }
            if (unit instanceof Enemy) {
                //call next turn
                goNextRound();
            }
        }
    }



    @Override
    public void setTarget(Target target) {

    }

    @Override
    public void resetTarget(Target target) {

    }

    @Override
    public Boolean isInteractionActive() {
        return false;
    }

    @Override
    public Optional<Skill<T>> getActiveInteraction() {
        return Optional.empty();
    }

    @Override
    public void startTurn(Unit unit, Boolean isally) {
        this.nextCharacter = new nextCharacter(unit,isally);
        goNextRound();
    }


    public void resetInteraction() {
        jPanelCharacterOption.removeAll();
        jPanelCharacterOption.revalidate();
        jPanelCharacterOption.repaint();
    }
}
