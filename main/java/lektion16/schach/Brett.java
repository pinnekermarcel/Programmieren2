package lektion16.schach;

public class Brett
{
  boolean[][] brett = new boolean[8][8];
  
  public Brett()
  {
    
  }
  
  public void markiereFeld(int x, int y)
  {
    brett[x-1][y-1] = true;
  }
  
  public boolean gibFeld(int x, int y)
  {
    return brett[x-1][y-1];
  }

    public Brett kombiniere(Brett anderesBrett) {
        Brett neuesBrett = new Brett();

        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                // Wenn das Feld auf diesem ODER dem anderen Brett markiert ist...
                if (this.gibFeld(i, j) || anderesBrett.gibFeld(i, j)) {
                    neuesBrett.markiereFeld(i, j); // ...markiere es auf dem neuen Brett
                }
            }
        }
        return neuesBrett;
    }
  
}
