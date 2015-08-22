package org.ship.service;

import java.util.List;

import org.ship.model.Security;

public interface ISecurityService {

	public void addSecurity(Security security);
	
	public Security queryById(long securityId);
	
	public List<Security> queryByAll();
}
