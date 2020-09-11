package jp.co.foxbit.horikiri.spring.jpa.sample.model.db;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import jp.co.foxbit.horikiri.spring.jpa.sample.model.parameter.ParameterInformationModel;

@Entity
@Table(schema = "[user]", name = "[Information]")
public class DBInformationModel {

    @Id
    @Column(name = "userid", nullable = false, updatable = false)
    private String userID;

    @Column(name = "firstname", nullable = false)
    private String firstName;

    @Column(name = "lastname", nullable = false)
    private String lastName;

    @Column(name = "createdat", nullable = true, updatable = false)
    private Timestamp createdAt;

    @Column(name = "modifiedat", nullable = true)
    private Timestamp modifiedAt;

    @Column(name = "deleted", nullable = true)
    private boolean deleted;

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

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Timestamp modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public DBInformationModel() {

        createdAt = new Timestamp(System.currentTimeMillis());
        modifiedAt = createdAt;
    }

    public DBInformationModel(ParameterInformationModel informationModel, boolean isCreate) {

        var timestamp = new Timestamp(System.currentTimeMillis());

        userID = informationModel.getUserID();
        firstName = informationModel.getFirstName();
        lastName = informationModel.getLastName();
        if (isCreate) createdAt = timestamp;
        modifiedAt = timestamp;
        deleted = !informationModel.getValidUser();
    }
}
