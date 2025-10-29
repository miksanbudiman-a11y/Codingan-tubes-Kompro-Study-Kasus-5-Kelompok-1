import java.util.*;

public class MainATM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MesinATM atm = new MesinATM();

      
        Bank bni = new Bank("BNI");
        bni.tambahRekening(new Rekening("111", "King Dzaky", 2_000_000, "BNI", 1_000_000));
        bni.tambahRekening(new Rekening("112", "Ajudan Faras", 3_000_000, "BNI", 1_000_000));
        bni.tambahRekening(new Rekening("113", "Iksan", 5_000_000, "BNI", 2_000_000));

        Bank bri = new Bank("BRI");
        bri.tambahRekening(new Rekening("211", "Melzaqi", 4_000_000, "BRI", 1_000_000));
        bri.tambahRekening(new Rekening("212", "Leonel Ade", 6_000_000, "BRI", 1_500_000));
        bri.tambahRekening(new Rekening("213", "Prince Davi", 2_000_000, "BRI", 1_000_000));

        atm.tambahBank(bni);
        atm.tambahBank(bri);

        System.out.println("");
        System.out.println("================================================");
        System.out.println("    === SELAMAT DATANG DI ATM MULTI-BANK ===");
        System.out.println("================================================");
        while (true) {
            System.out.print("\nMasukkan nomor rekening (atau 'exit' untuk keluar): ");
            String noRek = input.next();
            if (noRek.equalsIgnoreCase("exit")) {
                 System.out.println("================================================");
                System.out.println("       Terima kasih telah menggunakan ATM!");
                 System.out.println("================================================");
                break;
            }

            Rekening akun = atm.login(noRek);
            if (akun != null) {
                atm.menuTransaksi(akun);
            }
        }
    }
}
