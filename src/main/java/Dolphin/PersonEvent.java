package Dolphin;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

    @Entity
    @Getter
    @Setter
    @NoArgsConstructor
    @ToString
    @Table(name = "personevent")
    public class PersonEvent {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        @ManyToOne
        private Person person;
        @ManyToOne
        private Event event;

        @Column(name = "singupdate")
        private LocalDate sinupdate;
        @Column(name = "eventfee")
        private int eventfee;



        public PersonEvent(Person person, Event event, LocalDate singupdate, int eventfee) {
            this.person = person;
            this.event = event;
            this.sinupdate = singupdate;
            this.eventfee = eventfee;
        }

    }


