package jp.co.foxbit.horikiri.spring.jpa.sample.model.form;

import java.text.SimpleDateFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import jp.co.foxbit.horikiri.spring.jpa.sample.model.db.InformationModel;

public class InformationForm {

    @NotBlank
    @Size(min = 8, max = 32)
    @Email
//    @Pattern(regexp = "[a-zA-Z0-9!-/:-@\\[-~\\.]*")
    private String userID;

    @NotBlank
    @Size(max = 32)
    private String firstName;

    @NotBlank
    @Size(max = 32)
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

    public InformationForm() {

    }
    
    public InformationForm(InformationModel informationModel) {

        userID = informationModel.getUserID();
        firstName = informationModel.getFirstName();
        lastName = informationModel.getLastName();
        createdAt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(informationModel.getCreatedAt());
        modifiedAt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(informationModel.getModifiedAt());
        validUser = !informationModel.getDeleted();
    }
}