import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Kutuphane {

    public static void main(String[] args) {

        // Kütüphanedeki kitapları saklamak için bir HashMap oluşturuldu.
        Map<String, String> kitaplar = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Kullanıcıya menü seçenekleri gösterildi.
            System.out.println("1. Kitapları Listele");
            System.out.println("2. Kitap Ekle");
            System.out.println("3. Kitap Sil");
            System.out.println("4. Çıkış");
            System.out.print("Seçiminizi yapın (1-4): ");

            int secim = scanner.nextInt();
            scanner.nextLine(); // dummy code

            switch (secim) {
                case 1:
                    // Kütüphanedeki kitapları listeleme işlemi
                    listeleKitaplar(kitaplar);
                    break;
                case 2:
                    // Kütüphaneye yeni kitap ekleme işlem
                    kitapEkle(kitaplar, scanner);
                    break;
                case 3:
                    // Kütüphaneden kitap silme işlemi
                    kitapSil(kitaplar, scanner);
                    break;
                case 4:
                    // Programdan çıkış işlemi
                    System.out.println("Programdan çıkılıyor...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Geçersiz seçim! Tekrar deneyin.");
            }
        }
    }

    // Kütüphanedeki kitapları listeleme işlemini gerçekleştiren metod
    private static void listeleKitaplar(Map<String, String> kitaplar) {
        if (kitaplar.isEmpty()) {
            System.out.println("Kütüphane boş.");
        } else {
            System.out.println("Kütüphanedeki Kitaplar:");
            for (Map.Entry<String, String> entry : kitaplar.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    // Yeni bir kitap eklemek için kullanılan metod
    private static void kitapEkle(Map<String, String> kitaplar, Scanner scanner) {
        System.out.print("Kitap adını girin: ");
        String kitapAdi = scanner.nextLine();

        System.out.print("Yazar adını girin: ");
        String yazarAdi = scanner.nextLine();

        kitaplar.put(kitapAdi, yazarAdi);
        System.out.println("Kitap eklendi: " + kitapAdi);
    }


    // Kütüphaneden bir kitap silmek için kullanılan metod

    private static void kitapSil(Map<String, String> kitaplar, Scanner scanner) {
        System.out.print("Silmek istediğiniz kitap adını girin: ");
        String kitapAdi = scanner.nextLine();

        if (kitaplar.containsKey(kitapAdi)) {
            kitaplar.remove(kitapAdi);
            System.out.println(kitapAdi + " adlı kitap silindi.");
        } else {
            System.out.println("Bu isimde bir kitap bulunamadı.");
        }
    }
}

