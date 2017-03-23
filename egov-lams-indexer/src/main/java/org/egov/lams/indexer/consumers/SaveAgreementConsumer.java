package org.egov.lams.indexer.consumers;

import java.io.IOException;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.egov.lams.indexer.adapter.AgreementAdaptor;
import org.egov.lams.indexer.contract.AgreementDetails;
import org.egov.lams.indexer.model.Agreement;
import org.egov.lams.indexer.repository.ElasticSearchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SaveAgreementConsumer {

	public static final Logger LOGGER = LoggerFactory.getLogger(SaveAgreementConsumer.class);

	@Autowired
	private ElasticSearchRepository elasticSearchRepository;

	@Autowired
	private AgreementAdaptor agreementAdapter;

	@KafkaListener(containerFactory = "kafkaListenerContainerFactory", topics = { "${kafka.topics.save.agreement}",
			"${kafka.topics.update.agreement}" })
	public void listen(ConsumerRecord<String, String> record) {
		LOGGER.info("key:" + record.key() + ":" + "value:" + record.value());

		if (record.topic().equals("${kafka.topics.save.agreement}")) {

			ObjectMapper objectMapper = new ObjectMapper();
			Agreement agreement = null;
			try {
				LOGGER.info("SaveAgreementConsumer agreement-save-db AgreementDao:" + elasticSearchRepository);
				agreement = objectMapper.readValue(record.value(), Agreement.class);
			} catch (IOException e) {
				LOGGER.info(e.getMessage(), e);
			}
			if (agreement != null) {
				AgreementDetails agreementDetails = agreementAdapter.indexOnCreate(agreement);
				elasticSearchRepository.saveAgreement(agreementDetails);
			}
		}

		else if (record.topic().equals("${kafka.topics.update.agreement}")) {

			ObjectMapper objectMapper = new ObjectMapper();
			Agreement agreement = null;
			try {
				LOGGER.info("SaveAgreementConsumer agreement-update-db AgreementDao:" + elasticSearchRepository);
				agreement = objectMapper.readValue(record.value(), Agreement.class);
			} catch (IOException e) {
				LOGGER.info(e.getMessage(), e);
			}
			AgreementDetails agreementDetails = agreementAdapter.indexOnCreate(agreement);
			elasticSearchRepository.updateAgreement(agreementDetails);
		}

	}
}