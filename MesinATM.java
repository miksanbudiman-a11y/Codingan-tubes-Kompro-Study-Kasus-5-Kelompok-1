import java.util.*;

class MesinATM {
    List<Bank> daftarBank = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public void tambahBank(Bank b) {
        daftarBank.add(b);
    }

    public Rekening login(String noRek) {
        for (Bank b : daftarBank) {
            Rekening r = b.cariRekening(noRek);
            if (r != null) {
                System.out.println("");
                 System.out.println("================================================");
                System.out.println("        Selamat datang, " + r.nama + " di " + b.namaBank);
                 System.out.println("================================================");
                return r;
            }
        }
        System.out.println("Nomor rekening tidak ditemukan!");
        return null;
    }

    public void menuTransaksi(Rekening akun) {
        int pilih;
        do {
            System.out.println("\n===== MENU ATM =====");
            System.out.println("1. Cek Saldo");
            System.out.println("2. Tarik Tunai");
            System.out.println("3. Setor Tunai");
            System.out.println("4. Transfer");
            System.out.println("5. Riwayat Transaksi");
            System.out.println("6. Logout");
            System.out.print("Pilih menu: ");
            pilih = input.nextInt();

            switch (pilih) {
                case 1:
                    System.out.println("=======================================");
                    System.out.println("        Saldo Anda: Rp" + akun.saldo);
                     System.out.println("=====================================");
                    break;
                case 2:
                     System.out.println("================================================");
                    System.out.print("          Masukkan jumlah tarik: Rp");
                    akun.tarik(input.nextDouble());
                     System.out.println("=====================================================");
                    break;
                case 3:
                    System.out.println("======================================================");
                    System.out.print("             Masukkan jumlah setor: Rp");
                    akun.setor(input.nextDouble());
                    System.out.println("================================================");
                    break;
                case 4:
                    System.out.println("================================================");
                    transferMenu(akun);
                    System.out.println("================================================");
                    break;
                case 5:
                    System.out.println("================================================");
                    akun.tampilkanRiwayat();
                    System.out.println("================================================");
                    break;
                case 6:
                    System.out.println("================================================");
        System.out.println("                 Logout berhasil");
        System.out.println("             =====Terima Kasih=====");
        System.out.println("        ==Sampai Jumpa Di lain Waktu Lagi==");
        System.out.println("            ==Jangan Lupa Login Lagi==");
        System.out.println("================================================");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilih != 6);
    }

    private void transferMenu(Rekening sumber) {
        System.out.print("             Masukkan nomor rekening tujuan: ");
        String noTujuan = input.next();

        Rekening tujuan = null;
        for (Bank b : daftarBank) {
            tujuan = b.cariRekening(noTujuan);
            if (tujuan != null) break;
        }

        if (tujuan == null) {
            System.out.println("             Rekening tujuan tidak ditemukan!");
            return;
        }

        System.out.print("             Masukkan jumlah transfer: Rp");
        double jumlah = input.nextDouble();
        sumber.transfer(tujuan, jumlah);
    }
}
