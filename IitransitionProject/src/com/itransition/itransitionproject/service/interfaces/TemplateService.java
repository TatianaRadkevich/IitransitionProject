package com.itransition.itransitionproject.service.interfaces;

import com.itransition.itransitionproject.entity.TemplateTable;
import com.itransition.itransitionproject.entity.User;

public interface TemplateService {
	
	public void addRef(User user, String ref);
	
	public void remoteRef(User user);
	
	public TemplateTable findRef(String ref);
}
