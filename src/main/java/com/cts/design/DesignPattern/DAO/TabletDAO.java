package com.cts.design.DesignPattern.DAO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;



public class TabletDAO implements TabletDAOInterface{
	static List<Tablet> tablets;
	@Override
	public  void createTablet(Tablet tablet) {
		tablets.add(tablet);
		String data="\n"+tablet.getTabletName()+","+tablet.getManufacturer()+","+tablet.getManufactureDate()+","+tablet.getExpiryDate();
		try {
			Files.write(Paths.get("src/data/tablet_details.txt"), data.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteTablet(String tabletName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTablet(String tabletname) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readTablet(String tabletName) {
		// TODO Auto-generated method stub
		
	}
	public  static void getTabletsFromFile() {
		
			 try {
				 tablets= Files.lines(Paths.get("src/data/tablet_details.txt")).map(Utility::parseTablet)
						 //.filter(issue ->issue!=null && issue.getIssueId().startsWith("IS"))
						 .collect(Collectors.toList());
			 }catch(IOException e) {
				 e.printStackTrace();
			 }
		
	}
	public static void main(String[] args) {
		getTabletsFromFile();
		tablets.forEach(System.out::println);
		TabletDAO obj=new TabletDAO();
		obj.createTablet(new Tablet("Amit","ABC",LocalDate.of(2010, 06, 23),LocalDate.of(2010, 07, 23)));
		tablets.forEach(System.out::println);
	}

}
