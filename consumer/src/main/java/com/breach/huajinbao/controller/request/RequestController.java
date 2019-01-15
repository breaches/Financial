package com.breach.huajinbao.controller.request;

import com.breach.common.entity.Questionnaire;
import com.breach.huajinbao.service.quest.IRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class RequestController {

    @Autowired
    private IRequestService quest;

    @RequestMapping("/quest")
    public void quest(@RequestBody Questionnaire q){
         quest.quest(q);
    }

    @RequestMapping("/qqq")
    public List<Map<String, Object>> qqq() {
        return quest.qqq();
    }

}
