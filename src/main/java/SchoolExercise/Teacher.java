package SchoolExercise;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "firstname")
    private String Firstname;

    @Column(name = "lastname")
    private String Lastname;
    @OneToOne
    private Semester semester;
    public Teacher(String firstname, String lastname) {
        Firstname = firstname;
        Lastname = lastname;
    }
}
