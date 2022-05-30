package com.tvolvers.certification.restfulbooker.models;

public class ClientData {
    private String firstname;
    private String lastname;
    private int totalprice;
    private Boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;

    private String checkin;
    private String checkout;

    public ClientData(String firstname, String lastname, int totalprice, Boolean depositpaid, String checkin, String checkout,String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.additionalneeds = additionalneeds;
        this.checkin = checkin;
        this.checkout= checkout;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public Boolean getDepositpaid() {
        return depositpaid;
    }

    public BookingDates getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates( String checkin, String checkout) {
        this.bookingdates = new BookingDates(checkin,checkout);
    }


    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public String getCheckin() {
        return checkin;
    }

    public String getCheckout() {
        return checkout;
    }
}
