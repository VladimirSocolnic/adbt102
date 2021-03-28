package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

public class GamePerspective extends UserView {
    private Image background;
    private Game game;
    public GamePerspective(World w, Game g, int width, int height) {
        super(w, width, height);
        background = new ImageIcon("data/bg1.jpg").getImage();
        game = g;



    }

    @Override
    protected void paintBackground(Graphics2D g) {

        g.drawImage(background, 0, 0, this);
    }





}
