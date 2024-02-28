package fun.aaronwu.bler.entity;

import lombok.*;

import java.util.UUID;

/**
 * 简历实体类
 *
 * @author AaronWu
 *
 * rId 简历ID
 * uId 用户ID
 * rInfo 简历的补充信息
 * rFile 简历文件，存储在阿里云OSS中
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Resume {
    private UUID rId;
    private UUID uId;
    private String rInfo;
    private String rFile;
}
