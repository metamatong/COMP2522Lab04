package ca.bcit.comp2522.bookstore;

/**
 * A class representing a Autobiography, which is a type of Biography.
 * An Autobiography contains information about a subject, who is the focus of the biography.
 *
 * Extends the Biography class.
 * Implements the Printable interface.
 *
 * Methods:
 * - Implements the display() method from Printable to print out details of the biography.
 *
 * @author Kyle Cheon
 * @author Tommy Nguyen
 * @version 1.0
 */
public class Autobiography extends Biography implements Printable
{
    /**
     * Constructs a Biography object with a title, publication year, author, and subject.
     *
     * @param title         the title of the book (must not be null or exceed 100 characters)
     * @param yearPublished the year the book was published (must be between 1 and 2025)
     * @param author        the author of the book (must not be null)
     * @throws IllegalArgumentException if any parameter is invalid
     */
    public Autobiography(final String title,
                         final int yearPublished,
                         final Author author)
    {
        super(title, yearPublished, author, author);
    }

    public void display() {
        super.display();
        System.out.println("Author: " +
                getAuthor().getName().getFirstName() +
                " " +
                getAuthor().getName().getLastName() +
                " wrote this autobiography themselves." );
    }


}
