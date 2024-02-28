package fun.aaronwu.bler.entity;

import lombok.*;

import java.util.UUID;

/**
 * 标签实体类
 *
 * @author AaronWu
 *
 * tId 标签ID
 * tName 标签名称
 * tIcon 标签标志，存储在阿里云OSS中
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Tag {
    private UUID tId;
    private String tName;
    private String tIcon;
}
