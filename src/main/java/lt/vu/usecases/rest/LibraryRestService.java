package lt.vu.usecases.rest;

import lt.vu.entities.Library;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

//@MyInterceptor
@Alternative
@ApplicationScoped
@Path("/rest")
@Produces(MediaType.APPLICATION_JSON)
public class LibraryRestService {
    @Inject
    private EntityManager em;

    @GET
    @Path("/{libraryId}")
    public Library find(@PathParam("libraryId") Integer userId) {
        return em.find(Library.class, userId);
    }

    @GET
    @Path("")
    public List<Library> find() {
        return em.createNamedQuery("Library.findAll", Library.class).getResultList();
    }

    @Path("/")
    @POST
    @Transactional
    public Library create(@QueryParam("name") String name) {
        Library library = new Library();
        library.setName(name);
        em.persist(library);
        return library;
    }

    @Path("/{libraryId}")
    @PUT
    @Transactional
    public Response update(@PathParam("libraryId") Integer libraryId,
                           @QueryParam("name") String name) {
        Library library = em.find(Library.class, libraryId);
        if (library == null) {
            throw new IllegalArgumentException("library id " + libraryId + " not found");
        }
        library.setName(name);
        em.merge(library);
        em.flush();
        return Response.ok(library).build();
    }
}
