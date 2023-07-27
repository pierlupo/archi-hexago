package org.example.config;

import com.infrastructure.repository.Impl.ReportRepoImpl;
import com.infrastructure.repository.Impl.RoleRepoImpl;
import com.infrastructure.repository.Impl.UserRepoImpl;
import org.example.service.ReportServiceImpl;
import org.example.service.UserServiceImpl;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class ApiRestInitializer implements ApplicationContextInitializer {

    private final ConfigurableApplicationContext infraContext;

    public ApiRestInitializer(ConfigurableApplicationContext infraContext) {
        this.infraContext = infraContext;

    }

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableListableBeanFactory registry = applicationContext.getBeanFactory();
        registry.registerSingleton("ReportService", new ReportServiceImpl(infraContext.getBean(ReportRepoImpl.class)));
        registry.registerSingleton("UserService", new UserServiceImpl(infraContext.getBean(UserRepoImpl.class)));
        registry.registerSingleton("UserRepo", infraContext.getBean(UserRepoImpl.class));
        registry.registerSingleton("RoleRepo", infraContext.getBean(RoleRepoImpl.class));

    }
}
