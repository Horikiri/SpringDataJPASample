package jp.co.foxbit.horikiri.spring.jpa.sample.model.result;

import java.text.SimpleDateFormat;

import jp.co.foxbit.horikiri.spring.jpa.sample.model.db.DBInformationModel;

public class ResultInformationModel {

    private String userID;

    private String firstName;

    private String lastName;

    private String createdAt;

    private String modifiedAt;

    private boolean validUser;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public boolean getValidUser() {
        return validUser;
    }

    public void setValidUser(boolean validUser) {
        this.validUser = validUser;
    }

    public ResultInformationModel(DBInformationModel informationModel) {

        userID = informationModel.getUserID();
        firstName = informationModel.getFirstName();
        lastName = informationModel.getLastName();
        createdAt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(informationModel.getCreatedAt());
        modifiedAt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(informationModel.getModifiedAt());
        validUser = !informationModel.getDeleted();
    }

}
