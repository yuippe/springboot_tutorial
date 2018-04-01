package org.spring.springboot.domain;

/**
 * 
 * <p>Title:City</p>
 * <p>Description: City Instance Class</p>
 * @author yuippe
 * @date 2018年3月29日
 */
public class City {
	
	/**
	 * City Number
	 */
	private Long id;
	
	/**
	 * Province Number
	 */
	private Long provinceId;
	
	/**
	 * City name
	 */
	private String cityName;
	
	/**
	 * desc
	 */
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
