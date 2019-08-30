package com.herculis.model;

import com.herculis.annotation.Field;

public class CreditCard {

    /**
     * <p>Placeholder like : 5456165456165454</p>
     */
    @Field("CARDPAN")
    private String pan;

    /**
     * <p>Placeholder like : 12.2020</p>
     */
    @Field("CARDEXPIRY")
    private String expiryDate;

    /**
     * <p>Placeholder like : 000</p>
     */
    @Field("CARDCVV")
    private String cvv;

    /**
     * <p>Placeholder like : 000</p>
     */
    @Field("NAMEONCARD")
    private String nameOnCard;

    public CreditCard() {
    }

    public CreditCard(String pan, String expiryDate) {
        this.pan = pan;
        this.expiryDate = expiryDate;
    }

    public CreditCard(String pan, String expiryDate, String nameOnCard) {
        this.pan = pan;
        this.expiryDate = expiryDate;
        this.nameOnCard = nameOnCard;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }
}
