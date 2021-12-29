package service;
import org.junit.Test;
import static org.junit.Assert.*;

public class Tests {

    @Test
    public void PaymentTest1() {
    Payment a = new Payment("Кутина Ирина Андреевна", 13, 1, 2016, 211);
    assertEquals(a.getFIO(), "Кутина Ирина Андреевна");
}

    @Test
    public void PaymentTest2() {
        Payment a = new Payment("Кутина Ирина Андреевна", 13, 1, 2016, 211);
        assertEquals(a.getDay(), 13);
    }

    @Test
    public void PaymentTest3() {
        Payment a = new Payment("Кутина Ирина Андреевна", 13, 1, 2016, 211);
        assertEquals(a.getMonth(), 1);
    }

    @Test
    public void PaymentTest4() {
        Payment a = new Payment("Кутина Ирина Андреевна", 13, 1, 2016, 211);
        assertEquals(a.getYear(), 2016);
    }

    @Test
    public void PaymentTest5() {
        Payment a = new Payment("Кутина Ирина Андреевна", 13, 1, 2016, 211);
        assertEquals(a.getSum(), 211, 20);
    }

    @Test
    public void PaymentTestErr1() {
        try{
            Payment a = new Payment("Кутина Ирина Андреевна", -1, 1, 2016, 211);
        }catch (IllegalArgumentException err)
        {
            System.err.println("Некорректно введен день");
        }
    }

    @Test
    public void PaymentTestErr2() {
        try{
            Payment a = new Payment("Кутина Ирина Андреевна", 5, 13, 2016, 211);
        }catch (IllegalArgumentException err)
        {
            System.err.println("Некорректно введен месяц");
        }
    }

    @Test
    public void PaymentTestErr3() {
        try{
            Payment a = new Payment("Кутина Ирина Андреевна", 5, 11, 0, 211);
        }catch (IllegalArgumentException err)
        {
            System.err.println("Некорректно введен год");
        }
    }

    @Test
    public void PaymentTestErr4() {
        try{
            Payment a = new Payment("Кутина Ирина Андреевна", 5, 12, 2016, -4);
        }catch (IllegalArgumentException err)
        {
            System.err.println("Некорректно введена сумма");
        }
    }

    @Test
    public void PaymentTestErr5() {
        try{
            Payment a = new Payment(null, 5, 12, 2016, 5);
        }catch (IllegalArgumentException err)
        {
            System.err.println("Отсутствует ФИО");
        }
    }

    @Test
    public void setFioTest() {
        Payment a = new Payment("Кутина Ирина Андреевна", 13, 1, 2016, 211);
        a.setFio("Асаевич Никита Сергеевич");
        assertEquals(a.getFIO(), "Асаевич Никита Сергеевич");
    }

    @Test
    public void setFioTestErr() {
        Payment a = new Payment("Кутина Ирина Андреевна", 13, 1, 2016, 211);
        try{
            a.setFio(null);
        }catch (IllegalArgumentException err)
        {
            System.err.println("Отсутствует ФИО");
        }
    }

    @Test
    public void setDayTest() {
        Payment a = new Payment("Кутина Ирина Андреевна", 13, 1, 2016, 211);
        a.setDay(21);
        assertEquals(a.getDay(), 21);
    }

    @Test
    public void setDayTestErr() {
        Payment a = new Payment("Кутина Ирина Андреевна", 13, 1, 2016, 211);
        try{
            a.setDay(-2);
        }catch (IllegalArgumentException err)
        {
            System.err.println("Некорректно введен день");
        }
    }

    @Test
    public void setYearTest() {
        Payment a = new Payment("Кутина Ирина Андреевна", 13, 1, 2016, 211);
        a.setYear(2021);
        assertEquals(a.getYear(), 2021);
    }

    @Test
    public void setYearTestErr() {
        Payment a = new Payment("Кутина Ирина Андреевна", 13, 1, 2016, 211);
        try{
            a.setYear(0);
        }catch (IllegalArgumentException err)
        {
            System.err.println("Некорректно введен год");
        }
    }

