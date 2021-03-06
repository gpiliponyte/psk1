package lt.vu.usecases.mybatis.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Book {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.books.id
     *
     * @mbg.generated Sun Apr 07 17:44:28 EEST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.books.library_id
     *
     * @mbg.generated Sun Apr 07 17:44:28 EEST 2019
     */
    private Integer libraryId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.books.id
     *
     * @return the value of public.books.id
     *
     * @mbg.generated Sun Apr 07 17:44:28 EEST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.books.id
     *
     * @param id the value for public.books.id
     *
     * @mbg.generated Sun Apr 07 17:44:28 EEST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.books.library_id
     *
     * @return the value of public.books.library_id
     *
     * @mbg.generated Sun Apr 07 17:44:28 EEST 2019
     */
    public Integer getLibraryId() {
        return libraryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.books.library_id
     *
     * @param libraryId the value for public.books.library_id
     *
     * @mbg.generated Sun Apr 07 17:44:28 EEST 2019
     */
    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }

    private Library library;
    private List<Author> authors;
}