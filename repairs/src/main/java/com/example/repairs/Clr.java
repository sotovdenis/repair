package com.example.repairs;

import com.example.repairs.dto.CarDto;
import com.example.repairs.dto.CartDto;
import com.example.repairs.dto.CustomerDto;
import com.example.repairs.dto.RepairPartsDto;
import com.example.repairs.entities.*;
import com.example.repairs.repositories.*;
import com.example.repairs.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.github.javafaker.Faker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

@Component
public class Clr implements CommandLineRunner {

	private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	private final CarsInfoService carsInfoService;
	private final CategoryRepo categoryRepository;
	private final CustomerService customerService;
	private final RepairPartsRepo repairPartsRepository;
	private final OrderRepo orderRepository;
	private final ReviewRepo reviewRepository;
	private final RepairPartsService repairPartsService;
	private final ReviewService reviewService;
	private final CategoryService categoryService;
	private final UserRepository userDetailsService;
	private final CartService cartService;


	@Autowired
	public Clr(CarsInfoService carsInfoService,
	           CategoryRepo categoryRepo,
	           CustomerService customerService,
	           RepairPartsRepo repairPartsRepo,
	           OrderRepo orderRepo,
	           ReviewRepo reviewRepo,
	           RepairPartsService repairPartsService,
	           ReviewService reviewService,
	           CategoryService categoryService,
	           UserRepository userDetailsService,
	           CartService cartService) {
		this.carsInfoService = carsInfoService;
		this.categoryRepository = categoryRepo;
		this.customerService = customerService;
		this.repairPartsRepository = repairPartsRepo;
		this.orderRepository = orderRepo;
		this.reviewRepository = reviewRepo;
		this.repairPartsService = repairPartsService;
		this.reviewService = reviewService;
		this.categoryService = categoryService;
		this.userDetailsService = userDetailsService;
		this.cartService = cartService;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Welcome to the Repair Management System!");

		while (true) {
			System.out.println("Choose option from:" +
					"\n1 - Add Car" +
					"\n2 - Add Category" +
					"\n3 - Add Customer" +
					"\n4 - Add Repair Part" +
					"\n5 - Add Order" +
					"\n6 - Add Review" +
					"\n7 - Show All Cars" +
					"\n8 - Show All Categories" +
					"\n9 - Show All Customers" +
					"\n10 - Show All Repair Parts" +
					"\n11 - Show All Orders" +
					"\n12 - Show All Reviews");

			String input = bufferedReader.readLine().toLowerCase();

			switch (input) {
				case "1":
					this.addCar();
					break;
				case "2":
					this.addCategory();
					break;
				case "3":
					this.addCustomer();
					break;
				case "4":
					this.addRepairPart();
					break;
				case "5":
					this.addOrder();
					break;
				case "6":
					this.addReview();
					break;
				case "7":
					this.showAllCars();
					break;
				case "8":
					this.showAllCategories();
					break;
				case "9":
//                    this.showAllCustomers();
					break;
				case "10":
					this.showAllRepairParts();
					break;
				case "11":
					this.showAllOrders();
					break;
				case "12":
					this.showAllReviews();
					break;
				case "13":
					this.addToCart();
					break;
				default:
					System.out.println("Invalid option. Please try again.");
			}
			System.out.println("==================================");
		}
	}

	private void addToCart() throws IOException {
		System.out.println("Enter your name and repair name");
		String[] params = bufferedReader.readLine().split(" ");
		String username = params[0];

		User user = userDetailsService.getUserByUsername(params[0]);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(user.getUsername());

		RepairParts repairParts = repairPartsService.findAll().getFirst();
		System.out.println(repairParts.getName());

		Cart cart = new Cart(user, repairParts);


//		Cart cart = new Cart(userDetailsService.findByUsername(username).get(), repairPartsService.findAll().stream().filter(e -> e.getName().equals(params[1])).toList().getFirst());

//		CartDto cartDto = new CartDto(cart.getUserId().getId(), cart.getRepairPartsId().getId());

		CartDto cartDto = new CartDto(user.getId(), repairParts.getId());

//		cartService.addCart(cartDto);
		cartService.add(cart);

		System.out.println("Successfully added to cart!");

	}

	private void addCar() throws IOException {
		System.out.println("Enter car details in format: brandName VIN");
		String[] params = bufferedReader.readLine().split(" ");

		CarDto carDto = new CarDto();
		carDto.setBrandName(params[0]);
		carDto.setVin(params[1]);
		carsInfoService.addCarInfo(params[0], params[1]);
		System.out.println("Successfully added car!");
		System.out.println(carsInfoService.findCarInfoByName("audi").toString());
	}

