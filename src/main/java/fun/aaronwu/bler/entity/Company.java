package fun.aaronwu.bler.entity;

import lombok.*;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 企业实体类，继承自用户抽象类
 *
 * @author AaronWu
 *
 * uWebsite 企业官网
 * uAuthorized 企业授权情况
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Company extends User{

    private enum Authorize{
        Y("Y"),//已经授权
        N("N");//尚未授权

        private final String value;

        Authorize(String value){
            this.value=value;
        }

        public static Authorize fromValue(String value){
            for(Authorize authorize:Authorize.values()){
                if(authorize.value.equals(value)){
                    return authorize;
                }
            }
            throw new IllegalArgumentException("无效授权值"+value);
        }
    }

    private String uWebsite;
    private Authorize uAuthorized;

    public Company(String uEmail, String uPassword, String uName, String uInfo, String uWebsite){
        this.setUEmail(uEmail);
        this.setUPassword(DigestUtils.md5DigestAsHex(uPassword.getBytes(StandardCharsets.UTF_8)));
        this.setUImg("https://aaron-recruitment-website.oss-cn-shanghai.aliyuncs.com/%E9%BB%98%E8%AE%A4icon/user.png");
        this.setUName(uName);
        this.setUInfo(uInfo);
        this.setUWebsite(uWebsite);
        this.setUAuthorized(Authorize.fromValue("N"));
    }
}
