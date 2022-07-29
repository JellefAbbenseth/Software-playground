import java.util.Scanner;

public class Spielereien {
    public static void main(String[] args) {
        new Spielereien().spielereien();
    }

    public void spielereien(){
        System.out.println("Test");

        Scanner sc = new Scanner(System.in);

        String text = sc.next();

        System.out.println(text);

        System.out.println("Gib eine ganze Zahl ein:");

        int a = sc.nextInt();

        System.out.println("Gib eine ganze Zahl ein:");
        int b = sc.nextInt();

        int c = addition(a,b);

        System.out.println("Das Ergebnis der Addition ist: " +c);

        System.out.println("Möchtest du Multiplizieren?\nj oder n:");
        if(sc.next().equals("j")){
            c = multiplication(a, b);
            System.out.println("Das Ergebnis der Multiplikation ist: " +c);
        }

        System.out.println("Möchtest du noch etwas rechnen? subtraktion");

        if (sc.next().equals("subtraktion")) {
            c = subtraktion(a, b);
            System.out.println("Das Ergebnis der Subtraktion ist: " +c);
        }

        sc.close(); 
    }

    private int subtraktion(int a, int b) {
        return a -b;
    }

    private int multiplication(int a, int b) {
        return a*b;
    }

    private int addition(int a, int b) {
        return a + b;
    }
}
