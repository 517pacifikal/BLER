package fun.aaronwu.bler.mapper;

import fun.aaronwu.bler.entity.City;
import fun.aaronwu.bler.entity.Company;
import fun.aaronwu.bler.entity.Job;
import fun.aaronwu.bler.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;
import java.util.UUID;

/**
 * 企业映射接口,定义对Company表的操作有哪些
 *
 * @author AaronWu
 */

@Mapper
public interface CompanyMapper {

    /**
     * 插入
     * @param c 企业对象
     */
    void insert(Company c);

    /**
     * 更新
     * @param c 企业对象
     */
    void update(Company c);

    /**
     * 删除
     * @param c 企业对象
     */
    void delete(Company c);

    /**
     * 查单个
     * @param uId 用户ID
     * @return Company 企业对象
     */
    Company getOneById(UUID uId);

    /**
     * 通过岗位查询企业
     * @param job 岗位对象
     * @return Company 企业对象
     */
    Company getOneByJob(Job job);

    /**
     * 通过企业名称获取企业
     * @param uName 企业名称
     * @return Company 企业对象
     */
    Company getOneByName(String uName);

    /**
     * 通过标签查询企业
     * @param tag 标签对象
     * @return List<Company>
     */
    List<Company> getAllByTag(Tag tag);

    /**
     * 获取全部企业
     * @return List<Company>
     */
    List<Company> getAllCompany();

    /**
     * 获取全部没有认证的企业
     * @return List<Company>
     */
    List<Company> getAllUnAuthorized();

    /**
     * 动态sql查询企业,选择条件有是否只查看未授权,是否有标签限制
     * @param unAuthorized 是否为只查询未认证通过的
     * @param tag 标签对象,需要查询的标签不为空
     * @param city 是否仅查询某城市
     * @return List<Company>
     */
    List<Company> getAllCompanyDynamically(@Param("unAuthorized") int unAuthorized, @Param("tag")Tag tag, @Param("city") City city);

    /**
     * 授权企业的注册，由管理员操作
     * @param c 企业对象
     */
    void authorizeCompany(Company c);

    /**
     * 为企业添加标签
     * @param company 企业对象
     * @param tag 标签对象
     */
    void addCompanyTag(@Param("company") Company company, @Param("tag") Tag tag);

    /**
     * 为企业添加城市
     * @param company 企业对象
     * @param city 城市对象
     */
    void addCompanyCity(@Param("company") Company company, @Param("city") City city);
}
