package com.wangpeng.controller;

import com.wangpeng.pojo.Article;
import com.wangpeng.service.ArticleService;
import com.wangpeng.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService service;

    /**
     * 查询文章
     * @param page  当前页码
     * @param limit 每页大小
     * @return 文章信息
     */
    @RequestMapping({"queryArticles.do", "student/queryArticles.do", "teacher/queryArticles.do"})
    public Map<String,Object> queryArticles(Integer page, Integer limit){
        //获取文章数量
        int count = service.getArticlesCount();
        //获取数据
        List<Article> articles = service.findArticlesByPage(page,limit);
        //结果map
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("code", 0);
        res.put("msg", "");
        res.put("count", count);
        res.put("data", articles);

        return res;
    }

    /**
     * 查询所有文章
     * @return 文章信息
     */
    @RequestMapping("queryAllArticles.do")
    public List<Article> queryAllArticles(){
        return service.findAllArticles();
    }

    /**
     * 删除文章
     * @param json 文章对象的json
     * @return 成功行数
     */
    @RequestMapping("deleteArticles.do")
    public Integer deleteArticles(String json){
        if(json.charAt(0) != '[') json = '[' + json + ']';  //如果不是数组形式，变成数组形式
        List<Article> articles = JsonUtil.parseList(json, Article.class);
        return service.deleteArticles(articles);
    }

    /**
     * 添加一个文章
     * @param json 文章对象的json
     * @return 成功标志1
     */
    @RequestMapping("addArticle.do")
    public Integer addArticle(String json){
        Article article = JsonUtil.parseObject(json, Article.class);
        return service.addArticle(article);
    }

    /**
     * 修改一个文章
     * @param json 文章对象的json
     * @return 成功标志1
     */
    @RequestMapping("updateArticle.do")
    public Integer updateArticle(String json){
        Article article = JsonUtil.parseObject(json, Article.class);
        return service.updateArticle(article);
    }

    /**
     * 获取文章总数
     * @return 文章总数
     */
    @RequestMapping("getAmount.do")
    public Integer getAmount() {
        return service.getArticlesCount();
    }

    /**
     * 搜索文章
     * @param page 当前页码
     * @param limit 每页大小
     * @param json 搜索参数的json
     *             {"title":文章标题,"date":日期}
     * @return 文章信息
     */
    @RequestMapping({"searchArticles.do", "student/searchArticles.do", "teacher/searchArticles.do"})
    public Map<String,Object> searchArticles(Integer page, Integer limit, String json){
        //获得搜索的参数
        Map<String, Object> searchParam = JsonUtil.parseMap(json, String.class, Object.class);
        //获取查询个数
        int count = service.getSearchCount(searchParam);
        //查询数据
        List<Article> articles = service.searchArticles(page, limit, searchParam);
        //结果map
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("code", 0);
        res.put("msg", "");
        res.put("count", count);
        res.put("data", articles);
        return res;
    }

}
