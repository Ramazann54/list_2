package org.example;

public class FinanceReport {
    private Payment[] payments;
    private String fullName;
    private int quantityOfReports;
    private Date date;

    public FinanceReport(int quantityOfReports, int day, int month, int year, String fullName) {
        if(fullName == null || fullName.isEmpty()) throw new IllegalArgumentException();
        this.quantityOfReports = quantityOfReports;
        payments = new Payment[quantityOfReports];
        this.date = new Date(day, month, year);
        this.fullName = fullName;
    }
    public FinanceReport(FinanceReport f) {
        this.quantityOfReports = f.getQuantityOfReports();
        this.payments = new Payment[f.payments.length];
        for (int i = 0; i < f.payments.length; i++) {
            this.payments[i] = new Payment(f.payments[i]);
        }
        this.date = new Date(f.getDay(), f.getMonth(), f.getYear());
        this.fullName = f.getAuthor();
    }
    public FinanceReport() {
        this.quantityOfReports = 0;
        payments = new Payment[quantityOfReports];
        this.date = new Date();
        this.fullName = "noname";
    }

    public void setPayment(Payment report, int i) {
        this.payments[i] = new Payment(report);
    }

    public int getNumberOfPayments() {
        return payments.length;
    }
    public Payment getPayment(int i) {
        return payments[i];
    }

    public int getQuantityOfReports() {
        return payments.length;
    }

    public Payment[] getPayments() {
        return payments;
    }

    public int getDay() {
        return this.date.getDay();
    }

    public void setDay(int day) {
        this.date.setDay(day);
    }

    public int getMonth() {
        return this.date.getMonth();
    }

    public void setMonth(int month) {
        this.date.setMonth(month);
    }

    public int getYear() {
        return this.date.getYear();
    }

    public void setYear(int year) {
        this.date.setYear(year);
    }

    public String getAuthor() {
        return fullName;
    }

    public void setAuthor(String fullName) {
        this.fullName = fullName;
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder( String.format(
                "Автор: %s, Дата: %02d.%02d.%04d, Количество платежей: %s, Платежи:\n",
                fullName, getDay(), getMonth(), getYear(), quantityOfReports)
        );
        if (payments != null) {
            for (Payment payment : payments) {
                if (payment != null) {
                    result.append(payment);
                }
            }
        }
        return result.toString();
    }



}
