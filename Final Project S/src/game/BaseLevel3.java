package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import java.awt.*;

public class BaseLevel3 extends GameFundamentation {

    public BaseLevel3(Game game){
        //the base class will create the student, professor
        //and the ProfessorEncounter
        super(game);

        //we still need to set the positions of the student
        //and professor
        getSamurai().setPosition(new Vec2(0, 14 ));
        getSensei().setPosition(new Vec2(25,-15));

        //we're setting up BooksPickup here though we could
        //also add it to the GameLevel class
        getSamurai().addCollisionListener(new ScrollObtained(getSamurai()));

        getSamurai().addCollisionListener(new SoulObt(getSamurai()));
        getSamurai().addCollisionListener(new ShinElim(getSamurai()));
        getSamurai().addCollisionListener(new MesObt(getSamurai()));
        getSamurai().addCollisionListener(new InvSignObt(getSamurai()));
        getSamurai().addCollisionListener(new SecMonolObt(getSamurai()));

        // make the ground
        Shape shape = new BoxShape(20, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(55, 60));
        ground.setFillColor(Color.white);

        ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0, 13));
        ground.setFillColor(Color.white);

        shape = new BoxShape(30, 0.5f);
        ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(10, 5));
        ground.setFillColor(Color.white);

        ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(-10, -2));
        ground.setFillColor(Color.white);



        shape = new BoxShape(30, 0.5f);
        ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(10, -10));
        ground.setFillColor(Color.white);

        ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0, -18));
        ground.setFillColor(Color.white);



        // make some walls
        Shape wallShape = new BoxShape(0.5f, 6);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-19, 20));
        wall1.setFillColor(Color.white);

        wallShape = new BoxShape(0.5f, 100);
        wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-31, 11));
        wall1.setFillColor(Color.white);

        wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(31, 11));
        wall1.setFillColor(Color.white);





        //create some pickups (Scrolls)
        for (int i=0; i<1; i++){
            Scrolls scroll = new Scrolls(this);
            scroll.setPosition(new Vec2(-17,15));

            scroll = new Scrolls(this);
            scroll.setPosition(new Vec2(-28,2));

            scroll = new Scrolls(this);
            scroll.setPosition(new Vec2(-20,2));

            scroll = new Scrolls(this);
            scroll.setPosition(new Vec2(5,0));
        }



        for (int i=0; i<1; i++){
            Shinoby enemy = new Shinoby(this);
            enemy.setPosition(new Vec2(0,0));

            enemy = new Shinoby(this);
            enemy.setPosition(new Vec2(10,0));

            enemy = new Shinoby(this);
            enemy.setPosition(new Vec2(25,8));
        }

        for (int i=0; i<1; i++){
            Soul signs = new Soul(this);
            signs.setPosition(new Vec2(25,-8));
        }



    }

    @Override
    public boolean isComplete() {
        if (getSamurai().getBookCount() == 4) //2
            return true;
        else
            return false;
    }
}