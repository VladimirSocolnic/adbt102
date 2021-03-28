package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import java.awt.*;

public class BaseLevel6 extends GameFundamentation {

    public BaseLevel6(Game game){
        //the base class will create the student, professor
        //and the ProfessorEncounter
        super(game);

        //we still need to set the positions of the student
        //and professor
        getSamurai().setPosition(new Vec2(-25, 15 ));
        getSensei().setPosition(new Vec2(-20,15));

        //we're setting up BooksPickup here though we could
        //also add it to the GameLevel class

        getSamurai().addCollisionListener(new ScrollObtained(getSamurai()));
        getSamurai().addCollisionListener(new ShinElim(getSamurai()));
        getSamurai().addCollisionListener(new MesObt(getSamurai()));
        getSamurai().addCollisionListener(new InvSignObt(getSamurai()));





        // make the ground
        Shape shape = new BoxShape(11, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(55, 60));
        ground.setFillColor(Color.blue);

        ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(-20, 10));
        ground.setFillColor(Color.blue);

        ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0, 10));
        ground.setFillColor(Color.blue);

        ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(30, 10));
        ground.setFillColor(Color.blue);

        ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(20,0 ));
        ground.setFillColor(Color.blue);

        shape = new BoxShape(2, 0.5f);
        ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(7, -1));
        ground.setFillColor(Color.blue);

        ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(3, -2));
        ground.setFillColor(Color.blue);

        ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(-1, -3));
        ground.setFillColor(Color.blue);

        ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(-5, -4));
        ground.setFillColor(Color.blue);

        shape = new BoxShape(6, 0.5f);
        ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(-13, -5));
        ground.setFillColor(Color.blue);

        shape = new BoxShape(4, 0.5f);
        ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(-30, -5));
        ground.setFillColor(Color.blue);

        shape = new BoxShape(10, 0.5f);
        ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(-20, -13));
        ground.setFillColor(Color.blue);

        shape = new BoxShape(3, 0.5f);
        ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(-5, -14));
        ground.setFillColor(Color.blue);

        shape = new BoxShape(3, 0.5f);
        ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(2, -15));
        ground.setFillColor(Color.blue);

        shape = new BoxShape(12, 0.5f);
        ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(20, -16));
        ground.setFillColor(Color.blue);



        // make some walls
        Shape wallShape = new BoxShape(0.5f, 20f);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-31, -6));
        wall1.setFillColor(Color.blue);

        wallShape = new BoxShape(0.5f, 20f);
        wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(31, -6));
        wall1.setFillColor(Color.blue);



    }
    @Override
    public boolean isComplete() {
        if (getSamurai().getBookCount() == 0)
            return true;
        else
            return false;
    }
}
