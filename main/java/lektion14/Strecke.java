package lektion14;

public class Strecke {
    int a;//startpunkt
    int b;//endpunkt

    public Strecke(int p1, int p2) {
        if(p1 < 0 || p2 < 0){
            throw new RuntimeException("zahl muss ganzahlig und pos. sein!");
        }
        if(p1 < p2){
            this.a = p1;
            this.b = p2;
        }else{

            this.a = p2;
            this.b = p1;
        }
    }
    public boolean ueberschneidet(Strecke andere) {
        if(this.a >= andere.b || this.b <= andere.a){
            return false;
        }
        return true;
    }
    public String toString(){
        if(this.a == this.b){
            return String.valueOf(this.a);
        }
        String output = String.valueOf(this.a);
        int abstand = this.b - this.a;

        for (int i = 0; i < abstand; i++){
            output +=  "-";
        }
        output += this.b;
        return output;

    }

}
