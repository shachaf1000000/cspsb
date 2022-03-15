package com.fscsp.csp.test;

import com.fscsp.csp.beans.Category;
import com.fscsp.csp.beans.Company;
import com.fscsp.csp.beans.Coupon;
import com.fscsp.csp.maneger.ClientType;
import com.fscsp.csp.maneger.LogInManeger;
import com.fscsp.csp.services.CompaniesServiceImplement;
import com.fscsp.csp.utils.Art;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.List;

@Component
@Order(2)
@RequiredArgsConstructor
public class CompanyTest implements CommandLineRunner {
	@Autowired
	private CompaniesServiceImplement companyService;
	@Autowired
	private LogInManeger loginManager;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(Art.SERVICE);
		boolean status =testLoginCompany();
		if (status) {
			testAddCoupon();
			testUpdateCoupon();
			testDeleteCoupon();
			testGetCompanyCoupons();
			testGetCompanyCouponsByCategory();
			testGetCompanyCouponsByMaxPrice();
			testGetCompanyById();
		}
		System.out.println(" Testings for Company test has ended as the status is " + status);
	}

	private void testGetCompanyById() {
		try {
			int id=5;
			System.out.println("the company with the id "+id+" is "+companyService.getCompanyById(id));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void testGetCompanyCoupons() {
		List<Coupon> coupons;
		try {
			Company comp1 = new Company("Tesla", "Tesla@gmail.com", "Tesla1234");
			comp1.setId(1);
			companyService.setCompany(comp1);
			coupons = companyService.getCompanyCoupons(comp1);
			System.out.println("here are All the coupons for"+comp1.getName()+" :\n"+coupons);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public boolean testLoginCompany() {
		try {
			ClientType type1 = ClientType.COMPANY;
			String email1 ="Tesla@gmail.com";
			String password1 = "Tesla1234";
			CompaniesServiceImplement service1=(CompaniesServiceImplement)loginManager.login(email1, password1, type1);
			
//			ClientType type2 = ClientType.COMPANY;
//			String email2 ="Toyota@gmail.com";
//			String password2 = "Toyota1234";
//			CompaniesServiceImplement service2=(CompaniesServiceImplement)loginManager.login(email2, password2, type2);
//
//			ClientType type3 = ClientType.COMPANY;
//			String email3 ="MG@gmail.com";
//			String password3 = "MG1234";
//			CompaniesServiceImplement service3=(CompaniesServiceImplement)loginManager.login(email3, password3, type3);
//
//			ClientType type4 = ClientType.COMPANY;
//			String email4 ="Mercedes@gmail.com";
//			String password4 = "Mercedes1234";
//			CompaniesServiceImplement service4=(CompaniesServiceImplement)loginManager.login(email4, password4, type4);
//
//			ClientType type5 = ClientType.COMPANY;
//			String email5 ="Renault@gmail.com";
//			String password5 = "Renault1234";
//			CompaniesServiceImplement service5=(CompaniesServiceImplement)loginManager.login(email5, password5, type5);
			if (service1 != null) {
				return true;
			}
//			if (service2 != null) {
//				return true;
//			}
//			if (service3 != null) {
//				return true;
//			}
//			if (service4 != null) {
//				return true;
//			}
//			if (service5 != null) {
//				return true;
//			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public void testAddCoupon() {
		try {
			Date utilDate = new Date();

			java.sql.Date sqlDate1 = new java.sql.Date(utilDate.getTime());
			java.sql.Date sqlDate1Plus = new java.sql.Date(utilDate.getTime() + 500000);
			
			java.sql.Date sqlDate2 = new java.sql.Date(utilDate.getTime()+ 1000000);
			java.sql.Date sqlDate2Plus = new java.sql.Date(utilDate.getTime() + 1500000);
			
			java.sql.Date sqlDate3 = new java.sql.Date(utilDate.getTime()+ 1500000);
			java.sql.Date sqlDate3Plus = new java.sql.Date(utilDate.getTime() + 2000000);
			
			java.sql.Date sqlDate4 = new java.sql.Date(utilDate.getTime()+ 2000000);
			java.sql.Date sqlDate4Plus = new java.sql.Date(utilDate.getTime() + 2500000);
			
			java.sql.Date sqlDate5 = new java.sql.Date(utilDate.getTime()+ 2500000);
			java.sql.Date sqlDate5Plus = new java.sql.Date(utilDate.getTime() + 3000000);
			
			Company comp1 = new Company("Tesla", "Tesla@gmail.com", "Tesla1234");
			comp1.setId(1);
			
			Coupon Coup1 = new Coupon(comp1, "RESTAURANT Discount!", "25% off on your next purchase in our RESTAURANT", Category.RESTAURANT, sqlDate1,
					sqlDate1Plus, 2, 25.0, "nothing");
			Coupon Coup2 = new Coupon(comp1, "LG TV!", "25% off on your next purchase", Category.ELECTRICITY, sqlDate2,
					sqlDate2Plus, 2, 242.0, "nothing");
			Coupon Coup3 = new Coupon(comp1, "free shake!", "1 free drink", Category.FOOD, sqlDate3,
					sqlDate3Plus, 2, 12.0, "nothing");
			Coupon Coup4 = new Coupon(comp1, "1 day trip to eilat! ", "a couple size bedroom,and free dinner", Category.VACATION, sqlDate4,
					sqlDate4Plus, 2, 212.0, "nothing");
			Coupon Coup5 = new Coupon(comp1, "1 day trip to eilat*2 !", "a couple size bedroom,and free dinner*2", Category.VACATION, sqlDate5,
					sqlDate5Plus, 2, 414.0, "nothing");
			
			companyService.addCoupon(Coup1,comp1.getId());
			companyService.addCoupon(Coup2,comp1.getId());
			companyService.addCoupon(Coup3,comp1.getId());
			companyService.addCoupon(Coup4,comp1.getId());
			companyService.addCoupon(Coup5,comp1.getId());
			
			Company comp2 = new Company("Toyota", "Toyota@gmail.com", "Toyota1234");
			comp2.setId(2);

			Coupon Coup6 = new Coupon(comp2, "Chef meal! ", "Chef meal with all expenses on us", Category.RESTAURANT, sqlDate1,
					sqlDate1Plus, 2, 100.0, "nothing");
			Coupon Coup7 = new Coupon(comp2, "One Plus Phone!", "15% Off and a free screen protector", Category.ELECTRICITY, sqlDate2,
					sqlDate2Plus, 2, 292.0, "nothing");
			Coupon Coup8 = new Coupon(comp2, "Red Meat!", "15% Off on one kilo of any red meat", Category.FOOD, sqlDate3,
					sqlDate3Plus, 2, 18.0, "nothing");
			Coupon Coup9 = new Coupon(comp2, "1 day trip to Amsterdam! ", "a couple size bedroom,and free dinner", Category.VACATION, sqlDate4,
					sqlDate4Plus, 2, 412.0, "nothing");
			Coupon Coup10 = new Coupon(comp2, "1 day trip to Amsterdam*2 !", "a couple size bedroom,and free dinner*2", Category.VACATION, sqlDate5,
					sqlDate5Plus, 2, 824.0, "nothing");
			
			companyService.addCoupon(Coup6,comp2.getId());
			companyService.addCoupon(Coup7,comp2.getId());
			companyService.addCoupon(Coup8,comp2.getId());
			companyService.addCoupon(Coup9,comp2.getId());
			companyService.addCoupon(Coup10,comp2.getId());
			
			Company comp3 = new Company("MG", "MG@gmail.com", "MG1234");
			comp3.setId(3);

			Coupon Coup11 = new Coupon(comp3, "Sushi !", "150 Shekel off our mains", Category.RESTAURANT, sqlDate1,
					sqlDate1Plus, 2, 110.0, "nothing");
			Coupon Coup12 = new Coupon(comp3, "PS5!", "PS5 + 2 Remotes + 2 Games at a combo price!", Category.ELECTRICITY, sqlDate2,
					sqlDate2Plus, 2, 592.0, "nothing");
			Coupon Coup13 = new Coupon(comp3, "Milk!", "Buy 1 Litre of any milk and get Marva Cookies (1pc)", Category.FOOD, sqlDate3,
					sqlDate3Plus, 2, 13.0, "nothing");
			Coupon Coup14 = new Coupon(comp3, "1 day trip to sinay! ", "a couple size bedroom,and free dinner", Category.VACATION, sqlDate4,
					sqlDate4Plus, 2, 112.0, "nothing");
			Coupon Coup15 = new Coupon(comp3, "1 day trip to sinay*2! ", "a couple size bedroom,and free dinner*2", Category.VACATION, sqlDate5,
					sqlDate5Plus, 2, 224.0, "nothing");
			
			companyService.addCoupon(Coup11,comp3.getId());
			companyService.addCoupon(Coup12,comp3.getId());
			companyService.addCoupon(Coup13,comp3.getId());
			companyService.addCoupon(Coup14,comp3.getId());
			companyService.addCoupon(Coup15,comp3.getId());
			
			Company comp4 = new Company("Mercedes", "Mercedes@gmail.com", "Mercedes1234");
			comp4.setId(4);

			Coupon Coup16 = new Coupon(comp4, "Catering !", "All you can eat (150 Mains)", Category.RESTAURANT, sqlDate1,
					sqlDate1Plus, 2, 129.0, "nothing");
			Coupon Coup17 = new Coupon(comp4, "AirPods Pro!", "10% off your next purchase ", Category.ELECTRICITY, sqlDate2,
					sqlDate2Plus, 2, 72.0, "nothing");
			Coupon Coup18 = new Coupon(comp4, "Butchery!", "150 Shekel at our local butcher for you", Category.FOOD, sqlDate3,
					sqlDate3Plus, 2, 118.0, "nothing");
			Coupon Coup19 = new Coupon(comp4, "1 day trip to berlin !", "a couple size bedroom,and free dinner", Category.VACATION, sqlDate4,
					sqlDate4Plus, 2, 312.0, "nothing");
			Coupon Coup20 = new Coupon(comp4, "1 day trip to berlin*2! ", "a couple size bedroom,and free dinner*2", Category.VACATION, sqlDate5,
					sqlDate5Plus, 2, 624.0, "nothing");
			
			companyService.addCoupon(Coup16,comp4.getId());
			companyService.addCoupon(Coup17,comp4.getId());
			companyService.addCoupon(Coup18,comp4.getId());
			companyService.addCoupon(Coup19,comp4.getId());
			companyService.addCoupon(Coup20,comp4.getId());
			
			Company comp5 = new Company("Renault", "Renault@gmail.com", "Renault1234");
			comp5.setId(5);

			Coupon Coup21 = new Coupon(comp5, "Chef meal !", "Chef meal with all expenses on us", Category.RESTAURANT, sqlDate1,
					sqlDate1Plus, 2, 100.0, "nothing");
			Coupon Coup22 = new Coupon(comp5, "One Plus Phone!", "15% Off and a free screen protector", Category.ELECTRICITY, sqlDate2,
					sqlDate2Plus, 2, 292.0, "nothing");
			Coupon Coup23 = new Coupon(comp5, "Red Meat!", "15% Off on one kilo of any red meat", Category.FOOD, sqlDate3,
					sqlDate3Plus, 2, 18.0, "nothing");
			Coupon Coup24 = new Coupon(comp5, "1 day trip to paris! ", "a couple size bedroom,and free dinner", Category.VACATION, sqlDate4,
					sqlDate4Plus, 2, 512.0, "nothing");
			Coupon Coup25 = new Coupon(comp5, "1 day trip to paris*2! ", "a couple size bedroom,and free dinner*2", Category.VACATION, sqlDate5,
					sqlDate5Plus, 2, 1020.0, "nothing");
			Coupon Coup26 = new Coupon(comp5, "2 days trip to paris*2! ", "a couple size bedroom,and free dinner*2", Category.VACATION, sqlDate5,
					sqlDate5Plus, 2, 2020.0, "nothing");
			
			companyService.addCoupon(Coup21,comp5.getId());
			companyService.addCoupon(Coup22,comp5.getId());
			companyService.addCoupon(Coup23,comp5.getId());
			companyService.addCoupon(Coup24,comp5.getId());
			companyService.addCoupon(Coup25,comp5.getId());
			companyService.addCoupon(Coup26,comp5.getId());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void testDeleteCoupon() {
		try {
			int id=26;
			companyService.deleteCoupon(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void testGetCompanyCouponsByCategory() {
		try {
			int id=1;
//			companyService.getCompanyCouponsByCategory(Category.SHOPPING,companyService.getCompanyById(id));
			companyService.getCompanyCouponsByCategory(Category.RESTAURANT,companyService.getCompanyById(id));
			companyService.getCompanyCouponsByCategory(Category.ELECTRICITY,companyService.getCompanyById(id));
			companyService.getCompanyCouponsByCategory(Category.FOOD,companyService.getCompanyById(id));
			companyService.getCompanyCouponsByCategory(Category.VACATION,companyService.getCompanyById(id));
//			System.out.println("Here are your selected Company's Coupons selected by the Category(SHOPPING) : "+companyService.getCompanyCouponsByCategory(Category.SHOPPING,companyService.getCompanyById(id)));
			System.out.println("Here are your selected Company's Coupons selected by the Category(RESTAURANT) : "+companyService.getCompanyCouponsByCategory(Category.RESTAURANT,companyService.getCompanyById(id)));
			System.out.println("Here are your selected Company's Coupons selected by the Category(ELECTRICITY)"+companyService.getCompanyCouponsByCategory(Category.ELECTRICITY,companyService.getCompanyById(id)));
			System.out.println("Here are your selected Company's Coupons selected by the Category(FOOD)"+companyService.getCompanyCouponsByCategory(Category.FOOD,companyService.getCompanyById(id)));
			System.out.println("Here are your selected Company's Coupons selected by the Category(VACATION)"+companyService.getCompanyCouponsByCategory(Category.VACATION,companyService.getCompanyById(id)));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void testGetCompanyCouponsByMaxPrice() {
		try {
			int id=1;
		Company c=	companyService.getCompanyById(id);
			double x = (Math.random()*1000);
			companyService.getCompanyCouponsByMaxPrice(x,c);
			System.out.println("Here are your Company's Coupons selected by your "+x+"(max price)"+companyService.getCompanyCouponsByMaxPrice(x,c));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void testUpdateCoupon() {
		try {
			int id =1;
			Company comp1 = new Company("Tesla", "Tesla@gmail.com", "Tesla1234");
			comp1.setId(1);
			java.util.Date utilDate = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			java.sql.Date sqlDate2 = new java.sql.Date(utilDate.getTime()+500000);
			String title = "Discount";
			String description = "45% off on your next purchase";
			Category category =Category.RESTAURANT;
			int amount = 2;
			double price = 30.5;
			String image ="nothing";
			Coupon Coup1 = new Coupon(id,comp1, title, description,category, sqlDate, sqlDate2, amount, price,image);
			companyService.updateCoupon(Coup1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
