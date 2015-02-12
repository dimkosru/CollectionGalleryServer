package ru.redraven.collectiongallery;

/**
 * Created by Дмитрий on 12.02.2015.
 */
public class Item {
    private final long id;
    private final String name;

    public Item(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }
}