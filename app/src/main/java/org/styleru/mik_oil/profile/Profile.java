package org.styleru.mik_oil.profile;

public class Profile {

    private String name;
    private String numberCard;
    private String urlPhoto;
    private double scoreCard;

    Profile(String name, String numberCard, String urlPhoto, double scoreCard) {
        this.name = name;
        this.numberCard = numberCard;
        this.scoreCard = scoreCard;
        this.urlPhoto = urlPhoto;
    }

    String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    double getScoreCard() {
        return scoreCard;
    }

    public void setScoreCard(float scoreCard) {
        this.scoreCard = scoreCard;
    }

    String getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(String numberCard) {
        this.numberCard = numberCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