    @Test
    public void setMonthTest() {
        Payment a = new Payment("Кутина Ирина Андреевна", 13, 1, 2016, 211);
        a.setMonth(5);
        assertEquals(a.getMonth(), 5);
    }

    @Test
    public void setMonthTestErr() {
        Payment a = new Payment("Кутина Ирина Андреевна", 13, 1, 2016, 211);
        try{
            a.setMonth(14);
        }catch (IllegalArgumentException err)
        {
            System.err.println("Некорректно введен месяц");
        }
    }

    @Test
    public void setSumTest() {
        Payment a = new Payment("Кутина Ирина Андреевна", 13, 1, 2016, 211);
        a.setSum(22.5);
        assertEquals(a.getSum(), 22.5, 50);
    }

    @Test
    public void setSumTestErr() {
        Payment a = new Payment("Кутина Ирина Андреевна", 13, 1, 2016, 211);
        try{
            a.setSum(-5);
        }catch (IllegalArgumentException err)
        {
            System.err.println("Некорректно введена сумма");
        }
    }

    @Test
    public void FinanceReportTestErr() {
        int n = -3;
        try{
            FinanceReport a = new FinanceReport(n);
        }catch (IllegalArgumentException err)
        {
            System.err.println("Некорректная длина массива");
        }
    }

    @Test
    public void get_setReportTest() {
        FinanceReport a = new FinanceReport(1);
        Payment a2 = new Payment("Асаевич Никита Сергеевич", 14, 6, 2050, 0.75);
        a.setReport(a2, 0);
        assertEquals(a.getReport(0), a2);
    }

    @Test
    public void setReportTestErr1() {
        FinanceReport a = new FinanceReport(1);
        Payment a2 = new Payment("Асаевич Никита Сергеевич", 14, 6, 2050, 0.75);
        try{
            a.setReport(a2, 1);
        }catch (IllegalArgumentException err)
        {
            System.err.println("Некорректный индекс массива");
        }
    }

    @Test
    public void setReportTestErr2() {
        FinanceReport a = new FinanceReport(1);
        Payment a2 = new Payment("Асаевич Никита Сергеевич", 14, 6, 2050, 0.75);
        try{
            a.setReport(null, 0);
        }catch (IllegalArgumentException err)
        {
            System.err.println("Отсутствуют данные");
        }
    }

    @Test
    public void getReportTestErr() {
        FinanceReport a = new FinanceReport(1);
        Payment a2 = new Payment("Асаевич Никита Сергеевич", 14, 6, 2050, 0.75);
        a.setReport(a2, 0);
        try{
            a.getReport(6);
        }catch (IllegalArgumentException err)
        {
            System.err.println("Некорректный индекс массива");
        }
    }

    @Test
    public void toStringTest() {
        int n = 4;
        FinanceReport b = new FinanceReport(n);
        Payment a1 = new Payment("Кутина Ирина Андреевна", 13, 1, 2016, 211);
        Payment a2 = new Payment("Асаевич Никита Сергеевич", 14, 6, 2050, 0.75);
        Payment a3 = new Payment("Ильяшенко Влад", 1, 1, 1, 25.5);
        Payment a4 = new Payment("Шанаурин Сергей", 27, 2, 2077, 100);
            b.setReport(a1, 0);
            b.setReport(a2, 1);
            b.setReport(a3, 2);
            b.setReport(a4, 3);
            assertEquals(b.toString(), "FIO = Кутина Ирина Андреевна, date: day = 13. month = 1. year = 2016, sum " +
                    "= 211,000000 FIO = Асаевич Никита Сергеевич, date: day = 14. month = 6. year = 2050, sum = 0,750000" +
                    " FIO = Ильяшенко Влад, date: day = 1. month = 1. year = 1, sum = 25,500000 FIO = Шанаурин Сергей, " +
                    "date: day = 27. month = 2. year = 2077, sum = 100,000000 ");
        }

