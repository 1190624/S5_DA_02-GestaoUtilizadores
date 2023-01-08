package com.S5_DA_02.GestaoUtilizadores.Common;

public interface IMapper<E, D extends IDTO> {
    D toDTO(E entity);
    E toEntity(D dto);
}
