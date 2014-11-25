package com.itransition.itransitionproject.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itransition.itransitionproject.dao.interfaces.ComboPropertiesDAO;
import com.itransition.itransitionproject.entity.ComboProperties;

@Repository
public class ComboPropertiesDAOImpl extends BaseDAOImpl implements ComboPropertiesDAO {

    public void addComboProperties(ComboProperties comboProperties) {
        super.addElement(comboProperties);
    }
    
    public ComboProperties getComboProperties(Integer id) {
    	return (ComboProperties) super.getRecordById(ComboProperties.class, id);
    }

    public List<ComboProperties> listComboProperties() {
    	return super.<ComboProperties> getAllRecords("from ComboProperties");
    }

    public void removeComboProperties(Integer id) {    	
    	super.removeObject(ComboProperties.class, id);
    }
}
