package com.cs.myapps.lenaDenaRozana.controllers;

import com.cs.myapps.lenaDenaRozana.logging.LenaDenaLogger;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cs.myapps.lenaDenaRozana.beans.*;
import com.cs.myapps.lenaDenaRozana.dao.*;
import com.cs.myapps.lenaDenaRozana.util.Constants;

@Controller

public class PartnerController {

	private PartnerDao dao = new PartnerDao();
	
	@RequestMapping(value="/partner", method=RequestMethod.GET)
	public ModelAndView registerPartner(Map<String, Object> model)
	{
		LenaDenaLogger.getLogger().info("partnerForm in :"+this.getClass());
		Partner partner = new Partner();
		model.put("partnerForm", partner);
		return new ModelAndView("partner","command",partner);
		//DbServiceConfig.getOwnerDbConnector();
	}
	
	@RequestMapping(value="/partner",method = RequestMethod.POST)  
	public String savePartner(@Valid @ModelAttribute("partnerForm") Partner partner,BindingResult bindingResult
			,HttpServletRequest request)
	{
		if (bindingResult.hasErrors()) {
			System.out.println("CH** Error found");
			
			//return new ModelAndView("registerOwner","command",owner);
			//return new ModelAndView("redirect:/registerOwner");
            return "partner";
        }
		String ownerId = (String) request.getSession().getAttribute(Constants.getOwnerId());
		System.out.println("CH** OwnerId:"+ownerId);
		dao.save(partner,ownerId);
		//return new ModelAndView("redirect:/login");
		return "loginSuccess";
	}
	

	
	
}
