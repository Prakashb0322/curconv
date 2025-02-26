package com.prakash.cuconv.service;

import com.prakash.cuconv.model.Conversion;
import com.prakash.cuconv.repository.ConversionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CurrencyConverterService {

    private static final String API_URL = "https://v6.exchangerate-api.com/v6/04e9c6bd5d091c433a5b2b92/latest/";

    @Autowired
    private ConversionRepository conversionRepository;

    public double convert(double amount, String from, String to) {
        String url = API_URL + from;
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        JSONObject jsonObject = new JSONObject(response);
        JSONObject rates = jsonObject.getJSONObject("conversion_rates");

        if (rates.has(to)) {
            double exchangeRate = rates.getDouble(to);
            double convertedAmount = amount * exchangeRate;

            // Save conversion data to MySQL
            Conversion conversion = new Conversion();
            conversion.setAmount(amount);
            conversion.setFromCurrency(from);
            conversion.setToCurrency(to);
            conversion.setConvertedAmount(convertedAmount);
            conversionRepository.save(conversion);

            return convertedAmount;
        } else {
            return 0.0; // Invalid currency case
        }
    }
}























//package com.prakash.cuconv.service;
//
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//import org.json.JSONObject;
//
//@Service
//public class CurrencyConverterService {
//
//    private static final String API_URL = "https://v6.exchangerate-api.com/v6/04e9c6bd5d091c433a5b2b92/latest/USD";
//
//    public double convert(double amount, String from, String to) {
//        String url = API_URL + from;
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject(url, String.class);
//
//        JSONObject jsonObject = new JSONObject(response);
//        JSONObject rates = jsonObject.getJSONObject("conversion_rates");
//
//        if (rates.has(to)) {
//            double exchangeRate = rates.getDouble(to);
//            return amount * exchangeRate;
//        } else {
//            return 0.0;  // Invalid currency case
//        }
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
////package com.prakash.cuconv.service;
////
////import org.springframework.stereotype.Service;
////
////import java.util.HashMap;
////import java.util.Map;
////
////@Service
////public class CurrencyConverterService {
////
////    private final Map<String, Double> exchangeRates;
////
////    public CurrencyConverterService() {
////        exchangeRates = new HashMap<>();
////        exchangeRates.put("USD-INR", 86.67);
////        exchangeRates.put("INR-USD", 1 / 86.67);
////        exchangeRates.put("USD-EUR", 0.91);
////        exchangeRates.put("EUR-USD", 1.1);
////        exchangeRates.put("GBP-USD", 1.27);
////        exchangeRates.put("USD-GBP", 0.79);
////        // Add more currency rates as needed
////    }
////
////    public double convert(double amount, String from, String to) {
////        String key = from + "-" + to;
////        return exchangeRates.getOrDefault(key, 0.0) * amount;
////    }
////}
