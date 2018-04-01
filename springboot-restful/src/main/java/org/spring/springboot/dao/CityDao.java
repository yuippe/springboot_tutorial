package org.spring.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.City;

/**
 * 
 * <p>Title:CityDao</p>
 * <p>Description: City DAO Interface Class</p>
 * @author yuippe
 * @date 2018年3月30日
 */
public interface CityDao {
	
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
	City findById(@Param("id") Long id);
	
	Long saveCity(City city);
	
	Long updateCity(City city);
	
	Long deleteCity(Long id);
}
