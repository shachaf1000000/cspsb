package com.fscsp.csp.maneger;

import com.fscsp.csp.exceptions.CustomException;
import com.fscsp.csp.services.AdminsServiceImplement;
import com.fscsp.csp.services.ClientService;
import com.fscsp.csp.services.CompaniesServiceImplement;
import com.fscsp.csp.services.CustomersServiceImplement;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * LogInManeger is a method which allows the users to log in and use the
 * services based on which privilege they have after inputting Email, password ,
 * and choosing which client type they identify as, the method checks for
 * validity if the validation is successful, the method returns
 * 
 * @return sends back the type of clientService the client has access to
 */
@Service
public class LogInManeger {
	private final ApplicationContext ctx;
	private final AdminsServiceImplement adminService;
	private final CompaniesServiceImplement companyService;
	private final CustomersServiceImplement customerService;

	public LogInManeger(ApplicationContext ctx, AdminsServiceImplement adminService, CompaniesServiceImplement companyService, CustomersServiceImplement customerService) {
		this.ctx = ctx;
		this.adminService = adminService;
		this.companyService = companyService;
		this.customerService = customerService;
	}

	public ClientService login(String email, String password, ClientType clientType) throws CustomException {
		ClientService clientService = null;
		switch (clientType) {
		case ADMIN:
			if(adminService.login(email, password)) {
				clientService = (ClientService) adminService;	
			}
			break;
		case COMPANY:
			if(companyService.login(email, password)) {
				clientService = (ClientService) companyService;
			}
			break;
		case CUSTOMER:		
			if(customerService.login(email, password)) {
				clientService = (ClientService) customerService;
			}
			break;
		}
		if (clientService==null) {
			throw new CustomException("Unsuccessful Login,try again!");
		}
		return clientService;
	}
}
