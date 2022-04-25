package org.example;

public class Date {

    private int year;
    private int month;
    private int day;


    public Date() {
        this.year = 1970;
        this.month = 1;
        this.day = 1;
    }



    public Date(int day, int month, int year) {
        isValidDate(day, month, year);
        this.day = day;
        this.month = month;
        this.year = year;
    }

    private static boolean isValidDate(int day, int month, int year) {

        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] monthLeapDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        boolean leap = !((year % 4 != 0) || (year % 100) == 0) && (year % 400 != 0);
        //проверка на високосность

        if (year < 1970) {
            throw new IllegalArgumentException("Incorrect year");
        }

        if (month > 12 || month < 1) {
            throw new IllegalArgumentException("Incorrect month");
        }

        if (day <= 0) {
            throw new IllegalArgumentException("Incorrect day < = 0");
        }
        if (!leap && monthDays[month - 1] < day) {
            throw new IllegalArgumentException("Incorrect day");
        }

        if (leap && monthLeapDays[month - 1] < day) {
            throw new IllegalArgumentException("Incorrect day");
        }

        return true;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return year == date.year && month == date.month && day == date.day;
    }

    @Override
    public String toString() {
        return day + "." + month + "." + year;
    }
}