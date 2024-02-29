package fun.aaronwu.bler.mapper;

import fun.aaronwu.bler.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.UUID;

/**
 * 应聘者映射接口，定义对Employee表的操作有哪些
 */

@Mapper
public interface EmployeeMapper {

    /**
     * 插入
     * @param e 应聘者对象
     */
    void insert(Employee e);

    /**
     * 更新
     * @param e 应聘者对象
     */
    void update(Employee e);

    /**
     * 删除
     * @param e 应聘者对象
     */
    void delete(Employee e);

    /**
     * 查单个
     * @param uId 用户ID
     * @return 应聘者对象
     */
    Employee getOneById(UUID uId);

    /**
     * 查询所有应聘者
     * @return 应聘者列表
     */
    List<Employee> getAllEmployees();

    /**
     * 动态查询应聘者，根据非空的条件
     * @param e 应聘者对象
     * @return 应聘者列表
     */
    List<Employee> getAllEmployeeDynamically(Employee e);

    /**
     * 通过简历对象得到写简历的用户
     * @param resume 简历对象
     * @return 应聘者对象
     */
    Employee getResumeEmployee(Resume resume);

    void addEmployeeTag(@Param("employee") Employee employee, @Param("tag") Tag tag);

    void addEmployeeCity(@Param("employee") Employee employee, @Param("city") CityMapper city);
}
