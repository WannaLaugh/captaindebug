package com.captaindebug.address;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the display address page
 */
@Controller
public class AddressController {

	private static final Logger logger = LoggerFactory.getLogger(AddressController.class);

	private AddressService addressService;

	/**
	 * Grab hold of an address and push it into the model for display.
	 * 
	 * @param id
	 *            The id of the address object as a request param in the form id=<num>
	 * 
	 */
	@RequestMapping(value = "/findaddress", method = RequestMethod.GET)
	public String findAddress(@RequestParam("id") int id, Model model) {

		logger.info("Processing an address page request for address with id: " + id);

		Address address = addressService.findAddress(id);
		model.addAttribute(address);

		return "address-display";
	}

	@Autowired
	void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}
}
