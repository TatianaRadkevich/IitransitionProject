package com.itransition.itransitionproject.service;

import java.util.List;

import com.itransition.itransitionproject.domain.ComboProperties;

public interface ComboPropertiesService {
	
	public void addComboProperties(ComboProperties comboProperties);
	
	public ComboProperties getComboProperties(Integer id);
	
	public List<ComboProperties> listComboProperties();
	
	public void removeComboProperties(Integer id);
}
