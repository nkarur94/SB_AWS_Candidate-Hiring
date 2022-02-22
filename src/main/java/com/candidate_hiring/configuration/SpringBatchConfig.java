package com.candidate_hiring.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.candidate_hiring.entity.CandidateHiringDetailsEntity;


@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {


	@Bean
	public Job job(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
			ItemReader<CandidateHiringDetailsEntity> itemReader, ItemProcessor<CandidateHiringDetailsEntity, CandidateHiringDetailsEntity> itemProcessor,
			ItemWriter<CandidateHiringDetailsEntity> itemWriter) {

		Step step = stepBuilderFactory.get("ETL-file-load").<CandidateHiringDetailsEntity, CandidateHiringDetailsEntity>chunk(100).reader(itemReader)
				.processor(itemProcessor).writer(itemWriter).build();

		return jobBuilderFactory.get("ETL-Load").incrementer(new RunIdIncrementer()).start(step).build();

	}
	

	@Bean
	public FlatFileItemReader<CandidateHiringDetailsEntity> reader() {
		FlatFileItemReader<CandidateHiringDetailsEntity> reader = new FlatFileItemReader<>();

		reader.setResource(new ClassPathResource("candidate_details.csv"));

		reader.setLinesToSkip(1);
		reader.setLineMapper(getLinerMapper());

		

		return reader;

	}

	@Bean
	public LineMapper<CandidateHiringDetailsEntity> getLinerMapper() {

		DefaultLineMapper<CandidateHiringDetailsEntity> defaultLineMapper = new DefaultLineMapper<>();

		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);

		lineTokenizer.setNames(new String[] {"CHId","firstName","middleName","lastName","eMail","mobileNo","hiredCity","hiredDate","degree","hireLab","attitudeRemark","communicationRemark","knowledgeRemark","onboardStatus","status","creatorUser","joindate","location","aggrPer","currentPinCode","permanentPinCode" });

		BeanWrapperFieldSetMapper<CandidateHiringDetailsEntity> fieldSetMapper = new BeanWrapperFieldSetMapper<CandidateHiringDetailsEntity>();
		fieldSetMapper.setTargetType(CandidateHiringDetailsEntity.class);

		defaultLineMapper.setLineTokenizer(lineTokenizer);

		defaultLineMapper.setFieldSetMapper(fieldSetMapper);

		return defaultLineMapper;
	}

	
}
