package com.itransition.itransitionproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itransition.itransitionproject.dao.ComboPropertiesDAO;
import com.itransition.itransitionproject.domain.ComboProperties;

@Service
public class ComboPropertiesServiceImpl implements ComboPropertiesService {
 
    @Autowired
    private ComboPropertiesDAO comboPropertiesDAO;
 
    @Transactional
    public void addComboProperties(ComboProperties comboProperties) {
    	comboPropertiesDAO.addComboProperties(comboProperties);
    }
 
    @Transactional
    public List<ComboProperties> listComboProperties() { 
        return comboPropertiesDAO.listComboProperties();
    }
 
    @Transactional
    public void removeComboProperties(Integer id) {
    	comboPropertiesDAO.removeComboProperties(id);
    }
}

