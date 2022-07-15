package com.noazz.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.noazz.blog.dao.mapper.ArticleMapper;
import com.noazz.blog.dao.pojo.Article;
import com.noazz.blog.service.ArticleService;
import com.noazz.blog.vo.ArticleVo;
import com.noazz.blog.vo.parms.PageParams;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    @Override
    public List<ArticleVo> listArticlesPage(PageParams pageParams) {
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        Page<Article> page = new Page<>(pageParams.getPage(), pageParams.getPageSize());
        Page<Article> articlePage = articleMapper.selectPage(page, queryWrapper);
        return copyList(articlePage.getRecords());
    }

    /**
     * 将数据层的对象复制为渲染页面对象
     *
     * @param records 查询出来的文章
     * @return 返回渲染层的文章列表
     */
    private List<ArticleVo> copyList(List<Article> records) {
        List<ArticleVo> articleVoList = new ArrayList<>();
        for (Article record : records) {
            articleVoList.add(copy(record));
        }
        return articleVoList;
    }

    private ArticleVo copy(Article record) {
        ArticleVo articleVo = new ArticleVo();
        BeanUtils.copyProperties(record, articleVo);
        articleVo.setCreateDate(new DateTime(record.getCreateDate()).toString("yyyy-MM-dd HH:mm"));
        return articleVo;
    }
}
