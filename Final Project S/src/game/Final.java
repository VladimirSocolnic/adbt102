package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Final extends DynamicBody {
    private static final Shape endsamDIM = new CircleShape(3);
    private static SoundClip endmes;
    static {
        try {
            endmes = new SoundClip("data/endsam.wav");
            System.out.println("Loading books sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    private static final BodyImage image =
            new BodyImage("data/samsam.png", 6f);
    public Final(World w) {
        super(w, endsamDIM);
        addImage(image);
    }

    @Override
    public void destroy()
    {
        endmes.play();
        super.destroy();
    }

}

