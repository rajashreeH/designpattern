package com.cts.design.DesignPattern.DAO;

import java.time.LocalDate;

public class Utility {
	public static Tablet parseTablet(String tabletDetails) {
		String[] tDetails=tabletDetails.split(",");
		return new Tablet(tDetails[0],tDetails[1],LocalDate.of(Integer.parseInt(tDetails[2].split("/")[2]),Integer.parseInt(tDetails[2].split("/")[1]),Integer.parseInt(tDetails[2].split("/")[0])),LocalDate.of(Integer.parseInt(tDetails[3].split("/")[2]),Integer.parseInt(tDetails[3].split("/")[1]),Integer.parseInt(tDetails[3].split("/")[0])));
	}
}
