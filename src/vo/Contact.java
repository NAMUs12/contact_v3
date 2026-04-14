package vo;

public class Contact {
    private int id;  // getter 만
    private String name;
    private String phone;

    // 생성자
    public Contact(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    // Getter와 Setter
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // toString 재정의
    @Override
    public String toString() {
        return "[" + id + "] " + name + " / " + phone;
    }
}