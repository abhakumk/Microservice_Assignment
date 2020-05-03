package com.ms.assignment.ManageCurrencyMs.model;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author w2cluster03
 *
 */
public interface CurrencyRepo  extends JpaRepository<Currency, String> {

}
