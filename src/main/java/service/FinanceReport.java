package service;
import java.util.Arrays;

public class FinanceReport {
    private Payment[] report;

    public FinanceReport(int n) {
        if( n < 1) {
            throw new IllegalArgumentException("Некорректная длина массива");
        }
            report = new Payment[n];
    }
    public Payment getReport(int i) {
        if(( i < 0)||(i >= report.length)){
            throw new IllegalArgumentException("Некорректный индекс массива");
        }
            return report[i];

    }

    public void setReport(Payment Report, int i) {
        if(( i < 0)||(i >= report.length)){
            throw new IllegalArgumentException("Некорректный индекс массива");
        }
        if(Report == null){
            throw new IllegalArgumentException("Отсутствуют данные");
        }
            this.report[i] = Report;

    }

    public int getNumberPayments()
    {
        return report.length;
    }

    public FinanceReport getReports(final FinanceReport b) {
        for (int i = 0; i < b.getNumberPayments(); i++){
            report[i] = b.getReport(i);
        }
        return b;
    }

    @Override
    public String toString() {
        StringBuilder stringReport = new StringBuilder();
        String format = "FIO = %s, date: day = %d. month = %d. year = %d, sum = %f ";
        for(int i = 0; i< report.length; i++)
        {
            stringReport.append(String.format(format, report[i].getFIO(), report[i].getDay(), report[i].getMonth(), report[i].getYear(), report[i].getSum()));
        }
        return stringReport.toString();
    }

}