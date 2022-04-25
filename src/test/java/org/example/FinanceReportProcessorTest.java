package org.example;

import junit.framework.TestCase;

import static org.junit.Assert.assertNotEquals;

public class FinanceReportProcessorTest extends TestCase {

    public void testSearchForChar() throws IllegalArgumentException {
        Payment payment = new Payment("Иванов Иван Сергеевич", new Date(11, 11, 1999), 30);
        Payment payment1 = new Payment("Иванов Иван Иванович", new Date(11, 11, 1989), 10000);
        FinanceReport financeReport = new FinanceReport(2, 5, 4, 2020, "Бухгалтер Лена");
        financeReport.setPayment(payment, 1);
        financeReport.setPayment(payment1, 0);
        char ch1 = 'И';
        String expected = "Автор: Бухгалтер Лена, Дата: 05.04.2020, Количество платежей: 2, Платежи:\n" +
                "Плательщик: Иванов Иван Сергеевич, Дата: 11.11.1999, Сумма: 0 руб. 30 коп.\n" +
                "Плательщик: noname, Дата: 1.1.1970, Сумма: 0 руб. 00 коп.\n";
        assertEquals(FinanceReportProcessor.searchForChar(financeReport, ch1).toString(),expected);
    }
    public void testSearchForCount() throws IllegalArgumentException {
        Payment payment = new Payment("Иванов Иван Сергеевич", new Date(11, 11, 1999), 30);
        Payment payment1 = new Payment("Иванов Иван Иванович", new Date(11, 11, 1989), 10000);
        FinanceReport financeReport = new FinanceReport(2, 5, 4, 2020, "Бухгалтер Лена");
        financeReport.setPayment(payment, 1);
        financeReport.setPayment(payment1, 0);
        int count = 100000;
        String expected = "Автор: Бухгалтер Лена, Дата: 01.01.2020, Количество платежей: 2, Платежи:\n" +
                "Плательщик: Иванов Иван Иванович, Дата: 11.11.1989, Сумма: 100 руб. 00 коп.\n" +
                "Плательщик: Иванов Иван Сергеевич, Дата: 11.11.1999, Сумма: 0 руб. 30 коп.\n";
        assertEquals(FinanceReportProcessor.searchForCount(financeReport, count).toString(), expected);

    }

}