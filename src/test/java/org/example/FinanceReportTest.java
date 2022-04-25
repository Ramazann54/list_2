package org.example;

import junit.framework.TestCase;

import static org.junit.Assert.assertNotEquals;

public class FinanceReportTest extends TestCase {

    public void testFinanceReport() throws IllegalArgumentException {
        Payment payment = new Payment("Иванов Иван Сергеевич", new Date(11, 11, 1999), 30);
        Payment somePayment = new Payment();
        FinanceReport financeReport = new FinanceReport(2, 5, 4, 2020, "Бухгалтер Лена");
        financeReport.setPayment(payment, 0);
        financeReport.setPayment(somePayment, 1);
        String expected = "Автор: Бухгалтер Лена, Дата: 05.04.2020, Количество платежей: 2, Платежи:\n" +
                "Плательщик: Иванов Иван Сергеевич, Дата: 11.11.1999, Сумма: 0 руб. 30 коп.\n" +
                "Плательщик: noname, Дата: 1.1.1970, Сумма: 0 руб. 00 коп.\n";
        assertEquals(expected, financeReport.toString());
    }


    public void testdefaultConstructor() {
        FinanceReport financeReport = new FinanceReport();
        String expected = "Автор: noname, Дата: 01.01.1970, Количество платежей: 0, Платежи:\n";
        assertEquals(expected, financeReport.toString());
    }


    public void testcopy() {
        Payment payment = new Payment("Иванов Иван Сергеевич", new Date(28, 2, 1999), 30);
        Payment somePayment = new Payment();
        FinanceReport financeReport = new FinanceReport(2, 5, 4, 2020, "Бухгалтер Лена");
        financeReport.setPayment(payment, 0);
        financeReport.setPayment(somePayment, 1);

        FinanceReport financeReportCopy = new FinanceReport(financeReport);
        assertEquals(financeReport.toString(), financeReportCopy.toString());

        financeReport.setPayment(
                new Payment("Иванов Ваня", new Date(1,1, 1980), 1000), 0
        );
        assertNotEquals(financeReport, financeReportCopy);

    }

    public void testsetReport() {
        Payment payment = new Payment("Иванов Иван Сергеевич", new Date(11, 11, 1999), 30);
        Payment somePayment = new Payment();
        FinanceReport financeReport = new FinanceReport(2, 5, 4, 2020, "Бухгалтер Лена");
        financeReport.setPayment(payment, 0);
        financeReport.setPayment(somePayment, 1);
        //set
        financeReport.setPayment(payment, 1);

        String expected = "Автор: Бухгалтер Лена, Дата: 05.04.2020, Количество платежей: 2, Платежи:\n" +
                "Плательщик: Иванов Иван Сергеевич, Дата: 11.11.1999, Сумма: 0 руб. 30 коп.\n" +
                "Плательщик: Иванов Иван Сергеевич, Дата: 11.11.1999, Сумма: 0 руб. 30 коп.\n";
        assertEquals(expected, financeReport.toString());
    }


    public void testgetReport() {
        Payment payment = new Payment("Иванов Иван Сергеевич", new Date(11, 11, 1999), 30);
        FinanceReport financeReport = new FinanceReport(2, 5, 4, 2020, "Бухгалтер Лена");
        financeReport.setPayment(payment, 0);
        financeReport.setPayment(payment, 1);
        assertEquals(true, payment.equals(financeReport.getPayment(0)));
    }


    public void testgetQuantityOfReports() {
        FinanceReport financeReport = new FinanceReport(2, 5, 4, 2020, "Бухгалтер Лена");
        assertEquals(2, financeReport.getQuantityOfReports());
    }

}