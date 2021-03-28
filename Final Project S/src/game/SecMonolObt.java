package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class SecMonolObt implements CollisionListener {

    private Samurai game;
    public SecMonolObt(Samurai s){
        this.game = s;
    }


    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof SecMonol) {
            e.getOtherBody().destroy();
        }


    }



    }




