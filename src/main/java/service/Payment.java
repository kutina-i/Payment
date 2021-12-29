package service;

import java.util.Objects;

public class Payment {

private String FIO;
private int day;
private int month;
private int year;
private double sum;

    public Payment(String fio, int day, int month, int year, double sum) {
        if(fio == null){
            throw new IllegalArgumentException("Отсутствует ФИО");
        }else{
        this.FIO = fio;
        }
        if(year < 1){
            throw new IllegalArgumentException("Некорректно введен год");
        }else{
            this.year = year;
        }
        if(month < 1 || month > 12){
            throw new IllegalArgumentException("Некорректно введен месяц");
        }else{
            this.month = month;
        }
        if(day < 1 || day > 31){
            throw new IllegalArgumentException("Некорректно введен день");
        }else{
            if(month == 4 || month == 6 || month == 9 || month == 11){
                if (day > 30){
                    throw new IllegalArgumentException("Некорректно введен день");
                }
            }
            if(month == 2){
                if(year % 400 == 0 && year % 100 != 0 && year % 4 == 0){
                    if (day > 29){
                        throw new IllegalArgumentException("Некорректно введен день");
                    }
                }else{
                    if (day > 28){
                        throw new IllegalArgumentException("Некорректно введен день");
                    }
                }
            }
            this.day = day;
        }
        if(Double.compare(sum, 0) < 0){
            throw new IllegalArgumentException("Некорректно введена сумма");
        }else {
            this.sum = sum;
        }
    }

    public int getDay() {
        return day;
    }

    public double getSum() {
        return sum;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getFIO() {
        return FIO;
    }

    public void setDay(int day) {
        if(year == 0){
            throw new IllegalArgumentException("Сначала введите год");
        }
        if(month == 0){
            throw new IllegalArgumentException("Сначала введите месяц");
        }
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Некорректно введен день");
        } else {
            if (month == 4 || month == 6 || month == 9 || month == 11) {
                if (day > 30) {
                    throw new IllegalArgumentException("Некорректно введен день");
                }
            }
            if (month == 2) {
                if (year % 400 == 0 && year % 100 != 0 && year % 4 == 0) {
                    if (day > 29) {
                        throw new IllegalArgumentException("Некорректно введен день");
                    }
                } else {
                    if (day > 28) {
                        throw new IllegalArgumentException("Некорректно введен день");
                    }
                }
            }
            this.day = day;
        }
    }

    public void setFio(String fio) {
        if(fio == null){
            throw new IllegalArgumentException("Введите ФИО");
        }
            this.FIO = fio;

    }

    public void setMonth(int month) {
        if(month < 1 || month > 12){
            throw new IllegalArgumentException("Некорректно введен месяц");
        }
            this.month = month;

    }

    public void setSum(double sum) {

        if(Double.compare(sum, 0) < 0){
            throw new IllegalArgumentException("Некорректно введена сумма");
        }
            this.sum = sum;

    }

    public void setYear(int year) {
        if(year < 1){
             throw new IllegalArgumentException("Некорректно введен год");
    }
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return day == payment.day && month == payment.month && year == payment.year && Double.compare(payment.sum, sum) == 0 && Objects.equals(FIO, payment.FIO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FIO, day, month, year, sum);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "FIO='" + FIO + '\'' +
                ", day=" + day +
                ", month=" + month +
                ", year=" + year +
                ", sum=" + sum +
                '}';
    }
}
