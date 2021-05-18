import java.io.*;

class Ajoneuvo {
    private int paino;
    private int huippunopeus;
    private int ajetut_kilometrit;

    Ajoneuvo(int paino, int huippunopeus, int ajetut_kilometrit) {
        this.paino = paino;
        this.huippunopeus = huippunopeus;
        this.ajetut_kilometrit = ajetut_kilometrit;
    }

    protected void aja(int ajettava_matka) {
        this.ajetut_kilometrit += ajettava_matka;
    }

    protected int anna_paino() {
        return this.paino;
    }

    protected int anna_huippunopeus() {
        return this.huippunopeus;
    }

    protected int anna_ajetut_kilometrit() {
        return this.ajetut_kilometrit;
    }
}

class Auto extends Ajoneuvo {
    String merkki;
    String malli;
    String rekisteri_nro;

    boolean kaynnissa;

    Auto(int anna_paino, int anna_huippunopeus, int anna_ajetut_kilometrit, String merkki, String malli, String rekkari, boolean kaynnissa) {
        super(anna_paino, anna_huippunopeus, anna_ajetut_kilometrit);
        this.merkki = merkki;
        this.malli = malli;
        this.rekisteri_nro = rekkari;
        this.kaynnissa = kaynnissa;
    }

    void aseta_merkki(String merkki) {
        this.merkki = merkki;
    }

    void aseta_malli(String malli) {
        this.malli = malli;
    }

    void aseta_rekkari(String rekkari) {
        this.rekisteri_nro = rekkari;
    }

    void kaynnista() {
        this.kaynnissa = true;
    }

    void sammuta() {
        this.kaynnissa = false;
    }

    void katsasta() {
        System.out.println("Auton tiedot:");
        System.out.println("Merkki: " + this.merkki);
        System.out.println("Malli: " + this.malli);
        System.out.println("Ajokilometrit: " + this.anna_ajetut_kilometrit());
        System.out.println("Paino (kg): " + this.anna_paino());
        System.out.println("Huippunopeus (km/h): " + this.anna_huippunopeus());
        System.out.println("Rekisterinumero: " + this.rekisteri_nro);
        if (kaynnissa == true) {
            System.out.println("Auto on käynnissä");
        } else if (kaynnissa == false) {
            System.out.println("Auto ei ole käynnissä");
        }
    }
}

public class Autoilua {
    public static void main(String[] args) {

        BufferedReader lukija = new BufferedReader(new InputStreamReader(System.in));
        int paino, nopeus, km;
        String merkki, malli, rekkari;
        try {
            System.out.println("Anna auton merkki:");
            merkki = lukija.readLine();
            System.out.println("Anna auton malli:");
            malli = lukija.readLine();
            System.out.println("Anna auton rekisterinumero:");
            rekkari = lukija.readLine();
            System.out.println("Anna auton paino:");
            paino = Integer.parseInt(lukija.readLine());
            System.out.println("Anna auton huippunopeus:");
            nopeus = Integer.parseInt(lukija.readLine());
            System.out.println("Anna autolla ajetut kilometrit:");
            km = Integer.parseInt(lukija.readLine());
            System.out.println("\n");

            Auto autoX = new Auto(paino, nopeus, km, merkki, malli, rekkari, false);

            autoX.katsasta();
            autoX.kaynnista();
            autoX.aja(95);
            System.out.print("\n\n");

            autoX.sammuta();
            autoX.katsasta();
        }
        catch (Exception e) {
            System.out.println("Virhetilanne!");
        }
    }
}