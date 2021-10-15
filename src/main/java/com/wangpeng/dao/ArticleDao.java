package com.wangpeng.dao;

import com.wangpeng.pojo.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ArticleDao {
    /**
     * 添加文章
     * @param article
     * @return
     */
    int insertArticle(Article article);

    /**
     * 删除文章
     * @param articles
     * @return
     */
    int deleteArticles(List<Article> articles);

    /**
     * 修改文章
     * @param article
     * @return
     */
    int updateArticle(Article article);

    /**
     * 查询所有文章
     * @return
     */
    List<Article> selectArticles();

    /**
     * 根据id查询文章
     * @param id
     * @return
     */
    Article selectArticle(Integer id);

    /**
     * 分页查询文章
     * @param begin 起始索引，从0开始
     * @param size  每页大小
     * @return
     */
    List<Article> selectArticlesByLimit(@Param("begin") int begin, @Param("size")int size);

    /**
     * 获取文章数量
     * @return
     */
    int getArticlesCount();

    /**
     * 分页搜索文章
     * @param map 4个参数，begin,size,mname,mdept
     * @return
     */
    List<Article> searchArticlesByLimit(Map<String,Object> map);

    /**
     * 获取搜索的数量
     * @param map 2个参数，mname,mdept
     * @return
     */
    int getSearchCount(Map<String,Object> map);
}
