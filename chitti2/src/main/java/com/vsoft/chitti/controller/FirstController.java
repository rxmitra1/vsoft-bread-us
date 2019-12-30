package com.vsoft.chitti.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vsoft.chitti.bean.Address;
import com.vsoft.chitti.bean.Employee;
import com.vsoft.chitti.bean.UserReg;
import com.vsoft.chitti.repository.EmployeeRepository;
import com.vsoft.chitti.repository.UserRegRepository;
import com.vsoft.util.Response;

@RestController
@RequestMapping("/user")
public class FirstController {

	@Autowired
	private EmployeeRepository empRepository;

	@Autowired
	private UserRegRepository userRegRepository;

	@PostMapping(value = "/first")
	public Employee getFirstApi(@RequestBody Employee employee) {

		Employee employee3 = new Employee();
		employee3.setName(employee.getName());
		employee3.setEmail(employee.getEmail());

		List<Address> addressList = new ArrayList<Address>();
		List<Address> address2 = employee.getAddress();
		for (Address address3 : address2) {
			Address address = new Address();

			address.setStreet(address3.getStreet());
			address.setDistrict(address3.getDistrict());
			address.setState(address3.getState());
			address.setEmployee(employee3);
			addressList.add(address);

		}

		employee3.setAddress(addressList);

		Employee employee2 = empRepository.save(employee3);

		return employee2;
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public Response saveUser(@RequestBody UserReg user) {

		Response response = new Response();
		UserReg userReg = userRegRepository.save(user);
		if (userReg != null) {
			response.setStatusCode(200);
			response.setReason("User Stored Successfully");
			response.setData(userReg);
		} else {
			response.setStatusCode(700);
			response.setReason("User not Stored.");
			response.setData(userReg);
		}

		return response;
	}

	@RequestMapping(value = "/loginUser/{mobile}/{password}", method = RequestMethod.GET)
	public Response loginUser(@PathVariable String mobile, @PathVariable String password) {
		Response response = new Response();
		// UserReg userReg2 = null;
		UserReg userReg = userRegRepository.findByMobileAndPassword(mobile, password);

		System.out.println(userReg);
		if (userReg != null) {
			response.setStatusCode(200);
			response.setReason("User Login Successfully..");
			response.setData(userReg);
		} else {
			response.setStatusCode(701);
			response.setReason("Username or Password Incorrect.");
			// response.setData(userReg);
		}

		return response;
	}

	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public ResponseEntity<String> getUser() {
		UserReg userReg2 = null;
		Optional<UserReg> userReg = userRegRepository.findById(1);
		if (userReg.isPresent()) {
			userReg2 = userReg.get();
		}
		System.out.println(userReg2.getName());
		return new ResponseEntity<String>(userReg2.getName(), HttpStatus.OK);
	}

}
