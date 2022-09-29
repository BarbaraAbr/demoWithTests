package com.example.demowithtests.util.config;

import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.dto.EmployeeSaveDto;
import dev.akkinoc.spring.boot.orika.OrikaMapperFactoryConfigurer;
import ma.glasnost.orika.MapperFactory;

public class MappingConfig implements OrikaMapperFactoryConfigurer {
    @Override
    public void configure(MapperFactory mapperFactory) {

        mapperFactory.classMap(Employee.class, EmployeeSaveDto.class)
                .customize(new EmployeeMapper())
                .byDefault()
                .register();

        mapperFactory.classMap(Employee.class, EmployeeSaveDto.class)
                .byDefault()
                .register();
    }
}
