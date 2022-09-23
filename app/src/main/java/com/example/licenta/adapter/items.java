package com.example.licenta.adapter;

public class items {

    private String lName;
    private int lPrice;
    private String lDetails;
    private int lImageId;
    private int lImageId1;
    private int lImageId2;
    private String lPayment;
    private String lModel;
    private int lQuantity;

    // Constructors
    public items(String ObjectName, int ObjectPrice, int ImageResourceId, String DetailsItem, String ModelUri) {
        lName = ObjectName;
        lPrice = ObjectPrice;
        lImageId = ImageResourceId;
        lDetails = DetailsItem;
        lModel = ModelUri;

    }

    public items(int ObjectPrice, String Payment){
        this.lPrice = ObjectPrice;
        this.lPayment = Payment;
    }

    public items(String ObjectName, int ObjectPrice, int ImageResourceId) {
        lName = ObjectName;
        lPrice = ObjectPrice;
        lImageId = ImageResourceId;
    }

    public items(String ObjectName, int ObjectPrice, int ImageResourceId, int ImageResourceId1, int ImageResourceId2, String ModelUri, String DetailsItem) {
        lName = ObjectName;
        lPrice = ObjectPrice;
        lImageId = ImageResourceId;
        lDetails = DetailsItem;
        lModel = ModelUri;
        lImageId1 = ImageResourceId1;
        lImageId2 = ImageResourceId2;

    }

    public items(String ObjectName, int ObjectPrice, int ImageResourceId, int ImageResourceId1, int ImageResourceId2, String ModelUri, String DetailsItem, int Quantity) {
        lName = ObjectName;
        lPrice = ObjectPrice;
        lImageId = ImageResourceId;
        lDetails = DetailsItem;
        lModel = ModelUri;
        lImageId1 = ImageResourceId1;
        lImageId2 = ImageResourceId2;
        lQuantity = Quantity;

    }

    public items(int ImageResourceId) {
        lImageId = ImageResourceId;
    }

    // Getters
    public String getlName() {
        return lName;
    }

    public int getlPrice() {
        return lPrice;
    }

    public int getQuantity() {
        return lQuantity;
    }

    public void setQuantity(int quantity) {
        this.lQuantity = quantity;
    }

    public int getlImageId() {
        return lImageId;
    }

    public String getlDetails() {
        return lDetails;
    }

    public String getlModel() {
        return lModel;
    }

    public int getlImageId1() {
        return lImageId1;
    }

    public int getlImageId2() {
        return lImageId2;
    }

    public String getlPayment() { return lPayment; }


    // Setters
    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setlImageId(int lImageId) {
        this.lImageId = lImageId;
    }

    public void setlDetails(String lDetails) {
        this.lDetails = lDetails;
    }

    public void setlPrice(int lPrice) {
        this.lPrice = lPrice;
    }

    public void setlModel(String lModel) {
        this.lModel = lModel;
    }

    public void setlImageId1(int lImageId1) {
        this.lImageId1 = lImageId1;
    }

    public void setlImageId2(int lImageId2) {
        this.lImageId2 = lImageId2;
    }

    public void setlPayment(String lPayment) { this.lPayment = lPayment; }

}
