package spring.learn.batchtask;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

public class Main {
    public static void main(String[] args) throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {


        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");


        //获取任务启动器
        JobLauncher launcher = context.getBean(JobLauncher.class);
        JobRepository jobRepository = context.getBean(JobRepository.class);
        PlatformTransactionManager transactionManager = context.getBean(PlatformTransactionManager.class);


        //创建reader

        FlatFileItemReader<DeviceCommand> flatFileItemReader = new FlatFileItemReader<>();
        flatFileItemReader.setResource(new FileSystemResource("src/main/resources/batch-data.csv"));
        flatFileItemReader.setLineMapper(new HelloLineMapper());

        //创建processor
        HelloItemProcessor helloItemProcessor = new HelloItemProcessor();

        // 创建writer
        FlatFileItemWriter<DeviceCommand> flatFileItemWriter = new FlatFileItemWriter<>();
        flatFileItemWriter.setResource(new FileSystemResource("src/main/resources/batch-data.csv"));
        flatFileItemWriter.setLineAggregator(new HelloLineAggregator());


        // 创建Step
        StepBuilderFactory stepBuilderFactory = new StepBuilderFactory(jobRepository, transactionManager);
        Step step = stepBuilderFactory.get("step")
                .<DeviceCommand, DeviceCommand>chunk(1)
                .reader(flatFileItemReader)       // 读操作
                .processor(helloItemProcessor)    // 处理操作
                .writer(flatFileItemWriter)       // 写操作
                .build();


        // 创建Job
        JobBuilderFactory jobBuilderFactory = new JobBuilderFactory(jobRepository);
        Job job = jobBuilderFactory.get("job")
                .start(step)
                .build();

        // 启动任务
        launcher.run(job, new JobParameters());

    }
}
