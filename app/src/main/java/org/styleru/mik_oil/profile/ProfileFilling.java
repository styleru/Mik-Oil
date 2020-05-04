package org.styleru.mik_oil.profile;

public class ProfileFilling {

    private String userName;
    private String avatarURL;
    private double cardBalance;
    // Barcode attribute.
    private String cardNumber;

    ProfileFilling(String userName, String avatarURL,
                   double cardBalance, String cardNumber) {
        this.userName = userName;
        this.avatarURL = avatarURL;
        this.cardBalance = cardBalance;
        this.cardNumber = cardNumber;
    }

    public ProfileFilling() {
    }

    public ProfileFilling(ProfileFilling profileFilling) {
        userName = profileFilling.userName;
        avatarURL = profileFilling.avatarURL;
        cardBalance = profileFilling.cardBalance;
        cardNumber = profileFilling.cardNumber;
    }

    String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    double getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(double cardBalance) {
        this.cardBalance = cardBalance;
    }

    String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

