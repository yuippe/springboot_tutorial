package org.spring.springboot.controller;

import java.util.List;

import org.spring.springboot.domain.City;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * <p>Title:CityRestController</p>
 * <p>Description:City Controller implement Restful HTTP services</p>
 * @author yuippe
 * @date 2018年3月30日
 */
@RestController
public class CityRestController {
	
	@Autowired
	private CityService cityService;
	
	@RequestMapping(value = "api/city/{id}", method = RequestMethod.GET)
	public City findOneCity(@PathVariable("id") Long id) {
		return cityService.findCityById(id);
	}
	
	@RequestMapping(value = "api/city", method = RequestMethod.GET)
	public List<City> findAllCity(){
		return cityService.findAllCity();
	}
	
	@RequestMapping(value = "api/city", method = RequestMethod.POST)
	public void createCity(@RequestBody City city) {
		cityService.saveCity(city);
	}
	
	@RequestMapping(value = "api/city", method = RequestMethod.PUT)
	public void modifyCity(@RequestBody City city) {
		cityService.updateCity(city);
	}
	
	@RequestMapping(value = "api/city/{id}", method = RequestMethod.DELETE)
	public void deleteCity(@PathVariable("id") Long id) {
		cityService.deleteCity(id);
	}
}
