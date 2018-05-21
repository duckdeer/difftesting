package org.duckdeer.difftesting;

import org.apache.commons.lang3.builder.DiffBuilder;
import org.apache.commons.lang3.builder.DiffResult;
import org.apache.commons.lang3.builder.Diffable;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Objects;
import java.util.UUID;

public class OrderPosition implements Diffable<OrderPosition> {

    public enum OrderPositionType { CAR, EQUIPMENT }
    private String id;
    private int amount;
    private String name;
    private String description;
    private OrderPositionType type;

    public OrderPosition() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OrderPositionType getType() {
        return type;
    }

    public void setType(OrderPositionType type) {
        this.type = type;
    }

    public DiffResult diff(OrderPosition otherOrderPosition) {
        return new DiffBuilder(this, otherOrderPosition, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("amount", this.amount, otherOrderPosition.amount)
                .append("name", this.name, otherOrderPosition.name)
                .append("description", this.description, otherOrderPosition.description)
                .append("type", this.type, otherOrderPosition.type)
                .build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderPosition that = (OrderPosition) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "OrderPosition{" +
                "id=" + id +
                '}';
    }
}
