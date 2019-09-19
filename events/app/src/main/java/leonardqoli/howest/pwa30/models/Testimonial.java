package leonardqoli.howest.pwa30.models;

public class Testimonial {

    private int event_id;
    private int testimonial_id;
    private int user_id;
    private String comment;

    public Testimonial(int event_id, int testimonial_id, int user_id, String comment) {
        this.event_id = event_id;
        this.testimonial_id = testimonial_id;
        this.user_id = user_id;
        this.comment = comment;
    }

    public int getEvent_id() {
        return event_id;
    }

    public int getTestimonial_id() {
        return testimonial_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getComment() {
        return comment;
    }
}
