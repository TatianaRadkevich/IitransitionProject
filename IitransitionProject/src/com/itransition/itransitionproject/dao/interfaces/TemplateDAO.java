package com.itransition.itransitionproject.dao.interfaces;

import com.itransition.itransitionproject.entity.TemplateTable;

public interface TemplateDAO {
	public void addRef(TemplateTable table);
	public void remoteRef(TemplateTable table);
	public TemplateTable getTemplateTable(String ref);
}
