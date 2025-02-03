package ca.bcit.comp2522.bookstore;

public class Name implements Printable{
    private final String first;
    private final String last;

    /*
     * A constructor to instantiate a Name object.
     * @param first the first name of the Name instance.
     * @param last the last name of the Name instance.
     */
    Name(final String first, final String last) {
        validateName(first);
        validateName(last);
        this.first = first;
        this.last = last;
    }

    /*
     * Validates name in string whether they are blank, null, or longer than 50 characters.
     */
    private void validateName(final String name) {
        final boolean blank;
        final boolean longerThanFifty;

        blank = name == null || name.isEmpty();
        longerThanFifty = name.length() >= 50;

        if (blank) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (longerThanFifty) {
            throw new IllegalArgumentException("Name cannot exceed 50 characters");
        }
    }

    /**
     * This method overrides display() method from Printable and
     * prints every instance variable to the console.
     */
    @Override
    public void display() {
        System.out.println("First Name: " + first);
        System.out.println("Last Name: " + last);
    }
}
