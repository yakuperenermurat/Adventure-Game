package javas;

public class Obstacle {
    private int id ;
    private int damage ;
    private int health;
    private String name ;
    private int ObsAward;
    private int orjinalHealth;


    public Obstacle(int id, String name, int damage, int health,int ObsAward) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.health = health;
        setOrjinalHealth(health);
        this.ObsAward = ObsAward;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0 ){
            health = 0;
        }
        this.health = health;
    }

    public int getObsAward() {
        return ObsAward;
    }

    public void setObsAward(int award) {
        this.ObsAward = award;
    }

    public int getOrjinalHealth() {
        return orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }
}
