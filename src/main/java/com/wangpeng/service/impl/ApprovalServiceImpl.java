package com.wangpeng.service.impl;

import com.wangpeng.dao.ApprovalDao;
import com.wangpeng.pojo.Approval;
import com.wangpeng.service.ApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ApprovalServiceImpl implements ApprovalService {

    @Autowired
    ApprovalDao approvalDao;

    @Override
    public List<Approval> findAllApprovals() {
        return approvalDao.selectApprovals();
    }

    @Override
    public List<Approval> findApprovalsByPage(int page, int size) {
        int begin = (page - 1) * size;
        return approvalDao.selectApprovalsByLimit(begin,size);
    }

    @Override
    public int getApprovalsCount() {
        return approvalDao.getApprovalsCount();
    }

    @Override
    public int deleteApprovals(List<Approval> approvals) {
        return approvalDao.deleteApprovals(approvals);
    }

    @Override
    public int addApproval(Approval approval) {
        return approvalDao.insertApproval(approval);
    }

    @Override
    public int updateApproval(Approval approval) {
        return approvalDao.updateApproval(approval);
    }

    @Override
    public int getApprovalsCountBySid(Integer sid) {
        return approvalDao.getApprovalsCountBySid(sid);
    }

    @Override
    public List<Approval> findApprovalsByPageBySid(Integer page, Integer size, Integer sid) {
        int begin = (page - 1) * size;
        return approvalDao.selectApprovalsByLimitBySid(begin,size,sid);
    }

}
