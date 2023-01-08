package com.S5_DA_02.GestaoUtilizadores.Common;

import java.util.List;

public interface IService<D extends IDTO> {
    <E extends IDTO> E saveEntity(D dto);
}
