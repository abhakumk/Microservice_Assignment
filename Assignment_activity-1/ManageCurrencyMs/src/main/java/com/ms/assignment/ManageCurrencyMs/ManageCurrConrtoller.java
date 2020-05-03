package com.ms.assignment.ManageCurrencyMs;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.assignment.ManageCurrencyMs.model.Currency;

/**
 * @author w2cluster03
 *
 */
@RestController
@RequestMapping("/ms1")
public class ManageCurrConrtoller {
		
	private static Logger log = LoggerFactory.getLogger(ManageCurrConrtoller.class);
	
		@Autowired
		ManageCurrService manageCurrService;
		
		/**
		 * @param currFactor
		 * @return
		 */
		@PostMapping(path = "/curr")
		public ResponseEntity<String> addConversionFactor(@RequestBody Currency currFactor) {
			log.info(currFactor.toString());
			try {
				String status =  manageCurrService.addConversionFactor(currFactor);
				return new ResponseEntity<String>(status, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<String>("Failed! - "+e.getMessage(), HttpStatus.EXPECTATION_FAILED);
			}
		}
		
		/**
		 * @param currFactor
		 * @return
		 */
		@PatchMapping(path = "/curr")
		public ResponseEntity<String> updateConversionFactor(@RequestBody Currency currFactor) {
			log.info(currFactor.toString());
			try {
				String status =  manageCurrService.updateConversionFactor(currFactor);
				return new ResponseEntity<String>(status, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<String>("Failed! - "+e.getMessage(), HttpStatus.EXPECTATION_FAILED);
			}
		}
		
		/**
		 * @param countryCode
		 * @return
		 */
		@GetMapping(path = "/curr/{countryCode}")
		public ResponseEntity<Currency> getConversionFactor(@PathVariable String countryCode) {
			try {
				Currency curr =  manageCurrService.getConversionFactor(countryCode);
				if(curr != null) {
					return new ResponseEntity<Currency>(curr, HttpStatus.OK);
				} 
					
			} catch (Exception e) {
				//TO-DO:log it 
			}
			return new ResponseEntity<Currency>(HttpStatus.NOT_FOUND);
		}
		
		/**
		 * @return
		 */
		@GetMapping(path = "/currFactor")
		public List<Currency> getAllCurrFactors() {
			return manageCurrService.getCurrFactors();
		}
}

		
