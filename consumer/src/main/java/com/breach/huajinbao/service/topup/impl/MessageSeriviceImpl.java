package com.breach.huajinbao.service.topup.impl;

import com.breach.common.entity.ConsumerAuths;
import com.breach.huajinbao.mapper.topup.IMessageMapper;

import com.breach.huajinbao.service.topup.IMessageSerivice;
import com.breach.huajinbao.util.sign.ConsumerSessionUtil;
import com.breach.huajinbao.util.topup.MessageQuery;
import com.breach.huajinbao.util.topup.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wanghehe on 2019年01月11日
 * ..11333a
 */
@Service
public class MessageSeriviceImpl  implements IMessageSerivice {

    @Autowired
    private IMessageMapper messageMapper;

    /**
     * 获取消息表格1
     * @param
     * @return
     *
     */
    @Override
    public Map<String, Object> getMessageList(MessageQuery messageQuery) {


        Map<String, Object> map = new HashMap<>();
        ConsumerAuths consumer = ConsumerSessionUtil.getConsumer();
        List<Map<String, Object>> messageInfo = messageMapper.getMessage(messageQuery,consumer.getId());
        //全部的个数
        Integer total =messageMapper.getTotal(messageQuery,consumer.getId());
        //未读个数
        Integer unread =messageMapper.getUnread(consumer.getId());
        map.put("data",messageInfo);
        map.put("total",total);
        map.put("unread",unread);

        return map;
    }
    /**
     * 批量删除消息
     * @param
     * @param ids
     * @return
     *
     */
    @Override
    public Result deleteMessage(int[] ids) {
        messageMapper.deleteMessage(ids);
        return new Result(200,"删除成功");
    }

    /**
     * 批量修改消息状态
     * @param
     * @return
     *
     */
    @Override
    public Result updateMessage(int[] ids) {


        messageMapper.updateMessage(ids);
        return new Result(200,"修改已读成功");

    }
    /**
     * 展开修改已读
     * @param
     * @return
     *
     */
    @Override
    public  Map<String,Object> setState(Integer id) {
        messageMapper.setState(id);
        //并返回未读个数
        Map<String, Object> map = new HashMap<>();
        ConsumerAuths consumer = ConsumerSessionUtil.getConsumer();
        Integer unread =  messageMapper.getUnread(consumer.getId());
        map.put("unread",unread);
        return map;
    }
}


