package draw_shapes;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.Random;

public class ShapesController {

    @FXML
    private Canvas draw_canvas;
    private GraphicsContext gc;
    
    //This function runs the program
    @FXML
    public void initialize() throws CloneNotSupportedException {
    	gc=draw_canvas.getGraphicsContext2D();
        final int NUM_OF_SHAPES=2, MAX_SHAPE_SIZE=200;
        ArrayList<MyShape> shapes_array=new ArrayList<MyShape>();
        Random r = new Random();
        Color c = Color.RED;
        int x1, y1, x2, y2;

        //Let's create the array - we will add 2 lins, 2 rectangles and 2 ovals
        MyLine line;
        MyRectangle rect;
        MyOval oval;

        //Let's add 2 lines to the array
        for (int i=0; i<NUM_OF_SHAPES; i++) {
            x1=r.nextInt(MAX_SHAPE_SIZE);
            x2=r.nextInt(MAX_SHAPE_SIZE);
            y1=r.nextInt(MAX_SHAPE_SIZE);
            y2=r.nextInt(MAX_SHAPE_SIZE);
            line= new MyLine(x1,y1,x2,y2, c, gc);
            shapes_array.add(line);
        }

        //Let's add 2 rectangles to the array
        for (int i=0; i<NUM_OF_SHAPES; i++) {
            x1=r.nextInt(MAX_SHAPE_SIZE);
            x2=r.nextInt(MAX_SHAPE_SIZE);
            y1=r.nextInt(MAX_SHAPE_SIZE);
            y2=r.nextInt(MAX_SHAPE_SIZE);
            rect= new MyRectangle(x1,y1,x2,y2, c, gc, true);
            shapes_array.add(rect);
        }
        
        //Let's add 2 ovals to the array
        for (int i=0; i<NUM_OF_SHAPES; i++) {
            x1=r.nextInt(MAX_SHAPE_SIZE);
            x2=r.nextInt(MAX_SHAPE_SIZE);
            y1=r.nextInt(MAX_SHAPE_SIZE);
            y2=r.nextInt(MAX_SHAPE_SIZE);
            oval= new MyOval(x1,y1,x2,y2, c, gc, true);
            shapes_array.add(oval);
        }

        c = Color.GREEN;
        //Clone the shapes and then move, change to red and empty
        for (int i=0; i<NUM_OF_SHAPES*3; i++) {
            shapes_array.add((MyShape)shapes_array.get(i).clone());
            shapes_array.get(i+3*NUM_OF_SHAPES).SetX1(shapes_array.get(i).GetX1()+10);
            shapes_array.get(i+3*NUM_OF_SHAPES).SetY1(shapes_array.get(i).GetY1()+10);
            shapes_array.get(i+3*NUM_OF_SHAPES).SetColor(c);
            if(!(shapes_array.get(i+3*NUM_OF_SHAPES) instanceof MyLine)) {
                ((MyBoundedShape)shapes_array.get(i+3*NUM_OF_SHAPES)).SetIsFull(false);
            }  
        }

        //Draw everything
        //Draw lines
        for (int i=0; i<NUM_OF_SHAPES; i++) {
            ((MyLine)shapes_array.get(i)).drawLine();
        }
        //Draw rectangles
        for (int i=NUM_OF_SHAPES; i<NUM_OF_SHAPES*2; i++) {
            ((MyRectangle)shapes_array.get(i)).drawRectangle();
        }
        //Draw ovals
        for (int i=NUM_OF_SHAPES*2; i<NUM_OF_SHAPES*3; i++) {
            ((MyOval)shapes_array.get(i)).drawOval();
        }
        //Draw lines
        for (int i=NUM_OF_SHAPES*3; i<NUM_OF_SHAPES*4; i++) {
            ((MyLine)shapes_array.get(i)).drawLine();
        }
        //Draw rectangles
        for (int i=NUM_OF_SHAPES*4; i<NUM_OF_SHAPES*5; i++) {
            ((MyRectangle)shapes_array.get(i)).drawRectangle();
        }
        //Draw ovals
        for (int i=NUM_OF_SHAPES*5; i<NUM_OF_SHAPES*6; i++) {
            ((MyOval)shapes_array.get(i)).drawOval();
        }
    }
}