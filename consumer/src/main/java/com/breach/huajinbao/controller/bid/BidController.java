package com.breach.huajinbao.controller.bid;

import com.breach.common.entity.UserBorrowBidApplyRecord;
import com.breach.huajinbao.service.bid.IBidService;
import com.breach.huajinbao.util.sign.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: Financial
 * @description: 全局标
 * @author: shaokang
 * @create: 2019-01-17 11:14
 **/
@RestController
@RequestMapping("/bid")
public class BidController {

    @Autowired
    IBidService bidService;

    @RequestMapping("/borrowApply")
    public ReturnUtil borrowApply(@RequestBody UserBorrowBidApplyRecord userBorrowBidApplyRecord) {
        return bidService.borrowApply(userBorrowBidApplyRecord);
    }

}
