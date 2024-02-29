package fun.aaronwu.bler.mapper;

import fun.aaronwu.bler.entity.Company;
import fun.aaronwu.bler.entity.Job;
import fun.aaronwu.bler.entity.Tag;
import fun.aaronwu.bler.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.UUID;

/**
 * 岗位映射接口,定义对Job表的操作有哪些
 *
 * @author AaronWu
 */

@Mapper
public interface JobMapper {

    /**
     * 插入一个岗位，必须指定岗位所属企业，以及岗位的标签
     * @param job 岗位第项
     * @param company 企业对象
     * @param tag 标签对象
     */
    void insert(@Param("job")Job job, @Param("company")Company company, @Param("tag")Tag tag);

    /**
     * 更新
     * @param j 岗位对象
     */
    void update(Job j);

    /**
     * 删除
     * @param j 岗位对象
     */
    void delete(Job j);

    /**
     * 通过ID得到岗位
     * @param jId 岗位ID
     * @return 岗位对象
     */
    Job getOneById(UUID jId);

    /**
     * 通过岗位名称查找岗位
     * @param jName 岗位名称
     * @return 岗位列表
     */
    List<Job> getAllByName(String jName);

    /**
     * 动态查询岗位
     * @param company 企业对象
     * @param tag 标签对象
     * @param user 用户对象
     * @param order 结果是否排序 0为默认值,1为升序,-1为降序
     * @param salary 期望最低薪资
     * @return 岗位列表
     */
    List<Job> getAllJobsDynamically(@Param("company") Company company, @Param("tag") Tag tag, @Param("user") User user, @Param("order")int order,@Param("salary")int salary);

    /**
     * 为岗位添加标签
     * @param job 岗位对象
     * @param tag 标签对象
     */
    void addJobTag(@Param("job") Job job,@Param("tag") Tag tag);

    /**
     * 为岗位删除标签
     * @param job 岗位对象
     * @param tag 标签对象
     */
    void deleteJobTag(@Param("job") Job job,@Param("tag") Tag tag);
}
