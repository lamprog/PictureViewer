<%--
  Created by IntelliJ IDEA.
  User: fahrbsve
  Date: 12/04/17
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.diconium.pictureviewer.PhotoAlbum" %>
<%@page contentType="image/jpeg" %>
<%java.io.OutputStream binaryOut = response.getOutputStream();
    String indexString = request.getParameter("photo");
    if (indexString != null) {
        int index = (new Integer(indexString.trim())).intValue();
        PhotoAlbum photo = PhotoAlbum.getPhotoAlbum(session);
        byte[] bytes = photo.getPhotoData(index);
        for (int i = 0; i < bytes.length; i++) {
            binaryOut.write(bytes[i]);
        }
    } else {
        response.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
%>