package gerenciador;

public class Customer {
    private int customerId;
    private String name;
    private String city;
    private int grade;
    private int salesmanId;

    public Customer() {
    }

    public Customer(String name, String city, int grade, int salesmanId) {
        this.name = name;
        this.city = city;
        this.grade = grade;
        this.salesmanId = salesmanId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getSalesmanId() {
        return salesmanId;
    }

    public void setSalesmanId(int salesmanId) {
        this.salesmanId = salesmanId;
    }
}
