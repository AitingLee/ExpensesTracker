package org.example;

public class Invoice 
{
    private String payee;
    private int amount, month, day;

    public Invoice(int amount, int month, int day, String payee) {
        this.payee = payee;
        this.amount = amount;
        this.month = month;
        this.day = day;
    }

    public String getPayee() {
        return payee;
    }

    public int getAmount() {
        return amount;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void printInvoice()
    {
        System.out.println("amount:" + amount + ", month:" + month + ", day:" + day + ", payee:" + payee);
    }

    
}
