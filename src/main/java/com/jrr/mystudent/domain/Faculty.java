package com.jrr.mystudent.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Faculty.
 */
@Entity
@Table(name = "faculty")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Faculty implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "faculty_name", nullable = false)
    private String facultyName;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "faculty")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Student> studentFaculties = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public Faculty facultyName(String facultyName) {
        this.facultyName = facultyName;
        return this;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getAddress() {
        return address;
    }

    public Faculty address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Student> getStudentFaculties() {
        return studentFaculties;
    }

    public Faculty studentFaculties(Set<Student> students) {
        this.studentFaculties = students;
        return this;
    }

    public Faculty addStudentFaculty(Student student) {
        studentFaculties.add(student);
        student.setFaculty(this.facultyName);
        return this;
    }

    public Faculty removeStudentFaculty(Student student) {
        studentFaculties.remove(student);
        student.setFaculty(null);
        return this;
    }

    public void setStudentFaculties(Set<Student> students) {
        this.studentFaculties = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Faculty faculty = (Faculty) o;
        if (faculty.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, faculty.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Faculty{" +
            "id=" + id +
            ", facultyName='" + facultyName + "'" +
            ", address='" + address + "'" +
            '}';
    }
}
