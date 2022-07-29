public class StringsZerlegen {

    private String strLandzeichen;
    private String strPruefZiffer;
    private String strKontonummer;
    private String strBLZ;

    public static void main(String[] args) {
        new StringsZerlegen();
    }

    public StringsZerlegen() {
        extrahiereKennzeichen("DE68210501700012345678");
        ausgabeKennzeichen();
        splitString();
    }

    private void splitString() {
        String str = "Wilkommen:lieber Gast";

        String[] arrOfStr =str.split(":");/*
        for (String a : arrOfStr) {
            System.out.println(a);
        }*/
        for (int i = 0; i<arrOfStr.length; i++) {
            String[] arrTwoOfStr = arrOfStr[i].split(" ");
            for (String b : arrTwoOfStr) {
                System.out.println(b);
            }
            System.out.println();
        }

    }

    public void ausgabeKennzeichen() {
        System.out.println("Land: " +strLandzeichen);
        System.out.println("Prüfziffer: " +strPruefZiffer);
        System.out.println("Bankleitzahl: " +strBLZ);
        System.out.println("Kontonummer: " +strKontonummer);
    }

    public void extrahiereKennzeichen(String iban) {
        strLandzeichen = iban.substring(0, 2);
        strPruefZiffer = iban.substring(2, 4);
        strBLZ = iban.substring(4, 12);
        strKontonummer = iban.substring(12, 22);

    }
}
