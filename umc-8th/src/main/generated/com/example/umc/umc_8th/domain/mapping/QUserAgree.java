package com.example.umc.umc_8th.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserAgree is a Querydsl query type for UserAgree
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserAgree extends EntityPathBase<UserAgree> {

    private static final long serialVersionUID = -1026212415L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserAgree userAgree = new QUserAgree("userAgree");

    public final com.example.umc.umc_8th.domain.common.QBaseEntity _super = new com.example.umc.umc_8th.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.example.umc.umc_8th.domain.QTerms terms;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final com.example.umc.umc_8th.domain.QUser user;

    public QUserAgree(String variable) {
        this(UserAgree.class, forVariable(variable), INITS);
    }

    public QUserAgree(Path<? extends UserAgree> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserAgree(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserAgree(PathMetadata metadata, PathInits inits) {
        this(UserAgree.class, metadata, inits);
    }

    public QUserAgree(Class<? extends UserAgree> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.terms = inits.isInitialized("terms") ? new com.example.umc.umc_8th.domain.QTerms(forProperty("terms")) : null;
        this.user = inits.isInitialized("user") ? new com.example.umc.umc_8th.domain.QUser(forProperty("user")) : null;
    }

}

