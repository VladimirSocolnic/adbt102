package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class MesObt implements CollisionListener {

    private Samurai game;
    public MesObt(Samurai s){
        this.game = s;
    }


    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof MesBird) {
            e.getOtherBody().destroy();
        }


    }



    }




