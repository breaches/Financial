package com.breach.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author shaokang
 * @since 2019-01-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ConsumerQuestionnaire extends Model<ConsumerQuestionnaire> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer consumerId;

    /**
     * 您的年龄？
     */
    private String age;

    /**
     * 您家庭可支配收入大概是多少？
     */
    private String income;

    /**
     * 在您每年的家庭收入中，可用于投资的比例为？
     */
    private String layout;

    /**
     *  您有多少年投资股票、基金、P2P、外汇及其他各类金融产品的投资经验？
     */
    private String experience;

    /**
     * 您的投资目标是？
     */
    private String target;

    /**
     * 您偏好的投资期限是多久？
     */
    private String timeLimit;

    /**
     * 您的投资出现何种程度的波动时，您会呈现明显的焦虑？
     */
    private String mood;

    private String type;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
