package com.fastlearn.notification.share.mapper;

import java.util.List;

public interface EntityToDto<E, O> {

    O toDTO(E entity);

    E toEntity(O toDto);

    List<E> toEntity(List<O> toDto);

    List<O> toDto(List<E> toDto);

}

