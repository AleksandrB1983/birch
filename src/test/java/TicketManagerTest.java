import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class TicketManagerTest {
    @Test
    public void testSortFewTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Хабаровск", 500, 10, 17);
        Ticket ticket2 = new Ticket("Москва", "С-Петербург", 300, 7, 10);
        Ticket ticket3 = new Ticket("Москва", "С-Петербург", 300, 10, 12);
        Ticket ticket4 = new Ticket("Москва", "Владивосток", 700, 12, 9);
        Ticket ticket5 = new Ticket("Москва", "С-Петербург", 200, 8, 10);
        Ticket ticket6 = new Ticket("Москва", "С-Петербург", 100, 11, 12);
        Ticket ticket7 = new Ticket("С-Петербург", "Сочи", 400, 15, 17);
        Ticket ticket8 = new Ticket("Москва", "Новосибирск", 400, 11, 15);
        Ticket ticket9 = new Ticket("Москва", "С-Петербург", 600, 16, 22);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Ticket[] expected = {ticket6, ticket5, ticket2, ticket3, ticket9};
        Ticket[] actual = manager.search("Москва", "С-Петербург");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortZeroTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Хабаровск", 500, 10, 17);
        Ticket ticket2 = new Ticket("Москва", "С-Петербург", 300, 7, 10);
        Ticket ticket3 = new Ticket("Москва", "С-Петербург", 300, 10, 12);
        Ticket ticket4 = new Ticket("Москва", "Владивосток", 700, 12, 9);
        Ticket ticket5 = new Ticket("Москва", "С-Петербург", 200, 8, 10);
        Ticket ticket6 = new Ticket("Москва", "С-Петербург", 100, 11, 12);
        Ticket ticket7 = new Ticket("С-Петербург", "Сочи", 400, 15, 19);
        Ticket ticket8 = new Ticket("Москва", "Новосибирск", 400, 11, 15);
        Ticket ticket9 = new Ticket("Москва", "С-Петербург", 600, 16, 22);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("Москва", "Сочи");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortOneTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Хабаровск", 500, 10, 17);
        Ticket ticket2 = new Ticket("Москва", "С-Петербург", 300, 7, 10);
        Ticket ticket3 = new Ticket("Москва", "С-Петербург", 300, 10, 12);
        Ticket ticket4 = new Ticket("Москва", "Владивосток", 700, 12, 9);
        Ticket ticket5 = new Ticket("Москва", "С-Петербург", 200, 8, 10);
        Ticket ticket6 = new Ticket("Москва", "С-Петербург", 100, 11, 12);
        Ticket ticket7 = new Ticket("С-Петербург", "Сочи", 400, 15, 19);
        Ticket ticket8 = new Ticket("Москва", "Новосибирск", 400, 11, 15);
        Ticket ticket9 = new Ticket("Москва", "С-Петербург", 600, 16, 22);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Ticket[] expected = {ticket4};
        Ticket[] actual = manager.search("Москва", "Владивосток");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Хабаровск", 500, 10, 17);
        Ticket ticket2 = new Ticket("Москва", "С-Петербург", 300, 7, 10);  // 3
        Ticket ticket3 = new Ticket("Москва", "С-Петербург", 300, 10, 12);  // 2
        Ticket ticket4 = new Ticket("Москва", "Владивосток", 700, 12, 9);
        Ticket ticket5 = new Ticket("Москва", "С-Петербург", 200, 8, 10);  // 2
        Ticket ticket6 = new Ticket("Москва", "С-Петербург", 100, 11, 12); // 1
        Ticket ticket7 = new Ticket("С-Петербург", "Сочи", 400, 15, 19);
        Ticket ticket8 = new Ticket("Москва", "Новосибирск", 400, 11, 15);
        Ticket ticket9 = new Ticket("Москва", "С-Петербург", 600, 16, 22);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket6, ticket3, ticket5, ticket2, ticket9};
        Ticket[] actual = manager.search("Москва", "С-Петербург", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortZeroTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Хабаровск", 500, 10, 17);
        Ticket ticket2 = new Ticket("Москва", "С-Петербург", 300, 7, 10);
        Ticket ticket3 = new Ticket("Москва", "С-Петербург", 300, 10, 12);
        Ticket ticket4 = new Ticket("Москва", "Владивосток", 700, 12, 9);
        Ticket ticket5 = new Ticket("Москва", "С-Петербург", 200, 8, 10);
        Ticket ticket6 = new Ticket("Москва", "С-Петербург", 100, 11, 12);
        Ticket ticket7 = new Ticket("С-Петербург", "Сочи", 400, 15, 19);
        Ticket ticket8 = new Ticket("Москва", "Новосибирск", 400, 11, 15);
        Ticket ticket9 = new Ticket("Москва", "С-Петербург", 600, 16, 22);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = manager.search("Москва", "Сочи", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortOneTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Хабаровск", 500, 10, 17);
        Ticket ticket2 = new Ticket("Москва", "С-Петербург", 300, 7, 10);
        Ticket ticket3 = new Ticket("Москва", "С-Петербург", 300, 10, 12);
        Ticket ticket4 = new Ticket("Москва", "Владивосток", 700, 12, 9);
        Ticket ticket5 = new Ticket("Москва", "С-Петербург", 200, 8, 10);
        Ticket ticket6 = new Ticket("Москва", "С-Петербург", 100, 11, 12);
        Ticket ticket7 = new Ticket("С-Петербург", "Сочи", 400, 15, 19);
        Ticket ticket8 = new Ticket("Москва", "Новосибирск", 400, 11, 15);
        Ticket ticket9 = new Ticket("Москва", "С-Петербург", 600, 16, 22);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket1};
        Ticket[] actual = manager.search("Москва", "Хабаровск", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
