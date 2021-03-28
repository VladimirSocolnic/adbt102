package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class RunStoneObt implements CollisionListener {

    private Samurai game;
    public RunStoneObt(Samurai s){
        this.game = s;
    }


    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof RunStone) {
            e.getOtherBody().destroy();
        }


    }



    }




