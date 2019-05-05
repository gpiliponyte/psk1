package lt.vu.usecases.controllers;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lt.vu.entities.Library;
import lt.vu.usecases.dao.LibraryDAO;
import org.omnifaces.cdi.ViewScoped;
import org.primefaces.context.RequestContext;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Named // @Named instead of Spring’s @Component to declare a bean.
@ViewScoped // A @ViewScoped bean lives exactly as long as a JSF view.
@Slf4j // SLF4J is a simple facade for logging systems allowing the end-user to plug-in the desired logging system at deployment time.
public class EditLibraryController implements Serializable { // Serializable no methods just indicates that serializable
    @Getter
    private Library selectedLibrary;
    @Getter
    private Library conflictingLibrary;
    @Getter
    private List<Library> allLibraries;

    @Inject // Identifies injectable constructors, methods, and fields.
    private LibraryDAO libraryDAO;

    @PostConstruct // In the @PostConstruct method the bean is fully initialized and you can use the dependencies.
    public void init() {
        reloadAll();
    }

    public void prepareForEditing(Library library) {
        selectedLibrary = library;
        conflictingLibrary = null;
    }

    @Transactional // deal with db
    public void updateSelectedLibrary() {
        try {
            libraryDAO.updateAndFlush(selectedLibrary);
            reloadAll();
        } catch (OptimisticLockException ole) {
            conflictingLibrary = libraryDAO.findById(selectedLibrary.getId());
            RequestContext.getCurrentInstance().addCallbackParam("validationFailed", true);
        }
    }

    @Transactional
    public void overwriteLibrary() {
        selectedLibrary.setOptLockVersion(conflictingLibrary.getOptLockVersion());
        updateSelectedLibrary();
    }

    public void reloadAll() {
        allLibraries = libraryDAO.getAllLibraries();
    }
}
