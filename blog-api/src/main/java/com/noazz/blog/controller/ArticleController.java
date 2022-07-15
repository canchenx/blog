package com.noazz.blog.controller;

import com.noazz.blog.service.ArticleService;
import com.noazz.blog.vo.ArticleVo;
import com.noazz.blog.vo.Result;
import com.noazz.blog.vo.parms.PageParams;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    public Result articleList(@RequestBody PageParams pageParams) {
        List<ArticleVo> articles = articleService.listArticlesPage(pageParams);
        return Result.success(articles);
    }
}
