package org.example;

import java.util.Objects;

public class Payment {
    private String fullName;
    private Date date;
    private int sumOfPayment;

    public Payment(String fullName, Date date, int sumOfPayment) {
        if (fullName == null) throw new IllegalArgumentException("Пустое ФИО!");
        this.fullName = fullName;
        this.date = date;
        this.sumOfPayment = sumOfPayment;
    }
    public Payment() {
        this.fullName = "noname";
        this.date = new Date();
        this.sumOfPayment = 0;
    }
    public Payment(Payment payment) {
        this.fullName = payment.getFullName();
        this.date = payment.getDate();
        this.sumOfPayment = payment.getSumOfPayment();
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSumOfPayment() {
        return sumOfPayment;
    }

    public void setSumOfPayment(int sumOfPayment) {
        this.sumOfPayment = sumOfPayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return sumOfPayment == payment.sumOfPayment && Objects.equals(fullName, payment.fullName) && Objects.equals(date, payment.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, date, sumOfPayment);
    }

    @Override
    public String toString() {
        int rub = sumOfPayment / 100;
        int kop = sumOfPayment % 100;
        return String.format("Плательщик: %s, Дата: %s, Сумма: %d руб. %02d коп.\n",
                fullName, date.toString(), rub, kop
        );
    }
}
