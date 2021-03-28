package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class MesBird extends DynamicBody {
    private static final Shape MesBirdDim = new CircleShape(2);
    private static SoundClip MessageToSens;
    static {
        try {
            MessageToSens = new SoundClip("data/GoToSens.wav");
            System.out.println("Loading Message 1 sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    private static final BodyImage image =
            new BodyImage("data/mes.png", 4f);
    public MesBird(World w) {
        super(w, MesBirdDim);
        addImage(image);
    }

    @Override
    public void destroy()
    {
        MessageToSens.play();
        super.destroy();
    }

}

