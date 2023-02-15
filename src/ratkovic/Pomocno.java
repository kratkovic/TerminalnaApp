package ratkovic;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Pomocno {

	public static Scanner ulaz;
	public static boolean DEV;

	public static int unosBrojRaspon(String poruka, int min, int max) {
		int i;
		while (true) {
			try {
				System.out.print(poruka);
				i = Integer.parseInt(ulaz.nextLine());
				if (i < min || i > max) {
					System.out.println("Broj mora biti između " + min + " i " + max);
					continue;
				}
				return i;
			} catch (Exception e) {
				System.out.println("Niste unijeli broj");
			}
		}
	}

	public static String unosTeksta(String poruka) {
		String s;
		while (true) {
			System.out.print(poruka);
			s = ulaz.nextLine();
			if (s.trim().isEmpty()) {
				System.out.println("Obavezan unos");
				continue;
			}
			return s;
		}
	}
    public static Date kreirajDatum(int dan, int mjesec, int godina) {
    	GregorianCalendar gc = new GregorianCalendar();
    	gc.set(Calendar.DAY_OF_MONTH, dan);
    	gc.set(Calendar.MONTH, mjesec - 1);
    	gc.set(Calendar.YEAR, godina);
    	gc.set(Calendar.HOUR_OF_DAY, 0);
        gc.set(Calendar.MINUTE, 0);
        gc.set(Calendar.SECOND, 0);
        gc.set(Calendar.MILLISECOND, 0);
    	Date datum = gc.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String formatiraniDatum = dateFormat.format(datum);
        try {
            return dateFormat.parse(formatiraniDatum);
        } catch (ParseException e) {
            return datum;
        }     
}
    public static BigDecimal unosCijene(String poruka) {
        System.out.println(poruka);
        BigDecimal cijena = null;
        while (cijena == null) {
            String unos = ulaz.nextLine();
            try {
                cijena = new BigDecimal(unos);
            } catch (NumberFormatException ex) {
                System.out.println("Neispravan unos. Molimo unesite ponovo: ");
            }
        }
        return cijena;
}
}