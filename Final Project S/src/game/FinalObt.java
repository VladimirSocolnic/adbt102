package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class FinalObt implements CollisionListener {

    private Samurai game;
    public FinalObt(Samurai s){
        this.game = s;
    }


    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Final) {
            e.getOtherBody().destroy();
        }


    }



    }




