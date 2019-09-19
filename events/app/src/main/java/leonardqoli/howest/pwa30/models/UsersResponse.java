package leonardqoli.howest.pwa30.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UsersResponse {

    @SerializedName("error")
    private boolean err;

    private List<User> users;

    public UsersResponse(boolean err, List<User> users) {
        this.err = err;
        this.users = users;
    }

    public boolean isErr() {
        return err;
    }

    public List<User> getUsers() {
        return users;
    }
}
