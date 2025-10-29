import java.util.*;

class Bank {
    String namaBank;
    List<Rekening> daftarRekening = new ArrayList<>();

    public Bank(String namaBank) {
        this.namaBank = namaBank;
    }

    public void tambahRekening(Rekening r) {
        daftarRekening.add(r);
    }

    public Rekening cariRekening(String noRek) {
        for (Rekening r : daftarRekening) {
            if (r.noRek.equals(noRek)) {
                return r;
            }
        }
        return null;
    }
}