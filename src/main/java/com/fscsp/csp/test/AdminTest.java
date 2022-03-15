package com.fscsp.csp.test;

import com.fscsp.csp.beans.Company;
import com.fscsp.csp.beans.Coupon;
import com.fscsp.csp.beans.Customer;
import com.fscsp.csp.job.ExpirationDailyJob;
import com.fscsp.csp.maneger.ClientType;
import com.fscsp.csp.maneger.LogInManeger;
import com.fscsp.csp.services.AdminsServiceImplement;
import com.fscsp.csp.utils.Art;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Order(1)
@RequiredArgsConstructor
public class AdminTest implements CommandLineRunner {
	@Autowired
	private AdminsServiceImplement adminService;
	@Autowired
	private LogInManeger loginManager;
	@Autowired
	private ExpirationDailyJob edj;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(Art.SERVICE);
		boolean status = testLoginAdmin();

		if (status) {
			testAddCompany();
			testAddCustomer();
			testGetAllCompanies();
			testGetAllCustomers();
			testGetOneCompany();
			testGetOneCustomer();
			testUpdateCompany(); 
			testUpdateCustomer();
			testDeleteCompany();
			testDeleteCustomer();
			testedj();
		}
		System.out.println(" Testings for Admin test has ended as the status is " + status);
	}

	public void testedj() {
		try {
			edj.removeExpierdCoupon();
			System.out.println("ExpirationDailyJob done");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public boolean testLoginAdmin() {
		try {
			String email = "Admin@gmail.com";
			String password = "Admin1234";
			ClientType type = ClientType.ADMIN;
			AdminsServiceImplement service = (AdminsServiceImplement) loginManager.login(email, password, type);
			if (service != null) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public void testAddCompany() {
		try {
			Company tesla = new Company("Tesla", "Tesla@gmail.com", "Tesla1234");
			Company toyota = new Company("Toyota", "Toyota@gmail.com", "Toyota1234");
			Company MG = new Company("MG", "MG@gmail.com", "MG1234");
			Company Mercedes = new Company("Mercedes", "Mercedes@gmail.com", "Mercedes1234");
			Company Renault = new Company("Renault", "Renault@gmail.com", "Renault1234");
			Company Hyundai = new Company("Hyundai", "Hyundai@gmail.com", "Hyundai1234");
			
			adminService.addCompany(tesla);
			adminService.addCompany(toyota);
			adminService.addCompany(MG);
			adminService.addCompany(Mercedes);
			adminService.addCompany(Renault);
			adminService.addCompany(Hyundai);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void testAddCustomer() {
		try {
			ArrayList<Coupon> coupList = new ArrayList<Coupon>();
			Customer elonMusk=new Customer("Elon", "Musk", "ElonMusk@gmail.com", "Elon1234", coupList);
			adminService.addCustomer(elonMusk);
			Customer akioToyoda=new Customer("Akio", "Toyoda", "AkioToyoda@gmail.com", "Akio1234", coupList);
			adminService.addCustomer(akioToyoda);
			Customer RajeevChaba=new Customer("Rajeev", "Chaba", "RajeevChaba@gmail.com", "Rajeev1234", coupList);
			adminService.addCustomer(RajeevChaba);
			Customer DieterZetsche=new Customer("Dieter", "Zetsche", "DieterZetsche@gmail.com", "Dieter1234", coupList);
			adminService.addCustomer(DieterZetsche);
			Customer LucaMeo=new Customer("Luca", "Meo", "LucaMeo@gmail.com", "Luca1234", coupList);
			adminService.addCustomer(LucaMeo);
			Customer JaeChang=new Customer("Jae", "Chang", "JaeChang@gmail.com", "Jae1234", coupList);
			adminService.addCustomer(JaeChang);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void testDeleteCompany() {
		try {
			int id=6;
			adminService.deleteCompany(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void testDeleteCustomer() {
		try {
			int id=6;
			adminService.deleteCustomer(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void testGetAllCompanies() {
		try {
			adminService.getAllCompanies();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void testGetAllCustomers() {
		try {
			adminService.getAllCustomers();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void testGetOneCompany() {
		try {
			int id=1;
			adminService.getSingleCompany(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void testGetOneCustomer() {
		try {
			int id=1;
			adminService.getSingleCustomer(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void testUpdateCompany() {
		try {
			Company test = new Company(2, "Toyota", "Toyota@gmail.com", "Toyota1234566");
			adminService.updateCompany(test);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void testUpdateCustomer() {
		try {
			adminService.updateCustomer(new Customer(2, "Akio2", "Toyoda2", "Akio2Toyoda2@gmail.com", "Akio123444"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
