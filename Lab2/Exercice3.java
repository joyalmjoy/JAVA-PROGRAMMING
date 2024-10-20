package Lab2;

    public class Exercice3 {
        // Constructor
        public Exercice3() {
        }
        // Method 1: Display book title
        public static String displayInfo(String title) {
            return "The book title is: " + title;

        }

        // Method 2: Display book title and author
        public static String displayInfo(String title, String author) {
            return "The book title is: " + title + "\n" +
                    "The author is: " + author;
        }

        // Method 3: Display book title, author, and year of publication
        public static String displayInfo(String title, String author, int year) {
            return "The book title is: " + title + "\n" +
                    "The author is: " + author + "\n" +
                    "The year of publication is: " + year;
        }

        public static void main(String[] args) {
            // Calling the first overloaded method
            System.out.println(displayInfo("To Kill a Mockingbird"));
            System.out.println("-------------------------");
            // Calling the second overloaded method
            System.out.println(displayInfo("To Kill a Mockingbird", "Harper Lee"));
            System.out.println("-------------------------");
            // Calling the third overloaded method
            System.out.println(displayInfo("To Kill a Mockingbird", "Harper Lee", 1960));
        }
    }


