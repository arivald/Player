package com.example.arivald.playbackservice.model;

/**
 * A library, essentially top level folder plus metadata.
 *
 * Created by Arivald on 2016-01-27.
 */
public class Library {

    /**
     * Lib name
     */
    String name;

    /**
     * Absolute path to the library
     */
    String path;

    /**
     * Lib top level folder
     */
    Folder topLevelFolder;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Folder getTopLevelFolder() {
        return topLevelFolder;
    }

    public void setTopLevelFolder(Folder topLevelFolder) {
        this.topLevelFolder = topLevelFolder;
    }


}
