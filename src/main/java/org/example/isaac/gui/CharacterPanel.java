/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.example.isaac.gui;

import org.example.isaac.Logger;
import org.example.isaac.TODO;
import org.example.isaac.events.CharactersEventListner;
import org.example.isaac.events.FightEventListner;
import org.example.isaac.manager.FightManager;
import org.example.isaac.manager.GameManager;
import org.example.isaac.models.characters.interactions.impl.WeaponAttackAttack;
import org.example.isaac.models.characters.interactions.type.Interaction;
import org.example.isaac.models.characters.type.Unit;
import org.example.isaac.models.characters.type.Enemy;
import org.example.isaac.models.characters.type.MainUnit;
import org.example.isaac.models.characters.Target;
import org.example.isaac.models.characters.interactions.Skill;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;

/**
 * @author trapa
 */
public class CharacterPanel<T extends Unit> extends javax.swing.JPanel implements FightEventListner<T>, CharactersEventListner<T> {
    private T unit;
    private String characterImgPath;
    private Boolean isAlly;




    @Override
    public void getNextTurns(Unit unit, Boolean isally) {
        if (unit.equals(this.unit)) {
            boolean use;
            if (!isally) {
                for (Enemy enemy : FightManager.getInstance().getEnemies()) {
                    if (enemy.equals(this.unit)) {
                        List<Interaction> toRemove = new ArrayList<>();
                        for (Interaction<? extends Unit> activeInteraction : FightManager.getInstance().getActiveInteractionsOnUnit(enemy)) {
                            use = activeInteraction.use();
                            if (!use||activeInteraction instanceof WeaponAttackAttack<? extends Unit>){
                                toRemove.add(activeInteraction);
                            }
                        }
                        for (Interaction<? extends Unit> interactionToRemove : toRemove) {
                            deleteInteractionPanel(interactionToRemove);
                            FightManager.getInstance().removeInteractionFromCharacter(this.unit, interactionToRemove);
                        }
                    }
                }
            }
            if (isally) {
                for (MainUnit mainUnit : FightManager.getInstance().getAllies()) {
                    if (mainUnit.equals(this.unit)) {
                        List<Interaction> toRemove = new ArrayList<>();
                        for (Interaction<? extends Unit> activeInteraction :FightManager.getInstance().getActiveInteractionsOnUnit(mainUnit)) {
                            use = activeInteraction.use();
                            if (!use ||activeInteraction instanceof WeaponAttackAttack<? extends Unit>){
                                toRemove.add(activeInteraction);
                            }
                        }
                        for (Interaction<? extends Unit> interactionToRemove : toRemove) {
                            deleteInteractionPanel(interactionToRemove);
                            FightManager.getInstance().removeInteractionFromCharacter(this.unit, interactionToRemove);
                        }
                    }
                }
            }
            this.jLabelCharacterHealth.setText(unit.getCurrentHealth() + "/" + unit.getMaxHealth());
            this.jPanelCharacterImg.invalidate();
            this.jPanelCharacterImg.revalidate();
            this.jPanelCharacterImg.repaint();
        }
    }


    @Override
    public void setTarget(Target target) {
        if (target.target().equals(this.unit)) {
            this.jPanelCharacterImg.setBackground(Color.RED);
        }
    }

    @Override
    public void resetTarget(Target target) {
        if (target.target().equals(this.unit)) {
            // set background to transparent
            this.jPanelCharacterImg.setBackground(null);
        }
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
        // not used be this class does not need to do anything on start turn
    }


    /**
     * Creates new form JPanelEnemy
     */

    public CharacterPanel() {
        initComponents();
    }

