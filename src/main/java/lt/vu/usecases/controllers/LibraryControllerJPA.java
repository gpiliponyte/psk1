package lt.vu.usecases.controllers;


import lombok.Getter;
import lt.vu.entities.Library;
import lt.vu.entities.Book;
import lt.vu.usecases.dao.BookDAO;
import lt.vu.usecases.dao.LibraryDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class LibraryControllerJPA {
    @Getter
    private List<Library> libraries;

    @Getter
    private Library library = new Library();

    @Getter
    private Book book = new Book();

    @Inject
    private LibraryDAO libraryDAO;

    @Inject
    private BookDAO bookDAO;

    @PostConstruct
    public void init() {
        loadAllLibraries();
    }

    @Transactional
    public void createLibraryWithBook() {
        library.getBooks().add(book);
        book.setLibrary(library);
        bookDAO.create(book);
        libraryDAO.create(library);
    }

    private void loadAllLibraries() {
        this.libraries = libraryDAO.getAllLibraries();
    }
}
