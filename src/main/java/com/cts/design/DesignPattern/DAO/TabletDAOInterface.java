package com.cts.design.DesignPattern.DAO;

public interface TabletDAOInterface {
	public  void createTablet(Tablet tablet);
	public  void deleteTablet(String tabletName);
	public  void updateTablet(String tabletname);
	public  void readTablet(String tabletName);

}
