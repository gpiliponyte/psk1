package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "libraries")
@NamedQueries({
        @NamedQuery(name = "Library.findAll", query = "SELECT l FROM Library l")
})
@Getter
@Setter
@ToString(of = {"id", "name"})
public class Library implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "library")
    private List<Book> books = new ArrayList<>();
}
