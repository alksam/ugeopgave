package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "truck")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class truck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "model",length = 30)
    private String brand;
    @Column( name = "capacity" ,length = 8)
    private int capacity ;
    @Column(name = "regisrationnm", length = 12)
    private  int registrationnumber ;
    @OneToOne
    private driver driverr ;

    public truck ( String brand, int capacity,int registrationnumber) {
        this.brand = brand;
         this.capacity = capacity;
         this.registrationnumber= registrationnumber;


    }

    public void addDriverr(driver driverr) {

        this.driverr = driverr;
    }



}
