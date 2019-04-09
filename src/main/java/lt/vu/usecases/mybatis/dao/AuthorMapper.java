package lt.vu.usecases.mybatis.dao;

import java.util.List;
import lt.vu.usecases.mybatis.model.Author;
import org.mybatis.cdi.Mapper;

@Mapper
public interface AuthorMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.authors
     *
     * @mbg.generated Sun Apr 07 17:44:28 EEST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.authors
     *
     * @mbg.generated Sun Apr 07 17:44:28 EEST 2019
     */
    int insert(Author record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.authors
     *
     * @mbg.generated Sun Apr 07 17:44:28 EEST 2019
     */
    List<Author> selectAll();
}