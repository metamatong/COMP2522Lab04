package ca.bcit.comp2522.bookstore;

/**
 * A class to represent an Author, which is a type of Person.
 * An Author has a genre associated with their works.
 *
 * Extends the Person class.
 * Implements Printable interface.
 *
 * Data Members:
 * - Genre (e.g. "Horror"): not null, not blank, and less than 30 characters.
 *
 * Methods:
 * - Inherits methods from Person.
 * - Implements display() from Printable.
 *
 * @author Kyle Cheon
 * @author Tommy Nguyen
 * @version 1.0
 */
public class Author extends Person {

    private final String genre;
    private static final int MAX_GENRE_LENGTH = 30;

    /**
     * A constructor to instantiate an Author object.
     *
     * @param dateOfBirth the date of birth of the Author instance.
     * @param dateOfDeath the date of death of the Author instance.
     * @param name the full name of the Author instance.
     * @param genre the literary genre of the Author.
     */
    public Author(final Date dateOfBirth,
                  final Date dateOfDeath,
                  final Name name,
                  final String genre) {

        super(dateOfBirth, dateOfDeath, name);
        validateGenre(genre);
        this.genre = genre;
    }

    /**
     * Validates the genre of the Author.
     * Ensures the genre is not null, not blank, and does not exceed the maximum length.
     *
     * @param genre the literary genre of the Author.
     */
    private void validateGenre(final String genre) {
        if (genre == null) {
            throw new IllegalArgumentException("Genre can't be null");
        }

        if (genre.isBlank()) {
            throw new IllegalArgumentException("Genre can't be blank");
        }

        if (genre.length() > MAX_GENRE_LENGTH) {
            throw new IllegalArgumentException("Genre should be less than " + MAX_GENRE_LENGTH);
        }
    }

    /**
     * An accessor method for the genre of the Author.
     *
     * @return a String representing the literary genre of the Author.
     */
    public String getGenre() {
        return genre;
    }

    /**
     * This method overrides display() from Printable and
     * prints every data field of the Author instance.
     */
    @Override
    public void display() {
        final boolean deathDateNull;

        deathDateNull = getDeathDate() == null;

        System.out.println("Date of Birth: " + getBirthDate());

        if (!deathDateNull) {
            System.out.println("Date of Death: " + getDeathDate());
        }

        System.out.println("Name: " + getName());
        System.out.println("Genre: " + getGenre());
    }
}
