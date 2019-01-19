package com.breach.huajinbao.service.topup;

import com.breach.huajinbao.util.topup.MessageQuery;
import com.breach.huajinbao.util.topup.Result;

import java.util.Map;

/**
 * Created by wanghehe on 2019年01月11日
 */

public interface IMessageSerivice {

    /**
     * 获取用户消息列表
     * @param
     * @return
     *
     */
    Map<String, Object> getMessageList(MessageQuery messageQuery);
    /**
     * 批量删除消息
     * @param
     * @return
     *
     */
    Result deleteMessage(int[] ids);
    /**
     * 批量修改消息状态
     * @param
     * @return
     *
     */
    Result updateMessage(int[] ids);
    /**
     * 展开修改已读
     * @param
     * @return
     *
     */
    Map<String,Object> setState(Integer id);
}


