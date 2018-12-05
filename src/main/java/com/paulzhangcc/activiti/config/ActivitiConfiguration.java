package com.paulzhangcc.activiti.config;

import org.activiti.engine.*;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @author paul
 * @description
 * @date 2018/12/5
 */
@Configuration
public class ActivitiConfiguration {
    @Bean
    public SpringProcessEngineConfiguration processEngineConfiguration(DataSource dataSource, PlatformTransactionManager transactionManager){
        SpringProcessEngineConfiguration springProcessEngineConfiguration = new SpringProcessEngineConfiguration();
        springProcessEngineConfiguration.setDataSource(dataSource);
        springProcessEngineConfiguration.setTransactionManager(transactionManager);
        springProcessEngineConfiguration.setDatabaseSchemaUpdate("true");
        springProcessEngineConfiguration.setJobExecutorActivate(false);
        return springProcessEngineConfiguration;
    }

    @Bean
    public ProcessEngineFactoryBean processEngine(SpringProcessEngineConfiguration processEngineConfiguration){
        ProcessEngineFactoryBean processEngineFactoryBean = new ProcessEngineFactoryBean();
        processEngineFactoryBean.setProcessEngineConfiguration(processEngineConfiguration);
        return processEngineFactoryBean;
    }

    @Bean
    public RepositoryService repositoryService(ProcessEngine processEngine){
        RepositoryService repositoryService = processEngine.getRepositoryService();
        return repositoryService;
    }

    @Bean
    public RuntimeService runtimeService(ProcessEngine processEngine){
        RuntimeService runtimeService = processEngine.getRuntimeService();
        return runtimeService;
    }

    @Bean
    public TaskService taskService(ProcessEngine processEngine){
        TaskService taskService = processEngine.getTaskService();
        return taskService;
    }
    @Bean
    public HistoryService historyService(ProcessEngine processEngine){
        HistoryService historyService = processEngine.getHistoryService();
        return historyService;
    }

    @Bean
    public ManagementService managementService(ProcessEngine processEngine){
        ManagementService managementService = processEngine.getManagementService();
        return managementService;
    }

}
