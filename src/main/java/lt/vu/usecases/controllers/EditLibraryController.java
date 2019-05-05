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

@Named
@ViewScoped
@Slf4j
public class EditLibraryController implements Serializable {
    @Getter
    private Library selectedLibrary;
    @Getter
    private Library conflictingLibrary;
    @Getter
    private List<Library> allLibraries;

    @Inject
    private LibraryDAO libraryDAO;

    @PostConstruct
    public void init() {
        reloadAll();
    }

    public void prepareForEditing(Library library) {
        selectedLibrary = library;
        conflictingLibrary = null;
    }

    @Transactional
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
