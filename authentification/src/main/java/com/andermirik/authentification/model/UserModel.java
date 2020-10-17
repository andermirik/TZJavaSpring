package com.andermirik.authentification.model;
import javax.management.relation.Role;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="users")
public class UserModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;

    @Column(name="login")
    private String login;

    @Column(name="password")
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    private RoleModel role;

    public UserModel(){

    }

    public UserModel(String login, String password, RoleModel role) {
        super();
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long user_id) {
        this.id = user_id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleModel getRole() {
        return role;
    }

    public void setRole(RoleModel role) {
        this.role = role;
    }
}

