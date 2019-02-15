package com.ant.controller;

import com.ant.entity.InviteMsg;
import com.ant.entity.PullRefreshEntity;
import com.ant.entity.ReMsg;
import com.ant.entity.SystemUser;
import com.ant.service.InviteService;
import com.ant.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author: Ant
 * @Date: 2019/02/14 10:27
 * @Description:
 */
@Controller
public class UserController {

    @Autowired
    private SystemUserService userService;
    @Autowired
    private InviteService inviteService;

    @RequestMapping("/userRegister")
    public @ResponseBody
    ReMsg userRegister(SystemUser user) {
        ReMsg msg = new ReMsg();
        try {
            userService.register(user);
            msg.setStatus(true);
            msg.setMsg("register success!");
        } catch (Exception e) {
            msg.setStatus(false);
            msg.setMsg("注册失败！请确保用户名输入正确后再试一次");
        }
        return msg;
    }

    @RequestMapping("/checkUsername")
    public @ResponseBody
    boolean checkUsername(@RequestParam(value = "c_username") String c_username) {
        return userService.checkUsername(c_username);
    }

    @RequestMapping("/inviteNum")
    public @ResponseBody
    int inviteNum() {
        SystemUser systemUser = (SystemUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userService.getInviteNum(systemUser.getId());
    }

    @RequestMapping("/getInviteList")
    public @ResponseBody
    PullRefreshEntity<InviteMsg> getInviteList(@RequestParam("begin") int begin, @RequestParam("end") int end) {
        System.out.println(begin + " - " + end);
        SystemUser systemUser = (SystemUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return inviteService.findPullRefreshEntityByUser(systemUser.getId(), begin, end);
    }

    @RequestMapping("/inviteAnswer")
    public @ResponseBody ReMsg inviteAnswer(@RequestParam("invite_id") int invite_id, @RequestParam("op") int op){
        ReMsg reMsg = new ReMsg();
        switch (op){
            case 1:
                inviteService.accept(invite_id);
                reMsg.setStatus(true);
                break;
            case 2:
                inviteService.refuse(invite_id);
                reMsg.setStatus(true);
                break;
            default:
                reMsg.setStatus(false);
                reMsg.setMsg("违规操作！");
        }
        return reMsg;
    }
}
