//package com.example.model;
//
//import javax.persistence.*;
//import java.util.Set;
//@Entity
//public class Student {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//    private String name;
//    private Integer gender;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "account_id",referencedColumnName = "id")
//    private Account account;
//
//    @ManyToOne
//    @JoinColumn(name = "class_id",referencedColumnName = "id")
//    private ClassRoom classRoom;
//
//    @ManyToMany
//    @JoinTable(name = "student_course",joinColumns = @JoinColumn(name = "student_id"),
//            inverseJoinColumns =@JoinColumn(name = "course_id") )
//    private Set<Course> courses;
//
//    public Student(Integer id, String name, Integer gender, Account account, ClassRoom classRoom, Set<Course> courses) {
//        this.id = id;
//        this.name = name;
//        this.gender = gender;
//        this.account = account;
//        this.classRoom = classRoom;
//        this.courses = courses;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getGender() {
//        return gender;
//    }
//
//    public void setGender(Integer gender) {
//        this.gender = gender;
//    }
//
//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }
//
//    public ClassRoom getClassRoom() {
//        return classRoom;
//    }
//
//    public void setClassRoom(ClassRoom classRoom) {
//        this.classRoom = classRoom;
//    }
//
//    public Set<Course> getCourses() {
//        return courses;
//    }
//
//    public void setCourses(Set<Course> courses) {
//        this.courses = courses;
//    }
//}
