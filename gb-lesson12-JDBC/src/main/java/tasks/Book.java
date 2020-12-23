package tasks;


@DBTable(name = "books")
public class Book {
    @DBId
    private Long id;
    @DBColumn
    private String author;
    @DBColumn
    private String name;
    @DBColumn
    private Integer pageNum;

    public Book() {

    }

    public Book(String author, String name, Integer pageNum) {
        this.author = author;
        this.name = name;
        this.pageNum = pageNum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", pageNum=" + pageNum +
                '}';
    }
}
