package fun.aaronwu.bler.entity;

import lombok.*;

import java.util.UUID;

/**
 * 城市类，企业和应聘者都可以有多个城市
 *
 * @author AaronWu
 *
 * cId 城市ID
 * cName 城市名称
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class City {
    private UUID cId;
    private String cName;
}
