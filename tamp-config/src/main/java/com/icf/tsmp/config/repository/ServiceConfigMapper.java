package com.icf.tsmp.config.repository;

import com.icf.tsmp.config.model.ServiceConfigDo;

import java.util.List;

public interface ServiceConfigMapper {
    ServiceConfigDo queryByJYDM(String jydm);

    List<ServiceConfigDo> getAllServiceConfig();
}
