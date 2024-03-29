package com.itransition.itransitionproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itransition.itransitionproject.dao.interfaces.ComboPropertiesDAO;
import com.itransition.itransitionproject.entity.ComboProperties;
import com.itransition.itransitionproject.service.interfaces.ComboPropertiesService;

@Service
public class ComboPropertiesServiceImpl implements ComboPropertiesService {
 
    @Autowired
    private ComboPropertiesDAO comboPropertiesDAO;
 
    @Transactional
    public void addComboProperties(ComboProperties comboProperties) {
    	comboPropertiesDAO.addComboProperties(comboProperties);
    }
    
    @Transactional
    public ComboProperties getComboProperties(Integer id) {
    	return comboPropertiesDAO.getComboProperties(id);
    }
 
    @Transactional
    public List<ComboProperties> listComboProperties() { 
        return comboPropertiesDAO.listComboProperties();
    }
 
    @Transactional
    public void removeComboProperties(Integer id) {
    	comboPropertiesDAO.removeComboProperties(id);
    }

	/**
	 * @return the comboPropertiesDAO
	 */
	public ComboPropertiesDAO getComboPropertiesDAO() {
		return comboPropertiesDAO;
	}

	/**
	 * @param comboPropertiesDAO the comboPropertiesDAO to set
	 */
	public void setComboPropertiesDAO(ComboPropertiesDAO comboPropertiesDAO) {
		this.comboPropertiesDAO = comboPropertiesDAO;
	}
}

