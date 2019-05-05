package lt.vu.usecases.dao;

import lt.vu.entities.Library;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class LibraryDAO {
    @Inject
    private EntityManager em;

    public List<Library> getAllLibraries() {
        return em.createNamedQuery("Library.findAll", Library.class).getResultList();
    }

    public void create(Library library) {
        em.persist(library);
    }

    public void updateAndFlush(Library library) {
        em.merge(library);
        em.flush();
    }

    public Library findById(Integer id) {
        return em.find(Library.class, id);
    }
}
