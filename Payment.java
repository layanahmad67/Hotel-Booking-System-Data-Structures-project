/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

public class Payment {

    private int paymentId;
    private double amount;
    private String payment_Type; // "Credit Card", "Cash", "Online"
    private boolean PayCheck; // to check if the payment is completed

    public Payment(int paymentId, double amount, String payment_Type, boolean PayCheck) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.payment_Type = payment_Type;
        this.PayCheck = PayCheck;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPayment_Type() {
        return payment_Type;
    }

    public void setPayment_Type(String payment_Type) {
        this.payment_Type = payment_Type;
    }

    public boolean isPayCheck() {
        return PayCheck;
    }

    public void setPayCheck(boolean PayCheck) {
        this.PayCheck = PayCheck;
    }

    @Override
    public String toString() {
        return "Payment{" + "paymentId=" + paymentId + ", amount=" + amount + ", payment_Type=" + payment_Type + ", PayCheck=" + PayCheck + '}';
    }
    
    
    
}
