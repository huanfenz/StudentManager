package com.wangpeng.service;

import com.wangpeng.pojo.Article;

import java.util.List;
import java.util.Map;

public interface ArticleService {

    /**
     * 找所有的文章
     * @return
     */
    List<Article> findAllArticles();

    /**
     * 分页找所有文章
     * @param page
     * @param size
     * @return
     */
    List<Article> findArticlesByPage(int page, int size);

    /**
     * 获取文章总数
     * @return
     */
    int getArticlesCount();

    /**
     * 删除指定文章
     * @param articles
     * @return 删除成功的数量
     */
    int deleteArticles(List<Article> articles);

    /**
     * 添加一个文章
     * @param article
     */
    int addArticle(Article article);

    /**
     * 修改一个文章
     * @param article
     * @return
     */
    int updateArticle(Article article);

    /**
     * 搜索文章
     * @param page
     * @param size
     * @param searchParam
     */
    List<Article> searchArticles(Integer page, Integer size, Map<String, Object> searchParam);

    /**
     * 获取搜索的数量
     * @param searchParam
     * @return
     */
    int getSearchCount(Map<String, Object> searchParam);

}
