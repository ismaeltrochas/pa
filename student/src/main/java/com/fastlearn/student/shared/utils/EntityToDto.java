package com.fastlearn.student.shared.utils;

import java.util.List;

public interface EntityToDto <E,O>{

    E toEntity(O entity);
    O toDto(E entity);

    List<O> toDto(List<E> entities);
    List<E> toEntity(List<O> entities);

}