    public CharacterPanel(T unit, Boolean isAlly) {
        this.isAlly = isAlly;
        initComponents();
        this.unit = unit;
        GameManager.getInstance().subscribeFightListner(this);
        FightManager.getInstance().subscribeFightListner(this);
        FightManager.getInstance().subscribePanelListner(this);
        this.characterImgPath = unit.getAvatarPath();
        Logger.getInstance().log(characterImgPath);
        Image image = new ImageIcon(CharacterPanel.class.getResource(characterImgPath)).getImage();
        this.jLabelCharacterImg.setIcon(new ImageIcon(image));
        jLabelCharacterHealth.setText("" + unit.getCurrentHealth() + " / " + unit.getMaxHealth());
        jLabelCharacterName.setText(unit.getName());
        this.invalidate();
        this.validate();
        this.repaint();
    }

    @Override
    public void setInteractionsCharacters(Interaction<T> interaction1) {
        Interaction<T> interaction;
        try {
            interaction = interaction1.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        if ((!isAlly && interaction.getTargetType() == Skill.TargetType.ENEMYTEAM)) {
            jPanelContainerCurrentEffects.add(new StatusPanel<>(interaction));
            FightManager.getInstance().setInteractionToCharacter(this.unit, interaction);
        }
        if (isAlly && interaction.getTargetType() == Skill.TargetType.ALLYTEAM) {
            jPanelContainerCurrentEffects.add(new StatusPanel<>(interaction));
            FightManager.getInstance().setInteractionToCharacter(this.unit, interaction);
        }
        if (interaction.getTargetType() == Skill.TargetType.SELF && unit == FightManager.getInstance().getCurrentCharacter()) {
            jPanelContainerCurrentEffects.add(new StatusPanel<>(interaction));
            FightManager.getInstance().setInteractionToCharacter(this.unit, interaction);
        }
        if (interaction.getTargetType() == Skill.TargetType.ALL) {
            jPanelContainerCurrentEffects.add(new StatusPanel<>(interaction));
            FightManager.getInstance().setInteractionToCharacter(this.unit, interaction);
        }
        if (interaction.getTargetType() == Skill.TargetType.ENEMY && !isAlly && FightManager.getInstance().getClickedUnit() == this.unit) {
            jPanelContainerCurrentEffects.add(new StatusPanel<>(interaction));
            FightManager.getInstance().setInteractionToCharacter(this.unit, interaction);
        }
        if (interaction.getTargetType() == Skill.TargetType.DEAD && this.unit.getCurrentHealth() < 0) {
            jPanelContainerCurrentEffects.add(new StatusPanel<>(interaction));
            FightManager.getInstance().setInteractionToCharacter(this.unit, interaction);
        }
        this.jLabelCharacterHealth.setText(unit.getCurrentHealth() + "/" + unit.getMaxHealth());
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
        jPanelContainerCurrentEffects = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 51));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jPanelCharacterImg.setBackground(new java.awt.Color(255, 255, 0));

