package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class SecMonol extends DynamicBody {
    private static final Shape SecMonolDim = new CircleShape(2);
    private static SoundClip SecondMonologue;
    static {
        try {
            SecondMonologue = new SoundClip("data/firstmonolog.wav");
            System.out.println("Loading second monologue sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    private static final BodyImage image =
            new BodyImage("data/firstsoul.png", 4f);
    public SecMonol(World w) {
        super(w, SecMonolDim);
        addImage(image);
    }

    @Override
    public void destroy()
    {
        SecondMonologue.play();
        super.destroy();
    }

}

