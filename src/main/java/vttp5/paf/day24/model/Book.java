package vttp5.paf.day24.model;

public class Book 
{
    private int id; // auto_increment
    private String title; // varchar(255)
    private int quantity;
    private Boolean isActive;
    
    public Book() {
    }

    public Book(int id, String title, int quantity, Boolean isActive) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
        this.isActive = isActive;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    } 

    
}
