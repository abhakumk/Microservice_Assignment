package com.ms.assignment.ConvertCurrencyMs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.assignment.ConvertCurrencyMs.service.ConvertCurrService;

/**
 * @author w2cluster03
 *
 */
@RestController
@RequestMapping("/ms2")
public class ConvertCurrController {
	
	@Autowired
	ConvertCurrService convertCurrService;
	
	/**
	 * Activity-2: Invoke the MS-1 microservice from MS-2 using Feign client
     *
	 * @param countryCode
	 * @param amount
	 * @return
	 */
	@GetMapping(path = "/conv/v1/{countryCode}/{amount}")
	public ResponseEntity<String> getConvertCurrencyv1(@PathVariable String countryCode, @PathVariable Double amount) {
		try {
			String convertedCurr =  convertCurrService.getConversionFactorFeign(countryCode, amount);
			if(convertedCurr != null) {
				return new ResponseEntity<String>(convertedCurr, HttpStatus.OK);
			} 
				
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.EXPECTATION_FAILED); 
		}
		return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
	}
	
	/**
	 * Activity-2: Update the Feign client for MS-1 to point to the Discovery Service and ensure MS-2 run successfully
     *
	 * @param countryCode
	 * @param amount
	 * @return
	 */
	@GetMapping(path = "/conv/v2/{countryCode}/{amount}")
	public ResponseEntity<String> getConvertCurrencyv2(@PathVariable String countryCode, @PathVariable Double amount) {
		try {
			String convertedCurr =  convertCurrService.getConversionFactorFeignEureka(countryCode, amount);
			if(convertedCurr != null) {
				return new ResponseEntity<String>(convertedCurr, HttpStatus.OK);
			} 
				
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.EXPECTATION_FAILED); 
		}
		return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
	}
	
	/**
	 * Activity-2: Invoke the MS-1 microservice from MS-2 without using Feign client
     *
	 * @param countryCode
	 * @param amount
	 * @return
	 */
	@GetMapping(path = "/conv/{countryCode}/{amount}")
	public ResponseEntity<String> getConvertCurrency(@PathVariable String countryCode, @PathVariable Double amount) {
		try {
			String convertedCurr =  convertCurrService.getConversionFactor(countryCode, amount);
			if(convertedCurr != null) {
				return new ResponseEntity<String>(convertedCurr, HttpStatus.OK);
			} 
				
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.EXPECTATION_FAILED); 
		}
		return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
	}

}
