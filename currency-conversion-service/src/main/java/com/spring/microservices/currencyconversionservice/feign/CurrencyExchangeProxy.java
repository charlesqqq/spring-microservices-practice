package com.spring.microservices.currencyconversionservice.feign;

import com.spring.microservices.currencyconversionservice.bean.CurrencyConversionBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange-service", url = "http://localhost:8000")
//@FeignClient("currency-exchange-service")
@FeignClient("netflix-zuul-api-gateway-server")
@RibbonClient("currency-exchange-service")
public interface CurrencyExchangeProxy {
	
//	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	CurrencyConversionBean getCurrencyConversionBean(@PathVariable("from") String from, @PathVariable("to") String to);
}
