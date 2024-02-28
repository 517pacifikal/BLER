package fun.aaronwu.bler.entity;

import lombok.*;

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
}
