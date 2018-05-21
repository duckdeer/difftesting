package org.duckdeer.difftesting;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.commons.lang3.builder.Diff;
import org.apache.commons.lang3.builder.DiffBuilder;
import org.apache.commons.lang3.builder.DiffResult;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class DiffTest {

    private Order order1;
    private Order order2;

    @Test
    public void testZeroDiffs() {
        Date date = new Date();

        Customer cust = new Customer();
        cust.setFirstName("Max");
        cust.setLastName("Mustermann");

        OrderPosition position = new OrderPosition();
        position.setType(OrderPosition.OrderPositionType.EQUIPMENT);
        position.setAmount(2);
        position.setName("Duftbaum");


        order1 = new Order();
        order1.setName("Order");
        order1.setOrderDate(date);
        order1.setCustomer(cust);
        order1.addOrderPosition(position);

        order2 = new Order();
        order2.setName("Order");
        order2.setOrderDate(date);
        order2.setCustomer(cust);
        order2.addOrderPosition(position);

//        List<Diff<?>> diffs = order1.diff(order2).getDiffs();
//        Iterator<Diff<?>> it = diffs.iterator();
//        assertFalse(it.hasNext());
        assertEquals(0, order1.diff(order2).getNumberOfDiffs());
    }
}
