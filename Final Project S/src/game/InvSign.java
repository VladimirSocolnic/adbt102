package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class InvSign extends DynamicBody {
    private static final Shape InvisSignDim = new CircleShape(2);
    private static SoundClip MessageToSens;
    static {
        try {
            MessageToSens = new SoundClip("data/2mes.wav");
            System.out.println("Loading books sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    private static final BodyImage image =
            new BodyImage("data/sign.png", 4f);
    public InvSign(World w) {
        super(w, InvisSignDim);
        addImage(image);
    }

    @Override
    public void destroy()
    {
        MessageToSens.play();
        super.destroy();
    }

}

