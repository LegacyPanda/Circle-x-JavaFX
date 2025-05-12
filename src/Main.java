import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Main extends Application
{
    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        Circle circle1 = new Circle(100, 100, 50, Color.BLUE);
        Circle circle2 = new Circle(200, 200, 50, Color.RED);
        Circle circle3 = new Circle(300, 300, 50, Color.GREEN); 
        Circle circle4 = new Circle(400, 400, 50, Color.GRAY); 
        Circle circle5 = new Circle(500, 500, 50, Color.PINK); 
        Circle circle6 = new Circle(600, 600, 50, Color.PURPLE);

        Button btn = new Button("Click Me!");

        Group root = new Group(btn, circle1, circle2, circle3, circle4, circle5, circle6);
        Scene scene = new Scene(root, 500, 500, Color.BLACK);

        AnimationTimer timer = new AnimationTimer() 
        {
            @Override
            public void handle(long now)
            {
                double screneWidth = scene.getWidth();
                
                Circle[] circles = {circle1, circle2, circle3, circle4, circle5, circle6};

                for (Circle c : circles) {
                    c.setCenterX(c.getCenterX() + 2);

                    if (c.getCenterX() - c.getRadius() > screneWidth) {
                        c.setCenterX(-c.getRadius());
                    }
                }
            }
        };

        btn.setOnAction(e ->
        {
            timer.start();
        }
        );

        stage.setTitle("I DID IT");
        stage.setScene(scene);
        stage.show();
    }
}