package com.lxinet.jeesns.web.manage.member;

import com.lxinet.jeesns.core.annotation.Before;
import com.lxinet.jeesns.core.controller.BaseController;
import com.lxinet.jeesns.core.dto.ResultModel;
import com.lxinet.jeesns.core.model.Page;
import com.lxinet.jeesns.interceptor.UserLoginInterceptor;
import com.lxinet.jeesns.model.member.Member;
import com.lxinet.jeesns.model.member.ScoreDetail;
import com.lxinet.jeesns.service.member.IScoreDetailService;
import com.lxinet.jeesns.utils.MemberUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * Created by zchuanzhao on 2019/1/5.
 */
@Controller("scoreDetailManageController")
@RequestMapping("${managePath}/member/scoreDetail")
@Before(UserLoginInterceptor.class)
public class ScoreDetailController extends BaseController {
    private static final String INDEX_FTL_PATH = "/manage/member/scoreDetail/";
    @Resource
    private IScoreDetailService scoreDetailService;

    @GetMapping(value = {"/list","/list/{memberId}"})
    public String list(@PathVariable(value = "memberId",required = false) Integer memberId, Model model){
        if (memberId == null){
            memberId = 0;
        }
        Page page = new Page(request);
        ResultModel<ScoreDetail> resultModel = scoreDetailService.list(page,memberId);
        model.addAttribute("model", resultModel);
        return INDEX_FTL_PATH + "list";
    }
}
