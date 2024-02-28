package fun.aaronwu.bler.entity;

import lombok.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * 用户抽象类，作为应聘者，企业，管理员三种用户的父类
 *
 * @author AaronWu
 *
 * uId 用户ID
 * uEmail 用户邮箱
 * uPassword 用户密码
 * uName 用户名称
 * uInfo 用户信息
 * uImg 用户图片
 * uIdentity 用户身份
 * cities 用户所在城市
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class User {

    private enum Identity {
        E("E"), // 应聘者
        C("C"), // 企业
        A("A"); // 管理员

        private final String value;

        Identity(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static Identity fromValue(String value) {
            for (Identity identity : Identity.values()) {
                if (identity.value.equals(value)) {
                    return identity;
                }
            }
            throw new IllegalArgumentException("无效身份" + value);
        }
    }

    private UUID uId;
    private String uEmail;
    private String uPassword;
    private String uName;
    private String uInfo;
    private String uImg;
    private Identity uIdentity;

    private List<City> cities;
    private List<Tag> tags;
    private List<Message> messages;
    private List<Job> jobs;
}
