package com.prakash.cuconv.controller;

import com.prakash.cuconv.service.CurrencyConverterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConverterController {

    private final CurrencyConverterService currencyService;

    public CurrencyConverterController(CurrencyConverterService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/")
    public String showForm() {
        return "index";  // Loads index.html
    }

    @PostMapping("/convert")
    public String convertCurrency(@RequestParam double amount,
                                  @RequestParam String fromCurrency,
                                  @RequestParam String toCurrency,
                                  Model model) {
        double result = currencyService.convert(amount, fromCurrency, toCurrency);
        model.addAttribute("result", result);
        model.addAttribute("amount", amount);
        model.addAttribute("fromCurrency", fromCurrency);
        model.addAttribute("toCurrency", toCurrency);
        return "index";  // Reloads index.html with result
    }
}
