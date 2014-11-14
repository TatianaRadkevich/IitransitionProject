package com.itransition.itransitionproject.service;

import java.util.List;

import com.itransition.itransitionproject.domain.ComboProperties;

public interface ComboPropertiesService {
	
public void addComboProperties(ComboProperties comboProperties);
	
	public List<ComboProperties> listComboProperties();
	
	public void removeComboProperties(Integer id);
}
