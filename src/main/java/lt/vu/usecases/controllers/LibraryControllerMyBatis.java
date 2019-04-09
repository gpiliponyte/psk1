package lt.vu.usecases.controllers;


import lombok.Getter;
import lt.vu.usecases.mybatis.dao.BookMapper;
import lt.vu.usecases.mybatis.dao.LibraryMapper;
import lt.vu.usecases.mybatis.model.Book;
import lt.vu.usecases.mybatis.model.Library;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model // tas pats kaip: @Named ir @RequestScoped
public class LibraryControllerMyBatis {
    @Getter
    private List<Library> libraries;

    @Getter
    private Library library = new Library();

    @Getter
    private Book book = new Book();

    @Inject
    private LibraryMapper libraryMapper;

    @Inject
    private BookMapper bookMapper;

    @PostConstruct
    public void init() {
        loadAllLibraries();
    }

    @Transactional
    public void createLibraryWithBook() {
        libraryMapper.insert(library);
        book.setLibraryId(library.getId());
        bookMapper.insert(book);
    }
    private void loadAllLibraries() {
        this.libraries = libraryMapper.selectAll();
    }
}
