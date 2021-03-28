package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class InvSignObt implements CollisionListener {

    private Samurai game;
    public InvSignObt(Samurai s){
        this.game = s;
    }


    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof InvSign) {
            e.getOtherBody().destroy();
        }


    }



    }




