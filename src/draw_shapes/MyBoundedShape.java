package draw_shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class MyBoundedShape extends MyShape {

    private Boolean isFull;

    //Constructor
    public MyBoundedShape (int x1, int y1, int x2, int y2, Color color, GraphicsContext shapeGC) {
        super(x1, y1, x2, y2, color, shapeGC);
    }
    //Getter
    public Boolean GetIsFull() {
        return this.isFull;
    }
    //Setter
    public void SetIsFull(Boolean isFull) {
        this.isFull=isFull;
    }

}
