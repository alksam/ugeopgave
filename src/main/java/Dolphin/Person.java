package Dolphin;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private PersonDetails personDetails;
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private Set<Fee> fees= new HashSet<>();
   // @ManyToMany( cascade = CascadeType.PERSIST)
    //private Set<Event>events = new HashSet<>();
@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private Set<PersonEvent> events = new HashSet<>();

    public Person(String name) {
        this.name = name;
    }

    public void addPersonDetail(PersonDetails personDetails) {
        this.personDetails = personDetails;
        if (personDetails != null) {
            personDetails.setPerson(this);
        }
    }

        public void addFee (Fee fee)
        {
            this.fees.add(fee);
            if (fee != null)
            {
                fee.setPerson(this);
            }
        }

        public void addEvent (Person person , Event event, LocalDate singupDate, int eventFee)
        {
            PersonEvent personEvent = new PersonEvent(person,event,singupDate,eventFee);
            this.events.add(personEvent);
        }



    }


