package com.noazz.blog.vo;

import lombok.Data;

@Data
public class ArticleVo {
    //雪花算法生成id，不加此注解id会丢失精度，导致无法找到文章内容
//    @JsonSerialize(using = ToStringSerializer.class)
    private String id;

    private String title;

    private String summary;

    private Integer commentCounts;

    private Integer viewCounts;

    private Integer weight;

    //创建时间 数据库是long类型
    private String createDate;

    private String author;

//    private ArticleBodyVo body;
//    private List<TagVo> tags;
//    private CategoryVo category;

}