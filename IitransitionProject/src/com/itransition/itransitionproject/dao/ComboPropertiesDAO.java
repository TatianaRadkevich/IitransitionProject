package com.itransition.itransitionproject.dao;

import java.util.List;

import com.itransition.itransitionproject.domain.ComboProperties;

public interface ComboPropertiesDAO {
	
	public void addComboProperties(ComboProperties comboProperties);
	
	public List<ComboProperties> listComboProperties();
	
	public void removeComboProperties(Integer id);

}
