package fun.aaronwu.bler.entity;

import lombok.*;

import java.time.LocalDate;

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

}
