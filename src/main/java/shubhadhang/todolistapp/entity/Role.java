package shubhadhang.todolistapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @Column(nullable = false,unique = true)
    private String name;

    public Role(String name) {
        this.name = name;
    }
}
