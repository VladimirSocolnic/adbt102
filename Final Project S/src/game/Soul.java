package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Soul extends DynamicBody {
    private static final Shape soulDim = new CircleShape(2);
    private static SoundClip NextInst;
    static {
        try {
            NextInst = new SoundClip("data/soul.wav");
            System.out.println("Loading soul sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

    }

    private static final BodyImage image =
            new BodyImage("data/soul.png", 4f);
    public Soul(World w) {
        super(w, soulDim);
        addImage(image);
    }

    @Override
    public void destroy()
    {
        NextInst.play();
        super.destroy();
    }

}

