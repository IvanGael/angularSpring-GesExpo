package com.project.GesExpo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true, nullable = false)
    private String Username;

    @Column(unique = true, nullable = false)
    private String Email;

    @Column(nullable = false)
    private String Password;

    @Column(nullable = false)
    private String About;

    private int Active;

    private int Blocked;

    @Column(nullable = false, unique = true)
    private String Role = "";


    private String Permission = "";


    public User(String username, String password, String email, int active, int blocked, String role, String permission, String about) {
        this.Username = username;
        this.Password = password;
        this.Email = email;
        this.Active = active;
        this.Blocked = blocked;
        this.Role = role;
        this.Permission = permission;
        this.About = about;
    }

    protected User(){
    }

    public Long getId() {
        return Id;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public int getActive() {
        return Active;
    }

    public int getBlocked() {
        return Blocked;
    }

    public String getRole() {
        return Role;
    }

    public String getPermission() {
        return Permission;
    }

    public List<String> getRoleList() {
        if(this.Role.length() > 0) {
            return Arrays.asList(this.Role.split(","));
        }
        return new ArrayList<>();
    }

    public List<String> getPermissionList() {
        if(this.Permission.length() > 0) {
            return Arrays.asList(this.Permission.split(","));
        }
        return new ArrayList<>();
    }




    public void setId(Long id) {
        this.Id = id;
    }

    public void setUsername(String username) {
        this.Username = username;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public void setActive(int active) {
        this.Active = active;
    }

    public void setBlocked(int blocked) {
        this.Blocked = blocked;
    }

    public void setRole(String role) {
        this.Role = role;
    }

    public void setPermission(String permission) {
        this.Permission = permission;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAbout() {
        return About;
    }

    public void setAbout(String about) {
        About = about;
    }
}