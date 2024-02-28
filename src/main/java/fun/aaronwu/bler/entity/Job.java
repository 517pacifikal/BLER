package fun.aaronwu.bler.entity;

import lombok.*;

import java.util.UUID;

/**
 * 岗位实体类
 *
 * @author AaronWu
 *
 * jId 岗位ID
 * uId 岗位归属的企业ID
 * jName 岗位名称
 * jSalary_lower 岗位最低薪资
 * jSalary_upper 岗位最高工资
 * jSalary_frequency 薪数
 * jEduBgd 岗位学历要求
 * jQuality 岗位性质，分为实习，校招，社招
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Job {

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

        public static Job.EduBgd fromValue(String value) {
            for (Job.EduBgd eduBgd: Job.EduBgd.values()){
                if(eduBgd.getValue().equals(value)){
                    return eduBgd;
                }
            }
            throw new IllegalArgumentException("无效学历" + value);
        }
    }

    private enum Quality {
        SX("SX"),
        XZ("XZ"),
        SZ("SZ");
        public final String value;
        Quality(String value){
            this.value=value;
        }
        public String getValue(){
            return value;
        }
        public static Job.Quality fromValue(String value) {
            for (Job.Quality quality:Job.Quality.values()){
                if(quality.getValue().equals(value)){
                    return quality;
                }
            }
            throw new IllegalArgumentException("无效性质"+value);
        }
    }

    private UUID jId;
    private UUID uId;
    private String jName;
    private int jSalary_lower;
    private int jSalary_upper;
    private int jSalary_frequency;
    private EduBgd jEduBgd;
}
