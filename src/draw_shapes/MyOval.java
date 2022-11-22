package draw_shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyOval extends MyBoundedShape {
    
    //Constructor
    public MyOval (int x1, int y1, int x2, int y2, Color color, GraphicsContext shapeGC, Boolean isFull) {
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
        // Check if o is an instance of MyOval or not (if it is a non-bounded shape the result will be false)
        if (!(o instanceof MyOval)) {
            return false;
        }
        //Typecast o to MyOval in order to compare the values inside
        MyOval m = (MyOval) o;
        //Compare the data members and return accordingly
        return (m.GetX2()==this.GetX2())&&(m.GetY2()==this.GetY2());
    }
    
    //Draw the oval
    public void drawOval() {
        GraphicsContext shapeGC=super.GetShapeGC();
        shapeGC.setStroke(super.GetColor());
        shapeGC.setLineWidth(super.LINE_WIDTH);
        shapeGC.setFill(super.GetColor());

        if(super.GetIsFull()) {
            shapeGC.fillOval(super.GetX1(), super.GetY1(), super.GetX2(), super.GetY2());
        }
        else {
            shapeGC.strokeOval(super.GetX1(), super.GetY1(), super.GetX2(), super.GetY2());
        }
    }
}