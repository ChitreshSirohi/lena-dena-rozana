package com.cs.myapps.lenaDenaRozana.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cs.myapps.lenaDenaRozana.beans.Login;
import com.cs.myapps.lenaDenaRozana.logging.LenaDenaLogger;
import com.cs.myapps.lenaDenaRozana.util.Constants;
import com.cs.myapps.lenaDenaRozana.dao.*;


@Controller
public class LoginController {

	private OwnerDao dao = new OwnerDao();

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String viewLogin(Map<String, Object> model) {
		Login user = new Login();
		model.put("loginForm", user);
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(@Valid @ModelAttribute("loginForm") Login login,
			BindingResult result, Map<String, Object> model,HttpServletRequest request) {

		if (result.hasErrors()) {
			return "login";
		}

		LenaDenaLogger.getLogger().warn("Verify login id:"+login.getId());
		LenaDenaLogger.getLogger().warn("Verify login password:"+login.getPassword());
		if(dao.verifyOwner(login.getId(), login.getPassword()) != null)
		{

			request.getSession().setAttribute(Constants.getOwnerId(), login.getId());

		}
		//dao.saveRet(login);

		return "loginSuccess";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String doLogout(HttpServletRequest request) {
		LenaDenaLogger.getLogger().warn(" logging out, user id:"+request.getAttribute(Constants.getOwnerId()));
		request.removeAttribute(Constants.getOwnerId());
		return "login";
	}
}
