package com.io.gift.mapper.config;

import java.util.List;

public interface DtoMapper<T, S>{

    T toDto(S entity);

    List<T> toDtoList(List<S> entityList);
}
