package model;

import sound.MidiSynth;

import java.awt.*;

public class Rectangle extends Shape {

    public Rectangle(Point topLeft, MidiSynth midiSynth){
        super(topLeft, midiSynth);
        instrument = 0;
        PLAYING_COLOR = new Color(230, 158, 60);
    }

    public Rectangle(int x, int y, int w, int h){
        super(x, y, w, h);
    }

    // EFFECTS: return true if the given Point (x,y) is contained within the bounds of this Shape
    @Override
    public boolean contains(Point point) {
        int point_x = point.x;
        int point_y = point.y;

        return containsX(point_x) && containsY(point_y);
    }

    //EFFECTS: draws the shape
    @Override
    public void drawGraphics(Graphics g) {
        g.drawRect(x, y, width, height);
    }

    //EFFECTS: fills the shape
    @Override
    public void fillGraphics(Graphics g) {
        g.fillRect(x, y, width, height);
    }


}
