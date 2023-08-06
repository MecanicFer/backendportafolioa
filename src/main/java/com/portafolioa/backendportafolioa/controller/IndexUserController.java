package com.portafolioa.backendportafolioa.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.portafolioa.backendportafolioa.constant.ViewConstant;

@Controller
public class IndexUserController {
	
	private static final Log LOG = LogFactory.getLog(IndexController.class);
	
	@GetMapping("/indexUser")
	public String indexUser() {
			LOG.info("returning login view");
			return ViewConstant.INDEXUSER;
	}
	
	@GetMapping("/indexUserEnglish")
	public String indexUserEnglish() {
			LOG.info("returning login view");
			return ViewConstant.INDEXUSER_ENGLISH;
	}
	
	@GetMapping("/PrincipalPageUser")
	public String PrincipalPageUser() {
		LOG.info("returning login view");
		return ViewConstant.PRINCIPALPAGEUSER;
	}
	
	@GetMapping("/PrincipalPageUserEnglish")
	public String PrincipalPageUserEnglish() {
		LOG.info("returning login view");
		return ViewConstant.PRINCIPALPAGEUSER_ENGLISH;
	}
	
	@GetMapping("/ProyectosUser")
	public String ProyectosUser() {
		LOG.info("returning login view");
		return ViewConstant.PROYECTOS_USER;
	}
	
	@GetMapping("/ProyectosUserEnglish")
	public String ProyectosUserEnglish() {
		LOG.info("returning login view");
		return ViewConstant.PROYECTOS_USER_ENGLISH;
	}
	
	@GetMapping("/BlogUser")
	public String BlogUser() {
		LOG.info("returning login view");
		return ViewConstant.BLOG;
	}
	
	@GetMapping("/SMSuserEspañol")
	public String SMSuserEspañol() {
		LOG.info("returning login view");
		return ViewConstant.SMS_USER_ESPAÑOL;
	}
	
	@GetMapping("/SMSuserEnglish")
	public String SMSuserEnglish() {
		LOG.info("returning login view");
		return ViewConstant.SMS_USER_ENGLISH;
	}
	
	@GetMapping("/GeneradorQRuser")
	public String GeneradorQRuser() {
		LOG.info("returning login view");
		return ViewConstant.GENERADORQR_USER;
	}
	
	@GetMapping("/GeneradorQRenglishUser")
	public String GeneradorQRenglishUser() {
		LOG.info("returning login view");
		return ViewConstant.GENERADORQR_ENGLISH_USER;
	}
	
	@GetMapping("/DoctoPDFConverterUser")
	public String DoctoPDFConverterUser() {
		LOG.info("returning login view");
		return ViewConstant.DOCTOPDFCONVERTER_USER;
	}
	
	@GetMapping("/DoctoPDFConverterEnglishUser")
	public String DoctoPDFConverterEnglishUser() {
		LOG.info("returning login view");
		return ViewConstant.DOCTOPDFCONVERTER_ENGLISH_USER;
	}
	
	@GetMapping("/PDFmergerUser")
	public String PDFmergerUser() {
		LOG.info("returning login view");
		return ViewConstant.PDFMERGER_USER;
	}
	
	@GetMapping("/PDFmergerEnglishUser")
	public String PDFmergerEnglishUser() {
		LOG.info("returning login view");
		return ViewConstant.PDFMERGER_ENGLISH_USER;
	}

}
