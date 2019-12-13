package com.cts.design.DesignPattern.DAO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class TabletDAO implements TabletDAOInterface {
	static Set<Tablet> tablets;
	static Tablet obj;

	@Override
	public void createTablet(Tablet tablet) {
		tablets.add(tablet);
		String data = "\n"+tablet.getTabletName() + "," + tablet.getManufacturer() + ","
				+ tablet.getManufactureDate().getDayOfMonth() + "/" + tablet.getManufactureDate().getMonthValue() + "/"
				+ tablet.getManufactureDate().getYear() + "," + tablet.getExpiryDate().getDayOfMonth() + "/"
				+ tablet.getExpiryDate().getMonthValue() + "/" + tablet.getExpiryDate().getYear();
		try {
			Files.write(Paths.get("src/data/tablet_details.txt"), data.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteTablet(String tabletName) {
		Optional<Tablet> remTab = tablets.stream().filter(t -> t.getTabletName().equalsIgnoreCase(tabletName))
				.findFirst();
		tablets.remove(remTab.get());
		try {
			Files.deleteIfExists(Paths.get("src/data/tablet_details.txt"));
			Files.createFile(Paths.get("src/data/tablet_details.txt"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		tablets.stream().forEach(t -> {
			try {
				Files.write((Paths.get("src/data/tablet_details.txt")),
						(t.getTabletName() + "," + t.getManufacturer() + "," + t.getManufactureDate().getDayOfMonth()
								+ "/" + t.getManufactureDate().getMonthValue() + "/" + t.getManufactureDate().getYear()
								+ "," + t.getExpiryDate().getDayOfMonth() + "/" + t.getExpiryDate().getMonthValue()
								+ "/" + t.getExpiryDate().getYear() + "\n").getBytes(),
						StandardOpenOption.APPEND);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		// TODO Auto-generated method stub

	}

	@Override
	public void updateTablet(Tablet tablet) {
		tablets.add(tablet);
		try {
			Files.deleteIfExists(Paths.get("src/data/tablet_details.txt"));
			Files.createFile(Paths.get("src/data/tablet_details.txt"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		tablets.stream().forEach(t -> {
			try {
				Files.write((Paths.get("src/data/tablet_details.txt")),
						(t.getTabletName() + "," + t.getManufacturer() + "," + t.getManufactureDate().getDayOfMonth()
								+ "/" + t.getManufactureDate().getMonthValue() + "/" + t.getManufactureDate().getYear()
								+ "," + t.getExpiryDate().getDayOfMonth() + "/" + t.getExpiryDate().getMonthValue()
								+ "/" + t.getExpiryDate().getYear() + "\n").getBytes(),
						StandardOpenOption.APPEND);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

	}

	@Override
	public void searchTablet(String tabletName) {
		tablets.stream().filter(t -> t.getTabletName().equalsIgnoreCase(tabletName)).forEach(System.out::println);

	}

	public static void getTabletsFromFile() {

		try {
			tablets = Files.lines(Paths.get("src/data/tablet_details.txt")).map(Utility::parseTablet)
					.filter(t ->t.getTabletName()!=null)
					// issue.getIssueId().startsWith("IS"))
					.collect(Collectors.toSet());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		getTabletsFromFile();
		//tablets.forEach(System.out::println);
		TabletDAO obj = new TabletDAO();
		obj.createTablet(new Tablet("Amitwas","ABC",LocalDate.of(2010, 06, 23),LocalDate.of(2010, 07, 23)));
		//tablets.forEach(System.out::println);
		obj.deleteTablet("amitwas");
		//tablets.forEach(System.out::println);
		obj.searchTablet("pentaids1");
		// tablets.forEach(System.out::println);
		obj.updateTablet(new Tablet("Amit", "ABCD", LocalDate.of(2010, 06, 23), LocalDate.of(2010, 07, 23)));
		tablets.forEach(System.out::println);
	}

}
