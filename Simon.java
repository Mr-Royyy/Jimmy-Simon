//All the java libraries that I am going to use
import javafx.animation.AnimationTimer;
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
import java.util.Random;

public class Simon
{
    //All of my declared fields that I will manipulate in the main method
    int green = 1;
    int red = 2;
    int yellow = 3;
    int blue = 4;
    int rand1;
    int rand2;
    int rand3;
    int rand4;
    int rand5;
    int rand6;
    int rand7;
    int rand8;
    int rand9;
    int rand10;
    int rand11;
    int rand12;
    int rand13;
    int rand14;
    int rand15;
    int rand16;
    int rand17;
    int rand18;
    int rand19;
    int rand20;
    //index counter, will count what index the user is currently at
    int counter = 0;
    //memory counter, will store the previous RNG choices made by the computer
    int[] memory = new int[40];
    //sequence array, will display the current sequence of the counter
    int[] sequence = new int[] {};
    //a timer value that creates a small period of time in between clicks so that the user can remember better
    static long lastRun = 0;

    //notes that keeps track of the current index made by the computer
    static int note = 0;
    //total amount of randoms made by the computer
    int currentNote = 2;
    //blinker delay between choices
    long blinkstartime;
    Text score;
    //Animation timers
    AnimationTimer blinkin1;
    AnimationTimer blinker;

