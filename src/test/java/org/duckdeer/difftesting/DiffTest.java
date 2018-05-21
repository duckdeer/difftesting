package org.duckdeer.difftesting;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.commons.lang3.builder.Diff;
import org.apache.commons.lang3.builder.DiffBuilder;
import org.apache.commons.lang3.builder.DiffResult;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertFalse;

public class DiffTest {

    private Order order1;
    private Order order2;

    @Test
    public void testEquals() {
        Date date = new Date();

        order1 = new Order();
        order1.setName("Order 1");
        order1.setOrderDate(date);

        Customer cust1 = new Customer();
        cust1.setFirstName("Hans");
        cust1.setLastName("Dampf");
        order1.setCustomer(cust1);

        Collection<OrderPosition> orderPositions = new HashSet<>();
        OrderPosition position = new OrderPosition();
        position.setType(OrderPosition.OrderPositionType.EQUIPMENT);
        position.setAmount(2);
        position.setName("Sonnenblenden");
        orderPositions.add(position);
        order1.setOrderPositions(orderPositions);

        order2 = new Order();
        order2.setName("Order 1");
        order2.setOrderDate(date);

        Customer cust2 = new Customer();
        cust2.setFirstName("Hans");
        cust2.setLastName("Dampf");
        order2.setCustomer(cust2);

        Collection<OrderPosition> orderPositions2 = new HashSet<>();
        OrderPosition position2 = new OrderPosition();
        position2.setType(OrderPosition.OrderPositionType.EQUIPMENT);
        position2.setAmount(2);
        position2.setName("Sonnenblenden");
        orderPositions2.add(position2);
        order2.setOrderPositions(orderPositions2);

        List<Diff<?>> diffs = order1.diff(order2).getDiffs();
        Iterator<Diff<?>> it = diffs.iterator();
        assertFalse(it.hasNext());
    }
}
