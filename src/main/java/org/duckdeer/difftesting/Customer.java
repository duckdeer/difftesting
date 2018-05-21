package org.duckdeer.difftesting;

import org.apache.commons.lang3.builder.DiffBuilder;
import org.apache.commons.lang3.builder.DiffResult;
import org.apache.commons.lang3.builder.Diffable;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Objects;
import java.util.UUID;

public class Customer implements Diffable<Customer> {

    private String id;
    private String firstName;
    private String lastName;

    public Customer() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                '}';
    }

    public DiffResult diff(Customer otherCustomer) {
        return new DiffBuilder(this, otherCustomer, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("firstName", this.firstName, otherCustomer.firstName)
                .append("lastName", this.lastName, otherCustomer.lastName)
                .build();
    }
}
