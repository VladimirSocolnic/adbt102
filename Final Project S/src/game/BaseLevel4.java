package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import java.awt.*;

public class BaseLevel4 extends GameFundamentation {

    public BaseLevel4(Game game){
        //the base class will create the student, professor
        //and the ProfessorEncounter
        super(game);

        //we still need to set the positions of the student
        //and professor
        getSamurai().setPosition(new Vec2(-20, 15 ));
        getSensei().setPosition(new Vec2(-25,-15));

        //we're setting up BooksPickup here though we could
        //also add it to the GameLevel class
        getSamurai().addCollisionListener(new ScrollObtained(getSamurai()));
        getSamurai().addCollisionListener(new SoulObt(getSamurai()));
        getSamurai().addCollisionListener(new ShinElim(getSamurai()));
        getSamurai().addCollisionListener(new MesObt(getSamurai()));
        getSamurai().addCollisionListener(new InvSignObt(getSamurai()));
        getSamurai().addCollisionListener(new SecMonolObt(getSamurai()));

        getSamurai().addCollisionListener(new RunStoneObt(getSamurai()));

        getSamurai().addCollisionListener(new SoulKatanaObt(getSamurai()));

        // make the ground
        Shape shape = new BoxShape(25, 0.4f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(55, 60));


        ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(-5, 12));
        ground.setFillColor(Color.gray);

        shape = new BoxShape(5, 0.5f);
        ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(25, 5));

        shape = new BoxShape(2, 0.5f);
        ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(18, 4));

        ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(15, 3));

        ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(12, 2));

        ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(9, 1));

        ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(6, 0));

        ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(3, -1));

        shape = new BoxShape(13, 0.5f);
        ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(-10, -2));


        shape = new BoxShape(25, 0.5f);
        ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(-10, -10));

        shape = new BoxShape(55, 0.5f);
        ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(-10, -17));



        // make some walls
        Shape wallShape = new BoxShape(0.5f, 6);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(999, 290));


        wallShape = new BoxShape(0.5f, 100);
        wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-31, 11));


        wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(31, 11));



        for (int i=0; i<1; i++){
            Shinoby enemy = new Shinoby(this);
            enemy.setPosition(new Vec2(10,-8));

            enemy = new Shinoby(this);
            enemy.setPosition(new Vec2(25,8));
        }




        for (int i=0; i<1; i++){
            RunStone signs = new RunStone(this);
            signs.setPosition(new Vec2(-10,0));
        }

        for (int i=0; i<1; i++){
            SoulKatana signs = new SoulKatana(this);
            signs.setPosition(new Vec2(25,-15));
        }

    }

    @Override
    public boolean isComplete() {
        if (getSamurai().getBookCount() == 0)
            return true;
        else
            return false;
    }
}