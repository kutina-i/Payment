package service;

public class FinanceReportProcessor {
    public static FinanceReport CharFIOReport(FinanceReport report, char a)
    {
        if(report == null){
            throw new IllegalArgumentException("Отсутствуют данные");
        }
        FinanceReport test = new FinanceReport(report.getNumberPayments());
        int j = 0;
        for(int i = 0; i<report.getNumberPayments(); i++)
        {
            if((report.getReport(i).getFIO().charAt(0)) == a)
            {
                test.setReport(report.getReport(i), j);
                j++;
            }
        }
        return test;
    }

    public static FinanceReport NeededReports(FinanceReport report, double sum)
    {
        if(Double.compare(sum, 0) < 0){
            throw new IllegalArgumentException("Некорректно введена сумма");
        }
        if(report == null){
            throw new IllegalArgumentException("Отсутствуют данные");
        }
        FinanceReport test = new FinanceReport(report.getNumberPayments());
        int j = 0;
        for(int i = 0; i < report.getNumberPayments(); i++)
        {
            if(Double.compare(sum,report.getReport(i).getSum()) > 0)
            {
                test.setReport(report.getReport(i), j);
                j++;
            }
        }
        return test;
    }

    public static double SumPayments(FinanceReport report, String dayMonthYear)
    {
        double sum = 0;

        String[] words = dayMonthYear.split("[.]");
        int Arr[] = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            Arr[i] = Integer.parseInt(words[i]);
        }
        for(int i = 0; i < report.getNumberPayments(); i++)
        {
            if((report.getReport(i).getDay() == Arr[0])&&(report.getReport(i).getMonth() == Arr[1])&&(report.getReport(i).getYear() == Arr[2])){
                sum = sum + report.getReport(i).getSum();
            }
        }
        return sum;
    }

    public static String[] ListMonths(FinanceReport report, int Year)
    {
        int n = 0;
        int[] Months = new int[12];
        for(int i = 0; i < Months.length; i++){
            Months[i] = 0;
        }
        String[] AllMonths = new String[12];
        {
            AllMonths[0] = "January";
            AllMonths[1] = "February";
            AllMonths[2] = "March";
            AllMonths[3] = "April";
            AllMonths[4] = "May";
            AllMonths[5] = "June";
            AllMonths[6] = "July";
            AllMonths[7] = "August";
            AllMonths[8] = "September";
            AllMonths[9] = "October";
            AllMonths[10] = "November";
            AllMonths[11] = "December";
        }

        for(int i = 0; i < report.getNumberPayments(); i++)
        {
            if((report.getReport(i).getYear() == Year)&&(Double.compare(report.getReport(i).getSum(), 0) > 0)){
                Months[report.getReport(i).getMonth() -1] = 1;
            }
        }

        for(int i = 0; i < Months.length; i++){
            if(Months[i] == 0){
                n++;
            }
        }
        String[] List = new String[n];
        int j = 0;
        for(int i = 0; i < Months.length; i++){
            if(Months[i] == 0){
                List[j] = AllMonths[i];
                j++;
            }
        }

        return List;
    }
}