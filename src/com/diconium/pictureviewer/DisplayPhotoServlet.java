package com.diconium.pictureviewer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by fahrbsve on 16.02.2017.
 */
@WebServlet(name = "DisplayPhotoServlet",
            urlPatterns = {"/DisplayPhotoServlet"})
public class DisplayPhotoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
        throws ServletException, IOException {

        String indexString = request.getParameter("photo");
        int index = (new Integer(indexString.trim())).intValue();
        response.setContentType("image/jpeg");
        OutputStream out = response.getOutputStream();

        try {
            HttpSession session = request.getSession();
            PhotoAlbum pa = PhotoAlbum.getPhotoAlbum(session);
            byte[] bytes = pa.getPhotoData(index);
            for (int i = 0; i < bytes.length; i++) {
                out.write(bytes[i]);
            }
        } finally {
            out.close();
        }
    }
}
