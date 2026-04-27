package lektion16.schach;

import lektion16.schach.AbstractFigur;

public class LaeuferImpl extends AbstractFigur implements Laeufer
{
  public LaeuferImpl(int x, int y)
  {
    super(x, y);
  }

  public Brett gibErlaubteFelder()
  {
    Brett brett = new Brett();
    for(int i = 1; i <= 8; i++){
        for(int j = 1; j <= 8; j++){
            // Prüfung: Ist die Entfernung auf der X-Achse gleich der auf der Y-Achse? (Diagonale)
            // Und: Ist das Feld NICHT das aktuelle Startfeld des Läufers?
            if (Math.abs(this.x - i) == Math.abs(this.y - j) && !(this.x == i && this.y == j)) {
                brett.markiereFeld(i, j);
            }
        }
    }
    return brett;
  }
  
  public static void main(String[] args)
  {
    LaeuferImpl l = new LaeuferImpl(4,5);
    Brett brett = l.gibErlaubteFelder();
    for (int j = 1; j <= 8; j++)
    {
      for (int i = 1; i <= 8; i++)
      {
        if (brett.gibFeld(i, j)) System.out.print("x");
        else System.out.print("o");
      }
      System.out.println();
    }
  }
}
