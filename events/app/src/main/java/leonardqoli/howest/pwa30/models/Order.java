package leonardqoli.howest.pwa30.models;

public class Order {

    private int order_id;
    private int user_id;
    private int ticket_id_1;
    private int ticket_id_2;
    private int ticket_id_3;
    private int ticket_id_1_quantity;
    private int ticket_id_2_quantity;
    private int ticket_id_3_quantity;
    private int totalOrder;
    private String firstName;
    private String lastName;
    private String company;
    private String title;
    private String address;
    private String apartment;
    private String city;
    private String country;
    private String postal;
    private String phoneNumber;
    private String created_at;

    public Order(int order_id, int user_id, int ticket_id_1, int ticket_id_2, int ticket_id_3, int ticket_id_1_quantity, int ticket_id_2_quantity, int ticket_id_3_quantity, int totalOrder, String firstName, String lastName, String company, String title, String address, String apartment, String city, String country, String postal, String phoneNumber, String created_at) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.ticket_id_1 = ticket_id_1;
        this.ticket_id_2 = ticket_id_2;
        this.ticket_id_3 = ticket_id_3;
        this.ticket_id_1_quantity = ticket_id_1_quantity;
        this.ticket_id_2_quantity = ticket_id_2_quantity;
        this.ticket_id_3_quantity = ticket_id_3_quantity;
        this.totalOrder = totalOrder;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.title = title;
        this.address = address;
        this.apartment = apartment;
        this.city = city;
        this.country = country;
        this.postal = postal;
        this.phoneNumber = phoneNumber;
        this.created_at = created_at;
    }

    public int getOrder_id() {
        return order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getTicket_id_1() {
        return ticket_id_1;
    }

    public int getTicket_id_2() {
        return ticket_id_2;
    }

    public int getTicket_id_3() {
        return ticket_id_3;
    }

    public int getTicket_id_1_quantity() {
        return ticket_id_1_quantity;
    }

    public int getTicket_id_2_quantity() {
        return ticket_id_2_quantity;
    }

    public int getTicket_id_3_quantity() {
        return ticket_id_3_quantity;
    }

    public int getTotalOrder() {
        return totalOrder;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompany() {
        return company;
    }

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }

    public String getApartment() {
        return apartment;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getPostal() {
        return postal;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCreated_at() {
        return created_at;
    }
}
