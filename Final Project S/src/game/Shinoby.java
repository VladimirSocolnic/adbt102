package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Shinoby extends DynamicBody {
    private static final Shape ShinDim = new CircleShape(2);
    private static SoundClip ShinElim;
    static {
        try {
            ShinElim = new SoundClip("data/el.wav");
            System.out.println("Loading kill sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    private static final BodyImage image =
            new BodyImage("data/shin.png", 5.5f);
    public Shinoby(World w) {
        super(w, ShinDim);
        addImage(image);
    }

    @Override
    public void destroy()
    {
        ShinElim.play();
        super.destroy();
    }

}

