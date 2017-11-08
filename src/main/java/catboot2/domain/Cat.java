package catboot2.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by USER on 01.11.2017.
 */
@Entity
@Data
@NoArgsConstructor
public class Cat {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "poroda")
    private String poroda;


}
