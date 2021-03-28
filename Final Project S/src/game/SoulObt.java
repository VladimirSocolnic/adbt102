package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class SoulObt implements CollisionListener {

    private Samurai game;
    public SoulObt(Samurai s){
        this.game = s;
    }


    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Soul) {
            e.getOtherBody().destroy();
        }


    }



    }




