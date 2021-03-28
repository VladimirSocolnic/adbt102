package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SamCont implements KeyListener {

    private static final float WALKING_SPEED = 10;

    private Samurai student;

    public SamCont(Samurai s){
        student = s;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        // other key commands omitted
        if (code == KeyEvent.VK_1) {
            student.startWalking(-WALKING_SPEED);
        } else if (code == KeyEvent.VK_2) {
            student.startWalking(WALKING_SPEED);
        }
        else if (code == KeyEvent.VK_J){
            student.jump(20);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_1) {
            student.stopWalking();
        } else if (code == KeyEvent.VK_2) {
            student.stopWalking();
        }
    }

    public void updateStudent(Samurai student){
        this.student = student;
    }
}
