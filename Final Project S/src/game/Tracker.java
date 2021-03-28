package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

public class Tracker implements StepListener {
    private GamePerspective view;
    private Samurai student;
    public Tracker(GamePerspective view, Samurai student) {
        this.view = view;
        this.student = student;
    }
    public void preStep(StepEvent e) {}
    public void postStep(StepEvent e) {
        view.setCentre(new Vec2(student.getPosition()));
    }
}