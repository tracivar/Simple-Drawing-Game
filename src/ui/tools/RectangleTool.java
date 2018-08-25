package ui.tools;

import model.Oval;
import model.Rectangle;
import model.Shape;
import ui.DrawingEditor;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class RectangleTool extends ShapeTool{

    private Rectangle rectangle;

    public RectangleTool(DrawingEditor editor, JComponent parent){
        super(editor, parent);
        rectangle = null;
    }

    // MODIFIES: this
    // EFFECTS:  a shape is instantiate MouseEvent occurs, and played and
    //           added to the editor's drawing
    @Override
    public void mousePressedInDrawingArea(MouseEvent e) {
        makeShape(e);
        rectangle.selectAndPlay();
        rectangle.setBounds(e.getPoint());
        editor.addToDrawing(rectangle);
    }

    // MODIFIES: this
    // EFFECTS:  unselects this shape, and sets it to null
    @Override
    public void mouseReleasedInDrawingArea(MouseEvent e) {
        rectangle.unselectAndStopPlaying();
        rectangle = null;
    }

    // MODIFIES: this
    // EFFECTS:  sets the bounds of thes shape to where the mouse is dragged to
    @Override
    public void mouseDraggedInDrawingArea(MouseEvent e) {
        rectangle.setBounds(e.getPoint());
    }

    //EFFECTS: Constructs and returns the new shape
    @Override
    public void makeShape(MouseEvent e) {
        rectangle = new Rectangle(e.getPoint(), editor.getMidiSynth());
    }

    //EFFECTS: Returns the string for the label.
    @Override
    public String getLabel() {
        return "Rectangle";
    }

}
