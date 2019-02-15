package com.ant.service;

import com.ant.entity.InviteMsg;
import com.ant.entity.PullRefreshEntity;
import com.ant.mapper.InviteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: Ant
 * @Date: 2019/02/15 11:54
 * @Description:
 */
@Service
public class InviteService {
    @Autowired
    private InviteMapper inviteMapper;

    public PullRefreshEntity<InviteMsg> findPullRefreshEntityByUser(String id, int begin, int end) {
        PullRefreshEntity<InviteMsg> pullRefreshEntity = new PullRefreshEntity<>();
        List<InviteMsg> inviteMsgList = inviteMapper.findByUser(id,begin,end-begin);
        pullRefreshEntity.setDataList(inviteMsgList);
        pullRefreshEntity.setHasMore(true);
        if (inviteMsgList.size() == 0 || end-begin > inviteMsgList.size())pullRefreshEntity.setHasMore(false);
        return pullRefreshEntity;
    }

    public InviteMsg findById(int invite_id) {
        return inviteMapper.findById(invite_id);
    }

    @Transactional
    public void accept(int invite_id) {
        
    }

    @Transactional
    public void refuse(int invite_id) {
    }
}