    //Brings up the stage for the Simon game
    public void Start(Stage secondaryStage)
    {
        Group root1 = new Group();
        Scene scene1 = new Scene(root1, 1000, 800);
        int min = 1;
        int max = 4;
        Random rand = new Random();
        //Animation delay
        blinkin1 = new AnimationTimer()
        {
            @Override
            public void handle(long now)
            {
                if(now - blinkstartime > 1000000000){
                    blinker.start();
                    stop();
                }
            }
        };


        //Created the shapes for the simon shape

        //green button
        Arc arc = new Arc(500,400,200,200,90,90);
        arc.setType(ArcType.ROUND);
        arc.setFill(Color.rgb(0,90,0));
        arc.setStroke(Color.BLACK);
        arc.setStrokeWidth(10);

        //red button
        Arc arc1 = new Arc(500,400,200,200,90,-90);
        arc1.setType(ArcType.ROUND);
        arc1.setFill(Color.rgb(157,19,19));
        arc1.setStroke(Color.BLACK);
        arc1.setStrokeWidth(10);

        //yellow button
        Arc arc2 = new Arc(500,400,200,200,180,90);
        arc2.setType(ArcType.ROUND);
        arc2.setFill(Color.rgb(173,171,51));
        arc2.setStroke(Color.BLACK);
        arc2.setStrokeWidth(10);

        //blue button
        Arc arc3 = new Arc(500,400,200,200,270,90);
        arc3.setType(ArcType.ROUND);
        arc3.setFill(Color.rgb(0,0,145));
        arc3.setStroke(Color.BLACK);
        arc3.setStrokeWidth(10);

        //center circle
        Circle circle = new Circle(80);
        circle.setFill(Color.BLACK);
        circle.setCenterX(500);
        circle.setCenterY(400);

        //Start button shape
        Rectangle Start = new Rectangle(150,75);
        Start.setFill(Color.TRANSPARENT);
        Start.setStroke(Color.WHITE);
        Start.setStrokeWidth(4);
        Start.setX(420);
        Start.setY(100);

        //Start text
        Text begin = new Text("Start");
        begin.setFont(Font.font("Comic Sans MS",50));
        begin.setFill(Color.WHITE);
        begin.setX(428);
        begin.setY(155);

        //Game over text
        Text gameOver = new Text("GAME OVER");
        gameOver.setFont(Font.font("Comic Sans MS",70));
        gameOver.setFill(Color.WHITE);
        gameOver.setX(295);
        gameOver.setY(400);
        gameOver.setStroke(Color.BLACK);
        gameOver.setStrokeWidth(3);
        gameOver.setVisible(false);

        //description text
        Text description = new Text("Simon is a fun memory game that tests the users ability to remember \n" +
                "   colours in a series, going up to a score of 20. Can you beat Simon?");
        description.setFont(Font.font("Comic Sans MS",25));
        description.setFill(Color.WHITE);
        description.setX(90);
        description.setY(700);

        //Green sound that will play when green is clicked
//        Media greenSound = new Media (new File("src/sounds/greenSound.wav").toURI().toString());
//        MediaPlayer greenPlayer = new MediaPlayer(greenSound);
//
//        //Red sound that will play when red is clicked
//        Media redSound = new Media (new File("src/sounds/redSound.wav").toURI().toString());
//        MediaPlayer redPlayer = new MediaPlayer(redSound);
//
//        //Yellow sound that will play when yellow is clicked
//        Media yellowSound = new Media (new File("src/sounds/yellowSound.wav").toURI().toString());
//        MediaPlayer yellowPlayer = new MediaPlayer(yellowSound);
//
//        //Blue sound that will play when blue is clicked
//        Media blueSound = new Media (new File("src/sounds/blueSound.wav").toURI().toString());
//        MediaPlayer bluePlayer = new MediaPlayer(blueSound);
//
//        //Lose sound that will play when the user's input is incorrect
//        Media lose = new Media (new File("src/sounds/lose.wav").toURI().toString());
//        MediaPlayer loseSound = new MediaPlayer(lose);

        EventHandler<MouseEvent> startClick = new EventHandler<MouseEvent>()
        {
            //All counters and updating variables are set to 0 and starts at the beginning
            //Sequence array uses each random and a 0 in-between, 0 sets the colour back to base colour
            //and randoms (1 to 4) light up the corresponding colour when the start button is clicked
            @Override
            public void handle(MouseEvent event)
            {
                //All my random variables that were declared as a field (1 to 4, 1 being green, 2 red, 3 yellow, 4 blue)
                rand1 = rand.nextInt(max - min + 1) + min;
                rand2 = rand.nextInt(max - min + 1) + min;
                rand3 = rand.nextInt(max - min + 1) + min;
                rand4 = rand.nextInt(max - min + 1) + min;
                rand5 = rand.nextInt(max - min + 1) + min;
                rand6 = rand.nextInt(max - min + 1) + min;
                rand7 = rand.nextInt(max - min + 1) + min;
                rand8 = rand.nextInt(max - min + 1) + min;
                rand9 = rand.nextInt(max - min + 1) + min;
                rand10 = rand.nextInt(max - min + 1) + min;
                rand11 = rand.nextInt(max - min + 1) + min;
                rand12 = rand.nextInt(max - min + 1) + min;
                rand13 = rand.nextInt(max - min + 1) + min;
                rand14 = rand.nextInt(max - min + 1) + min;
                rand15 = rand.nextInt(max - min + 1) + min;
                rand16 = rand.nextInt(max - min + 1) + min;
                rand17 = rand.nextInt(max - min + 1) + min;
                rand18 = rand.nextInt(max - min + 1) + min;
                rand19 = rand.nextInt(max - min + 1) + min;
                rand20 = rand.nextInt(max - min + 1) + min;

                blinker.start();
                sequence = new int[]{rand1, 0, rand2, 0, rand3, 0, rand4, 0, rand5, 0, rand6, 0, rand7,
                        0, rand8, 0, rand9, 0, rand10, 0, rand11, 0 , rand12, 0, rand13, 0,
                        rand14, 0 ,rand15, 0, rand16, 0, rand17,0, rand18, 0, rand19, 0 ,rand20, 0};
                counter = 0;
                note = 0;
                currentNote = 2;

                //displays the score divided by 2, since current note goes up to 40 because it counts
                //the random then the 0 (2 total), so current note would need to be divided to show your proper
                //score, which is +1 every turn
                score.setText(""+(currentNote/2));
                if(currentNote/2 >= 10)
                {
                    score.setX(480);
                    score.setY(418);
                }
                gameOver.setVisible(false);
            }
        };

        //Mouse event handler for green
        EventHandler<MouseEvent> MouseEvent1 = new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                //If mouse pressed is equal to green, set the shape fill colour
                //to a brighter hue to create a "light-up" effect
                if(event.getSource() == arc)
                {
                    arc.setFill(Color.rgb(0,255,0));
                    //plays the green sound
//                    greenPlayer.seek(Duration.millis(0));
//                    greenPlayer.play();
                    //Stores green in the array so that it can be recited as the current note increases
                    memory[counter++] = green;
                    memory[counter++] = 0;
                    boolean correct = true;

                    //if current note is greater than 40,code will stop.
                    if(currentNote > 40)
                    {
                        return;
                    }
                    //array scanner for-loop, checks if 'i' is less than counter. If this is the case,
                    //'i' will increase and memory will be updated. If memory is not equal to sequence (which
                    // would be the current value the user is on), the game will stop and display the text
                    //"Game Over"
                    for(int i = 0; i < counter; i++)
                    {
                        //if mouse input is not equal to the shape, lose sound is played and the correct boolean
                        //becomes false, stopping the blinker animation
                        if(memory[i] != sequence[i])
                        {
                            correct = false;
                            gameOver.setVisible(true);
//                            loseSound.seek(Duration.millis(0));
//                            loseSound.play();
                        }
                    }
                    //when mouse input is correct, current note is increased by 2 (to show the next random, followed
                    // by a 0 which is a reset back to the original, darker colour) and the delay is started.
                    if(correct && counter == note){
                        currentNote += 2;
                        counter = 0;
                        note = 0;
                        blinkstartime = System.nanoTime();
                        blinkin1.start();
                        score.setText(""+(currentNote/2));
                    }

                }
            }
        };
        //Mouse released event, when the user un-clicks the shape it causes the rgb value of the shape to decrease,
        //creating a "light-down" effect
        EventHandler<MouseEvent> MouseEvent2 = new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                if(event.getSource() == arc)
                {
                    arc.setFill(Color.rgb(0,90,0));

                }
            }
        };

        //Mouse event handler for red
        EventHandler<MouseEvent> MouseEvent3 = new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                if(event.getSource() == arc1)
                {
                    //If mouse pressed is equal to red, set the shape fill colour
                    //to a brighter hue to create a "light-up" effect
                    arc1.setFill(Color.rgb(255,0,0));
//                    redPlayer.seek(Duration.millis(0));
//                    redPlayer.play();
                    //Stores red in the array so that it can be recited as the current note increases
                    memory[counter++] = red;
                    memory[counter++] = 0;
                    boolean correct = true;

                    //if current note is greater than 40,code will stop.
                    if(currentNote > 40)
                    {
                        return;
                    }
                    //array scanner for-loop, checks if 'i' is less than counter. If this is the case,
                    //'i' will increase and memory will be updated. If memory is not equal to sequence (which
                    // would be the current value the user is on), the game will stop and display the text
                    //"Game Over"
                    for(int i = 0; i < counter; i++)
                    {
                        //if mouse input is not equal to the shape, lose sound is played and the correct boolean
                        //becomes false, stopping the blinker animation
                        if(memory[i] != sequence[i])
                        {
                            correct = false;
                            gameOver.setVisible(true);
//                            loseSound.seek(Duration.millis(0));
//                            loseSound.play();
                        }
                    }
                    //when mouse input is correct, current note is increased by 2 (to show the next random, followed
                    // by a 0 which is a reset back to the original, darker colour) and the delay is started.
                    if(correct && counter == note){
                        currentNote += 2;
                        note = 0;
                        counter =0;
                        //blinker.start();
                        blinkstartime = System.nanoTime();
                        blinkin1.start();
                        score.setText(""+(currentNote/2));
                    }
                }
            }
        };
        //Mouse released event, when the user un-clicks the shape it causes the rgb value of the shape to decrease,
        //creating a "light-down" effect
        EventHandler<MouseEvent> MouseEvent4 = new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                if(event.getSource() == arc1)
                {
                    arc1.setFill(Color.rgb(157,19,19));

                }
            }
        };

        //Mouse event handler for yellow
        EventHandler<MouseEvent> MouseEvent5 = new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                //If mouse pressed is equal to yellow, set the shape fill colour
                //to a brighter hue to create a "light-up" effect
                if(event.getSource() == arc2)
                {
                    arc2.setFill(Color.rgb(255,255,0));
//                    yellowPlayer.seek(Duration.millis(0));
//                    yellowPlayer.play();
                    //Stores yellow in the array so that it can be recited as the current note increases
                    memory[counter++] = yellow;
                    memory[counter++] = 0;
                    boolean correct = true;

                    //if current note is greater than 40,code will stop.
                    if(currentNote > 40)
                    {
                        return;
                    }
                    //array scanner for-loop, checks if 'i' is less than counter. If this is the case,
                    //'i' will increase and memory will be updated. If memory is not equal to sequence (which
                    // would be the current value the user is on), the game will stop and display the text
                    //"Game Over"
                    for(int i = 0; i < counter; i++)
                    {
                        //if mouse input is not equal to the shape, lose sound is played and the correct boolean
                        //becomes false, stopping the blinker animation
                        if(memory[i] != sequence[i])
                        {
                            correct = false;
                            gameOver.setVisible(true);
//                            loseSound.seek(Duration.millis(0));
//                            loseSound.play();
                        }
                    }
                    //when mouse input is correct, current note is increased by 2 (to show the next random, followed
                    // by a 0 which is a reset back to the original, darker colour) and the delay is started.
                    if(correct && counter == note){
                        currentNote += 2;
                        note = 0;
                        counter =0;
                        //blinker.start();
                        blinkstartime = System.nanoTime();
                        blinkin1.start();
                        score.setText(""+(currentNote/2));
                    }
                }
            }
        };
        //Mouse released event, when the user un-clicks the shape it causes the rgb value of the shape to decrease,
        //creating a "light-down" effect
        EventHandler<MouseEvent> MouseEvent6 = new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                if(event.getSource() == arc2)
                {
                    arc2.setFill(Color.rgb(173,171,51));
                }
            }
        };

        //Mouse event handler for blue
        EventHandler<MouseEvent> MouseEvent7 = new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                //If mouse pressed is equal to blue, set the shape fill colour
                //to a brighter hue to create a "light-up" effect
                if(event.getSource() == arc3)
                {
                    arc3.setFill(Color.rgb(0,0,255));
//                    bluePlayer.seek(Duration.millis(0));
//                    bluePlayer.play();
                    //Stores blue in the array so that it can be recited as the current note increases
                    memory[counter++] = blue;
                    memory[counter++] = 0;
                    boolean correct = true;

                    //if current note is greater than 40,code will stop.
                    if(currentNote > 40)
                    {
                        return;
                    }
                    //array scanner for-loop, checks if 'i' is less than counter. If this is the case,
                    //'i' will increase and memory will be updated. If memory is not equal to sequence (which
                    // would be the current value the user is on), the game will stop and display the text
                    //"Game Over"
                    for(int i = 0; i < counter; i++)
                    {
                        //if mouse input is not equal to the shape, lose sound is played and the correct boolean
                        //becomes false, stopping the blinker animation
                        if(memory[i] != sequence[i])
                        {
                            correct = false;
                            gameOver.setVisible(true);
//                            loseSound.seek(Duration.millis(0));
//                            loseSound.play();
                        }
                    }
                    //when mouse input is correct, current note is increased by 2 (to show the next random, followed
                    // by a 0 which is a reset back to the original, darker colour) and the delay is started.
                    if(correct && counter == note){
                        currentNote += 2;
                        note = 0;
                        counter =0;
                        blinkstartime = System.nanoTime();
                        blinkin1.start();
                        score.setText(""+(currentNote/2));
                    }
                }
            }
        };
        //Mouse released event, when the user un-clicks the shape it causes the rgb value of the shape to decrease,
        //creating a "light-down" effect
        EventHandler<MouseEvent> MouseEvent8 = new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                if(event.getSource() == arc3)
                {
                    arc3.setFill(Color.rgb(0,0,145));
                }
            }
        };

        //Blinker animation timer. This animation timer is responsible for displaying and creating sound
        //when the colour is being recited. ie, if the random in current note was 2 it switches the case of the array
        // so that when the sequence random (which ranges only from 1 to 4) is read,
        // it will switch it with the case (in this case, red would be lit
        // up because the case is '2')
        blinker = new AnimationTimer()
        {
            @Override
            public void handle(long now)
            {
                if(now - lastRun > 500000000) {
                    lastRun = now;


                    switch (sequence[note++]){
                        case 1:
                            arc.setFill(Color.rgb(0, 255, 0));
//                            greenPlayer.seek(Duration.millis(0));
//                            greenPlayer.play();
                            break;
                        case 2:
                            arc1.setFill(Color.rgb(255, 0, 0));
//                            redPlayer.seek(Duration.millis(0));
//                            redPlayer.play();
                            break;
                        case 3:
                            arc2.setFill(Color.rgb(255, 255, 0));
//                            yellowPlayer.seek(Duration.millis(0));
//                            yellowPlayer.play();
                            break;
                        case 4:
                            arc3.setFill(Color.rgb(0, 0, 255));
//                            bluePlayer.seek(Duration.millis(0));
//                            bluePlayer.play();
                            break;

                        //default colour values. Since default = 0, whenever the index in the sequence array is 0,
                        //colour is set back to default, dark values.
                        default:
                            arc.setFill(Color.rgb(0, 90, 0));
                            arc1.setFill(Color.rgb(157,19,19));
                            arc2.setFill(Color.rgb(173,171,51));
                            arc3.setFill(Color.rgb(0, 0, 145));

                    }
                    //if note is equal to the current sequence, blinker will stop.
                    if(note == sequence.length)
                    {
                        stop();
                    }
                    //if note is greater than or equal to current note, blinker will stop.
                    if(note >= currentNote){
                        stop();
                    }
                }
            }
        };

        //score text box
        score = new Text("" + (currentNote/2));
        score.setFont(Font.font("Comic Sans MS",55));
        score.setFill(Color.WHITE);
        score.setX(485);
        score.setY(418);

        //Main Menu text box
        Text text = new Text("Main Menu");
        text.setFont(Font.font("Comic Sans MS",30));
        text.setFill(Color.WHITE);
        text.setX(50);
        text.setY(100);

        //Rectangle that is inside the 'Main Menu' text
        Rectangle choice = new Rectangle(180,50);
        choice.setFill(Color.TRANSPARENT);
        choice.setStroke(Color.WHITE);
        choice.setStrokeWidth(4);
        choice.setX(35);
        choice.setY(65);

        //When menu is clicked, it will take you back to the start screen
        EventHandler<MouseEvent> MenuClicked = new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                if(event.getSource() == choice)
                {
                    SimonMain.displayMenu();
                }
            }
        };

        //All the rooted shapes and text boxes
        root1.getChildren().add(arc);
        root1.getChildren().add(arc1);
        root1.getChildren().add(arc2);
        root1.getChildren().add(arc3);
        root1.getChildren().add(circle);
        root1.getChildren().add(text);
        root1.getChildren().add(choice);
        root1.getChildren().add(gameOver);
        root1.getChildren().add(Start);
        root1.getChildren().add(begin);
        root1.getChildren().add(description);
        root1.getChildren().add(score);

        //All the rooted event handlers
        arc.setOnMousePressed(MouseEvent1);
        arc.setOnMouseReleased(MouseEvent2);
        arc1.setOnMousePressed(MouseEvent3);
        arc1.setOnMouseReleased(MouseEvent4);
        arc2.setOnMousePressed(MouseEvent5);
        arc2.setOnMouseReleased(MouseEvent6);
        arc3.setOnMousePressed(MouseEvent7);
        arc3.setOnMouseReleased(MouseEvent8);
        Start.setOnMousePressed(startClick);
        begin.setOnMouseClicked(startClick);
        choice.setOnMousePressed(MenuClicked);

        //Scene colour value
        scene1.setFill(Color.rgb(44,80,166));
        //Scene display
        secondaryStage.setScene(scene1);
    }}


