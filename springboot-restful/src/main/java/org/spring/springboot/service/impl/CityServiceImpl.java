package org.spring.springboot.service.impl;

import java.util.List;

import org.spring.springboot.dao.CityDao;
import org.spring.springboot.domain.City;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * <p>Title:CityServiceImpl</p>
 * <p>Description:Implement bussiness city of interface </p>
 * @author yuippe
 * @date 2018年3月30日
 */
@Service
public class CityServiceImpl implements CityService{
	
	@Autowired
	private CityDao cityDao;

	@Override
	public List<City> findAllCity() {
		// TODO Auto-generated method stub
		return cityDao.findAllCity();
	}

	@Override
	public City findCityById(Long id) {
		// TODO Auto-generated method stub
		return cityDao.findById(id);
	}

	@Override
	public Long saveCity(City city) {
		// TODO Auto-generated method stub
		return cityDao.saveCity(city);
	}

	@Override
	public Long updateCity(City city) {
		// TODO Auto-generated method stub
		return cityDao.updateCity(city);
	}

	@Override
	public Long deleteCity(Long id) {
		// TODO Auto-generated method stub
		return cityDao.deleteCity(id);
	}
	
	
}
