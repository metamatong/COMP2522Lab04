package ca.bcit.comp2522.bookstore;

public class Autobiography extends Biography implements Printable {
    /**
     * Constructs a Biography object with a title, publication year, author, and subject.
     *
     * @param title         the title of the book (must not be null or exceed 100 characters)
     * @param yearPublished the year the book was published (must be between 1 and 2025)
     * @param author        the author of the book (must not be null)
     * @throws IllegalArgumentException if any parameter is invalid
     */
    public Autobiography(String title, int yearPublished, Author author) {
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
