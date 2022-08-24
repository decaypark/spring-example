package com.mig.repository.asis;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@Mapper
public interface AsisBaseAdmMapper {

    Map<String, Object> selectDate(Map<String, Object> params);
}
