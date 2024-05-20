package javas;

public class Armor {
    private int id;
    private int block;
    private String name;
    private int price;

    public Armor(int id,  String name,int block, int price) {
        this.id = id;
        this.block = block;
        this.name = name;
        this.price = price;
    }

    public static Armor[] armors(){
        Armor[] armorList = new Armor[3];
        armorList[0]= new Armor(1,"Hafif",1,15);
        armorList[1]= new Armor(2,"Orta",3,25);
        armorList[2]= new Armor(3,"Ağır",1,40);
        return armorList;
    }
    public static Armor getArmorObjID(int id){
        for (Armor a : Armor.armors()){
            if (a.getId() == id){
                return a;
            }
        }
        return null;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
