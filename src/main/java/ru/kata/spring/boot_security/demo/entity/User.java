package ru.kata.spring.boot_security.demo.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "age")
    private int age;

    @Column(name = "email")
    @NotNull
    private String email;

    @Column(name = "password")
    @NotNull
    private String password;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "users_id")
            ,inverseJoinColumns = @JoinColumn(name = "id"))
    private Set<Role> roleSet;

    @Transient
    private boolean roleADMIN;
    @Transient
    private boolean roleUSER;



    public User() {
    }

    public User(String name, String surname, int age, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.password = password;
    }

    public void addRoleForUser(Role role) {
        if (roleSet == null) {
            roleSet = new HashSet<>();
        }
        roleSet.add(role);
    }

    public void setRolesUserAndAdmin() {
        for (Role role : roleSet) {
            if (role.getRoleName().equals("ROLE_USER")) {
                roleUSER = true;
            }
            if (role.getRoleName().equals("ROLE_ADMIN")) {
                roleADMIN = true;
            }
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

    public boolean getRoleADMIN() {
        return roleADMIN;
    }

    public void setRoleADMIN(boolean roleADMIN) {
        this.roleADMIN = roleADMIN;
    }

    public boolean getRoleUSER() {
        return roleUSER;
    }

    public void setRoleUSER(boolean roleUSER) {
        this.roleUSER = roleUSER;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public boolean isRoleADMIN() {
        return roleADMIN;
    }

    public boolean isRoleUSER() {
        return roleUSER;
    }
}
