package leonardqoli.howest.pwa30.models;

public class Ticket {

    private int event_id;
    private int ticket_id;
    private String title;
    private int price;
    private int persons_allowed;
    private int hour_limitation;

    public Ticket(int event_id, int ticket_id, String title, int price, int persons_allowed, int hour_limitation) {
        this.event_id = event_id;
        this.ticket_id = ticket_id;
        this.title = title;
        this.price = price;
        this.persons_allowed = persons_allowed;
        this.hour_limitation = hour_limitation;
    }

    public int getEvent_id() {
        return event_id;
    }

    public int getTicket_id() {
        return ticket_id;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public int getPersons_allowed() {
        return persons_allowed;
    }

    public int getHour_limitation() {
        return hour_limitation;
    }
}
