package org.daffy3.board.repository;

import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.daffy3.board.domain.ArticleComment;
import org.daffy3.board.domain.QArticle;
import org.daffy3.board.domain.QArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ArticleCommentRepository extends
        JpaRepository<ArticleComment, Long>,
        QuerydslPredicateExecutor<ArticleComment>,
        QuerydslBinderCustomizer<QArticleComment> {
    // 기본 검색은 QuerydslPredicateExecutor<Article>, QuerydslBinderCustomizer<QArticle>를 추가해줌으로써 해결이 된다.
    @Override
    default void customize(QuerydslBindings querydslBindings, QArticleComment qArticleComment) {
        // 선택적인 검색이 가능하도록 함
        querydslBindings.excludeUnlistedProperties(true);
        querydslBindings.including(qArticleComment.content, qArticleComment.createdAt, qArticleComment.createdBy); // 원하는 필드 추가

        querydslBindings.bind(qArticleComment.content).first(StringExpression::containsIgnoreCase); // 쿼리 생성문 ---> like '%${v}%'
        querydslBindings.bind(qArticleComment.createdAt).first(DateTimeExpression::eq); // 쿼리 생성문 ---> like '%${v}%'
        querydslBindings.bind(qArticleComment.createdBy).first(StringExpression::containsIgnoreCase); // 쿼리 생성문 ---> like '%${v}%'

    }
}
