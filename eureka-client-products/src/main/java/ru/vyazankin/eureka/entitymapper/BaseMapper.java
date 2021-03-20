package ru.vyazankin.eureka.entitymapper;

public interface BaseMapper<E, D> {
    E toEntity(D dto);
    D toDto(E entity);
}
