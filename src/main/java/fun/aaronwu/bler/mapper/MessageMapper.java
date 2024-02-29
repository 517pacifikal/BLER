package fun.aaronwu.bler.mapper;

import fun.aaronwu.bler.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.UUID;

/**
 * 消息映射接口,定义对Message表有哪些操作
 *
 * @author Aaron
 */
@Mapper
public interface MessageMapper {

    /**
     * 插入一条信息
     * @param message 消息对象
     * @param company 发送消息的企业对象
     * @param employee 接收消息的应聘者对象
     * @param job 消息基于的岗位对象
     */
    void insert(Message message, Company company, Employee employee, Job job);

    /**
     * 删除一条消息
     * @param message 消息对象
     * @param company 发送消息的企业对象
     * @param employee 接收消息的应聘者对象
     * @param job 消息基于的岗位对象
     */
    void delete(Message message, Company company, Employee employee, Job job);

    /**
     * 动态得到信息列表
     * @param company 企业对象
     * @param employee 应聘者对象
     * @param message 消息对象
     * @param visited 是否已读
     * @return 消息列表
     */
    List<Message> getAllMessagesDynamically(@Param("company") Company company,@Param("employee") Employee employee, @Param("message") Message message,@Param("visited") int visited);


}
