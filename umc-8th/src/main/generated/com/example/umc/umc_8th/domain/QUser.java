package com.example.umc.umc_8th.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -261519733L;

    public static final QUser user = new QUser("user");

    public final com.example.umc.umc_8th.domain.common.QBaseEntity _super = new com.example.umc.umc_8th.domain.common.QBaseEntity(this);

    public final ListPath<com.example.umc.umc_8th.domain.mapping.AcceptedMission, com.example.umc.umc_8th.domain.mapping.QAcceptedMission> acceptedMissionList = this.<com.example.umc.umc_8th.domain.mapping.AcceptedMission, com.example.umc.umc_8th.domain.mapping.QAcceptedMission>createList("acceptedMissionList", com.example.umc.umc_8th.domain.mapping.AcceptedMission.class, com.example.umc.umc_8th.domain.mapping.QAcceptedMission.class, PathInits.DIRECT2);

    public final StringPath address = createString("address");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final ListPath<com.example.umc.umc_8th.domain.mapping.FoodPreference, com.example.umc.umc_8th.domain.mapping.QFoodPreference> foodPreferList = this.<com.example.umc.umc_8th.domain.mapping.FoodPreference, com.example.umc.umc_8th.domain.mapping.QFoodPreference>createList("foodPreferList", com.example.umc.umc_8th.domain.mapping.FoodPreference.class, com.example.umc.umc_8th.domain.mapping.QFoodPreference.class, PathInits.DIRECT2);

    public final EnumPath<Gender> gender = createEnum("gender", Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DatePath<java.time.LocalDate> inactiveDate = createDate("inactiveDate", java.time.LocalDate.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final ListPath<Review, QReview> reviewList = this.<Review, QReview>createList("reviewList", Review.class, QReview.class, PathInits.DIRECT2);

    public final StringPath specAddress = createString("specAddress");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final ListPath<com.example.umc.umc_8th.domain.mapping.UserAgree, com.example.umc.umc_8th.domain.mapping.QUserAgree> userAgreeList = this.<com.example.umc.umc_8th.domain.mapping.UserAgree, com.example.umc.umc_8th.domain.mapping.QUserAgree>createList("userAgreeList", com.example.umc.umc_8th.domain.mapping.UserAgree.class, com.example.umc.umc_8th.domain.mapping.QUserAgree.class, PathInits.DIRECT2);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

