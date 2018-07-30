package com.example.userProfileAndRanking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.userProfileAndRanking.dto.UserTO;
import com.example.userProfileAndRanking.service.UserEditService;

@RestController
public class UserEditController {

	@Autowired
	private UserEditService userEditService;

	@RequestMapping(value = "/showUser/{id}", method = RequestMethod.GET)
	public UserTO showUser(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("showUser");
		modelAndView.addObject("user", userEditService.showUser(id));
		return userEditService.showUser(id);
	}

	@RequestMapping(value = "/editUser", method = RequestMethod.PUT)
	public String editUser(@RequestBody UserTO userTO) {
		ModelAndView modelAndView = new ModelAndView("editUser");
		modelAndView.addObject("user", userEditService.editUser(userTO.getUserId(), userTO));
		return "Edited user";
	}

	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("deleteUser");
		modelAndView.addObject("user", userEditService.deleteUser(id));
		return "Deleted user";
	}

	@RequestMapping(value = "/findUser", method = RequestMethod.POST)
	public List<UserTO> findUser(@RequestBody UserTO userTO) {
		ModelAndView modelAndView = new ModelAndView("findUser");
		modelAndView.addObject("user", userEditService.findUser(userTO));
		return userEditService.findUser(userTO);
	}

}
