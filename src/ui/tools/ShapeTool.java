package ui.tools;


import model.Oval;
import model.Rectangle;
import model.Shape;
import ui.DrawingEditor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public abstract class ShapeTool extends Tool {
	//private Shape rectangle;

    public ShapeTool(DrawingEditor editor, JComponent parent) {
		super(editor, parent);
		//rectangle = null;
	}

    // MODIFIES: this
    // EFFECTS:  creates new button and adds to parent
	@Override
	protected void createButton(JComponent parent) {
		button = new JButton(getLabel());
		button = customizeButton(button);
	}

    // MODIFIES: this
    // EFFECTS:  associate button with new ClickHandler
	@Override
	protected void addListener() {
		button.addActionListener(new ShapeToolClickHandler());
	}

	// MODIFIES: this
    // EFFECTS:  a shape is instantiate MouseEvent occurs, and played and
    //           added to the editor's drawing
	@Override
	public void mousePressedInDrawingArea(MouseEvent e) {
		makeShape(e);
		//rectangle.selectAndPlay();
		//rectangle.setBounds(e.getPoint());
		//editor.addToDrawing(rectangle);
	}


	// MODIFIES: this
    // EFFECTS:  unselects this shape, and sets it to null
	@Override
	public abstract void mouseReleasedInDrawingArea(MouseEvent e);

	// MODIFIES: this
    // EFFECTS:  sets the bounds of thes shape to where the mouse is dragged to
	@Override
	public abstract void mouseDraggedInDrawingArea(MouseEvent e);

	//EFFECTS: Returns the string for the label.
	protected abstract String getLabel();

	//EFFECTS: Constructs and returns the new shape
	protected abstract void makeShape(MouseEvent e);

	private class ShapeToolClickHandler implements ActionListener {

		// EFFECTS: sets active tool to the shape tool
		//          called by the framework when the tool is clicked
    	@Override
		public void actionPerformed(ActionEvent e) {
			editor.setActiveTool(ShapeTool.this);
		}
	}
}

