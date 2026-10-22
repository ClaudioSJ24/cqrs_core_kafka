package com.sanchez.cqrs.core.infrastructure.interfaces;

import com.sanchez.cqrs.core.querys.BaseQuery;
import com.sanchez.cqrs.core.querys.interfaces.QueryHandlerMethod;

import java.util.List;

public interface QueryDispatcher {

    <T extends BaseQuery> void registerHandler(Class<T> type, QueryHandlerMethod<T> handler);
    <U>List<U> send(BaseQuery baseQuery);
}
