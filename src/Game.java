import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);


    public void start() {
        System.out.println("Macera Oyununa Hoşgeldiniz ! ");
        System.out.print("Lütfen bir isim giriniz: ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);

        System.out.println(player.getName() + " Macera Dolu Macera Adasına Hoşgeldin!\nMaceraya Hazırsan Başlıyoruz.");
        System.out.println("----------------------------------------------------------------------------------");
        player.selectChar();
        player.selectLoc();

        Location location = null;

        while (true) {
            player.printInfo();
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("Bölgeler:");
            System.out.println();
            System.out.println("1-Güvenli Ev -> Güvenli evde düşman yok. Güvenli ev sizin için en iyisi!");
            System.out.println("2-Mağaza -> Mağazadan silah veya zırh satın alabilirsiniz.");
            System.out.println("3-Mağara -> Mağaraya gir. Dikkatli ol! Zombi çıkabilir! Kazanırsan ödülün: Yemek.");
            System.out.println("4-Orman -> Ormana gir. Dikkatli ol! Vampir çıkabilir! Kazanırsan ödülün: Odun.");
            System.out.println("5-Nehir -> Nehire gir. Dikkatli ol! Ayı çıkabilir! Kazanırsan ödülün: Su.");
            System.out.println("6-Maden -> Madene gir. Dikkatli ol! Yılan çıkabilir! Kazanırsan ödülün: Para,Zırh veya Silah");
            System.out.println("0-Çıkış yap -> Oyunu sonlandır."
            );
            System.out.println();
            System.out.print("Gitmek istediğiniz bölgeyi seçiniz: ");
            int selectLoc = input.nextInt();
            System.out.println("----------------------------------------------------------------------------------");


            switch (selectLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new Toolstore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                case 6:
                    location = new Mine(player);
                    break;
                default:
                    System.out.println("Geçersiz seçim. Güvenli eve yönlendiriliyorsunuz!");
                    location = new SafeHouse(player);

            }


            if (location == null) {
                System.out.println("Oyun bitti. Yine bekleriz!");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("Oyun bitti!");
                break;
            }
        }
    }
}

