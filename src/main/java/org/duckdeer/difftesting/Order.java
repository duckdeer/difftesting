package org.duckdeer.difftesting;

import org.apache.commons.lang3.builder.DiffBuilder;
import org.apache.commons.lang3.builder.DiffResult;
import org.apache.commons.lang3.builder.Diffable;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.*;

public class Order implements Diffable<Order> {

    private String id;
    private String name;
    private Date orderDate;
    private Collection<OrderPosition> orderPositions = new HashSet<>();
    private Customer customer;

    public Order() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Collection<OrderPosition> getOrderPositions() {
        return orderPositions;
    }

    public void setOrderPositions(Collection<OrderPosition> orderPositions) {
        this.orderPositions = orderPositions;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void addOrderPosition(OrderPosition orderPosition) {
        this.orderPositions.add(orderPosition);
    }

    public DiffResult diff(Order otherOrder) {
        return new DiffBuilder(this, otherOrder, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("name", this.name, otherOrder.name)
                .append("orderDate", this.orderDate, otherOrder.orderDate)
                .append("orderPositions", this.orderPositions, otherOrder.orderPositions)
                .append("customer", this.customer, otherOrder.customer)
                .build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                '}';
    }
}
