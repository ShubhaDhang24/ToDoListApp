package shubhadhang.todolistapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

@Entity
public class User {
    @Id
    @Column(updatable = false)
    private String email;

    @Column(nullable = false,length = 120)
    private String password;
    private  boolean expired;

    @ManyToMany//creating new table with user and roles
    @JoinTable (name = "users_roles",
               joinColumns = @JoinColumn(name="user-id"),
               inverseJoinColumns = @JoinColumn(name = "role_id"))

    private Set<Role> roles;

    //initialise user and save it to database
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public void addRole(Role role)
    {
        if(role==null)throw new IllegalArgumentException("Role is null.");
        if(roles==null) roles= new HashSet<>();
        roles.add(role);


    }
    public void remove(Role role)
    {
        if(role==null) throw new IllegalArgumentException("Role is null.");
        if(roles!=null){
            roles.remove(role);
        }
        else throw new IllegalArgumentException("List of roles is empty");
    }

}
