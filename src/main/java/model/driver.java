package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Random;

@Entity
@Table(name = "driver")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class driver {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , length = 50)
    private int id;
    @Column(name = "name" , length = 50)
    private String name;
    @Column(name = "salary" , length = 50)
    private BigDecimal Salary;
    @Column(name = "surname" , length = 50)
    private String surname;
    @Column(name = "date" , length = 50)
    @Temporal(TemporalType.DATE)
    private LocalDate date ;
    @OneToOne
    private truck wasteTruck;

    public driver(String name, BigDecimal salary, String surname) {
        this.name = name;
        this.Salary = salary;
        this.surname = surname;

    }
    public String DriverId() {
        // Format dateOfEmployment to ddMMyy format
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
        String datePart = dateFormat.format(Date.valueOf(date));

        // Get the first letters of the name and surname
        String nameInitials = String.valueOf(name.charAt(0)).toUpperCase();
        String surnameInitials = String.valueOf(surname.charAt(0)).toUpperCase();
        String initials = nameInitials + surnameInitials;

        // Generate a random number between 100 and 999
        Random random = new Random();
        int randomNumber = random.nextInt(900) + 100;

        // Get the last letter of the surname
        String lastLetter = String.valueOf(surname.charAt(surname.length() - 1)).toUpperCase();

        // Concatenate all parts to form the driver ID
        return datePart + "-" + initials + "-" + randomNumber + lastLetter;
    }

    public Boolean validateDriverId(String DriverId) {
        return DriverId.matches("[0-9][0-9][0-9][0-9][0-9][0-9]-[A-Z][A-Z]-[0-9][0-9][0-9][A-Z]");
    }
    @PrePersist
    protected void onCreate() {

        // Generate driver ID
        this.date = LocalDate.now(); // Set employment date
    }

}
