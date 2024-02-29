package fun.aaronwu.bler.mapper;

import fun.aaronwu.bler.entity.Employee;
import fun.aaronwu.bler.entity.Job;
import fun.aaronwu.bler.entity.Resume;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.UUID;

/**
 * 简历映射接口,定义对Resume表的操作
 *
 * @author AaronWu
 */
@Mapper
public interface ResumeMapper {

    /**
     * 插入
     * @param r 简历对象
     */
    void insert(Resume r);

    /**
     * 更新
     * @param r 简历对象
     */
    void update(Resume r);

    /**
     * 删除
     * @param r 简历对象
     */
    void delete(Resume r);

    /**
     * 通过id得到简历
     * @param rId 简历ID
     * @return 简历对象
     */
    Resume getOneById(UUID rId);

    /**
     * 得到某个应聘者的全部简历
     * @param employee 应聘者
     * @return
     */
    List<Resume> getAllByEmployee(Employee employee);

    /**
     * 根据应聘者和应聘岗位得到简历
     * @param employee 应聘者
     * @param job 应聘岗位
     * @return
     */
    Resume getOneByJob(Employee employee, Job job);
}
