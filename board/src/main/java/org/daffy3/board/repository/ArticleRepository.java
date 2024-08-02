package org.daffy3.board.repository;

import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.daffy3.board.domain.Article;
import org.daffy3.board.domain.QArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ArticleRepository extends JpaRepository<Article, Long>,
        QuerydslPredicateExecutor<Article>,
        QuerydslBinderCustomizer<QArticle> {
    // 기본 검색은 QuerydslPredicateExecutor<Article>, QuerydslBinderCustomizer<QArticle>를 추가해줌으로써 해결이 된다.
    @Override
    default void customize(QuerydslBindings querydslBindings, QArticle qArticle) {
        // 선택적인 검색이 가능하도록 함
        querydslBindings.excludeUnlistedProperties(true);
        querydslBindings.including(qArticle.title, qArticle.hashtag, qArticle.content, qArticle.createdAt, qArticle.createdBy); // 원하는 필드 추가

        // querydslBindings.bind(qArticle.title).first(StringExpression::likeIgnoreCase); // 쿼리 생성문 ---> like '${v}'
        querydslBindings.bind(qArticle.title).first(StringExpression::containsIgnoreCase); // 쿼리 생성문 ---> like '%${v}%'
        querydslBindings.bind(qArticle.content).first(StringExpression::containsIgnoreCase); // 쿼리 생성문 ---> like '%${v}%'
        querydslBindings.bind(qArticle.hashtag).first(StringExpression::containsIgnoreCase); // 쿼리 생성문 ---> like '%${v}%'
        querydslBindings.bind(qArticle.createdAt).first(DateTimeExpression::eq); // 쿼리 생성문 ---> like '%${v}%'
        querydslBindings.bind(qArticle.createdBy).first(StringExpression::containsIgnoreCase); // 쿼리 생성문 ---> like '%${v}%'

    }
}
