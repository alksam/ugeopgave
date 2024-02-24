package SchoolExercise.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "student_info")
@Getter
@NoArgsConstructor
@Setter
@ToString
public class StudentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "full_name")
    private String fullName;
    @Column(name = "student_id")
    private int studentId;
    @Column(name = "this_semester_name")
    private String thisSemesterName;
    @Column(name = "this_semester_description")
    private String thisSemesterDescription;



    public StudentInfo(String fullName, int studentId, String thisSemesterName, String thisSemesterDescription) {
        this.fullName = fullName;
        this.studentId = studentId;
        this.thisSemesterName = thisSemesterName;
        this.thisSemesterDescription = thisSemesterDescription;
    }



}
