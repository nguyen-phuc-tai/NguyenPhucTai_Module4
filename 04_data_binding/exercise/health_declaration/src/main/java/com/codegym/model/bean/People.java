package com.codegym.model.bean;


public class People {
    private String name;
    private String year;
    private String gender;
    private String nationality;
    private String idCard;
    private String travelInformation;
    private String vehicleNumber;
    private String seats;
    private String startDay;
    private String endDay;
    private String information;
    private String city;
    private String district;
    private String commune;
    private String address;
    private String phoneNumber;
    private String email;
    private String[] symptom;
    private String[] exposureHistory;

    public People() {
    }

    public People(String name, String year, String gender, String nationality,
                  String idCard, String travelInformation, String vehicleNumber, String seats,
                  String startDay, String endDay, String information, String city, String district,
                  String commune, String address, String phoneNumber, String email, String[] symptom, String[] exposureHistory) {
        this.name = name;
        this.year = year;
        this.gender = gender;
        this.nationality = nationality;
        this.idCard = idCard;
        this.travelInformation = travelInformation;
        this.vehicleNumber = vehicleNumber;
        this.seats = seats;
        this.startDay = startDay;
        this.endDay = endDay;
        this.information = information;
        this.city = city;
        this.district = district;
        this.commune = commune;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.symptom = symptom;
        this.exposureHistory = exposureHistory;
    }

    public String[] getExposureHistory() {
        return exposureHistory;
    }

    public void setExposureHistory(String[] exposureHistory) {
        this.exposureHistory = exposureHistory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getTravelInformation() {
        return travelInformation;
    }

    public void setTravelInformation(String travelInformation) {
        this.travelInformation = travelInformation;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getSymptom() {
        return symptom;
    }

    public void setSymptom(String[] symptom) {
        this.symptom = symptom;
    }
}
