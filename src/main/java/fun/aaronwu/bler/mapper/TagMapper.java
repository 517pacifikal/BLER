package fun.aaronwu.bler.mapper;

import fun.aaronwu.bler.entity.Company;
import fun.aaronwu.bler.entity.Job;
import fun.aaronwu.bler.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 标签映射接口,定义对Tag表的操作
 *
 * @author AaronWu
 */

@Mapper
public interface TagMapper {

    /**
     * 插入
     * @param t 标签对象
     */
    void insert(Tag t);

    /**
     * 更新
     * @param t 标签对象
     */
    void update(Tag t);

    /**
     * 删除
     * @param t 标签对象
     */
    void delete(Tag t);

    /**
     * 得到全部标签
     * @return 标签列表
     */
    List<Tag> getAllTags();

    /**
     * 动态获得标签列表
     * @param company 企业对象
     * @param job 岗位对象
     * @return 标签列表
     */
    List<Tag> getTagsDynamically(@Param("company")Company company, @Param("job")Job job);
}
