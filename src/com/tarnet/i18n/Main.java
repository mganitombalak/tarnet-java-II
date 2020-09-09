package com.tarnet.i18n;

// internationalization i18n
// localization         l10n

import sun.util.BuddhistCalendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.chrono.ThaiBuddhistChronology;
import java.time.chrono.ThaiBuddhistDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
//        Arrays.stream(Locale.getAvailableLocales()).forEach(l->{
//            System.out.printf("Locale Name: %s | Country: %s | Display Language: %s | Display Script: %s | Display Variant: %s%n",
//                    l.getDisplayName(),
//                    l.getDisplayCountry(),
//                    l.getDisplayLanguage(),
//                    l.getDisplayScript(),
//                    l.getDisplayVariant());
//
//
//            Locale fr = new Locale.Builder()
//                    .setLanguage("fr") // alpha-2 alpha-3
//                    .setRegion("CA")
//                    .setVariant("POSIX") // UNIX
//                    .setScript("Latn")
//                    .build();


//            Arrays.stream(NumberFormat.getAvailableLocales()).forEach(l->{
//                System.out.printf("Locale Name: %s | Country: %s | Display Language: %s | Display Script: %s | Display Variant: %s%n",
//                        l.getDisplayName(),
//                        l.getDisplayCountry(),
//                        l.getDisplayLanguage(),
//                        l.getDisplayScript(),
//                        l.getDisplayVariant());
//            });
//        DateFormat

//        System.out.printf("Current Locale information of running JVM Instance:"+ Locale.getDefault().getDisplayName()+"%n"); //Current Locale information of running JVM Instance
//        Locale.setDefault(Locale.CANADA_FRENCH);
//        System.out.printf("Current Locale information of running JVM Instance:"+ Locale.getDefault().getDisplayName()); //Current Locale information of running JVM Instance

//        System.out.printf("Locale:"+ Locale.getDefault());
//        NumberFormat numberFormatter = NumberFormat.getInstance();
//        double price = 1299.50d;
//        System.out.printf("%nprice:%s",numberFormatter.format(price));
//        numberFormatter = NumberFormat.getCurrencyInstance();
//        System.out.printf("%nprice: %s",numberFormatter.format(price));
//        numberFormatter = NumberFormat.getCurrencyInstance(Locale.JAPAN); // !!!!!!
//        System.out.printf("%nprice: %s",numberFormatter.format(price)); // !!!!

//        LocalDateTime localDateTime = LocalDateTime.now();
//        String pattern="dd MMMM yyyy HH:mm:ss.S";
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
//        System.out.printf("Today: %s%n",dateTimeFormatter.format(localDateTime));
////        Locale.setDefault(Locale.GERMANY);
//        dateTimeFormatter = DateTimeFormatter.ofPattern(pattern,Locale.GERMANY);
//        System.out.printf("Today: %s%n",dateTimeFormatter.format(localDateTime));

//
//        Arrays.stream(TimeZone.getAvailableIDs()).forEach(tz->{
//            System.out.printf("%s%n",tz);
//        });
//        LocalDateTime localDateTime=LocalDateTime.now(TimeZone.getTimeZone("Europe/Istanbul").toZoneId());
//        ZoneId nyTimeZone = TimeZone.getTimeZone("America/New_York").toZoneId();
//        // TimeZone tz = TimeZone.getTimeZone("GMT+4:00");
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
//        String result = dateTimeFormatter.format(ZonedDateTime.of(localDateTime,nyTimeZone));
//        System.out.printf("%s",result);

//        Calendar cal = Calendar.getInstance();
//        Calendar.getAvailableCalendarTypes().stream().forEach(ct -> {
//            System.out.printf("%s%n", ct);
//        });

        GregorianCalendar today = new GregorianCalendar(2020, Calendar.AUGUST, 21);
        GregorianCalendar zaferBayrami = new GregorianCalendar(2020, Calendar.JUNE, 30);
        today.add(GregorianCalendar.DATE, 1);
//        gregorianCalendar.add(Calendar.MONTH,1);
//        System.out.printf("%s%n", today.getTime());
//        System.out.println("Today<Zafer Bayrami:" + today.compareTo(zaferBayrami));
//        System.out.println("Zafer Bayrami>Today:" + zaferBayrami.compareTo(today));
//        System.out.println(today.toZonedDateTime().format(DateTimeFormatter.ofPattern("dd MMM yyyy")));
//        System.out.println("Agustos contains " + today.getActualMaximum(Calendar.DAY_OF_MONTH) + " days.");

        GregorianCalendar myCalendar = new GregorianCalendar(2020, Calendar.FEBRUARY, 21);

//        System.out.println("Feb contains " + myCalendar.getActualMaximum(Calendar.DAY_OF_MONTH) + " days.");
//
//        System.out.println("Actual min " + myCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));

//        System.out.println("Week " + myCalendar.getMinimum(Calendar.WEEK_OF_YEAR)); ???

//        System.out.println("2020 is lean year?:" + myCalendar.isLeapYear(2020));

        Date selectedDate = myCalendar.getTime();

        DateFormat fullDateFormatter = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL, Locale.FRANCE);
        System.out.println(fullDateFormatter.format(selectedDate));

        DateFormat shortDateFormatter = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.MEDIUM, Locale.ITALY);
        System.out.println(shortDateFormatter.format(selectedDate));

        SimpleDateFormat simpleFormatter = new SimpleDateFormat("dd MMMM yyyy HH:mm:ss.SSSS");
        System.out.println(simpleFormatter.format(selectedDate));


        // Sample
        ThaiBuddhistDate buddhistDate = ThaiBuddhistDate.now();
        System.out.println(buddhistDate);

    }
}
