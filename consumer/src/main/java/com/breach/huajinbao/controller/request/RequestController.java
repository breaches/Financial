package com.breach.huajinbao.controller.request;

import com.breach.common.entity.Questionnaire;
import com.breach.huajinbao.service.quest.IRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    @Autowired
    private IRequestService quest;

    @RequestMapping("/quest")
    public void quest(@RequestBody Questionnaire q){
         quest.quest(q);
    }
}
