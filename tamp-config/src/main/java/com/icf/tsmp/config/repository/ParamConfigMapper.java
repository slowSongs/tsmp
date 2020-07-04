package com.icf.tsmp.config.repository;

import com.icf.tsmp.config.model.ParamConfigDo;

import java.util.List;

public interface ParamConfigMapper {
    List<ParamConfigDo> queryByJYDM(String JYDM);

}
