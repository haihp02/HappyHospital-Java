package main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font arial_40,arial_80B;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinish = false;
    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");
    public UI(GamePanel  gp){
        this.gp = gp;
        arial_80B = new Font("Arial",Font.BOLD,80);
        arial_40 = new Font("Arial",Font.PLAIN,40);
    }
    public void showMessage(String text){
        message = text;
        messageOn = true;

    }
    public void draw(Graphics2D g2){

        this.g2 = g2;

        g2.setFont(arial_80B);
        g2.setColor(Color.RED);

        if(gp.gameState == gp.playState) {

        }
        if(gp.gameState == gp.pauseState) {
            drawPauseScreen();
        }
    }

    private void drawPauseScreen() {
        String text = "Tạm dừng";
        int x = getXForCenteredText(text);
        int y = gp.screenHeight/2;

        g2.drawString(text, x, y);
    }

    private int getXForCenteredText(String text) {

        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        return gp.screenWidth/2 - length/2;
    }
}