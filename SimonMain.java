import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class SimonMain extends Application
{
    static Stage primaryStage;
    static Scene menuScene;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        SimonMain.primaryStage = primaryStage;

        final int MAX_HEIGHT = 800;
        final int MAX_WIDTH = 1000;
        primaryStage.setTitle("EZ Mini-Games");
        Group root = new Group();
        Scene scene = new Scene(root,MAX_WIDTH,MAX_HEIGHT);
        scene.setFill(Color.rgb(47,108,175));
        menuScene = scene;

//        Image img = new Image("images/Title.jpg");
//        ImageView imgView = new ImageView(img);
//        imgView.setX(200);
//        imgView.setY(100);

        Text text = new Text("Simon Says");
        text.setFont(Font.font("Comic Sans MS",50));
        text.setFill(Color.WHITE);
        text.setX(340);
        text.setY(260);


        Rectangle choice = new Rectangle(310,70);
        choice.setFill(Color.TRANSPARENT);
        choice.setStroke(Color.WHITE);
        choice.setStrokeWidth(4);
        choice.setX(332);
        choice.setY(210);

        EventHandler<MouseEvent> MouseEvent1 = new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                if(event.getSource() == choice)
                {
                    Simon simon = new Simon();
                    simon.Start(primaryStage);
                }
            }
        };

        choice.setOnMousePressed(MouseEvent1);

//        root.getChildren().add(imgView);
        root.getChildren().add(text);
        root.getChildren().add(choice);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void Start(Stage secondaryStage)
    {
        Group root1 = new Group();
        Scene scene1 = new Scene(root1,1000,800);

        Arc arc = new Arc(500,400,200,200,90,90);
        arc.setType(ArcType.ROUND);
        arc.setFill(Color.rgb(0,90,0));
        arc.setStroke(Color.BLACK);
        arc.setStrokeWidth(10);

        Arc arc1 = new Arc(500,400,200,200,90,-90);
        arc1.setType(ArcType.ROUND);
        arc1.setFill(Color.rgb(157,19,19));
        arc1.setStroke(Color.BLACK);
        arc1.setStrokeWidth(10);

        Arc arc2 = new Arc(500,400,200,200,180,90);
        arc2.setType(ArcType.ROUND);
        arc2.setFill(Color.rgb(173,171,51));
        arc2.setStroke(Color.BLACK);
        arc2.setStrokeWidth(10);

        Arc arc3 = new Arc(500,400,200,200,270,90);
        arc3.setType(ArcType.ROUND);
        arc3.setFill(Color.rgb(0,0,145));
        arc3.setStroke(Color.BLACK);
        arc3.setStrokeWidth(10);

        Circle circle = new Circle(80);
        circle.setFill(Color.BLACK);
        circle.setCenterX(500);
        circle.setCenterY(400);



        root1.getChildren().add(arc);
        root1.getChildren().add(arc1);
        root1.getChildren().add(arc2);
        root1.getChildren().add(arc3);
        root1.getChildren().add(circle);



        secondaryStage.setTitle("Simon");
        secondaryStage.show();
        secondaryStage.setScene(scene1);

    }

    static void displayMenu()
    {
        primaryStage.setScene(menuScene);

    }
}
