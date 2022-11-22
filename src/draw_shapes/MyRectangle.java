package draw_shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyRectangle extends MyBoundedShape {
    
    //Constructor
    public MyRectangle (int x1, int y1, int x2, int y2, Color color, GraphicsContext shapeGC, Boolean isFull) {
        super(x1, y1, x2, y2, color, shapeGC);
        super.SetIsFull(isFull);
    }

    //Override the equals method
    @Override
    public boolean equals(Object o) {
        //If this is the very same object
        if (o == this) {
            return true;
        }
        // Check if o is an instance of MyRectangle or not (if it is a non-bounded shape the result will be false)
        if (!(o instanceof MyRectangle)) {
            return false;
        }
        //Typecast o to MyRectangle in order to compare the values inside
        MyRectangle m = (MyRectangle) o;
        //Compare the data members and return accordingly
        return (m.GetX2()==this.GetX2())&&(m.GetY2()==this.GetY2());
    }
    
    //Draw the rectangle
    public void drawRectangle () {
        GraphicsContext shapeGC=super.GetShapeGC();
        shapeGC.setStroke(super.GetColor());
        shapeGC.setLineWidth(super.LINE_WIDTH);
        shapeGC.setFill(super.GetColor());

        if(super.GetIsFull()) {
            shapeGC.fillRect(super.GetX1(), super.GetY1(), super.GetX2(), super.GetY2());
        }
        else {
            shapeGC.strokeRect(super.GetX1(), super.GetY1(), super.GetX2(), super.GetY2());
        }
    }
}