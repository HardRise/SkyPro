public class Book {
    private String nameOfBook;
    public static class Author {
        private String firstNameOfAuthor;
        private String lastNameOfAuthor;
        public Author(String firstNameOfAuthor, String lastNameOfAuthor) {
            this.firstNameOfAuthor = firstNameOfAuthor;
            this.lastNameOfAuthor = lastNameOfAuthor;
        }
        public String getLastNameOfAuthor() { return this.lastNameOfAuthor; }
        public String getFirstNameOfAuthor() { return this.firstNameOfAuthor; }
    }
    private int yearOfPublication;
    public Book(String nameOfBook, int yearOfPublication) {
        this.nameOfBook = nameOfBook;
        this.yearOfPublication = yearOfPublication;
    }
    public String getName() { return this.nameOfBook; }
    public int getYearOfPublication() { return this.yearOfPublication; }
    public void setYearOfPublication(int yearOfPublication) { this.yearOfPublication = yearOfPublication; }
    @Override
    public String toString() {
        return "Книга - " + getName() + " была опубликована в " + getYearOfPublication() +
                " году, написал это произведение ";
    }
}