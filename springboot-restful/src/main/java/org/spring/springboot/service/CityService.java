package org.spring.springboot.service;

import java.util.List;

import org.spring.springboot.domain.City;

/**
 * 
 * <p>Title:CityService</p>
 * <p>Description:Interface to business city</p>
 * @author yuippe
 * @date 2018年3月30日
 */
public interface CityService {
	
	/**
	 * Get list of information to City 
	 * @return
	 */
	List<City> findAllCity();
	
	/**
	 * As id of city, get information of special city
	 * @param id
	 * @return
	 */
	City findCityById(Long id);
	
	/**
	 * add city
	 * @param city
	 * @return
	 */
	Long saveCity(City city);
	
	/**
	 * update city
	 * @param city
	 * @return
	 */
	Long updateCity(City city);
	
	/**
	 * As id of city, delete city
	 * @param id
	 * @return
	 */
	Long deleteCity(Long id);
}
