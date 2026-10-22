package com.sanchez.cqrs.core.querys.interfaces;

import com.sanchez.cqrs.core.domain.BaseEntity;
import com.sanchez.cqrs.core.querys.BaseQuery;

import java.util.List;

@FunctionalInterface
public interface QueryHandlerMethod<T extends BaseQuery> {

    List<BaseEntity> handle(T query);


}