    @Test
    public void CharFIOReportTest() {
        FinanceReportProcessor g = new FinanceReportProcessor();
        int n = 4;
        FinanceReport b = new FinanceReport(n);
        Payment a1 = new Payment("Кутина Ирина Андреевна", 13, 1, 2016, 211);
        Payment a2 = new Payment("Асаевич Никита Сергеевич", 14, 6, 2050, 0.75);
        Payment a3 = new Payment("Ильяшенко Влад", 1, 1, 1, 25.5);
        Payment a4 = new Payment("Шанаурин Сергей", 27, 2, 2077, 100);
        b.setReport(a1, 0);
        b.setReport(a2, 1);
        b.setReport(a3, 2);
        b.setReport(a4, 3);
        assertEquals(g.CharFIOReport(b, 'И').getReport(0), a3);
    }

    @Test
    public void NeededReportsTest() {
        FinanceReportProcessor g = new FinanceReportProcessor();
        int n = 4;
        FinanceReport b = new FinanceReport(n);
        Payment a1 = new Payment("Кутина Ирина Андреевна", 13, 1, 2016, 211);
        Payment a2 = new Payment("Асаевич Никита Сергеевич", 14, 6, 2050, 0.75);
        Payment a3 = new Payment("Ильяшенко Влад", 1, 1, 1, 25.5);
        Payment a4 = new Payment("Шанаурин Сергей", 27, 2, 2077, 100);
        b.setReport(a1, 0);
        b.setReport(a2, 1);
        b.setReport(a3, 2);
        b.setReport(a4, 3);
        assertEquals(g.NeededReports(b, 100).getReport(1), a3);
    }

    @Test
    public void getReportsTest() {
        int n = 4;
        FinanceReport b = new FinanceReport(n);
        FinanceReport c = new FinanceReport(n);
        Payment a1 = new Payment("Кутина Ирина Андреевна", 13, 1, 2016, 211);
        Payment a2 = new Payment("Асаевич Никита Сергеевич", 14, 6, 2050, 0.75);
        Payment a3 = new Payment("Ильяшенко Влад", 1, 1, 1, 25.5);
        Payment a4 = new Payment("Шанаурин Сергей", 27, 2, 2077, 100);
        b.setReport(a1, 0);
        b.setReport(a2, 1);
        b.setReport(a3, 2);
        b.setReport(a4, 3);
        c.getReports(b);
        b.setReport(a3, 1);
        assertEquals(c.getReport(2), b.getReport(1));
    }


    @Test
    public void SumPaymentsTest() {
        FinanceReportProcessor g = new FinanceReportProcessor();
        int n = 4;
        FinanceReport b = new FinanceReport(n);
        Payment a1 = new Payment("Кутина Ирина Андреевна", 13, 1, 2016, 211);
        Payment a2 = new Payment("Асаевич Никита Сергеевич", 14, 6, 2050, 0.75);
        Payment a3 = new Payment("Ильяшенко Влад", 13, 1, 2016, 25.5);
        Payment a4 = new Payment("Шанаурин Сергей", 27, 2, 2077, 100);
        b.setReport(a1, 0);
        b.setReport(a2, 1);
        b.setReport(a3, 2);
        b.setReport(a4, 3);
        assertEquals(g.SumPayments(b, "13.1.2016"), 236.5, 15);
    }

    @Test
    public void ListMonthsTest() {
        FinanceReportProcessor g = new FinanceReportProcessor();
        int n = 4;
        FinanceReport b = new FinanceReport(n);
        Payment a1 = new Payment("Кутина Ирина Андреевна", 13, 5, 2016, 250);
        Payment a2 = new Payment("Асаевич Никита Сергеевич", 14, 6, 2016, 0.75);
        Payment a3 = new Payment("Ильяшенко Влад", 13, 1, 2016, 0);
        Payment a4 = new Payment("Шанаурин Сергей", 27, 2, 2077, 100);
        b.setReport(a1, 0);
        b.setReport(a2, 1);
        b.setReport(a3, 2);
        b.setReport(a4, 3);
        String[] Months = new String[10];

        Months[0] = "January";
        Months[1] = "February";
        Months[2] = "March";
        Months[3] = "April";
        Months[4] = "July";
        Months[5] = "August";
        Months[6] = "September";
        Months[7] = "October";
        Months[8] = "November";
        Months[9] = "December";
        assertArrayEquals(g.ListMonths(b, 2016), Months);
    }



}
