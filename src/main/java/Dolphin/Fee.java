package Dolphin;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
@Entity
@Getter
@Table(name = "fee")
@ToString
@Setter
@NoArgsConstructor
public class Fee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "amount")
    private int amount;
    @Column(name = "pay_date")
    private LocalDate payDate;

    @ManyToOne
    private Person person;

    public Fee( int amount, LocalDate payDate) {
        this.amount = amount;
        this.payDate = payDate;

    }
}
