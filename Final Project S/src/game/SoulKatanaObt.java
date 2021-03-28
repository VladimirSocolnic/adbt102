package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class SoulKatanaObt implements CollisionListener {

    private Samurai game;
    public SoulKatanaObt(Samurai s){
        this.game = s;
    }


    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof SoulKatana) {
            e.getOtherBody().destroy();
        }


    }



    }




