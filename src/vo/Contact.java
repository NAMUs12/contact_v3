package vo;

public class Contact {
    private int age;  // getter 만
    private long id;
    private String name;
    private String phone;

    // 생성자
    public Contact(Long id, String name, int age, String phone) {
        this.age = age;
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    // Getter
    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getPhone() {
        return this.phone;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // toString 재정의
    @Override
    public String toString() {
        return "[" + id + "] " + name + " / " + age + " / " + phone;
    }
}