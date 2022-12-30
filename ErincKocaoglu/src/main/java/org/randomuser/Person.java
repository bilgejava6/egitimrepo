package org.randomuser;

import javax.xml.namespace.QName;
import java.io.Serializable;

public class Person implements Serializable {
    String gender;
    String email;
    String phone;
    String nat;
    Name name;
    Location location;
    Dob dob;
    public static class Dob{
        Integer age;

        public Dob() {
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public static class Location{
        String country;
        String state;
        Object postcode;

        public Location() {
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public Object getPostcode() {
            return postcode;
        }

        public void setPostcode(Object postcode) {
            this.postcode = postcode;
        }
    }
    public static class Name{
        String title;
        String first;
        String last;

        public Name() {
        }
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public String getFirst() {
            return first;
        }
        public void setFirst(String first) {
            this.first = first;
        }
        public String getLast() {
            return last;
        }
        public void setLast(String last) {
            this.last = last;
        }
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='"+ name.getFirst()+  '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", nat='" + nat + '\'' +
                ", location='" + location.getCountry() + '\'' +
                ", yas='" + dob.getAge() + '\'' +

                '}';
    }

    public Person() {
    }

    public Person(String gender, String email, String phone, String nat) {
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.nat = nat;
    }

    public Dob getDob() {
        return dob;
    }

    public void setDob(Dob dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNat() {
        return nat;
    }

    public void setNat(String nat) {
        this.nat = nat;
    }
}
