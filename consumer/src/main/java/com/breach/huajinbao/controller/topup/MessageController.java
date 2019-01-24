package com.breach.huajinbao.controller.topup;

import com.breach.huajinbao.service.topup.IMessageSerivice;
import com.breach.huajinbao.util.topup.MessageQuery;
import com.breach.huajinbao.util.topup.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by wanghehe on 2019年01月11日
 * 消息界面控制层
 */
@RequestMapping("/getMessage")
@RestController
public class MessageController {


    @Autowired
    private IMessageSerivice messageSerivice;

    /**
     * 获取消息列表
     * @param
     * @return
     *
     */
    @RequestMapping("/getMessageList")
    public Map<String,Object> getMessageList(@RequestBody MessageQuery messageQuery){

        return messageSerivice.getMessageList(messageQuery);

    }

    /**
     * 批量删除消息
     * @param
     * @return
     *
     */
    @RequestMapping("/deleteMessage")
    public Result deleteMessage(@RequestBody int[]  ids){
        return  messageSerivice.deleteMessage(ids);
    }
    /**
     * 批量修改消息状态
     * @param
     * @return
     *
     */
    @RequestMapping("/updateMessage")
    public Result updateMessage(@RequestBody int[]  ids){

        return  messageSerivice.updateMessage(ids);

    }
    /**
     * 展开修改已读
     * @param
     * @return
     *
     */
    @RequestMapping("/setState")
    public Map<String,Object> setState(Integer id){


        return  messageSerivice.setState(id);

    }

}
