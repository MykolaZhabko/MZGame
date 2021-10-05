package com.mz.bear.scenes;

import com.mz.bear.GameBear;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameScene extends GeneralScene{

    public GameScene(){
        super();
    }

    private void showGameMessage(){
        Font myFont = Font.font("Arial", FontWeight.NORMAL, 24);
        gc.setFont(myFont);
        gc.setFill(Color.YELLOW);
        gc.fillText("Game Scene", 325,200);
    }

    @Override
    public void draw() {
        activeKeys.clear();
        new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
                gc.setFill(Color.BLACK);
                gc.fillRect(0,0,GAME_WIDTH, GAME_HEIGH);

                showGameMessage();

                if (activeKeys.contains(KeyCode.ESCAPE)){
                    this.stop();
                    GameBear.setScene(GameBear.WELCOME_SCENE);
                } else if(activeKeys.contains(KeyCode.ENTER)){
                    this.stop();
                    GameBear.setScene(GameBear.GAME_OVER_SCENE);
                }
            }
        }.start();

    }
}