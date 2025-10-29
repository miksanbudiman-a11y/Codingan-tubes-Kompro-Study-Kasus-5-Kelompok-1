import java.util.*;

class Rekening {
    String noRek, nama, bank;
    double saldo, limitHarian, totalTarikHarian;
    List<String> riwayat = new ArrayList<>();

    public Rekening(String noRek, String nama, double saldo, String bank, double limitHarian) {
        this.noRek = noRek;
        this.nama = nama;
        this.saldo = saldo;
        this.bank = bank;
        this.limitHarian = limitHarian;
        this.totalTarikHarian = 0;
    }

    public void tarik(double jml) {
        if (jml <= 0) {
            System.out.println("Jumlah tidak valid!");
            return;
        }
        if (jml > saldo) {
            System.out.println("             Saldo tidak mencukupi!");
        } else if (totalTarikHarian + jml > limitHarian) {
            System.out.println("   Melebihi limit harian! Sisa limit: Rp" + (limitHarian - totalTarikHarian));
        } else {
            saldo -= jml;
            totalTarikHarian += jml;
            riwayat.add("           Tarik tunai: Rp" + jml);
            System.out.println("   Penarikan berhasil. Sisa saldo "  +  nama + ": Rp" + saldo);
        }
    }

    public void setor(double jml) {
        if (jml <= 0) {
            System.out.println("Jumlah setor tidak valid!");
            return;
        }
        saldo += jml;
        riwayat.add("           Setor tunai: Rp" + jml);
        System.out.println("     Setoran berhasil. Saldo sekarang: Rp" + saldo);
    }

    public void transfer(Rekening tujuan, double jml) {
        double biaya = 0;
        if (!this.bank.equals(tujuan.bank)) {
            biaya = 6500;
            System.out.println("          Transfer antar bank, biaya admin Rp6.500");
        }

        if (jml + biaya > saldo) {
            System.out.println("Saldo tidak cukup untuk transfer + biaya admin.");
            return;
        }

        saldo -= (jml + biaya);
        tujuan.saldo += jml;

        riwayat.add("     Transfer ke " + tujuan.noRek + " (" + tujuan.nama + ") Rp" + jml);
        tujuan.riwayat.add("             Terima dari " + this.noRek + " (" + this.nama + ") Rp" + jml);

        System.out.println("    Transfer berhasil ke " + tujuan.nama + " sejumlah Rp" + jml);
    }

    public void tampilkanRiwayat() {
        System.out.println("        === Riwayat Transaksi " + nama + " ===");
        if (riwayat.isEmpty()) {
            System.out.println("            == Belum ada transaksi ==");
            System.out.println("      === silahkan lalukan transaksi "  + nama + " ===");
        } else {
            for (String r : riwayat) {
                System.out.println("- " + r);
            }
        }
    }
}