package com.breach.huajinbao.controller.zfq;

import com.breach.huajinbao.service.zfq.IPrizeService;
import com.breach.huajinbao.service.zfq.IRoleService;
import com.breach.huajinbao.util.zfq.PrizeQuery;
import com.breach.huajinbao.util.zfq.RoleQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @program: Financial
 * @description:
 * @author:
 * @create: 2019-02-27 21:03
 **/
@RestController
@RequestMapping("/prize")
public class PrizeController {

    @Autowired
    private IPrizeService prizeService ;
    /*
    满标初审记录
    实体p为接收的查询条件
    以下相同
     */
    @RequestMapping("/fullScale")
    public Map fullScale(@RequestBody PrizeQuery p) {
        return prizeService.fullScale(p);
    }
    //满标复审记录
    @RequestMapping("/recheck")
    public Map recheck(@RequestBody PrizeQuery p) {
        return prizeService.recheck(p);
    }
    //流标记录
    @RequestMapping("/failure")
    public Map failure(@RequestBody PrizeQuery p) {
        return prizeService.failure(p);
    }
    //发标审核记录
    @RequestMapping("/Invitation")
    public Map Invitation(@RequestBody PrizeQuery p) {
        return prizeService.Invitation(p);
    }
}
