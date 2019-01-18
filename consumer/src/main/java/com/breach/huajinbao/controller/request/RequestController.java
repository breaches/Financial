package com.breach.huajinbao.controller.request;

import com.breach.common.entity.ConsumerQuestionnaire;
import com.breach.huajinbao.service.quest.IRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RequestController {

    @Autowired
    private IRequestService quest;

    @RequestMapping("/quest1")
    public Map quest1(@RequestBody ConsumerQuestionnaire q){
        return quest.quest1(q);
    }

    @RequestMapping("/end")
    public String endquest(){
        return quest.end();
    }

}
