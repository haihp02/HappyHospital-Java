package entity;
import java.awt.*;
import java.awt.image.BufferedImage;
public class Entity {
    public int worldX,worldY;
    public int speed;
    public BufferedImage agvImage;
    public String direction;

    public int spriteCounter=0;
    public int spriteNum=1;

    public Rectangle solidArea;
    public boolean collisionOn = false;

    public int solidAreaDefaultX,solidAreaDefaultY;
}