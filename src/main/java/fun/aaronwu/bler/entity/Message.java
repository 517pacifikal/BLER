package fun.aaronwu.bler.entity;

import lombok.*;

import java.util.UUID;

/**
 * 消息实体类
 *
 * @author AaronWu
 *
 * uId 发送消息的用户
 * mType 消息类型，分为四种
 * mInfo 消息内容
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Message {

    private enum Type{
        RESUME_PASS("RESUME_PASS"),
        RESUME_UNPASS("RESUME_UNPASS"),
        ACCEPT("ACCEPT"),
        UNACCEPT("UNACCEPT");

        private final String value;

        Type(String value){
            this.value=value;
        }
        public String getValue(){
            return value;
        }
        public static Type fromValue(String value){
            for(Type mType:Type.values()){
                if(mType.value.equals(value)){
                    return mType;
                }
            }
            throw new IllegalArgumentException("无效类型"+value);
        }
    }

    private UUID uId;
    private Type mType;
    private String mInfo;

}
