package Lab1;
import java.time.LocalDate;     //(from w3 school)

    public class Singers {

        //5 Instances
        public int Singers_id;
        public String Singers_name;
        public String Singers_address;
        public LocalDate Date_Of_Birth;
        public int Number_Of_Albums_Published;

        //constructor with 0 arguments
        public Singers(){

        }

        //constructor with 1 argument
        public Singers(int Singers_id){
            this.Singers_id = Singers_id;
        }

        //constructor with 2 argument
        public Singers(int Singers_id, String Singers_name){
            this.Singers_id = Singers_id;
            this.Singers_name = Singers_name;
        }

        //constructor with 3 argument
        public Singers(int Singers_id, String Singers_name, String Singers_address){
            this.Singers_id = Singers_id;
            this.Singers_name = Singers_name;
            this.Singers_address = Singers_address;
        }

        //constructor with 4 argument
        public Singers(int Singers_id, String Singers_name, String Singers_address, LocalDate Date_Of_Birth){
            this.Singers_id = Singers_id;
            this.Singers_name = Singers_name;
            this.Singers_address = Singers_address;
            this.Date_Of_Birth = Date_Of_Birth;
        }

        //constructor with 5 argument
        public Singers(int Singers_id, String Singers_name, String Singers_address, LocalDate Date_Of_Birth, int Number_Of_Albums_Published){
            this.Singers_id = Singers_id;
            this.Singers_name = Singers_name;
            this.Singers_address = Singers_address;
            this.Date_Of_Birth = Date_Of_Birth;
            this.Number_Of_Albums_Published = Number_Of_Albums_Published;
        }

        public void setSingers_id(int Singers_id){
            this.Singers_id = Singers_id;
        }
        public void setSingers_name(String Singers_name){
            this.Singers_name = Singers_name;
        }
        public void setSingers_address(String Singers_address){
            this.Singers_address = Singers_address;
        }
        public void setDate_Of_Birth(LocalDate Date_Of_Birth){
            this.Date_Of_Birth = Date_Of_Birth;
        }
        public void setNumber_Of_Albums_Published(int Number_Of_Albums_Published){this.Number_Of_Albums_Published = Number_Of_Albums_Published;}

        public void set_All(int Singers_id, String Singers_name, String Singers_address, LocalDate Date_Of_Birth, int Number_Of_Albums_Published){
            this.Singers_id = Singers_id;
            this.Singers_name = Singers_name;
            this.Singers_address = Singers_address;
            this.Date_Of_Birth = Date_Of_Birth;
            this.Number_Of_Albums_Published = Number_Of_Albums_Published;
        }

        public int getSingers_id(){
            return Singers_id;
        }
        public String getSingers_name(){
            return Singers_name;
        }
        public String getSingers_address(){
            return Singers_address;
        }
        public LocalDate getDate_Of_Birth(){
            return Date_Of_Birth;
        }
        public int getNumber_Of_Albums_Published(){
            return Number_Of_Albums_Published;
        }
    }

