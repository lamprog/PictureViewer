package com.diconium.pictureviewer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by fahrbsve on 17.02.2017.
 */
@WebServlet(name = "RemovePhotoServlet",
            urlPatterns = {"/RemovePhotoServlet"})
public class RemovePhotoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        // extract GET parameter "photo"
        String indexString = request.getParameter("photo");
        int index = (new Integer(indexString.trim())).intValue();

        // get Singleton
        PhotoAlbum pa = PhotoAlbum.getPhotoAlbum(request.getSession());

        pa.removePhoto(index);

        // forward to DisplayAlbumServlet
        RequestDispatcher rd = request.getRequestDispatcher("DisplayAlbumServlet");
        rd.forward(request, response);
    }
}
