package com.wangpeng.service.impl;

import com.wangpeng.dao.ArticleDao;
import com.wangpeng.pojo.Article;
import com.wangpeng.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleDao articleDao;

    @Override
    public List<Article> findAllArticles() {
        return articleDao.selectArticles();
    }

    @Override
    public List<Article> findArticlesByPage(int page, int size) {
        int begin = (page - 1) * size;
        return articleDao.selectArticlesByLimit(begin,size);
    }

    @Override
    public int getArticlesCount() {
        return articleDao.getArticlesCount();
    }

    @Override
    public int deleteArticles(List<Article> articles) {
        return articleDao.deleteArticles(articles);
    }

    @Override
    public int addArticle(Article article) {
        return articleDao.insertArticle(article);
    }

    @Override
    public int updateArticle(Article article) {
        return articleDao.updateArticle(article);
    }

    @Override
    public List<Article> searchArticles(Integer page, Integer size, Map<String, Object> searchParam) {
        int begin = (page - 1) * size;
        //在搜索的基础上添加2个参数
        Map<String,Object> map = searchParam;
        map.put("begin", begin);
        map.put("size", size);
        List<Article> articles = articleDao.searchArticlesByLimit(map);
        return articles;
    }

    @Override
    public int getSearchCount(Map<String, Object> searchParam) {
        return articleDao.getSearchCount(searchParam);
    }

}
