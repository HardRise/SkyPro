public class Main {
    public static void main(String[] args) {
        Book.Author prideAndPrejudiceAuthor = new Book.Author("Джейн", "Остин");
        Book.Author warAndPeaceAuthor = new Book.Author("Лев", "Толстой");
        Book prideAndPrejudice = new Book("Гордость и предубеждение", 1812);
        Book warAndPeace = new Book("Война и мир", 1869);
        prideAndPrejudice.setYearOfPublication(1813);
        System.out.println(prideAndPrejudice + prideAndPrejudiceAuthor.getFirstNameOfAuthor() + " " + prideAndPrejudiceAuthor.getLastNameOfAuthor());
        System.out.println(warAndPeace + warAndPeaceAuthor.getFirstNameOfAuthor() + " " + warAndPeaceAuthor.getLastNameOfAuthor());
    }
}