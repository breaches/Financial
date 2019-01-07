package com.breach.common.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 账户表
包含该用户的：全部余额，可用余额，冻结金额，
全部余额 = 可用余额 + 冻结金额
可用余额 = 全部余额 - 冻结金额
冻结金额 = 投标空缺期 前端控制器
 * </p>
 *
 * @author shaokang
 * @since 2019-01-07
 */
@Controller
@RequestMapping("/consumerAccount")
public class ConsumerAccountController {

}

