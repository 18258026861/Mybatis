package entity;

/**
 * @author YZY
 * @date 2020/4/6 - 21:01
 */

public class Account {
    private int id;
    private String name;
    private float m;

    public Account() {
    }

    public Account(int id, String name, float m) {
        this.id = id;
        this.name = name;
        this.m = m;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getM() {
        return m;
    }

    public void setM(float m) {
        this.m = m;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", m=" + m +
                '}';
    }
}
