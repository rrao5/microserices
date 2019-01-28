package com.spry.pricing;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PricingResource {
	
	@GetMapping(value = "/price/{name}", produces = "application/json")
	public @ResponseBody float getPrice(@PathVariable String name)
	{
		switch (name) {
		case "camry":
			return  19000F;
		case "carolla":
			return  16000F;
		case "rav4":
			return 21000F;
		case "highlander":
			return  24000F;

		}
		return 0F;

	}

}
