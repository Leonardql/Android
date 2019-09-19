package leonardqoli.howest.pwa30.models;


public class Guest {
    private int event_id;
    private int guest_id;
    private String firstName;
    private String lastName;
    private String role;

    public Guest(int event_id, int guest_id, String firstName, String lastName, String role) {
        this.event_id = event_id;
        this.guest_id = guest_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public int getEvent_id() {
        return event_id;
    }

    public int getGuest_id() {
        return guest_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRole() {
        return role;
    }
}
