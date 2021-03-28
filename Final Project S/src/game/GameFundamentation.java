package game;

import city.cs.engine.World;

public abstract class GameFundamentation extends World {
    private Samurai Samurai;
    private Sensei Sensei;

    public GameFundamentation(Game game){
        //all levels have a student, a professor
        //and the student needs to reach the professor
        //to complete the game (hence a ProfessorEncounter)
        Samurai = new Samurai(this);
        Sensei = new Sensei(this);
        SenseMeeting encounter = new SenseMeeting(this, game);
        Samurai.addCollisionListener(encounter);

    }

    public Samurai getSamurai(){
        return Samurai;
    }
    public Sensei getSensei(){
        return Sensei;
    }
    public abstract boolean isComplete();

}
