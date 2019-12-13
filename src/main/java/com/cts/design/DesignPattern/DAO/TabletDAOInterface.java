package com.cts.design.DesignPattern.DAO;

public interface TabletDAOInterface {
	public  void createTablet(Tablet tablet);
	public  void deleteTablet(String tabletName);
	public  void updateTablet(Tablet tablet);
	public  void searchTablet(String tabletName);

}
