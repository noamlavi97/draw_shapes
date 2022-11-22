package draw_shapes;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.lang.Cloneable;

public abstract class MyShape implements Cloneable{
    
    private int x1, y1, x2, y2;
    private Color shapeColor;
    private GraphicsContext shapeGC;
    //Canvas bounds and line width
    protected final int CANVAS_SIZE=400, LINE_WIDTH=1;

    //Getters
    public int GetX1() {
        return this.x1;
    }
    public int GetY1() {
        return this.y1;
    }
    public int GetX2() {
        return this.x2;
    }
    public int GetY2() {
        return this.y2;
    }
    public Color GetColor() {
        return this.shapeColor;
    }
    public GraphicsContext GetShapeGC() {
        return this.shapeGC;
    }

    //Setters
    public void SetX1(int x1) {
        this.x1=x1;
    }
    public void SetY1(int y1) {
        this.y1=y1;
    }
    public void SetX2(int x2) {
        this.x2=x2;
    }
    public void SetY2(int y2) {
        this.y2=y2;
    }
    public void SetColor(Color shapeColor) {
        this.shapeColor=shapeColor;
    }
    public void SetGraphicsContext(GraphicsContext shapeGC) {
        this.shapeGC=shapeGC;
    }

    //Constructor
    public MyShape (int x1, int y1, int x2, int y2, Color color, GraphicsContext shapeGC) {
        //Verify that the shape is inside the bounds of the canvas:
        if (x1<0 || x1>CANVAS_SIZE || y1<0 || y1>CANVAS_SIZE || x2<0 || x2>CANVAS_SIZE || y2<0 || y2>CANVAS_SIZE) {
            System.out.println("Please note that the shape is out of the bounds of the canvas");
        }
        SetX1(x1);
        SetY1(y1);
        SetX2(x2);
        SetY2(y2);
        SetColor(color);
        SetGraphicsContext(shapeGC);
    }
    // Overriding clone() method by simply calling the Object class' clone() method
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    //We will define the size calculations in the subclasses because those have different signatures for each subclass
}
