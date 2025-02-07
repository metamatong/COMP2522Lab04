package ca.bcit.comp2522.bookstore;

import java.util.ArrayList;
import java.util.List;

/**
 * A driver class containing the main() method to demonstrate the creation and usage
 * of Book, Biography, and Autobiography objects, along with comparisons and interface methods.
 *
 * Assumes supporting classes Person, Name, and Date exist and function as required.
 *
 * @author Kyle Cheon
 * @author Tommy Nguyen
 * @version 1.0
 *
 */
public class Main
{
    /**
     *
     * main function to run and test classes.
     *
     * @param args for commandline arguments
     */
    public static void main(final String[] args)
    {

        /*
         *  STEP 1: CREATE FIVE AUTHORS & FIVE GREAT BOOKS
         */

        Author georgeOrwell = new Author(
                new Date(1903, 6, 25),
                new Date(1950, 1, 21),
                new Name("George", "Orwell"),
                "Dystopian Fiction"
        );

        Author harperLee = new Author(
                new Date(1926, 4, 28),
                new Date(2016, 2, 19),
                new Name("Harper", "Lee"),
                "Southern Gothic"
        );

        Author janeAusten = new Author(
                new Date(1775, 12, 16),
                new Date(1817, 7, 18),
                new Name("Jane", "Austen"),
                "Romance"
        );

        Author fScottFitzgerald = new Author(
                new Date(1896, 9, 24),
                new Date(1940, 12, 21),
                new Name("F. Scott", "Fitzgerald"),
                "Novel"
        );

        Author hermanMelville = new Author(
                new Date(1819, 8, 1),
                new Date(1891, 9, 28),
                new Name("Herman", "Melville"),
                "Adventure Fiction"
        );

        final Book book1;
        final Book book2;
        final Book book3;
        final Book book4;
        final Book book5;

        book1 = new Book("1984", 1949, georgeOrwell);
        book2 = new Book("To Kill a Mockingbird", 1960, harperLee);
        book3 = new Book("Pride and Prejudice", 1813, janeAusten);
        book4 = new Book("The Great Gatsby", 1925, fScottFitzgerald);
        book5 = new Book("Moby-Dick", 1851, hermanMelville);

        /*
         *  STEP 2: CREATE FIVE GREATEST BIOGRAPHIES
         */
        Person robertMoses = new Person(
                new Date(1888, 12, 18),
                new Date(1981, 7, 29),
                new Name("Robert", "Moses")
        );
        Person steveJobs = new Person(
                new Date(1955, 2, 24),
                new Date(2011, 10, 5),
                new Name("Steve", "Jobs")
        );
        Person winstonChurchill = new Person(
                new Date(1874, 11, 30),
                new Date(1965, 1, 24),
                new Name("Winston", "Churchill")
        );
        Person alexanderHamilton = new Person(
                new Date(1755, 1, 11),
                new Date(1804, 7, 12),
                new Name("Alexander", "Hamilton")
        );
        Person albertEinstein = new Person(
                new Date(1879, 3, 14),
                new Date(1955, 4, 18),
                new Name("Albert", "Einstein")
        );

        // Create Authors who wrote these biographies
        Author robertCaro = new Author(
                new Date(1935, 10, 15),
                null,
                new Name("Robert", "Caro"),
                "Biography"
        );

        Author walterIsaacson = new Author(
                new Date(1952, 5, 20),
                null,
                new Name("Walter", "Isaacson"),
                "Biography"
        );

        Author martinGilbert = new Author(
                new Date(1936, 10, 25),
                new Date(2015, 2, 3),
                new Name("Martin", "Gilbert"),
                "Biography"
        );

        Author ronChernow = new Author(
                new Date(1949, 3, 3),
                null,
                new Name("Ron", "Chernow"),
                "Biography"
        );

        // Reuse Walter Isaacson for Einstein as well, or create a second reference
        Author walterIsaacson2 = new Author(
                new Date(1952, 5, 20),
                null,
                new Name("Walter", "Isaacson"),
                "Biography"
        );

        final Biography bio1;
        final Biography bio2;
        final Biography bio3;
        final Biography bio4;
        final Biography bio5;

        // Create 5 Biographies
        bio1 = new Biography("The Power Broker", 1974, robertCaro, robertMoses);
        bio2 = new Biography("Steve Jobs", 2011, walterIsaacson, steveJobs);
        bio3 = new Biography("Churchill: A Life", 1991, martinGilbert, winstonChurchill);
        bio4 = new Biography("Alexander Hamilton", 2004, ronChernow, alexanderHamilton);
        bio5 = new Biography("Einstein: His Life and Universe", 2007, walterIsaacson2, albertEinstein);

        /*
         *  STEP 3: CREATE FIVE GREATEST AUTOBIOGRAPHIES
         * The subject is automatically the same as the Author in Autobiography
         */

        Author anneFrank = new Author(
                new Date(1929, 6, 12),
                new Date(1945, 3, 1),
                new Name("Anne", "Frank"),
                "Memoir"
        );

        final Autobiography auto1;

        auto1 = new Autobiography("The Diary of a Young Girl", 1947, anneFrank);

        Author nelsonMandela = new Author(
                new Date(1918, 7, 18),
                new Date(2013, 12, 5),
                new Name("Nelson", "Mandela"),
                "Memoir"
        );

        final Autobiography auto2;

        auto2 = new Autobiography("Long Walk to Freedom", 1994, nelsonMandela);

        Author mahatmaGandhi = new Author(
                new Date(1869, 10, 2),
                new Date(1948, 1, 30),
                new Name("Mahatma", "Gandhi"),
                "Memoir"
        );

        final Autobiography auto3;

        auto3 = new Autobiography("The Story of My Experiments with Truth", 1927, mahatmaGandhi);

        Author mayaAngelou = new Author(
                new Date(1928, 4, 4),
                new Date(2014, 5, 28),
                new Name("Maya", "Angelou"),
                "Memoir"
        );

        final Autobiography auto4;

        auto4 = new Autobiography("I Know Why the Caged Bird Sings", 1969, mayaAngelou);

        Author malcolmX = new Author(
                new Date(1925, 5, 19),
                new Date(1965, 2, 21),
                new Name("Malcolm", "X"),
                "Memoir"
        );

        final Autobiography auto5;

        auto5 = new Autobiography("Autobiography of Malcolm X", 1965, malcolmX);

        /*
         *  STEP 4: PERFORM COMPARISONS & USE INTERFACES
         */

        // Compare two Books by publication year using compareTo()
        System.out.println("\n--- Book Comparisons (by publication year) ---");
        System.out.print("Comparing \"" + book1.getTitle() + "\" (" +
                book1.getYearPublished() + ") with \"" +
                book2.getTitle() + "\" (" +
                book2.getYearPublished() + "): ");

        final int compareBooksResult;
        compareBooksResult = book1.compareTo(book2);

        if(compareBooksResult > 0)
        {
            System.out.println(book1.getTitle() + " is older than " + book2.getTitle());
        }
        else if(compareBooksResult < 0)
        {
            System.out.println(book1.getTitle() + " is newer than " + book2.getTitle());
        }
        else
        {
            System.out.println("Both books have the same publication year.");
        }

        // Compare two Biographies by subject using .equals()
        System.out.println("\n--- Biography Comparison (by subject) ---");
        System.out.print("Comparing \"" + bio1.getTitle() + "\" subject (" +
                robertMoses.getName().getFirstName() + " " + robertMoses.getName().getLastName() + ") with \"" +
                bio2.getTitle() + "\" subject (" +
                steveJobs.getName().getFirstName() + " " + steveJobs.getName().getLastName() + "): ");

        final boolean sameSubject;

        sameSubject = bio1.equals(bio2);

        if(sameSubject)
        {
            System.out.println("They share the same subject.");
        }
        else
        {
            System.out.println("They do NOT share the same subject.");
        }

        // Compare authors by birth year (example of a direct property comparison)
        System.out.println("\n--- Author Comparison (by birth year) ---");
        System.out.println(georgeOrwell.getName().getFirstName() +
                " was born in " +
                georgeOrwell.getBirthDate().getYear());
        System.out.println(harperLee.getName().getFirstName() +
                " was born in " +
                harperLee.getBirthDate().getYear());

        if(georgeOrwell.getBirthDate().getYear() < harperLee.getBirthDate().getYear())
        {
            System.out.println(georgeOrwell.getName().getFirstName() +
                    " was born before " +
                    harperLee.getName().getFirstName());
        }
        else if(georgeOrwell.getBirthDate().getYear() > harperLee.getBirthDate().getYear())
        {
            System.out.println(georgeOrwell.getName().getFirstName() +
                    " was born after " +
                    harperLee.getName().getFirstName());
        }
        else
        {
            System.out.println("They were born the same year!");
        }

        /*
         *  STEP 5: PRINTING USING Printable & REVERSING USING Reversible
         */

        List<Book> allBooks = new ArrayList<>();
        // Add the 5 basic books
        allBooks.add(book1);
        allBooks.add(book2);
        allBooks.add(book3);
        allBooks.add(book4);
        allBooks.add(book5);
        // Add the 5 biographies
        allBooks.add(bio1);
        allBooks.add(bio2);
        allBooks.add(bio3);
        allBooks.add(bio4);
        allBooks.add(bio5);
        // Add the 5 autobiographies
        allBooks.add(auto1);
        allBooks.add(auto2);
        allBooks.add(auto3);
        allBooks.add(auto4);
        allBooks.add(auto5);

        System.out.println("\n--- Using Printable Interface: Display Details for All Books ---");
        for (Book b : allBooks)
        {
            b.display();
            System.out.println();
        }

        System.out.println("\n--- Using Reversible Interface: Print Titles Backward ---");
        for (Book b : allBooks)
        {
            System.out.print("Reversed title for \"" + b.getTitle() + "\": ");
            b.backward();
        }
    }
}