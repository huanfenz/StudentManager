package com.wangpeng.dao;

import com.wangpeng.pojo.Approval;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ApprovalDao {
    /**
     * 添加审批
     * @param approval
     * @return
     */
    int insertApproval(Approval approval);

    /**
     * 删除审批
     * @param approvals
     * @return
     */
    int deleteApprovals(List<Approval> approvals);

    /**
     * 修改审批
     * @param approval
     * @return
     */
    int updateApproval(Approval approval);

    /**
     * 查询所有审批
     * @return
     */
    List<Approval> selectApprovals();

    /**
     * 根据id查询审批
     * @param id
     * @return
     */
    Approval selectApproval(Integer id);

    /**
     * 分页查询审批
     * @param begin 起始索引，从0开始
     * @param size  每页大小
     * @return
     */
    List<Approval> selectApprovalsByLimit(@Param("begin") int begin, @Param("size")int size);

    /**
     * 获取审批数量
     * @return
     */
    int getApprovalsCount();

    int getApprovalsCountBySid(int sid);

    List<Approval> selectApprovalsByLimitBySid(@Param("begin") int begin, @Param("size") Integer size, @Param("sid") Integer sid);

    int getApprovalsCountByWait();

    List<Approval> selectApprovalsByLimitByWait(@Param("begin") int begin, @Param("size")int size);
}
