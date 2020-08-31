import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.event.ActionEvent;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DrawShapesController {
    @FXML private Canvas canvas;
    @FXML
    void drawShapesButtonPressed(ActionEvent event) {

        // canvas dimensions and declaration
        GraphicsContext gc = canvas.getGraphicsContext2D();
        double centerX = canvas.getWidth() / 2;
        double centerY = canvas.getHeight() / 2;
        double canvasWidth = canvas.getWidth();
        double canvasHeight = canvas.getHeight();

        // create Color array
        Color colorList[] = {Color.BEIGE, Color.LIGHTGREEN, Color.BROWN, Color.LIGHTBLUE,
                Color.YELLOW, Color.VIOLET};

        //
        System.out.println("Figure 1: Lightgreen oval ");
        System.out.println("Figure 2: Lightblue oval ");
        System.out.println("Figure 3: Brown circle ");
        System.out.printf("Figure 4: Yellow circle %n");


        // EXAMPLE WHERE FIGURES OVERLAP
        // SHAPES DIMENSION 1
        double radiusX1 = canvasWidth / 5;
        double radiusY1 = canvasHeight / 7.5;
        myOval oval1 = new myOval(centerX + canvasWidth / 3 - canvasWidth / 6,
                centerY + canvasHeight / 2 - canvasWidth / 6, colorList[1], radiusX1, radiusY1);

        // SHAPES DIMENSION 2
        myOval oval2 = new myOval(centerX + canvasWidth / 3 + canvasWidth / 12,
                centerY + canvasHeight / 2 + canvasWidth / 12, colorList[3], radiusX1, radiusY1);

        oval1.draw(gc, canvasWidth, canvasHeight);
        oval2.draw(gc, canvasWidth, canvasHeight);


        // EXAMPLE WHERE FIGURES DO NOT OVERLAP
        // SHAPES DIMENSION 3
        double radiusX2 = canvasWidth / 9;
        double radiusY2 = canvasHeight / 9;
        myOval oval3 = new myOval(centerX + canvasWidth / 2 - canvasWidth / 6,
                centerY + canvasHeight / 2 - canvasWidth / 4, colorList[2], radiusX2, radiusX2);

        // SHAPES DIMENSION 4
        myOval oval4 = new myOval(centerX + canvasWidth / 2 + canvasWidth / 12,
                centerY + canvasHeight / 2 + canvasWidth / 16, colorList[4], radiusY2, radiusY2);

        oval3.draw(gc, canvasWidth, canvasHeight);
        oval4.draw(gc, canvasWidth, canvasHeight);



        if (oval3.doOverlap(oval1, oval2)) {
            System.out.println("figures 1 overlaps figure 2!");
        } else {
            System.out.println("figures 1 DO NOT!! overlap figure 2!");
        }

        if (oval3.doOverlap(oval1, oval3)) {
            System.out.println("figures 1 overlaps figure 3!");
        } else {
            System.out.println("figures 1 DO NOT!! overlap figure 3!");
        }
        if (oval3.doOverlap(oval1, oval4)) {
            System.out.println("figures 1 overlaps figure 4!");
        } else {
            System.out.println("figures 1 DO NOT!! overlap figure 4!");
        }

        if (oval3.doOverlap(oval2, oval3)) {
            System.out.println("figures 2 overlaps figure 3!");
        } else {
            System.out.println("figures 2 DO NOT!! overlap figure 3!");
        }
        if (oval3.doOverlap(oval2, oval4)) {
            System.out.println("figures 2 overlaps figure 4!");
        } else {
            System.out.println("figures 2 DO NOT!! overlap figure 4!");
        }

        if (oval3.doOverlap(oval3, oval4)) {
            System.out.println("figures 3 overlaps figure 4!");
        } else {
            System.out.println("figures 3 DO NOT!! overlap figure 4!");
        }





    }

}
