package org.daffy3.board.service;

import lombok.RequiredArgsConstructor;
import org.daffy3.board.domain.type.SearchType;
import org.daffy3.board.dto.ArticleDto;
import org.daffy3.board.dto.ArticleUpdateDto;
import org.daffy3.board.repository.ArticleRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional(readOnly = true)
    public Page<ArticleDto> searchArticles(SearchType searchType, String searchKeyword) {
        return Page.empty();
    }

    public ArticleDto searchArticle(long l) {
        return null;
    }

    public void saveArticle(ArticleDto dto) {

    }

    public void updataArticle(long articledId, ArticleUpdateDto dto) {
    }

    public void deleteArticle(long articleId) {
    }
}
