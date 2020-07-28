package com.example.notificationtask;

public class NotificationModel {
    int image;
    String username;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOlof() {
        return olof;
    }

    public void setOlof(String olof) {
        this.olof = olof;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }

    String olof;
    String userType;
    String descp;
    public NotificationModel(int image, String username, String olof, String userType, String descp) {
        this.image = image;
        this.username = username;
        this.olof = olof;
        this.userType = userType;
        this.descp = descp;
    }


}
