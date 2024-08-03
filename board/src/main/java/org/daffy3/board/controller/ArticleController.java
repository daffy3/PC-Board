package org.daffy3.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/*
 * /articles
 * /articles/{article-id}
 * /articles/search
 * /articles/search-hashtag
 * */

@RequestMapping("/articles")
@Controller
public class ArticleController {

    @GetMapping
    public String articles(ModelMap map) {
        map.addAttribute("articles", List.of());
        return "articles/index";
    }

    @GetMapping("/{articleId}")
    public String article(@PathVariable int articleId, ModelMap map) {
        map.addAttribute("article", null); // TODO: 기능구현 시, 실제 데이터를 넣어주어야 한다.
        map.addAttribute("article", List.of());

        return "articles/detail";
    }
}
