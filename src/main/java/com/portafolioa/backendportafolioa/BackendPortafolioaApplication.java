package com.portafolioa.backendportafolioa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


	// TODO: Auto-generated Javadoc
/**
	 * The Class BackendPortafolioaApplication.
	 */
	@SpringBootApplication
	@EnableScheduling
	public class BackendPortafolioaApplication {

		/**
		 * The main method.
		 *
		 * @param args the arguments
		 */
		public static void main(String[] args) {
			SpringApplication.run(BackendPortafolioaApplication.class, args);
		}

	}
