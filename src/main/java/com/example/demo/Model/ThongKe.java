package com.example.demo.Model;

public class ThongKe {
    private int countMember;
    private int borrowed;
    private int borrowing;
    private int violation;
    private int handled;
    private int handling;
    private int fee;

    public ThongKe() {
    }

    public ThongKe(int countMember, int borrowed, int borrowing, int violation, int handled, int handling, int fee) {
        this.countMember = countMember;
        this.borrowed = borrowed;
        this.borrowing = borrowing;
        this.violation = violation;
        this.handled = handled;
        this.handling = handling;
        this.fee = fee;
    }

    public int getBorrowing() {
        return borrowing;
    }

    public void setBorrowing(int borrowing) {
        this.borrowing = borrowing;
    }

    public int getCountMember() {
        return countMember;
    }

    public void setCountMember(int countMember) {
        this.countMember = countMember;
    }

    public int getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(int borrowed) {
        this.borrowed = borrowed;
    }

    public int getViolation() {
        return violation;
    }

    public void setViolation(int violation) {
        this.violation = violation;
    }

    public int getHandled() {
        return handled;
    }

    public void setHandled(int handled) {
        this.handled = handled;
    }

    public int getHandling() {
        return handling;
    }

    public void setHandling(int handling) {
        this.handling = handling;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }
}
