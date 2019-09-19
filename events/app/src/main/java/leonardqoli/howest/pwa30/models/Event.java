package leonardqoli.howest.pwa30.models;

public class Event {

    private int event_id;
    private String title;
    private String date;
    private String city;
    private String country;
    private String postal;
    private String info;
    private String about_the_party;
    private String created_at;

    public Event(int event_id, String title, String date, String city, String country, String postal, String info, String about_the_party, String created_at) {
        this.event_id = event_id;
        this.title = title;
        this.date = date;
        this.city = city;
        this.country = country;
        this.postal = postal;
        this.info = info;
        this.about_the_party = about_the_party;
        this.created_at = created_at;
    }

    public int getEvent_id() {
        return event_id;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
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

    public String getInfo() {
        return info;
    }

    public String getAbout_the_party() {
        return about_the_party;
    }

    public String getCreated_at() {
        return created_at;
    }
}