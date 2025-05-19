package com.example.umc.umc_8th.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFoodPreference is a Querydsl query type for FoodPreference
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFoodPreference extends EntityPathBase<FoodPreference> {

    private static final long serialVersionUID = -238068807L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFoodPreference foodPreference = new QFoodPreference("foodPreference");

    public final com.example.umc.umc_8th.domain.common.QBaseEntity _super = new com.example.umc.umc_8th.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final com.example.umc.umc_8th.domain.QFoodCategory foodCategory;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final com.example.umc.umc_8th.domain.QUser user;

    public QFoodPreference(String variable) {
        this(FoodPreference.class, forVariable(variable), INITS);
    }

    public QFoodPreference(Path<? extends FoodPreference> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFoodPreference(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFoodPreference(PathMetadata metadata, PathInits inits) {
        this(FoodPreference.class, metadata, inits);
    }

    public QFoodPreference(Class<? extends FoodPreference> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.foodCategory = inits.isInitialized("foodCategory") ? new com.example.umc.umc_8th.domain.QFoodCategory(forProperty("foodCategory")) : null;
        this.user = inits.isInitialized("user") ? new com.example.umc.umc_8th.domain.QUser(forProperty("user")) : null;
    }

}

