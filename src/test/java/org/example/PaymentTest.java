package org.example;

import junit.framework.TestCase;

public class PaymentTest extends TestCase {

    public void testTestToString() {
        Payment payment= new Payment("Дюсекеев Рамазан Рысбаевич", new Date(11, 11, 2020), 100);
        assertEquals(payment.toString(), "Плательщик: Дюсекеев Рамазан Рысбаевич, Дата: 11.11.2020, Сумма: 1 руб. 00 коп.\n");
    }
    public void testhashCode() {
        Payment a = new Payment("Иванов Иван Сергеевич", new Date(11, 11, 2020), 30);
        assertEquals(795712166, a.hashCode());

    }
    public void testequals() throws IllegalArgumentException {
        Payment a = new Payment("Иванов Иван Сергеевич", new Date(11, 11, 2020), 20);
        Payment b = new Payment("Иванов Иван Сергеевич", new Date(11, 11, 2020), 20);
        assertEquals(true, a.equals(b));

    }
    public void testcopy() throws IllegalArgumentException {
        Payment a = new Payment("Иванов Иван Сергеевич",  new Date(11, 11, 2020), 20);
        Payment b = new Payment(a);
        assertEquals(true, a.equals(b));

    }
    public void testdefaultConstructor() {
        Payment a = new Payment();
        assertEquals("Плательщик: noname, Дата: 1.1.1970, Сумма: 0 руб. 00 коп.\n", a.toString());
    }



}