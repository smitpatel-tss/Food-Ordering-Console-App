package model;

public class CuisineType {
    private String name;
    private long id;
    private static long count=0;

    public CuisineType(String name){
        this.name=name;
        this.id=count++;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }
}
