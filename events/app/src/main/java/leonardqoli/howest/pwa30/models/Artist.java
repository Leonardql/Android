package leonardqoli.howest.pwa30.models;

public class Artist {

    private int event_id;
    private int artist_id;
    private String firstName;
    private String lastName;
    private String role;
    private String motto;
    private String facebook_link;
    private String instagram_link;
    private String twitter_link;

    public Artist(int event_id, int artist_id, String firstName, String lastName, String role, String motto, String facebook_link, String instagram_link, String twitter_link) {
        this.event_id = event_id;
        this.artist_id = artist_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.motto = motto;
        this.facebook_link = facebook_link;
        this.instagram_link = instagram_link;
        this.twitter_link = twitter_link;
    }

    public int getEvent_id() {
        return event_id;
    }

    public int getArtist_id() {
        return artist_id;
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

    public String getMotto() {
        return motto;
    }

    public String getFacebook_link() {
        return facebook_link;
    }

    public String getInstagram_link() {
        return instagram_link;
    }

    public String getTwitter_link() {
        return twitter_link;
    }
}

