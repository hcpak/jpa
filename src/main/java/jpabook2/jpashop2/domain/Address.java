package jpabook2.jpashop2.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;



@Embeddable
public class Address {


    // 공통적으로 관리할 수 있다.
    @Column(length = 10)
    private String city;
    @Column(length = 20)
    private String street;
    @Column(length = 5)
    private String zipcode;


    //의미 있는 메소드를 만들어서 비지니스 로직에 쓸 수 있다.
    public String fullAddress(){
        return getCity() + " " +  getStreet() + " " + getZipcode();
    }


    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getZipcode() {
        return zipcode;
    }

    private void setCity(String city) {
        this.city = city;
    }

    private void setStreet(String street) {
        this.street = street;
    }

    private void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(getCity(), address.getCity()) &&
                Objects.equals(getStreet(), address.getStreet()) &&
                Objects.equals(getZipcode(), address.getZipcode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getStreet(), getZipcode());
    }
}
