package Dolphin;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "person_details")

public class PersonDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "zip_code")
    private  int zipCode;
    @Column(name = "age")
    private double age;
@OneToOne

@MapsId
    private Person person;

    public PersonDetails(String address, String city, int zipCode, double age) {
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
        this.age = age;
    }


}
