package com.seavus.codetalks.springcloudweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seavus.codetalks.springcloudweb.model.QuoteResult;
import com.seavus.codetalks.springcloudweb.service.QuotesClientService;

@Controller
public class QuotesController {

	@Autowired
	private QuotesClientService quotesClientService;
	
    @RequestMapping("/")
    public String getRandomQuote(Model model) {
    	QuoteResult quoteResult = quotesClientService.getQuoteResult();
        model.addAttribute("quoteText", quoteResult.getQuote().getText());
        model.addAttribute("serverPort", quoteResult.getServerInfo().getPort());
        return "quote";
    }
    


}
