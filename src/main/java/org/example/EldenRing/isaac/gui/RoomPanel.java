/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.example.EldenRing.isaac.gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import org.example.EldenRing.isaac.TODO;
import org.example.EldenRing.isaac.events.GameEventListner;
import org.example.EldenRing.isaac.manager.GameManager;
import org.example.EldenRing.isaac.models.characters.type.Enemy;
import org.example.EldenRing.isaac.models.characters.type.MainUnit;
import org.example.EldenRing.isaac.piano.Piano;
import org.example.EldenRing.isaac.rooms.fight.NormalFightingBehaviour;
import org.example.EldenRing.isaac.rooms.models.Room;
import org.example.EldenRing.isaac.RoomCoordinates;

/**
 * @author trapa
 */
public class RoomPanel extends javax.swing.JPanel implements GameEventListner {
    private Color originalcolor;
    private boolean starterRoom = false;
    private RoomCoordinates roomCoordinates;
    private Room roomtype;
    private Boolean visited = false;
    private List<MainUnit> character;
    private List<Enemy> enemies;

    /**
     * Creates new form RoomPanel
     */
    public RoomPanel() {
        initComponents();
    }

    public RoomPanel(RoomCoordinates roomCoordinates, boolean starterRoom, Room roomtype,List<MainUnit> character) {
        initComponents();
        GameManager.getInstance().setFighting(false);
        this.roomCoordinates = roomCoordinates;
        this.roomtype=roomtype;
        this.starterRoom = starterRoom;
        if (this.starterRoom) {
            this.character = character;
            this.setBackground(Color.yellow);
            this.jLabel1.setText("X");
            this.visited = true;
        } else {
            this.setBackground(Color.darkGray);
            this.jLabel1.setText(roomCoordinates.row() + ", " + roomCoordinates.column());
        }
        GameManager.getInstance().subscribe4Rooms(this);

        this.jLabel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                RoomPanel.this.originalcolor = RoomPanel.this.getBackground();
                if (RoomPanel.this.getBackground().equals(Color.RED)||RoomPanel.this.getBackground().equals(Color.yellow)) {
                    return;
                }
                RoomPanel.this.setBackground(Color.green);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (originalcolor.equals(Color.yellow)||originalcolor.equals(Color.RED)) {
                    return;
                }
                if (visited) {
                    RoomPanel.this.setBackground(Color.gray);
                }else {
                    RoomPanel.this.setBackground(Color.darkGray);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("Mi voglio spostare in : " + roomCoordinates);
                if (GameManager.getInstance().isMoveValid(roomCoordinates) && !GameManager.getInstance().isFighting()) {
                    GameManager.getInstance().teleport(RoomPanel.this.roomCoordinates);
                }
                else{
                    System.out.println("move invalid");
                }
            }
        });

    }

    private void reset() {
        this.jLabel1.setText("");
        if (visited) {
            this.setBackground(Color.GRAY);
        }
        else {
            this.setBackground(Color.darkGray);
        }
    }

    public boolean isStarterRoom() {
        return starterRoom;
    }

    public RoomCoordinates getRoomCoordinates() {
        return roomCoordinates;
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

        setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setBackground(new java.awt.Color(0, 102, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;


    @Override
    public void newGame(Piano piano) {

    }

    @Override
    @TODO(todo="fare in modo che solo le stanze adiacenti vengano colorate di NON visitato")
    public void move(RoomCoordinates roomCoordinates){

        if (roomCoordinates.row() == this.roomCoordinates.row() && roomCoordinates.column() == this.roomCoordinates.column() && !this.isStarterRoom()&&!GameManager.getInstance().isFighting()  ) {
            this.setBackground(Color.RED);
            this.originalcolor = Color.red;
            this.jLabel1.setText("X");
            this.character = GameManager.getInstance().getCharacter();
            this.enteredRoom();

        } else {
            if (this.isStarterRoom() && roomCoordinates == this.roomCoordinates) {
                this.jLabel1.setText("X");
                this.character = GameManager.getInstance().getCharacter();
                return;
            }
            if (!this.isStarterRoom()) {
                reset();
            } else {
                this.jLabel1.setText("");
                this.character = null;
            }

            this.invalidate();
            this.revalidate();
            this.repaint();
        }
    }

    @Override
    public void enteredRoom() {


        if (!RoomPanel.this.visited && RoomPanel.this.roomtype.getFightingBehaviour() instanceof NormalFightingBehaviour) {
            System.out.println("STANZA CON NEMICI TEST");
            GameManager.getInstance().setFighting(true);
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new BattleFrame(character);
                }
            });

        }

        RoomPanel.this.visited = true;
    }

    @Override
    public void selectCharacter(List<MainUnit> character) {

    }


    // End of variables declaration//GEN-END:variables
}
