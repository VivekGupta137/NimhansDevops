package com.pe.nimhans.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pe.nimhans.dto.UserDTO;
import com.pe.nimhans.entity.Doctor;
import com.pe.nimhans.entity.User;
import com.pe.nimhans.service.DoctorService;
import com.pe.nimhans.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins= {"http://localhost:4200","localhost:4200"})
public class UsersAddApi {
	@Autowired
	UserService userService;
	@Autowired
	DoctorService doctorService;
	
	@GetMapping("/all")
	public List<UserDTO> getAllUsers(){
		System.out.println(userService.getAll());
		return userService.getAll();
	}
	
//	first run this rest call to add the new user to users_auth
	@PostMapping("/{emp_id}")
	public void addUser(@PathVariable int emp_id, @RequestBody User theUser) {
		Doctor theDoctor = doctorService.findById(emp_id);
		theDoctor.setUsername(theUser);
		userService.save(theUser, theDoctor);
	}
// 	then run this for future updates to just add password
	@PostMapping("/update/{emp_id}")
	public void updateUser(@PathVariable int emp_id, @RequestBody String password) {
		Doctor theDoctor = doctorService.findById(emp_id);
		User theUsername = theDoctor.getUsername();
		theUsername.setPassword(password);
		doctorService.save(theDoctor);
	}
//	enable a doctor eg. send /update/enable/eid to enable 
	@PostMapping("/update/enable/{emp_id}")
	public void enableUser(@PathVariable int emp_id) {
		Doctor theDoctor = doctorService.findById(emp_id);
		User theUser = theDoctor.getUsername();
		userService.enable(theUser);
		doctorService.save(theDoctor);
	}
	@PostMapping("/update/disable/{emp_id}")
	public void disableUser(@PathVariable int emp_id) {
		Doctor theDoctor = doctorService.findById(emp_id);
		User theUser = theDoctor.getUsername();
		userService.disable(theUser);
		doctorService.save(theDoctor);
	}
}
