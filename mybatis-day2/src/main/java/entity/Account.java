package entity;

/**
 * @author YZY
 * @date 2020/4/6 - 21:01
 */
public class Account {
    private String name;
    private int id;
    private float money;

    public Account() {
    }

    public Account(int id,String name,  float money) {
        this.name = name;
        this.id = id;
        this.money = money;
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

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", money=" + money +
                '}';
    }
}
