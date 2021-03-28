package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class SenseMeeting implements CollisionListener {

    private GameFundamentation level;
    private Game game;

    public SenseMeeting(GameFundamentation level, Game game){
        this.level = level;
        this.game = game;
    }
    @Override
    public void collide(CollisionEvent e) {
        //if student collided with professor and the
        //conditions for completing the level are fulfilled
        //goToNextLevel
        if (e.getOtherBody() instanceof Sensei
                && level.isComplete()){
            game.goToNextLevel();
        }
    }
}
