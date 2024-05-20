import java.util.Scanner;

public class Player {
    private int damage ;
    private int health ;
    private int orjinalHealth;
    private int money ;
    private String name ;
    private String characterName;
    private Scanner input = new Scanner(System.in);
    private Inventory inventory;
    public Player (String name)
    {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectCharacter(){
        GameCharacter [] charList = {new Samurai() , new Archer(),new Knight()};
        System.out.println("Karakterler");
        System.out.println("---------------------------------------------");
       for (GameCharacter gameCharacter : charList) {
           System.out.println("ID : "+gameCharacter.getId()+
                   "\t Karakter: " + gameCharacter.getName() +
                   "\t Hasar: "+gameCharacter.getDamage()+
                   "\t Sağlık:  " +gameCharacter.getHealty()+
                   "\t Para: " + gameCharacter.getMoney());
       }

        System.out.println("---------------------------------------------");
        System.out.print("Lütfen bir karakter seçiniz ! ");
        int selectCharacter = input.nextInt();

        switch (selectCharacter){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
        System.out.println("Karakter : " + this.getCharacterName() +
                ", Hasar : " + this.getDamage() +
                ", Sağlık : " + this.getHealth() +
                ", Para : " + this.getMoney());
    }


    public void initPlayer(GameCharacter gameCharacter){
        this.setDamage(gameCharacter.getDamage());
        this.setHealth(gameCharacter.getHealty());
        this.setOrjinalHealth(gameCharacter.getHealty());
        this.setMoney(gameCharacter.getMoney());
        this.setCharacterName(gameCharacter.getName());

    }

    public void printInfo(){
        System.out.println(
                "Silah : " + this.getInventory().getWeapon().getName() +
                ", Zırh : " + this.getInventory().getArmor().getName()+
                ", Bloklama : " + this.getInventory().getArmor().getBlock() +
                ", Hasar : " + this.getTotalDamage() +
                ", Sağlık : " + this.getHealth() +
                ", Para : " + this.getMoney());
    }
    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }
    public int getDamage() {
        return damage ;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0){
            health = 0;
        }
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOrjinalHealth() {
        return orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }
}
