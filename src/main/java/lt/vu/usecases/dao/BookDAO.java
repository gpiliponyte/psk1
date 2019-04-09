package lt.vu.usecases.dao;

import lt.vu.entities.Book;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class BookDAO {
    @Inject
    private EntityManager em;

    public void create(Book book) {
        em.persist(book);
    }
}
