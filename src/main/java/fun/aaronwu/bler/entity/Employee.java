package fun.aaronwu.bler.entity;

import lombok.*;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.List;

/**
 * 应聘者实体类，继承自用户抽象类
 *
 * @author AaronWu
 *
 * uBirthday 用户生日
 * uSchool 用户毕业院校
 * uGender 用户性别
 * uEdyBgd 用户学历
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee extends User{

    private enum Gender {
        male("男"),
        female("女"),
        unknown("未知");

        public final String value;

        Gender(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static Gender fromValue(String value) {
            for (Gender gender : Gender.values()) {
                if (gender.getValue().equals(value)) {
                    return gender;
                }
            }
            throw new IllegalArgumentException("无效性别 " + value);
        }
    }

    private enum EduBgd {
        highSchool("高中"),
        vocationalHighSchool("中专"),
        junior("大专"),
        bachelor("本科"),
        master("硕士研究生"),
        doctor("博士研究生"),
        unknown("未知");

        public final String value;

        EduBgd(String value){
            this.value=value;
        }

        public String getValue(){
            return value;
        }

        public static EduBgd fromValue(String value) {
            for (EduBgd eduBgd:EduBgd.values()){
                if(eduBgd.getValue().equals(value)){
                    return eduBgd;
                }
            }
            throw new IllegalArgumentException("无效学历" + value);
        }
    }

    private LocalDate uBirthday;
    private String uSchool;
    private Gender uGender;
    private EduBgd uEduBgd;

    //注册用户的构造函数
    public Employee(String uEmail, String uPassword, String uName, String uInfo, String uSchool, String uGender, String uEduBgd, List<City> uCity){
        this.setUEmail(uEmail);
        //密码使用MD5加密
        this.setUPassword(DigestUtils.md5DigestAsHex(uPassword.getBytes(StandardCharsets.UTF_8)));
        this.setUImg("https://aaron-recruitment-website.oss-cn-shanghai.aliyuncs.com/%E9%BB%98%E8%AE%A4icon/user.png");
        this.setUName(uName);
        this.setUInfo(uInfo);
        this.setUSchool(uSchool);
        this.setUGender(Gender.fromValue(uGender));
        this.setUEduBgd(EduBgd.fromValue(uEduBgd));
        this.setCities(uCity);
    }
}
