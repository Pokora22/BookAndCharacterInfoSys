package models;

import java.util.Objects;
import dataStructures.CustomHashList;

public class Book {
    private String title;
    private String author;
    private String genre;
    private String countryOfSetting;
    private String countryOfOrigin;
    private String publisher;
    private int publicationYear;
    private int numberOfChapters;
    private int numberOfPages;
    private CustomHashList<BookCharacter> bookCharacters;

    public Book(String title, String author, String genre, String countryOfSetting, String countryOfOrigin,
                String publisher, int publicationYear, int numberOfChapters, int numberOfPages, String description,
                String image) {
        this.title = !title.isEmpty() ? title : "NOT GIVEN";
        this.author = !author.isEmpty() ? author : "NOT GIVEN";
        this.genre = !genre.isEmpty() ? genre : "NOT GIVEN";
        this.countryOfSetting = !countryOfSetting.isEmpty() ? countryOfSetting : "NOT GIVEN";
        this.countryOfOrigin = !countryOfOrigin.isEmpty() ? countryOfOrigin : "NOT GIVEN";
        this.publisher = !publisher.isEmpty() ? publisher : "NOT GIVEN";
        this.publicationYear = publicationYear<0 ? this.publicationYear = 0 : publicationYear;
        this.numberOfChapters = numberOfChapters<0 ? this.numberOfChapters = 0 : numberOfChapters;
        this.numberOfPages = numberOfPages<0 ? this.numberOfPages = 0 : numberOfPages;
        bookCharacters = new CustomHashList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(!title.isEmpty()) this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if(!author.isEmpty()) this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        if(!genre.isEmpty()) this.genre = genre;
    }

    public String getCountryOfSetting() {
        return countryOfSetting;
    }

    public void setCountryOfSetting(String countryOfSetting) { //plot setting
        if(!countryOfSetting.isEmpty()) this.countryOfSetting = countryOfSetting;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) { //where is the author from
        if(!countryOfOrigin.isEmpty()) this.countryOfOrigin = countryOfOrigin;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        if(!publisher.isEmpty()) this.publisher = publisher;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        if (publicationYear > 0) this.publicationYear = publicationYear;
    }

    public int getNumberOfChapters() {
        return numberOfChapters;
    }

    public void setNumberOfChapters(int numberOfChapters) {
        if(numberOfChapters > 0) this.numberOfChapters = numberOfChapters;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        if(numberOfPages > 0) this.numberOfPages = numberOfPages;
    }

    public CustomHashList<BookCharacter> getBookCharacters() {
        return bookCharacters;
    }

    public void addBookCharacter(BookCharacter character) {
        bookCharacters.add(character);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", countryOfSetting='" + countryOfSetting + '\'' +
                ", countryOfOrigin='" + countryOfOrigin + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publicationYear=" + publicationYear +
                ", numberOfChapters=" + numberOfChapters +
                ", numberOfPages=" + numberOfPages +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return getPublicationYear() == book.getPublicationYear() &&
                getNumberOfChapters() == book.getNumberOfChapters() &&
                getNumberOfPages() == book.getNumberOfPages() &&
                Objects.equals(getTitle(), book.getTitle()) &&
                Objects.equals(getAuthor(), book.getAuthor()) &&
                Objects.equals(getGenre(), book.getGenre()) &&
                Objects.equals(getCountryOfSetting(), book.getCountryOfSetting()) &&
                Objects.equals(getCountryOfOrigin(), book.getCountryOfOrigin()) &&
                Objects.equals(getPublisher(), book.getPublisher());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getAuthor(), getGenre(), getCountryOfSetting(), getCountryOfOrigin(), getPublisher(), getPublicationYear(), getNumberOfChapters(), getNumberOfPages());
    }
}