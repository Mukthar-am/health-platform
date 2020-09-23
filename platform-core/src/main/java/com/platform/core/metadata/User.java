package com.platform.core.metadata;

public class User {
    private int ID;
    private String NAME = null;
    private int AGE;
    private String GENDER;

    public User() { }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public int getAGE() {
        return AGE;
    }

    public void setAGE(int AGE) {
        this.AGE = AGE;
    }

    public String getGENDER() {
        return GENDER;
    }

    public void setGENDER(String GENDER) {
        this.GENDER = GENDER;
    }

    @Override
    public String toString() {
        StringBuilder userInfo = new StringBuilder();

        return userInfo.toString();
    }
}
