package com.example.umc.umc_8th.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTerms is a Querydsl query type for Terms
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTerms extends EntityPathBase<Terms> {

    private static final long serialVersionUID = 481494727L;

    public static final QTerms terms = new QTerms("terms");

    public final StringPath body = createString("body");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath optional = createBoolean("optional");

    public final StringPath title = createString("title");

    public final ListPath<com.example.umc.umc_8th.domain.mapping.UserAgree, com.example.umc.umc_8th.domain.mapping.QUserAgree> userAgreeList = this.<com.example.umc.umc_8th.domain.mapping.UserAgree, com.example.umc.umc_8th.domain.mapping.QUserAgree>createList("userAgreeList", com.example.umc.umc_8th.domain.mapping.UserAgree.class, com.example.umc.umc_8th.domain.mapping.QUserAgree.class, PathInits.DIRECT2);

    public QTerms(String variable) {
        super(Terms.class, forVariable(variable));
    }

    public QTerms(Path<? extends Terms> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTerms(PathMetadata metadata) {
        super(Terms.class, metadata);
    }

}

