package com.wangpeng.service;

import com.wangpeng.pojo.Approval;

import java.util.List;

public interface ApprovalService {

    /**
     * 找所有的审批
     * @return
     */
    List<Approval> findAllApprovals();

    /**
     * 分页找所有审批
     * @param page
     * @param size
     * @return
     */
    List<Approval> findApprovalsByPage(int page, int size);

    /**
     * 获取审批总数
     * @return
     */
    int getApprovalsCount();

    /**
     * 删除指定审批
     * @param approvals
     * @return 删除成功的数量
     */
    int deleteApprovals(List<Approval> approvals);

    /**
     * 添加一个审批
     * @param approval
     */
    int addApproval(Approval approval);

    /**
     * 修改一个审批
     * @param approval
     * @return
     */
    int updateApproval(Approval approval);

    int getApprovalsCountBySid(Integer sid);

    List<Approval> findApprovalsByPageBySid(Integer page, Integer size, Integer sid);

    int getApprovalsCountByWait();

    List<Approval> findApprovalsByPageByWait(Integer page, Integer size);

    Integer getApprovalsCountUntreated();
}
