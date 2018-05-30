package alifianadexe.unomi;

/**
 * Created by ditya on 5/28/18.
 */

public class User {

    String nickname;
    String profileURL;
    int userID;

    public User(String nickname, String profileURL, int userID) {
        this.userID = userID;
        this.nickname = nickname;
        this.profileURL = profileURL;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setProfileURL(String profileURL) {
        this.profileURL = profileURL;
    }

    public void setUserID(int i) {
        this.userID = i;
    }

    public String getNickname() {
        return nickname;
    }

    public String getProfileURL() {
        return profileURL;
    }

    public int getUserID() {
         return userID;
    }
}

