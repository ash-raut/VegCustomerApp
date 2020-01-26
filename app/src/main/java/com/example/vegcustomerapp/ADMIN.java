package com.example.vegcustomerapp;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ADMIN {

private static ADMIN currentAdmin = null;

    public static ADMIN getCurrentAdmin() {
        return currentAdmin;
    }

    public static void setCurrentAdmin(ADMIN currentAdmin) {
        ADMIN.currentAdmin = currentAdmin;
    }

    @SerializedName("admin_id")
    @Expose
    private String adminId;
    @SerializedName("admin_name")
    @Expose
    private String adminName;
    @SerializedName("admin_user_name")
    @Expose
    private String adminUserName;
    @SerializedName("admin_mobile")
    @Expose
    private String adminMobile;
    @SerializedName("admin_gender")
    @Expose
    private String adminGender;
    @SerializedName("admin_email")
    @Expose
    private String adminEmail;
    @SerializedName("admin_registration_date")
    @Expose
    private String adminRegistrationDate;
    @SerializedName("admin_password")
    @Expose
    private String adminPassword;

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminUserName() {
        return adminUserName;
    }

    public void setAdminUserName(String adminUserName) {
        this.adminUserName = adminUserName;
    }

    public String getAdminMobile() {
        return adminMobile;
    }

    public void setAdminMobile(String adminMobile) {
        this.adminMobile = adminMobile;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminRegistrationDate() {
        return adminRegistrationDate;
    }

    public void setAdminRegistrationDate(String adminRegistrationDate) {
        this.adminRegistrationDate = adminRegistrationDate;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminGender() {
        return adminGender;
    }

    public void setAdminGender(String adminGender) {
        this.adminGender = adminGender;
    }
}
