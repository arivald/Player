package com.example.arivald.playbackservice.model;

import java.util.HashSet;
import java.util.Set;

/**
 * One folder. Can contain Songs and other Folders.
 *
 * Created by Arivald on 2016-01-27.
 */
public class Folder {

    /**
     * Folder name, human friendly, editable
     */
    String name;

    /**
     * Folder path, relative to its parent
     */
    String path;


    /**
     * Sub folders of this folder.
     * A Set, because it is order-less.
     */
    Set<Folder> subFolders = new HashSet<>();

    /**
     * Songs in this folder.
     * Does not contain songs from subfolders
     */
    Set<Song> songs = new HashSet<>();

}
