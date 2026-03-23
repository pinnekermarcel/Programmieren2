package lektion14;

public class Punkt {
    int x;
    int y;

    public void verschiebePunkt( int zielX, int zielY) {
        if( zielX < 0 || zielY < 0 ){
            throw new RuntimeException("zielX or zielY is negative");
        }else if( zielX > 1920 || zielY > 1080 ){
            throw new RuntimeException("zielX or zielY is out of range");
        }
        x = zielX;
        y = zielY;

    }
}
