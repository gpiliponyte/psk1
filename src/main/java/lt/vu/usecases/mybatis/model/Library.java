package lt.vu.usecases.mybatis.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Library {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.libraries.id
     *
     * @mbg.generated Sun Apr 07 17:44:28 EEST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.libraries.name
     *
     * @mbg.generated Sun Apr 07 17:44:28 EEST 2019
     */
    private String name;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.libraries.id
     *
     * @return the value of public.libraries.id
     *
     * @mbg.generated Sun Apr 07 17:44:28 EEST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.libraries.id
     *
     * @param id the value for public.libraries.id
     *
     * @mbg.generated Sun Apr 07 17:44:28 EEST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.libraries.name
     *
     * @return the value of public.libraries.name
     *
     * @mbg.generated Sun Apr 07 17:44:28 EEST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.libraries.name
     *
     * @param name the value for public.libraries.name
     *
     * @mbg.generated Sun Apr 07 17:44:28 EEST 2019
     */
    public void setName(String name) {
        this.name = name;
    }

    private List<Book> books;
}