package edu.farmingdale.csc311_assignment3_groupbased;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Robot {

    private ImageView robotImage;
    private int x, y;
    private final int STEP_SIZE = 10;

    public Robot(Pane root){
        Image image = new Image(getClass().getResourceAsStream("robot.png"));
        robotImage = new ImageView(image);
        robotImage.setFitWidth(25);
        robotImage.setFitHeight(25);

        x = 50;
        y = 50;
        robotImage.setX(x);
        robotImage.setY(y);

        root.getChildren().add(robotImage);


    }

    void moveUp(){
        if(canMove(x,y - STEP_SIZE)) {
            y -= STEP_SIZE;
            robotImage.setY(y);
        }
    }

    void moveDown(){
        if(canMove(x, y+ STEP_SIZE)){
            y += STEP_SIZE;
            robotImage.setY(y);
        }
    }

    void moveLeft(){
        if(canMove(x - STEP_SIZE , y)){
            x -= STEP_SIZE;
            robotImage.setX(x);
        }
    }

    void moveRight(){
        if(canMove(x - STEP_SIZE, y)) {
            x += STEP_SIZE;
            robotImage.setX(x);
        }
    }
//temporary
    private boolean canMove(int x, int y){
        return true;
    }

    Image getRobotImage(){
        return robotImage.getImage();
    }
}
