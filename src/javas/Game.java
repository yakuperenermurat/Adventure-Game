package javas;

import javas.locations.*;

import java.util.Scanner;

public class Game {

    private Scanner input = new Scanner(System.in);
    public void start(){
        System.out.println("Macera Oyununa Hoşgeldiniz !");
        System.out.print("Lütfen  bir isim giriniz: ");
        String playerName = input.nextLine();

        Player player = new Player(playerName);
        System.out.println("Sayın " + player.getName() + " bu karanlık ve sisli adaya hoşgeldiniz !! " +
                "Burada yaşananların hepsi gerçek !");
        System.out.println("Lütfen bir karakter seçiniz: ");
        System.out.println("---------------------------------------------");
        player.selectCharacter();

        Location location = null ;
        while(true){
            player.printInfo();
            System.out.println();
            System.out.println("############### Bölgeler ############## ");
            System.out.println();
            System.out.println("1 - Güvenli Ev --> Burası sizin için güvenli bir ev , düşman yoktur !");
            System.out.println("2 - Eşya Dükkanı --> Silah veya Zırh satın alabilirsiniz !");
            System.out.println("3 - Mağara --> Ödül <Yemek> , dikkatli ol karşına  Zombi çıkabilir !");
            System.out.println("4 - Orman  --> Ödül <Odun> , dikkatli ol karşına Vampir çıkabilir !");
            System.out.println("5 - Nehir  --> Ödül <Su> , dikkatli ol karşına Ayı ");
            System.out.println("6 - Maden  --> Ödül <Para,Zırh veya Silah> , dikkatli ol karşına Yılan ");
            System.out.println("0 - Çıkış Yap --> Oyunu sonlandır.");
            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz : ");
            int selectLoc = input.nextInt();
            switch (selectLoc){
                case 0 :
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    if (!player.getInventory().hasAward("Food")){
                    location = new Cave(player);
                    break;}
                    System.out.println("Daha Önce Bu Bölgede Savaştın !!!");
                    continue;
                case 4:
                    if (!player.getInventory().hasAward("Firewood")){
                    location = new Forest(player);
                    break;}
                    System.out.println("Daha Önce Bu Bölgede Savaştın !!!");
                    continue;
                case 5: if (!player.getInventory().hasAward("Water")){
                    location = new River(player);
                    break;}
                    System.out.println("Daha Önce Bu Bölgede Savaştın !!!");
                    continue;
                case 6:
                    location= new Mine(player);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir bölge giriniz !");
            }
            if (location == null) {
                System.out.println("Bu karanlık ve sisli adadan çabuk vazgeçtiniz ! ");
                break;
            }
            if(!location.onLocation() ){
                if(player.getHealth() <= 0) {
                    System.out.println("GAME OVER !");
                }
                break;
            }

        }


    }
}
