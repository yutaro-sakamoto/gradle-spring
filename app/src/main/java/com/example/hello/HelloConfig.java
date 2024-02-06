package com.example.hello;

import org.springframework.batch.core.*;
import org.springframework.batch.core.job.builder.*;
import org.springframework.batch.core.configuration.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.batch.core.repository.*;
import org.springframework.transaction.*;
import org.springframework.batch.core.step.builder.*;

@Configuration
@EnableBatchProcessing
public class HelloConfig {

  @Bean
  public Job helloJob(JobRepository jobRepository, Step step) {
    return new JobBuilder("helloJob", jobRepository)
        .start(step)
        .build();
  }

  @Bean
  protected Step helloStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
    return new StepBuilder("helloStep", jobRepository)
        .tasklet(new MessageTasklet(), transactionManager)
        .build();
  }
}