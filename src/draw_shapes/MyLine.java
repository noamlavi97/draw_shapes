package draw_shapes;
import java.lang.Math;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyLine extends MyShape {
    
    //Constructor
    public MyLine (int x1, int y1, int x2, int y2, Color color, GraphicsContext shapeGC) {
        super(x1, y1, x2, y2, color, shapeGC);
    }
    
    //A method that calculates the length of the shape
    public double lineLength(){
        return Math.sqrt(Math.pow(super.GetX2()-super.GetX1(),2)+Math.pow(super.GetY2()-super.GetY2(),2));
    }

    //Override the equals method
    @Override
    public boolean equals(Object o) {
        //If this is the very same object
        if (o == this) {
            return true;
        }
        // Check if o is an instance of MyLine or not (if it is a bounded shape the result will be false)
        if (!(o instanceof MyLine)) {
            return false;
        }
        //Typecast o to MyLine in order to compare the values inside
        MyLine m = (MyLine) o;
        //Compare the data members and return accordingly
        return m.lineLength()==this.lineLength();
    }
    
    //Draw the line
    public void drawLine () {
        GraphicsContext lineGC=super.GetShapeGC();
        lineGC.setStroke(super.GetColor());
        lineGC.setLineWidth(super.LINE_WIDTH);
        lineGC.strokeLine(super.GetX1(), super.GetY1(), super.GetX2(), super.GetY2());
    }
}
