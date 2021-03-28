package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class ScrollObtained implements CollisionListener {

    private Samurai game;
    public ScrollObtained(Samurai s){
        this.game = s;
    }


    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Scrolls) {
            game.addScroll();
            e.getOtherBody().destroy();
        }


    }



    }




