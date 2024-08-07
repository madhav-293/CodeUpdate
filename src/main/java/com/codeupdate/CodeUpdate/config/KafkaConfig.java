package com.codeupdate.CodeUpdate.config;

import com.codeupdate.CodeUpdate.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
@EnableKafka
@Configuration
public class KafkaConfig {


    @Autowired
    CodeService codeService;

    @KafkaListener(topics = AppConstant.DETAIL_TOPIC_NAME,groupId = AppConstant.GROUP_ID_DETAIL)
    public void updateActive(com.codepost.CodePost.dto.CodeEntityDTO codeEntityDTO){
        codeService.updateByCodeVersion(codeEntityDTO.getCName(),codeEntityDTO.getVersion());
    }

}
