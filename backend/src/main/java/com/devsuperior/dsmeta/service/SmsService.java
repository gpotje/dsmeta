package com.devsuperior.dsmeta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repository.SaleRepository;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class SmsService {
	
	@Value("${twilio.sid}")
	private String twilioSid;

	@Value("${twilio.key}")
	private String twilioKey;

	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;

	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;
	
	@Autowired
	private SaleRepository repository;

	public String sendSms(Long id) {
		
		Sale sale = repository.findById(id).get();
		
		
		String date = sale.getDate().getMonthValue() + "/" +  sale.getDate().getYear();
		
		String msg = "O vendedor " + sale.getSellerName() + "foi destaque em " + date + " com um total de R$" + String.format("%.2f", sale.getAmount());
//
//		Twilio.init(twilioSid, twilioKey);
//
//		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
//		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);
//
//		Message message = Message.creator(to, from, msg).create();
//
//		System.out.println(message.getSid());
		
		
		log.info(msg);
		
		return "SMS --- enviado com sucesso  "+ msg;
	}

}
