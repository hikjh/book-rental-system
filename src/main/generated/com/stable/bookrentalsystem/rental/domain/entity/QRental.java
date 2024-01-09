package com.stable.bookrentalsystem.rental.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRental is a Querydsl query type for Rental
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRental extends EntityPathBase<Rental> {

    private static final long serialVersionUID = 1700488003L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRental rental = new QRental("rental");

    public final com.stable.bookrentalsystem.common.QBaseTimeEntity _super = new com.stable.bookrentalsystem.common.QBaseTimeEntity(this);

    public final com.stable.bookrentalsystem.book.domain.entity.QBook book;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isOverdue = createBoolean("isOverdue");

    public final BooleanPath isReturned = createBoolean("isReturned");

    public final com.stable.bookrentalsystem.member.domain.entity.QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final EnumPath<com.stable.bookrentalsystem.rental.domain.valueobject.RentalStatus> rentalStatus = createEnum("rentalStatus", com.stable.bookrentalsystem.rental.domain.valueobject.RentalStatus.class);

    public final DateTimePath<java.time.LocalDateTime> rentedAt = createDateTime("rentedAt", java.time.LocalDateTime.class);

    public QRental(String variable) {
        this(Rental.class, forVariable(variable), INITS);
    }

    public QRental(Path<? extends Rental> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRental(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRental(PathMetadata metadata, PathInits inits) {
        this(Rental.class, metadata, inits);
    }

    public QRental(Class<? extends Rental> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.book = inits.isInitialized("book") ? new com.stable.bookrentalsystem.book.domain.entity.QBook(forProperty("book")) : null;
        this.member = inits.isInitialized("member") ? new com.stable.bookrentalsystem.member.domain.entity.QMember(forProperty("member")) : null;
    }

}

