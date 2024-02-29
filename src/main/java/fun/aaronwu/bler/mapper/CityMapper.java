package fun.aaronwu.bler.mapper;

import fun.aaronwu.bler.entity.City;
import fun.aaronwu.bler.entity.Company;
import fun.aaronwu.bler.entity.Job;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.UUID;

/**
 * 城市映射接口，定义对City表的操作
 *
 * @author AaronWu
 */

@Mapper
public interface CityMapper {

    /**
     * 插入
     * @param c 城市对象
     */
    void insert(City c);

    /**
     * 更新
     * @param c 城市对象
     */
    void update(City c);

    /**
     * 删除
     * @param c 城市对象
     */
    void delete(City c);

    /**
     * 根据ID得到城市
     * @param cId 城市ID
     * @return 城市对象
     */
    City getOneById(UUID cId);

    /**
     * 根据名称得到城市
     * @param cName 城市名称
     * @return 城市对象
     */
    City getOneByName(String cName);

    /**
     * 获取全部城市
     * @return 城市列表
     */
    List<City> getAllCities();

    /**
     * 动态获取企业或者岗位所在的城市
     * @param company 企业对象
     * @param job 岗位对象
     * @return 城市列表
     */
    List<City> getCityDynamically(@Param("company")Company company, @Param("job")Job job);
}
