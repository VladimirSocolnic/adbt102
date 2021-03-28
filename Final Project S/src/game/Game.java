package game;

import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import java.io.IOException;

/**
 * A world with some bodies.
 */
public class Game {

    /** The World in which the bodies move and interact. */
    private GameFundamentation level;

    /** A graphical display of the world (a specialised JPanel). */
    private GamePerspective view;

    private SamCont controller;

    private int ScrollCount;

    private SoundClip gameMusic;

    public void addScroll (){
        ScrollCount = ScrollCount + 1;
    }

    public int getScrollCount(){

        return ScrollCount;

    }



    /** Initialise a new Game. */
    public Game() {

        try {
            gameMusic = new SoundClip("data/music1.wav");   // Open an audio input stream
            gameMusic.loop();  // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        // initialize level to Level1
        level = new BaseLevel1(this);

        // make a view
        view = new GamePerspective(level, this, 1200, 800);
        view.setZoom(20);

        // uncomment this to draw a 1-metre grid over the view
        // view.setGridResolution(1);

        controller = new SamCont(level.getSamurai());
        view.addKeyListener(controller);

        view.addMouseListener(new GiveFocus(view));

        //world.addStepListener(new Tracker(view, world.getStudent()));

        // add the view to a frame (Java top level window)
        final JFrame frame = new JFrame("Basic world");




        frame.add(view);
        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        //ControlPanel buttons = new ControlPanel();
        //window.add(buttons, BorderLayout.WEST);

        // uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(world, 500, 500);

        // start our game world simulation!
        level.start();
    }

    public void goToNextLevel(){

        if (level instanceof BaseLevel5) {
            //stop the current level
            level.stop();
            //create the new (appropriate) level
            //level now refers to new level
            level = new BaseLevel6(this);
            //change the view to look into new level
            view.setWorld(level);
            //change the controller to control the
            //student in the new world
            controller.updateStudent(level.getSamurai());
            //start the simulation in the new level
            level.start();
        }


        if (level instanceof BaseLevel4) {
            //stop the current level
            level.stop();
            //create the new (appropriate) level
            //level now refers to new level
            level = new BaseLevel5(this);
            //change the view to look into new level
            view.setWorld(level);
            //change the controller to control the
            //student in the new world
            controller.updateStudent(level.getSamurai());
            //start the simulation in the new level
            level.start();
        }

        if (level instanceof BaseLevel3){
            //stop the current level
            level.stop();
            //create the new (appropriate) level
            //level now refers to new level
            level = new BaseLevel4(this);
            //change the view to look into new level
            view.setWorld(level);
            //change the controller to control the
            //student in the new world
            controller.updateStudent(level.getSamurai());
            //start the simulation in the new level
            level.start();



        }

        if (level instanceof BaseLevel2){
            //stop the current level
            level.stop();
            //create the new (appropriate) level
            //level now refers to new level
            level = new BaseLevel3(this);
            //change the view to look into new level
            view.setWorld(level);
            //change the controller to control the
            //student in the new world
            controller.updateStudent(level.getSamurai());
            //start the simulation in the new level
            level.start();



        }

        if (level instanceof BaseLevel1){
            //stop the current level
            level.stop();
            //create the new (appropriate) level
            //level now refers to new level
            level = new BaseLevel2(this);
            //change the view to look into new level
            view.setWorld(level);
            //change the controller to control the
            //student in the new world
            controller.updateStudent(level.getSamurai());
            //start the simulation in the new level
            level.start();



        }



        else if (level instanceof BaseLevel6){
            System.out.println("Well done! Game complete.");
            System.exit(0);
        }






    }





    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }
}
