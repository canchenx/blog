package com.noazz.blog.service;

import com.noazz.blog.vo.ArticleVo;
import com.noazz.blog.vo.parms.PageParams;

import java.util.List;

public interface ArticleService {
    List<ArticleVo> listArticlesPage(PageParams pageParams);
}
