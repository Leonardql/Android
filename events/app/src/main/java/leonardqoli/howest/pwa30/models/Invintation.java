package leonardqoli.howest.pwa30.models;

public class Invintation {

    private int invintation_id;
    private int user_id;
    private String guestName;
    private String guestNumber;
    private String guestEmail;
    private String guestMessage;


    public Invintation(int invintation_id, int user_id, String guestName, String guestNumber, String guestEmail, String guestMessage) {
        this.invintation_id = invintation_id;
        this.user_id = user_id;
        this.guestName = guestName;
        this.guestNumber = guestNumber;
        this.guestEmail = guestEmail;
        this.guestMessage = guestMessage;
    }

    public int getInvintation_id() {
        return invintation_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getGuestNumber() {
        return guestNumber;
    }

    public String getGuestEmail() {
        return guestEmail;
    }

    public String getGuestMessage() {
        return guestMessage;
    }
}

