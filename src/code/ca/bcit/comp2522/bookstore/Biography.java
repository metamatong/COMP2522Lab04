package ca.bcit.comp2522.bookstore;

import java.util.Objects;

/**
 * A class representing a Biography, which is a type of Book.
 * A Biography contains information about a subject, who is the focus of the biography.
 *
 * Extends the Book class.
 * Implements the Printable interface.
 *
 * Data Members:
 * - subject: A Person object representing the subject of the biography. It is not null.
 *
 * Methods:
 * - Inherits methods from Book (such as getTitle(), getYearPublished(), getAuthor()).
 * - Overrides the equals() and hashCode() methods to compare two Biography objects based on the subject.
 * - Implements the display() method from Printable to print out details of the biography.
 *
 * @author [Your Name]
 * @version 1.0
 */
public class Biography extends Book implements Printable
{

    private final Person subject;

    /**
     * Constructs a Biography object with a title, publication year, author, and subject.
     *
     * @param title         the title of the book (must not be null or exceed 100 characters)
     * @param yearPublished the year the book was published (must be between 1 and 2025)
     * @param author        the author of the book (must not be null)
     * @param subject       the subject of the biography, represented as a Person object (must not be null)
     * @throws IllegalArgumentException if any parameter is invalid
     */
    public Biography(String title,
                     int yearPublished,
                     Author author,
                     Person subject)
    {
        super(title, yearPublished, author);
        validateSubject(subject);
        this.subject = subject;
    }

    /**
     * Compares this Biography to another object for equality.
     * Two biographies are considered equal if they are about the same subject.
     *
     * @param o the object to compare this Biography against
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(final Object o)
    {
        if(this == o)
        {
            return true;
        }

        if(o == null || getClass() != o.getClass())
        {
            return false;
        }

        Biography biography = (Biography) o;

        return subject == biography.subject;
    }

    /**
     * Returns a hash code for the Biography object.
     * The hash code is generated based on the subject of the biography.
     *
     * @return a hash code representing the Biography object
     */
    @Override
    public int hashCode()
    {
        return Objects.hashCode(subject);
    }

    /**
     * Implements the display() method from the Printable interface.
     * Prints the title, year published, author, and subject of the biography.
     */

    public void display()
    {
        final StringBuilder sb = new StringBuilder("Book Title: " + this.getTitle());
        sb.append("\nYear Published: ").append(this.getYearPublished());
        sb.append("\nAuthor: ").append(this.getAuthor().toString());
        sb.append("\nSubject: ").append(subject);
        System.out.println(sb);
    }

    /*
     * Validates the subject of the biography to ensure it is not null.
     *
     * @param subject the subject of the biography
     * @throws IllegalArgumentException if the subject is null
     */
    private static void validateSubject(final Person subject)
    {
        if(subject == null)
        {
            throw new IllegalArgumentException("Subject cannot be null");
        }
    }
}
