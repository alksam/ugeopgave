package SchoolExercise;

import Dolphin.PersonDetails;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "semester")
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String Description;
    @OneToOne(mappedBy = "semester", cascade = CascadeType.ALL)
    private Teacher teacher;
    @OneToMany(mappedBy = "semester", cascade = {CascadeType.PERSIST})
    private Set<Student> students = new HashSet<>();

    public void addStudent(Student student) {
        this.students=students;
        if (student != null) {
            student.setSemester(this);
        }


    }


    public void addTeacher(Teacher teacher) {
        this.teacher = teacher;
        if (teacher != null) {
            teacher.setSemester(this);
        }
    }



    public Semester(String name, String description) {
        this.name = name;
        Description = description;
    }
}