	private void addCategory() throws IOException {
		System.out.println("Enter category name:");
		for (int i = 0; i < carsInfoService.findAll().size(); i++) {
			categoryRepository.save(new Category(carsInfoService.findAll().get(i), "to", "toko"));
		}
		System.out.println("Successfully added categories!");
	}

	private void addCustomer() throws IOException {
		System.out.println("Enter customers count");
		String[] params = bufferedReader.readLine().split("\\s+");
		Faker faker = new Faker();

		for (int i = 0; i < Integer.parseInt(params[0]); i++) {
			CustomerDto customerDto = new CustomerDto();
			customerDto.setName(faker.artist().name());
			customerDto.setEmail(faker.artist().name() + "@mail.ru");
			customerDto.setPhone(faker.phoneNumber().phoneNumber());
			customerDto.setLogin(faker.name().name());
			customerDto.setPassword(faker.artist().name());
			customerService.addCustomer(customerDto);
		}
		System.out.println("Successfully added customers!");


	}

	private void addRepairPart() throws IOException {
		System.out.println("Enter repair parts count");
		String[] params = bufferedReader.readLine().split("\\s+");
		Faker faker = new Faker();
		Random random = new Random();

		Category category = categoryService.findAll().get(0);

		for (int i = 0; i < Integer.parseInt(params[0]); i++) {


			RepairPartsDto part = new RepairPartsDto();
			part.setCategory(category.getId());
			part.setDescription(faker.artist().name() + faker.lorem().characters().substring(0, 200));
			part.setName(faker.aviation().aircraft());
			part.setPrice(134214d);

			repairPartsRepository.save(new RepairParts(part.getName(),
					part.getDescription(),
					part.getPrice(),
					categoryRepository.findAll().getFirst()));
//			repairPartsService.addRepairPart(part);
		}

		System.out.println("Successfully added repair parts!");
	}

	private void addOrder() throws IOException {
		System.out.println("Enter order details in format: amount status");
		String[] params = bufferedReader.readLine().split("\\s+");

		User customer = userDetailsService.findAll().getFirst();
		RepairParts repairPart = repairPartsService.findAll().getFirst();
		double amount = Double.parseDouble(params[0]);
		String status = params[1];
		Timestamp date = new Timestamp(System.currentTimeMillis());

		if (customer != null && repairPart != null) {
			Order order = new Order(customer, repairPart, amount, status, date);
			orderRepository.save(order);
			System.out.println("Successfully added order!");
		} else {
			System.out.println("Error: Customer or Repair Part not found!");
		}
	}

	private void addReview() throws IOException {
		System.out.println("Enter review details in format: rating content");
		String[] params = bufferedReader.readLine().split("\\s+");

		User customer = userDetailsService.findAll().getFirst();
		RepairParts repairPart = repairPartsService.findAll().getFirst();

		//check orders

		int rating = Integer.parseInt(params[0]);
		String content = params[1];
		Timestamp date = new Timestamp(System.currentTimeMillis());

		if (customer != null && repairPart != null) {
			Review review = new Review(customer, repairPart, rating, content, date);
			reviewRepository.save(review);
			System.out.println("Successfully added review!");
		} else {
			System.out.println("Error: Customer or Repair Part not found!");
		}
	}

	private void showAllCars() {
		List<CarsInfo> cars = carsInfoService.findAll();
		cars.forEach(car -> System.out.printf("%s - %s%n",
				car.getBrandName(), car.getVin()));
	}

	private void showAllCategories() {
		List<Category> categories = categoryRepository.findAll();
		categories.forEach(category -> System.out.printf("%s%n", category.getName()));
	}

//    private void showAllCustomers() {
//        List<Customer> customers = customerRepository.findAll();
//        customers.forEach(customer -> System.out.printf("%s (%s)%n",
//                customer.getName(), customer.getEmail()));
//    }

	private void showAllRepairParts() {
		List<RepairParts> parts = repairPartsRepository.findAll();
		parts.forEach(part -> System.out.printf("%s - %s ($%.2f)%n",
				part.getName(),
				part.getDescription(),
				part.getPrice()));
	}

	private void showAllOrders() {
		List<Order> orders = orderRepository.findAll();
		orders.forEach(order -> System.out.printf("OrderService: %s - %s - $%.2f%n",
				order.getUser().getUsername(),
				order.getRepairParts().getName(),
				order.getAmount()));
	}

	private void showAllReviews() {
		List<Review> reviews = reviewRepository.findAll();
		reviews.forEach(review -> System.out.printf("Review: %s - %s - %d stars%n",
				review.getUsers().getUsername(),
				review.getContent(),
				review.getRating()));
	}
}

