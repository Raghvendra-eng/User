package com.Bank.User.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Bank.User.Controller.Services.AccountServices;
import com.Bank.User.Controller.entity.User;

public class AllControlers {
	
	@RestController
	public class myController {
		
		@Autowired
		private AccountServices accountServices; 
		// tomcat test
		
		@GetMapping("/home")
		public String home() {
			return "This is the home page";
		}
		
		// Updating accountBalance after debit
		
		
		@PostMapping("/debit/{accountNumber}")
		public User debit(@PathVariable String accountNumber, @RequestBody String amount) {
			
			User user = this.accountServices.getUser(Long.parseLong(accountNumber));
			
			if ( Long.parseLong(amount) <= user.getAccountBalance() ) {
				
				user.updateBalanceBy(-Long.parseLong(amount)) ;
				
				return this.accountServices.updateUser(user);
			}
			
			else 
				return user;
		}
		
		// Updating accountBalance after credit
		
		@PostMapping("/credit/{accountNumber}")
		public User credit(@PathVariable String accountNumber, @RequestBody String amount) {
				
			User user = this.accountServices.getUser(Long.parseLong(accountNumber));
			
			if ( Long.parseLong(amount) <= user.getAccountBalance() ) {
				
				user.updateBalanceBy(Long.parseLong(amount)) ;
				
				return this.accountServices.updateUser(user);
			}
			
			else 
				return user;

		}
	}
}
