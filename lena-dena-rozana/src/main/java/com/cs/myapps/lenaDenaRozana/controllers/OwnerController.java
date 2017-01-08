package com.cs.myapps.lenaDenaRozana.controllers;

import com.cs.myapps.lenaDenaRozana.logging.LenaDenaLogger;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cs.myapps.lenaDenaRozana.beans.*;
import com.cs.myapps.lenaDenaRozana.beans.CouchAppProps;
import com.cs.myapps.lenaDenaRozana.dao.*;
import com.cs.myapps.lenaDenaRozana.util.Constants;

@Controller
public class OwnerController {
	
	//static Logger log = Logger.getLogger(OwnerController.class.getName());
	private OwnerDao dao = new OwnerDao();
	
	@RequestMapping("/test")
	public void test1()
	{
		LenaDenaLogger.getLogger().info("Test in :"+this.getClass());
		
		//log.info("Test");
		//Disable for AOP logging
		/*final ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
		            "/WEB-INF/spring-servlet.xml");

		//ApplicationContext appCtx = new AnnotationConfigApplicationContext(DbServiceConfig.class);
		System.out.println("CH** context"+context);
		ApplicationProperties dbProps = (ApplicationProperties) context.getBean(ApplicationProperties.class);
		dbProps.setDb_service_name("db_service_name");*/
		//CouchDbService.getOwnerDbConnector();
	}
	
	@RequestMapping(value="/owner", method=RequestMethod.GET)
	public ModelAndView registerOwner(Map<String, Object> model)
	{
		LenaDenaLogger.getLogger().info("registerOwner in :"+this.getClass());
		Owner owner = new Owner();
		model.put("ownerForm", owner);
		return new ModelAndView("owner","command",owner);
		//DbServiceConfig.getOwnerDbConnector();
	}
	
	@RequestMapping(value="/owner",method = RequestMethod.POST)  
	public String saveOwner(@Valid @ModelAttribute("ownerForm") Owner owner,BindingResult bindingResult
			,HttpServletRequest request)
	{
		if (bindingResult.hasErrors()) {
			System.out.println("CH** Error found");
			
			//return new ModelAndView("registerOwner","command",owner);
			//return new ModelAndView("redirect:/registerOwner");
            return "owner";
        }
		dao.save(owner);
		//return new ModelAndView("redirect:/login");
		return "redirect:/login";
	}
	
	/*@RequestMapping(value="/verifyOwner",method = RequestMethod.POST) 
	public ModelAndView verifyOwner(@ModelAttribute("login") Login login, HttpServletRequest request)
	{
		LenaDenaLogger.getLogger().warn("Verify login id:"+login.getId());
		LenaDenaLogger.getLogger().warn("Verify login password:"+login.getPassword());
		if(dao.verifyOwner(login.getId(), login.getPassword()) != null)
		{
			
			request.getSession().setAttribute(Constants.getOwnerId(), login.getId());
			return new ModelAndView("redirect:/test");
		}
		//dao.saveRet(login);
		return new ModelAndView("redirect:/login");
	}
	
	@RequestMapping(value="/login")  
	public ModelAndView login()
	{
		//dao.dbDocTest();
		//return new ModelAndView("redirect:/login");
		return new ModelAndView("login","command",new Owner());
		//return null;
	}*/
	
	@RequestMapping(value="/logout")  
	public ModelAndView logout(HttpServletRequest request)
	{
		//return new ModelAndView("redirect:/login");
		request.getSession().removeAttribute(Constants.getOwnerId());
		return new ModelAndView("redirect:/");
		//return null;
	}

}
