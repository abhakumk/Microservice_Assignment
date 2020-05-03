package com.ms.assignment.ManageCurrencyMs;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.assignment.ManageCurrencyMs.model.Currency;
import com.ms.assignment.ManageCurrencyMs.model.CurrencyRepo;

/**
 * @author w2cluster03
 *
 */
@Component
public class ManageCurrService {
	
		@Autowired
		private CurrencyRepo repo;
			
		/**
		 * @return
		 */
		public List<Currency> getCurrFactors() {
			return repo.findAll();
		}
		
		/**
		 * @param countryCode
		 * @param convFactor
		 * @return
		 */
		public String addConversionFactor(Currency currFactor) {
				Currency curr =  repo.save(new Currency(currFactor.getCountryCode(), currFactor.getConverFactor()));
				if(curr != null) {
					return "Successfuly Created.";
				}
				return "Failed!";
		}
		
		/**
		 * @param countryCode
		 * @param convFactor
		 * @return
		 */
		public String updateConversionFactor(Currency currFactor) {
			try {
				Optional<Currency> curr =  repo.findById(currFactor.getCountryCode());
				if(curr.isPresent()) {
					Currency currency = curr.get();
					currency.setConverFactor(currFactor.getConverFactor());
					currency = repo.saveAndFlush(currency);
					if(currency != null) {
						return "Successfuly Updated.";
					}
				} else {
					return "Failed! No Record Found.";
				}
			} catch (Exception e) {
				return "Failed! - "+e.getMessage();
			}
			return "Failed!";
		}
		
		/**
		 * @param countryCode
		 * @return
		 */
		public Currency getConversionFactor(String countryCode) {
				Optional<Currency> curr =  repo.findById(countryCode);
				if(curr.isPresent()) {
					return curr.get();
				} 
			return null;
		}
		
	}
