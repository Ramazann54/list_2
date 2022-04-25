package org.example;

public class FinanceReportProcessor{
    public static FinanceReport searchForChar(FinanceReport report, char firstChar) {
        FinanceReport res = new FinanceReport(report.getQuantityOfReports(), 1, 1, 2020,  report.getAuthor());
        int N=0;
        for(int i = 0; i <report.getNumberOfPayments(); i++) {
            if(report.getPayment(i).getFullName().charAt(0) == firstChar){
                res.setPayment(report.getPayment(i), N);
                N++;
            }
        }
        return res;
    }
    public static FinanceReport searchForCount(FinanceReport report, int count) {
        FinanceReport res = new FinanceReport(report.getQuantityOfReports(), 1, 1, 2020,  report.getAuthor());
        int N=0;
        for(int i = 0; i <report.getNumberOfPayments(); i++) {
            if(report.getPayment(i).getSumOfPayment() < count){
                res.setPayment(report.getPayment(i), N);
                N++;
            }
        }
        return res;
    }

}
