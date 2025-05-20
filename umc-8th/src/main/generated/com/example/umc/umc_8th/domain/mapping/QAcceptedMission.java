package com.example.umc.umc_8th.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAcceptedMission is a Querydsl query type for AcceptedMission
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAcceptedMission extends EntityPathBase<AcceptedMission> {

    private static final long serialVersionUID = 2067286021L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAcceptedMission acceptedMission = new QAcceptedMission("acceptedMission");

    public final com.example.umc.umc_8th.domain.common.QBaseEntity _super = new com.example.umc.umc_8th.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.example.umc.umc_8th.domain.QMission mission;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final com.example.umc.umc_8th.domain.QUser user;

    public QAcceptedMission(String variable) {
        this(AcceptedMission.class, forVariable(variable), INITS);
    }

    public QAcceptedMission(Path<? extends AcceptedMission> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAcceptedMission(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAcceptedMission(PathMetadata metadata, PathInits inits) {
        this(AcceptedMission.class, metadata, inits);
    }

    public QAcceptedMission(Class<? extends AcceptedMission> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.mission = inits.isInitialized("mission") ? new com.example.umc.umc_8th.domain.QMission(forProperty("mission"), inits.get("mission")) : null;
        this.user = inits.isInitialized("user") ? new com.example.umc.umc_8th.domain.QUser(forProperty("user")) : null;
    }

}

