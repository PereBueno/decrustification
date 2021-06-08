package com.pbueno.learning.decrustification.dates;

/**
 * Using Date.java, create a function addDates(int) that allows adding the specified number of days to given date
 */
public class Date {
    public int day;
    public int month;
    public int year;
    private int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Date(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public Date addDate(int days) {
        Date newDate;
        synchronized (this){
            newDate = new Date(this.year, this.month, this.day);
        }
        newDate.day += days;
        if (newDate.day > daysInMonth[newDate.month-1]){
            int daysTilMonthEnd = daysInMonth[newDate.month-1] -(newDate.day - days) + 1;
            newDate.day = 1;
            newDate.month++;
            if (newDate.month == 13){
                newDate.month = 1;
                newDate.year++;
            }
            newDate = newDate.addDate(days - daysTilMonthEnd);
        }
        return newDate;
    }
}
