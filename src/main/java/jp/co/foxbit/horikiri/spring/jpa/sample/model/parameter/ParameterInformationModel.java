package jp.co.foxbit.horikiri.spring.jpa.sample.model.parameter;

public class ParameterInformationModel {

    private String userID;

    private String firstName;

    private String lastName;

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

    public boolean getValidUser() {
        return validUser;
    }

    public void setValidUser(boolean validUser) {
        this.validUser = validUser;
    }
}