        javax.swing.GroupLayout jPanelCharacterImgLayout = new javax.swing.GroupLayout(jPanelCharacterImg);
        jPanelCharacterImg.setLayout(jPanelCharacterImgLayout);
        jPanelCharacterImgLayout.setHorizontalGroup(
                jPanelCharacterImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelCharacterImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelCharacterImgLayout.setVerticalGroup(
                jPanelCharacterImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelCharacterImg, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
        );

        jLabelCharacterHealth.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabelCharacterHealth.setForeground(new java.awt.Color(0, 0, 255));
        jLabelCharacterHealth.setText("jLabel1");

        jLabelCharacterName.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabelCharacterName.setForeground(new java.awt.Color(255, 0, 0));
        jLabelCharacterName.setText("jLabel1");

        jPanelContainerCurrentEffects.setBackground(null);
        jPanelContainerCurrentEffects.setOpaque(false);
        jPanelContainerCurrentEffects.setLayout(new java.awt.GridLayout(1, 10));

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
                        .addComponent(jPanelContainerCurrentEffects, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanelCharacterImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jLabelCharacterName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelCharacterHealth, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanelContainerCurrentEffects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private boolean ifTrueUseSkill(Skill.TargetType targetType, List<Interaction<T>> interactions) {
        switch (targetType) {
            case SELF -> {
                if (this.unit == FightManager.getInstance().getClickedUnit()) {
                    for (Interaction<T> interaction : interactions) {
                         interaction.getTargets().add(this.unit);
                        FightManager.getInstance().setInteraction(interaction);
                    }
                    return true;
                }
            }
            case ENEMY, ENEMYTEAM -> {
                if (this.unit instanceof Enemy) {
                    System.out.println("[DEBUG] Enemy clicked");
                    for (Interaction<T> interaction : interactions) {
                        FightManager.getInstance().setInteraction(interaction);
                    }
                    return true;
                } else {
                    System.out.println("[DEBUG] Clicked SomeOne that Isnt an enemy");
                    return false;
                }
            }
            case DEAD -> {
                if (this.unit.getCurrentHealth() < 0 && FightManager.getInstance().getClickedUnit() == this.unit) {
                    for (Interaction<T> interaction : interactions) {
                        FightManager.getInstance().setInteraction(interaction);
                    }
                }
            }
            case ALLYTEAM -> {
                if (this.unit instanceof MainUnit) {
                    System.out.println("[DEBUG] ally clicked");
                    for (Interaction<T> interaction : interactions) {
                        FightManager.getInstance().setInteraction(interaction);
                    }
                    return true;
                } else {
                    System.out.println("[DEBUG] Clicked SomeOne that Isnt an ally");
                    return false;
                }
            }
            case ALL -> {
                for (Interaction<T> interaction : interactions) {
                    FightManager.getInstance().setInteraction(interaction);
                }
                return true;
            }
        }
        return false;
    }

    @TODO(todo = "aggiungere la logica dietro gli attacchi")
    private boolean useSkill(Skill<T> skill) {
        FightManager.getInstance().setClickedUnit(this.unit);
        List<Interaction<T>> interactions = skill.getInteractions();
        boolean clicked;
        Skill.TargetType targetType = interactions.get(0).getTargetType();
        clicked = ifTrueUseSkill(targetType, interactions);
        /*removeInteractionsWith0turns();*/
        if (clicked) {
            FightManager.getInstance().resetInteractions();
            return true;
        }
        return false;
    }
    private void deleteInteractionPanel(Interaction<? extends Unit> interaction) {
        for (int i = this.jPanelContainerCurrentEffects.getComponentCount() - 1; i >= 0; i--) {
            Component component = this.jPanelContainerCurrentEffects.getComponent(i);
            if (component instanceof StatusPanel statusPanel && statusPanel.checkInteraction(interaction)) {
                this.jPanelContainerCurrentEffects.remove(component);
            }
        }
    }
   /* private void removeInteractionsWith0turns() {
        for (int i = this.jPanelContainerCurrentEffects.getComponentCount() - 1; i >= 0; i--) {
            Component component = this.jPanelContainerCurrentEffects.getComponent(i);
            if (component instanceof StatusPanel statusPanel && statusPanel.checkInteraction(interaction)) {
                this.jPanelContainerCurrentEffects.remove(component);
            }
        }
    }*/

    private void formMouseClicked(MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        Optional<Skill<T>> currentskillTargetActive = FightManager.getInstance().getCurrentSkillActive();

        if (currentskillTargetActive.isPresent()) {
            Skill<T> skill = currentskillTargetActive.get();
            boolean b = useSkill(skill);
            if (b) {
                FightManager.getInstance().reset();
                FightManager.getInstance().callNextTurn();
            }
        } else {
            System.out.println("[DEBUG] No skill active");
        }

    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelCharacterHealth;
    private javax.swing.JLabel jLabelCharacterImg;
    private javax.swing.JLabel jLabelCharacterName;
    private javax.swing.JPanel jPanelCharacterImg;
    private javax.swing.JPanel jPanelContainerCurrentEffects;


    // End of variables declaration//GEN-END:variables

}
