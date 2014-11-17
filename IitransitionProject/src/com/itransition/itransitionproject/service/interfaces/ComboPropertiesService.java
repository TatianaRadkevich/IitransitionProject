package com.itransition.itransitionproject.service.interfaces;

import java.util.List;

import com.itransition.itransitionproject.entity.ComboProperties;

public interface ComboPropertiesService {
	
	public void addComboProperties(ComboProperties comboProperties);
	
	public ComboProperties getComboProperties(Integer id);
	
	public List<ComboProperties> listComboProperties();
	
	public void removeComboProperties(Integer id);
}
