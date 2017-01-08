package com.cs.myapps.lenaDenaRozana.controllers;

import com.cs.myapps.lenaDenaRozana.logging.LenaDenaLogger;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cs.myapps.lenaDenaRozana.beans.*;
import com.cs.myapps.lenaDenaRozana.dao.*;
import com.cs.myapps.lenaDenaRozana.util.Constants;

@Controller
public class TransactionController {
	


	private TransactionDao dao = new TransactionDao();
	private PartnerDao partDao = new PartnerDao();
	
	@RequestMapping(value="/transaction", method=RequestMethod.GET)
	public ModelAndView transaction(Map<String, Object> model,HttpServletRequest request)
	{
		LenaDenaLogger.getLogger().info("partnerForm in :"+this.getClass());
		Transaction transaction = new Transaction();
		model.put("transactionForm", transaction);
		String ownerId = (String) request.getSession().getAttribute(Constants.getOwnerId());
		dao.getFname(ownerId);
		dao.getDate(ownerId);
		return new ModelAndView("transaction","command",transaction).addObject("transactionList",referenceData(ownerId));
		//DbServiceConfig.getOwnerDbConnector();
		
	}
	
	@RequestMapping(value="/transaction",method = RequestMethod.POST)  
	public ModelAndView saveTransaction(@Valid @ModelAttribute("transactionForm") Transaction transaction,BindingResult bindingResult
			,HttpServletRequest request)
	{
		System.out.println("CH** transaction:"+transaction.getAmount());
		System.out.println("CH** transaction:"+transaction.getPartnerId());
		String ownerId = (String) request.getSession().getAttribute(Constants.getOwnerId());
		if (bindingResult.hasErrors()) {
			System.out.println("CH** Error found");
			
			return new ModelAndView("transaction","command",transaction).addObject("transactionList",referenceData(ownerId));
			//return new ModelAndView("redirect:/registerOwner");
            //return "transaction";
        }

		System.out.println("CH** transaction.getPartnerId():"+transaction.getPartnerId());
		String mobileNo = partDao.getMobileNo(ownerId, transaction.getPartnerId());
		String fname = partDao.getName(ownerId, transaction.getPartnerId());
		transaction.setMobileNo(mobileNo);
		transaction.setName(fname);
		System.out.println("CH** partDao.getMobileN:"+transaction.getDate());
		dao.save(transaction,ownerId);
		return new ModelAndView("loginSuccess");
		//return "redirect:loginSuccess";
	}
	
	@RequestMapping(value="/viewTransaction", method=RequestMethod.GET)  
	public ModelAndView getAllTransactions(Model model,HttpServletRequest request){ 		
		String ownerId = (String) request.getSession().getAttribute(Constants.getOwnerId());
		
		List transactionList = dao.getTrasactionsByDate(ownerId, null);
		System.out.println("CH** transactionList:"+transactionList.size());
		model.addAttribute(new DateFilter());
		return new ModelAndView("viewTransactions","transactionList",transactionList);  
	}  
	
	@RequestMapping(value="/transactionsByDate", method=RequestMethod.POST)  
	public ModelAndView getTransactionsByDate(@ModelAttribute("dateFilterForm") DateFilter dateFilter,HttpServletRequest request){ 		
		String ownerId = (String) request.getSession().getAttribute(Constants.getOwnerId());
		String date = (String) request.getAttribute("date");
		System.out.println("Date1:"+date);
		List transactionList = dao.getTrasactionsByDate(ownerId, getDateArray(date));
		System.out.println("CH** transactionList1:"+transactionList.size());
		return new ModelAndView("viewTransactions","transactionList",transactionList);  
	}  
	
	@RequestMapping(value="/dateFilter", method=RequestMethod.GET)  
	public String getTransactionsB(Model model,HttpServletRequest request){ 		
		String ownerId = (String) request.getSession().getAttribute(Constants.getOwnerId());
		String date = (String) request.getAttribute("date");
		System.out.println("Date2:"+date);
		model.addAttribute(new DateFilter());
		//List transactionList = dao.getTrasactionsByDate(ownerId, getDateArray(date));
		//System.out.println("CH** transactionList:"+transactionList.size());
		return "dateFilter";  
	}  
	
	
	private int[] getDateArray(String date) {
		if(date == null)
			return new int[]{2016,12,29};
		StringTokenizer stokens = new StringTokenizer(date,"-");
		int[] dt = new int[3];
		for(int ctr=0;stokens.hasMoreTokens();ctr++)
		{
			dt[ctr]=Integer.parseInt(stokens.nextToken());
		}
		return dt;
	}
	
	protected Map referenceData(String ownerId)  {

		//Map referenceData = new HashMap();
		
		List<Partner> partners = partDao.getPartners(ownerId);

		Map<String,String> partnerId = new LinkedHashMap<String,String>();
		
		for(Partner part:partners)
		{
		
		partnerId.put(part.getId(), part.getFname()+" "+part.getLname());
		}

		//referenceData.put("transactionList", partnerId);
		return partnerId;
	}
	

	
	
}
