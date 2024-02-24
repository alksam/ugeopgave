package SchoolExercise;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "student")
public class Student {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
        private Integer id;
        @Column(name = "firstname")
        private String Firstname;
        @Column(name = "lastname")
        private String Lastname;
        @Column(name = "age")
        private int age;
        @ManyToOne
        private Semester semester;



    public void setSemester(Semester semester) {
            this.semester = semester;
        }





        public Student(String firstname, String lastname, int age) {
            Firstname = firstname;
            Lastname = lastname;
            this.age = age;
        }
}
