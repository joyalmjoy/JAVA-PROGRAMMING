package Lab1;

import java.time.LocalDate;


public class Driver {
        public static void main(String[] args) {
            Singers singer1 = new Singers();
            System.out.println(singer1.getSingers_id());
            System.out.println(singer1.getSingers_name());
            System.out.println(singer1.getSingers_address());
            System.out.println(singer1.getDate_Of_Birth());
            System.out.println(singer1.getNumber_Of_Albums_Published());
            System.out.println();
            singer1.setSingers_id(603532);
            singer1.setSingers_name("Nivin Pauly");
            singer1.setSingers_address("Conlins road");
            singer1.setDate_Of_Birth(LocalDate.of(2000,02,20));
            singer1.setNumber_Of_Albums_Published(25);
            System.out.println(singer1.getSingers_id());
            System.out.println(singer1.getSingers_name());
            System.out.println(singer1.getSingers_address());
            System.out.println(singer1.getDate_Of_Birth());
            System.out.println(singer1.getNumber_Of_Albums_Published());
        }
    }

