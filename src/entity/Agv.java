package entity;


import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

    public class Agv extends Entity {
        public boolean isImmortal=false; // biến cần cho xử lý overlap =))
        private boolean isDisable = false; // biến cần cho xử lý overlap =))
        private int desX;
        private int desY;
        Font arial_17;
        GamePanel gp;
        KeyHandler keyH;
        public final int screenX;
        public final int screenY;
        public int hasKey=0;

        public Agv(GamePanel gp, KeyHandler keyH){
            this.gp=gp;
            this.keyH=keyH;
            solidArea=new Rectangle(8,16,32,32);
            solidAreaDefaultX=solidArea.x;
            solidAreaDefaultY=solidArea.y;
            setDefaultValues();
            getPlayerImage();
            screenX=gp.screenWidth/2 -gp.tileSize/2;
            screenY=gp.screenHeight/2-gp.tileSize/2;
            arial_17=new Font("Arial",Font.TYPE1_FONT,17);

        }
        public void setDefaultValues(){
            worldX=21*gp.tileSize;
            worldY=23*gp.tileSize;
            speed=2;
            direction="down";
        }
        public void getPlayerImage(){
            try{
                agvImage=ImageIO.read(getClass().getResourceAsStream("/res/agv.png"));
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        public void ToastInvalidMove(Graphics2D g2){
            String message="Di chuyển không hợp lệ!";
            g2.setFont(arial_17);
            g2.drawString(message,gp.tileSize*25,gp.tileSize*20);
        }
        public void ToastOverLay(Graphics2D g2){
            String message="AGV va chạm với Agent!";
            g2.setFont(arial_17);
            g2.drawString(message,gp.tileSize*25,gp.tileSize*20);
        }
        public void update(){
            if(keyH.leftPressed==true || keyH.downPressed==true || keyH.upPressed==true || keyH.rightPressed==true){
                if(keyH.upPressed==true){
                    direction="up";
                }
                else if(keyH.downPressed==true){
                    direction="down";
                }
                else if(keyH.rightPressed==true){
                    direction="right";
                }
                else if(keyH.leftPressed==true){
                    direction="left";
                }
                //CHECK TILE COLLISION
                collisionOn=false;
               // gp.cChecker.CheckTile(this);
                //CHECK OBJECT COLLISION
                //IF COLLISION IS TRUE -> PLAYER CAN'T MOVE
                if(collisionOn==false){
                    switch (direction){
                        case "up":
                            worldY-=speed;
                            break;
                        case "down":
                            worldY+=speed;
                            break;
                        case "left":
                            worldX-=speed;
                            break;
                        case "right":
                            worldX+=speed;
                            break;
                    }
                }
            }
        }
        public void draw(Graphics2D g2){
/*            g2.setColor(Color.white);
            g2.fillRect(x,y,gp.tileSize,gp.tileSize);*/

            g2.setFont(arial_17);
            g2.setColor(Color.green);
            String text="AGV";
            int textLength=(int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
            int x=worldX+16-textLength/2;
            int y=worldY-6;
            g2.drawString(text,x,y);
            g2.drawImage(agvImage,worldX,worldY,32,32,null);

        }
    }
