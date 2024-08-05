package org.daffy3.board.dto;

import org.daffy3.board.domain.ArticleComment;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link org.daffy3.board.domain.ArticleComment}
 */
public record ArticleCommentDto(LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy, String content) {
    public static ArticleCommentDto of(LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy, String content) {
        return new ArticleCommentDto(createdAt, createdBy, modifiedAt, modifiedBy, content);
    }
}