package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.johnzon.mapper.JohnzonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
@Getter
@Setter
@ToString(of = {"id"})
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books = new ArrayList<>();

    @Version
    @Column(name = "opt_lock_version")
    @JohnzonIgnore // kad reste neatsirastu
    private Integer optLockVersion;
}
