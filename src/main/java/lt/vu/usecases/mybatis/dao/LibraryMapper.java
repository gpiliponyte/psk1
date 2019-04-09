package lt.vu.usecases.mybatis.dao;

import java.util.List;
import lt.vu.usecases.mybatis.model.Library;
import org.mybatis.cdi.Mapper;

@Mapper
public interface LibraryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.libraries
     *
     * @mbg.generated Sun Apr 07 17:44:28 EEST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.libraries
     *
     * @mbg.generated Sun Apr 07 17:44:28 EEST 2019
     */
    int insert(Library record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.libraries
     *
     * @mbg.generated Sun Apr 07 17:44:28 EEST 2019
     */
    Library selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.libraries
     *
     * @mbg.generated Sun Apr 07 17:44:28 EEST 2019
     */
    List<Library> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.libraries
     *
     * @mbg.generated Sun Apr 07 17:44:28 EEST 2019
     */
    int updateByPrimaryKey(Library record);
}