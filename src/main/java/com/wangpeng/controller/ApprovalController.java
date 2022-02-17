package com.wangpeng.controller;

import com.wangpeng.pojo.Approval;
import com.wangpeng.pojo.Student;
import com.wangpeng.service.ApprovalService;
import com.wangpeng.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/approval")
public class ApprovalController {

    @Autowired
    ApprovalService service;

    /**
     * 查询审批
     * @param page  当前页码
     * @param limit 每页大小
     * @return 审批信息
     */
    @RequestMapping("queryApprovals.do")
    public Map<String,Object> queryApprovals(Integer page, Integer limit){
        //获取审批数量
        int count = service.getApprovalsCount();
        //获取数据
        List<Approval> approvals = service.findApprovalsByPage(page,limit);
        //结果map
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("code", 0);
        res.put("msg", "");
        res.put("count", count);
        res.put("data", approvals);

        return res;
    }

    /**
     * 查询审批（未审批的）
     * @param page  当前页码
     * @param limit 每页大小
     * @return 审批信息
     */
    @RequestMapping("queryApprovalsByWait.do")
    public Map<String,Object> queryApprovalsByWait(Integer page, Integer limit){
        //获取审批数量
        int count = service.getApprovalsCountByWait();
        //获取数据
        List<Approval> approvals = service.findApprovalsByPageByWait(page,limit);
        //结果map
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("code", 0);
        res.put("msg", "");
        res.put("count", count);
        res.put("data", approvals);

        return res;
    }

    /**
     * 根据学生id查询审批
     * @param page  当前页码
     * @param limit 每页大小
     * @return 审批信息
     */
    @RequestMapping({"queryApprovalsBySid.do", "student/queryApprovalsBySid.do"})
    public Map<String,Object> queryApprovalsBySid(Integer page, Integer limit, HttpServletRequest req){
        //获取当前账号信息
        Student loginStudent =  (Student) req.getSession().getAttribute("loginObj");
        Integer sid = loginStudent.getSid();
        //获取审批数量
        int count = service.getApprovalsCountBySid(sid);
        //获取数据
        List<Approval> approvals = service.findApprovalsByPageBySid(page,limit,sid);
        //结果map
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("code", 0);
        res.put("msg", "");
        res.put("count", count);
        res.put("data", approvals);

        return res;
    }

    /**
     * 查询所有审批
     * @return 审批信息
     */
    @RequestMapping("queryAllApprovals.do")
    public List<Approval> queryAllApprovals(){
        return service.findAllApprovals();
    }

    /**
     * 删除审批
     * @param json 审批对象的json
     * @return 成功行数
     */
    @RequestMapping({"deleteApprovals.do", "student/deleteApprovals.do"})
    public Integer deleteApprovals(String json){
        if(json.charAt(0) != '[') json = '[' + json + ']';  //如果不是数组形式，变成数组形式
        List<Approval> approvals = JsonUtil.parseList(json, Approval.class);
        return service.deleteApprovals(approvals);
    }

    /**
     * 添加一个审批
     * @param json 审批对象的json
     * @return 成功标志1
     */
    @RequestMapping({"addApproval.do", "student/addApproval.do"})
    public Integer addApproval(String json){
        Approval approval = JsonUtil.parseObject(json, Approval.class);
        return service.addApproval(approval);
    }

    /**
     * 修改一个审批
     * @param json 审批对象的json
     * @return 成功标志1
     */
    @RequestMapping("updateApproval.do")
    public Integer updateApproval(String json){
        Approval approval = JsonUtil.parseObject(json, Approval.class);
        return service.updateApproval(approval);
    }

    /**
     * 获取审批总数
     * @return 审批总数
     */
    @RequestMapping({"getAmount.do", "student/getAmount.do"})
    public Integer getAmount() {
        return service.getApprovalsCount();
    }

    /**
     * 获取未处理的审批总数
     * @return 未处理的审批总数
     */
    @RequestMapping("getAmountUntreated.do")
    public Integer getAmountUntreated() {
        return service.getApprovalsCountUntreated();
    }
}
