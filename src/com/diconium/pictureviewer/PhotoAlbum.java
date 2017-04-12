package com.diconium.pictureviewer;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fahrbsve on 17.02.2017.
 */
public class PhotoAlbum {
    public static String ATTRIBUTE_NAME = "Photo_Album";
    private List<byte[]> photoDataList = new ArrayList<byte[]>();
    private List<String> names = new ArrayList<String>();

    public PhotoAlbum() {
    }

    public void setSession(HttpSession session) {
        session.setAttribute(ATTRIBUTE_NAME, this);
    }

    public List getPhotoNames() {
        return names;
    }

    public void addPhoto(String name, byte[] bytes) {
        this.photoDataList.add(bytes);
        this.names.add(name);
    }

    public synchronized byte[] getPhotoData(int i) {
        return (byte[])photoDataList.get(i);
    }

    public synchronized String getPhotoName(int i) {
        return (String)names.get(i);
    }

    public synchronized int getPhotoCount() {
        return photoDataList.size();
    }

    public synchronized void removePhoto(int i) {
        photoDataList.remove(i);
        names.remove(i);
    }

    public static PhotoAlbum getPhotoAlbum(HttpSession session) {
        return (PhotoAlbum)session.getAttribute(ATTRIBUTE_NAME);
    }
}
