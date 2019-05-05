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
@Table(name = "books")
@Getter
@Setter
@ToString(of = {"id"})
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "library_id", referencedColumnName = "id")
    @ManyToOne
    private Library library;

    @JoinTable(name = "books_authors",
        joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "author_id", referencedColumnName = "id")}
    )
    @ManyToMany
    private List<Author> authors = new ArrayList<>();

    @Version
    @Column(name = "opt_lock_version")
    @JohnzonIgnore // kad reste neatsirastu
    private Integer optLockVersion;
}
