package org.daffy3.board.service;

import lombok.RequiredArgsConstructor;
import org.daffy3.board.dto.ArticleCommentDto;
import org.daffy3.board.repository.ArticleCommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ArticleCommentService {

    private final ArticleCommentRepository articleCommentRepository;

    @Transactional(readOnly = true)
    public List<ArticleCommentDto> searchArticleComment(long articleId) {
        return List.of();
    }
}
