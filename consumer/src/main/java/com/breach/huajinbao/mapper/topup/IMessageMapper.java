package com.breach.huajinbao.mapper.topup;

import com.breach.huajinbao.util.topup.MessageQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Map;

/**
 * Created by wanghehe on 2019年01月11日
 */
@Repository
public interface IMessageMapper {
    /**
     * 获取当前消息个数
     * @param
     * @return
     *
     */
    Integer getTotal(@Param("message") MessageQuery messageQuery,@Param("id") Integer id);
    /**
     * 获取当前全部消息
     * @param
     * @return
     *
     */
    List<Map<String, Object>> getMessage(@Param("message") MessageQuery messageQuery,@Param("id") Integer id);

    /**
     * 获取未读消息个数
     * @param
     * @return
     *
     */
    Integer getUnread(Integer id);
    /**
     * 批量删除消息
     * @param
     * @return
     *
     */
    void deleteMessage(int[] ids);

    /**
     * 批量修改消息状态
     * @param
     * @return
     *
     */
    void updateMessage(int[] ids);
    /**
     * 展开修改已读
     * @param
     * @return
     *
     */
    void setState(Integer id);


}
