package com.spry.inventory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InventoryController {
	
    @GetMapping(value = "/hello")
    public String greeting( Model model) {
    	model.addAttribute("car", "camry");
    	model.addAttribute("car1", "camry");
        return "inventory";
    }


}
