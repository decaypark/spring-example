package com.mig.repository.tobe;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@Mapper
public interface TobeBaseAdmMapper {

    Map<String, Object> selectDate(Map<String, Object> params);
}
