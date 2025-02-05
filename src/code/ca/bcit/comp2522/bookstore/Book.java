package ca.bcit.comp2522.bookstore;

/**
 * Represents a Book with a title, publication year, and an associated author.
 * Implements Comparable for sorting, Printable for displaying book details,
 * and Reversible for reversing the title.
 *
 * Implements:
 * - Comparable<Book>: Books are compared based on their publication year (older books are "larger").
 * - Printable: Displays book details.
 * - Reversible: Prints the title in reverse.
 *
 * @author Kyle Cheon
 * @author Tommy Nguyen
 * @version 1.0
 */
public class Book implements Comparable<Book>, Printable, Reversible
{

    private final String title;
    private final int yearPublished;
    private final Author author;

    private static final int CHARACTER_LIMIT = 100;
    private static final int THE_FIRST_YEAR = 1;
    private static final int THE_CURRENT_YEAR = 2025;

    /**
     * Constructs a Book object with a title, publication year, and author.
     *
     * @param title         the title of the book (must not be null or exceed 100 characters)
     * @param yearPublished the year the book was published (must be between 1 and 2025)
     * @param author        the author of the book (must not be null)
     * @throws IllegalArgumentException if any parameter is invalid
     */
    public Book(final String title,
                final int yearPublished,
                final Author author)
    {
        validateTitle(title);
        validateYearPublished(yearPublished);
        validateAuthor(author);
        this.title = title;
        this.yearPublished = yearPublished;
        this.author = author;
    }

    /**
     * Compares this book to another book based on their publication year.
     * Older books are considered "larger" for sorting purposes.
     *
     * @param o the other book to compare to
     * @return a positive value if this book is older, a negative value if it is newer, and 0 if the years are the same
     * @throws IllegalArgumentException if the other book is null
     */
    @Override
    public int compareTo(final Book o)
    {
        if(o == null)
        {
            throw new IllegalArgumentException("Book cannot be null");
        }
        return Integer.compare(o.yearPublished, this.yearPublished);
    }

    /**
     * Displays the book's details including title, publication year, and author.
     */
    @Override
    public void display()
    {
        final StringBuilder sb = new StringBuilder("Book Title: " + this.title);
        sb.append("\nYear Published: ").append(this.yearPublished);
        sb.append("\nAuthor: ").append(this.author.toString());

        System.out.println(sb);
    }

    /**
     * Prints the book's title in reverse.
     */
    @Override
    public void backward()
    {
        StringBuilder sb = new StringBuilder(this.title);
        sb.reverse();
        System.out.println(sb);
    }

    /**
     * Gets the title of the book.
     *
     * @return the book title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Gets the publication year of the book.
     *
     * @return the year the book was published
     */
    public int getYearPublished()
    {
        return yearPublished;
    }

    /**
     * Gets the author of the book.
     *
     * @return the author of the book
     */
    public Author getAuthor()
    {
        return author;
    }


    /*
     * Validates the book title.
     *
     * @param title the title of the book
     * @throws IllegalArgumentException if the title is null, empty, or exceeds 100 characters
     */
    private static void validateTitle(final String title)
    {
        if(title == null || title.isEmpty())
        {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        if(title.length() > CHARACTER_LIMIT)
        {
            throw new IllegalArgumentException("Title must not exceed " + CHARACTER_LIMIT + " characters");
        }
    }

    /*
     * Validates the publication year.
     *
     * @param yearPublished the year the book was published
     * @throws IllegalArgumentException if the year is not between 1 and 2025
     */
    private static void validateYearPublished(final int yearPublished)
    {
        if(yearPublished < THE_FIRST_YEAR || yearPublished > THE_CURRENT_YEAR)
        {
            throw new IllegalArgumentException("Year published must be between " + THE_FIRST_YEAR + " and " + THE_CURRENT_YEAR);
        }
    }

    /*
     * Validates the author.
     *
     * @param author the author of the book
     * @throws IllegalArgumentException if the author is null
     */
    private static void validateAuthor(final Author author)
    {
        if(author == null)
        {
            throw new IllegalArgumentException("Author cannot be null");
        }
    }
}
