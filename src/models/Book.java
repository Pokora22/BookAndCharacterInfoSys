package models;

import java.util.Objects;

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
    private String description;
    private String image;

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
        this.description = !description.isEmpty() ? description : "NOT GIVEN";
        this.image = !image.isEmpty() ? image : "NOT GIVEN";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCountryOfSetting() {
        return countryOfSetting;
    }

    public void setCountryOfSetting(String countryOfSetting) {
        this.countryOfSetting = countryOfSetting;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(!description.isEmpty()) this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        if(!image.isEmpty()) this.image = image;
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
                Objects.equals(getPublisher(), book.getPublisher()) &&
                Objects.equals(getDescription(), book.getDescription()) &&
                Objects.equals(getImage(), book.getImage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getAuthor(), getGenre(), getCountryOfSetting(), getCountryOfOrigin(), getPublisher(), getPublicationYear(), getNumberOfChapters(), getNumberOfPages(), getDescription(), getImage());
    }
}