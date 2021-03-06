package gameAlgo;

import main.GamePanel;

import java.util.ArrayList;

public class Position {
    public int x;
    public int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void getDoorPosition(GamePanel gp) {
        int col = 0;
        int row = 0;

        while(col < gp.maxScreenCol && row < gp.maxScreenRow){

            int doorNum = gp.tileM.mapDoorTileNum[col][row];

            int x = col*gp.tileSize;
            int y = row*gp.tileSize;

            if(doorNum != 0) gp.doorPos.add(new Position(x, y));

            col++;

            if(col == gp.maxScreenCol){
                col = 0;
                row ++;
            }
        }
    }

    public static void getDesPosition(GamePanel gp){
        int col = 5;
        int row = 0;

        while(col < 45 && row < gp.maxScreenRow){

            int tileNum = gp.tileM.mapTileNum[col][row];
            boolean check=gp.tileM.tile[tileNum].agvCollision;

            int x = col*gp.tileSize;
            int y = row*gp.tileSize;

            if(check==false) gp.DesPos.add(new Position(x, y));

            col++;

            if(col == 45){
                col = 0;
                row ++;
            }
        }
    }
    static double between (Position x, Position y) {
        return Math.sqrt((x.x - y.x)*(x.x - y.x)  + (x.y - y.y)*(x.y - y.y));
    }
}
