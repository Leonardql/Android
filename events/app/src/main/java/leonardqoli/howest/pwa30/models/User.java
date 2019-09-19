package leonardqoli.howest.pwa30.models;

public class User {

    private int user_id;
    private String email;
    private String name;
    private String created_at;


    public User(int user_id, String email, String userName, String created_at) {
        this.user_id = user_id;
        this.email = email;
        this.name = userName;
        this.created_at = created_at;
    }

    public int getId() {
        return user_id;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return name;
    }

    public String getCreated_at() {
        return created_at;
    }
}
