/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.21
 * Generated at: 2015-05-09 08:51:07 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.View;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class displayProfile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/standard.jar", Long.valueOf(1430813014779L));
    _jspx_dependants.put("jar:file:/C:/WebClient/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/LinkedinServicesClient/WEB-INF/lib/standard.jar!/META-INF/c.tld", Long.valueOf(1098736290000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">\r\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js\"></script>\r\n");
      out.write("  <script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>\r\n");
      out.write("<title>Display profile</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body style=\"background-color: #EBEFF2\">\r\n");
      out.write("<nav class=\"navbar navbar-inverse navbar-fixed-top\">  \r\n");
      out.write(" <div class=\"container-fluid\">\r\n");
      out.write("    <div class=\"navbar-header\">\r\n");
      out.write("      <img src=\"../resources/images/download.gif\" style=\"margin-left: 150px;margin-top: 7px;\">\r\n");
      out.write("    </div>\r\n");
      out.write(" \r\n");
      out.write(" <table>   \r\n");
      out.write(" <tr>\r\n");
      out.write("   \r\n");
      out.write("\t  <td>   \r\n");
      out.write("\t   <form id=\"form3\" method=\"post\" action=\"displayProfile\">\r\n");
      out.write("\t\t <div class=\"form-row\"><input class=\"submit\" type=\"submit\" value=\"ViewProfile\"/></div>\r\n");
      out.write("\t \t</form>\r\n");
      out.write("\t  </td>\r\n");
      out.write("   \r\n");
      out.write("\t  <td>  \r\n");
      out.write("\t      <form id=\"form3\" method=\"post\" action=\"searchUser\">\r\n");
      out.write("\t\t  <div class=\"form-row\"> <input type=\"text\" name=\"text\"/> \t \r\n");
      out.write("\t <input class=\"submit\" type=\"submit\" value=\"Search\"/></div>\r\n");
      out.write("\t \t </form>\r\n");
      out.write("\t  </td>\r\n");
      out.write("  \r\n");
      out.write("\t  <td>\r\n");
      out.write("\t \t  <form id=\"form3\" method=\"post\" action=\"showInvitations\">\r\n");
      out.write("\t\t   \t  <div class=\"form-row\"><input class=\"submit\" type=\"submit\" value=\"Invitations\"/></div>\r\n");
      out.write("\t \t </form>\r\n");
      out.write("\t  </td>\r\n");
      out.write("\t  \r\n");
      out.write("\t  <td>\r\n");
      out.write("\t     <form id=\"form3\" method=\"post\" action=\"showConnections\">\r\n");
      out.write("\t\t   \t   <input class=\"submit\" type=\"submit\" value=\"Connections\"/> \r\n");
      out.write("\t \t </form>\r\n");
      out.write("\t  </td>\r\n");
      out.write("\t    \r\n");
      out.write("\t  <td>\r\n");
      out.write("\t  <ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("        <li><a href=\"#\"><span class=\"glyphicon glyphicon-user\"></span> Sign Out</a></li>\r\n");
      out.write("        \r\n");
      out.write("      </ul>\r\n");
      out.write("\t  </td>\r\n");
      out.write("    \r\n");
      out.write(" </tr>\r\n");
      out.write(" \r\n");
      out.write("  </table>\r\n");
      out.write("  </div>\r\n");
      out.write(" </nav>  \r\n");
      out.write("  <br>\r\n");
      out.write(" <br> <br>\r\n");
      out.write(" <br>\r\n");
      out.write("   <!-- --------Top card--------- -->\r\n");
      out.write("    <div id=\"top-card\" class=\"profile-details\">    \r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t<div class=\"col-md-3\">    \t\r\n");
      out.write("\t\t\t<div id=\"profile\" class=\"profile-card profile-picture\">\r\n");
      out.write("\t\t\t\t<img src=\"../resources/images/srav.JPG\" height=\"150\" width=\"150\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\t\t\t\r\n");
      out.write("\t\t<div  >\r\n");
      out.write("\t\t\t <h3>Sravani Gunti</h3>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t</div>\t\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("  \t\t  \t\r\n");
      out.write("  \t<br> \r\n");
      out.write("   \r\n");
      out.write("    <form>\r\n");
      out.write("   \t\t<div class=\"container\">\t\t\t\r\n");
      out.write("\t  \t    <div class=\"well\" style=\"margin-left: 20px;\">\r\n");
      out.write("\t\t\t\t<div><h3>Summary</h3></div>  \t\r\n");
      out.write("\t\t\t\t\t<div align = center>\r\n");
      out.write("\t\t\t                <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userSummary.summary}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("\t\t\t        </div>\t\r\n");
      out.write("\t\t\t\t</div>\t\t \r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t \t</div>\t\r\n");
      out.write("\t\t\t \r\n");
      out.write("\t   \t<br>      \r\n");
      out.write("\t   \t\r\n");
      out.write("\t   \t <div class=\"container\">\r\n");
      out.write("\t   \t <div class=\"well\" style=\"margin-left: 20px;\">\r\n");
      out.write("    \t<div ><h3>Experience</h3></div>  \r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t<!-- Text input-->\r\n");
      out.write("\t\t<div align = center> \r\n");
      out.write("\t\t<label  class=\"control-label col-sm-2\"  for=\"textinput\">Company Name:</label>\r\n");
      out.write("\t\t <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${experience.company_name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("\t\t</div>  \r\n");
      out.write("         <br><br>\r\n");
      out.write("\t\t<div align = center> \r\n");
      out.write("\t\t<label class=\"control-label col-sm-2\" for=\"textinput\">Title:</label>\r\n");
      out.write("\t\t<p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${experience.title}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<br><br>\r\n");
      out.write("\t\t<div align = center> \r\n");
      out.write("\t\t<label class=\"control-label col-sm-2\"  for=\"textinput\">Location:</label>\r\n");
      out.write("\t\t  <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${experience.location}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<br><br>\r\n");
      out.write("\t\t<div align = center> \r\n");
      out.write("\t\t<label  class=\"control-label col-sm-2\"  for=\"textinput\">Description:</label>\t\t   \r\n");
      out.write("        <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${experience.description}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>  \r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<br><br>\t  \r\n");
      out.write("        \t<div align = center>\t\t\t<label></label>\t\t\t</div>\t\t\t<div align = center>\t\t\t<label></label>\t\t\t</div>\t\t\t<div align = center>\t\t\t<label></label>\t\t\t</div>\t\t\t<div align = center>\t\t\t<label></label>\t\t\t</div>\t\t\t<div align = center>\t\t\t<label></label>\t\t\t</div>\t\t\t<div align = center>\t\t\t<label></label>\t\t\t</div>\t\t\t<div align = center>\t\t\t<label></label>\t\t\t</div>\t\t\t<div align = center>\t\t\t<label></label>\t\t\t</div>\t\t\t\t<div align = center>\t\t\t<label></label>\t\t\t</div>\t\t\t<div align = center>\t\t\t<label></label>\t\t\t</div>\t\t\t<div align = center>\t\t\t<label></label>\t\t\t</div>\t\t\t<div align = center>\t\t\t<label></label>\t\t\t</div>\t\t</div>\t\t</div>\t\t\t\t<br><br>        \r\n");
      out.write("          <div class=\"container\">\r\n");
      out.write("\t   \t <div class=\"well\" style=\"margin-left: 20px;\">\r\n");
      out.write("\t\t<div ><h3>Education</h3></div>  \t\t\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t<div align = center> \r\n");
      out.write("\t\t<label class=\"control-label col-sm-2\"  for=\"textinput\">Level:</label>\r\n");
      out.write("\t\t  <p> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${education.level}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>   \r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\t<br><br>\r\n");
      out.write("\t\t<div align = center> \r\n");
      out.write("\t\t<label class=\"control-label col-sm-2\" for=\"textinput\">University Name:</label>\r\n");
      out.write("\t\t     <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${education.univ_name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\t<br><br>\r\n");
      out.write("\t\t<div align = center> \r\n");
      out.write("\t\t<label class=\"control-label col-sm-2\" for=\"textinput\">Field:</label>\r\n");
      out.write("\t\t   <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${education.field}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<br><br>\r\n");
      out.write("\t\t<div align = center> \r\n");
      out.write("\t\t<label class=\"control-label col-sm-2\" for=\"textinput\">Grade:</label>\r\n");
      out.write("\t\t <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${education.grade}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\t<br><br>\r\n");
      out.write("\t\t<div align = center> \r\n");
      out.write("\t\t<label class=\"control-label col-sm-2\" for=\"textinput\">Description:</label><br>\r\n");
      out.write("\t\t<p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${education.description}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\t<br><br>\t      \r\n");
      out.write("         <div align = center>\t\t\t<label></label>\t\t\t</div>\t\t\t<div align = center>\t\t\t<label></label>\t\t\t</div>\t\t\t<div align = center>\t\t\t<label></label>\t\t\t</div>\t\t\t<div align = center>\t\t\t<label></label>\t\t\t</div>\t\t\t<div align = center>\t\t\t<label></label>\t\t\t</div>\t\t\t<div align = center>\t\t\t<label></label>\t\t\t</div>\t\t\t<div align = center>\t\t\t<label></label>\t\t\t</div>\t\t\t<div align = center>\t\t\t<label></label>\t\t\t</div>\t\t\t<div align = center>\t\t\t<label></label>\t\t\t</div>\t\t\t<div align = center>\t\t\t<label></label>\t\t\t</div>\t\t\t<div align = center>\t\t\t<label></label>\t\t\t</div>\t\t</div>\t\t</div>\t\t<br>\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t   \t <div class=\"well\" style=\"margin-left: 20px;\">\r\n");
      out.write("\t\t\t<!-- <div ><h3>Skills</h3></div>\t<br> -->\r\n");
      out.write("\t\t\t<label class=\"control-label col-sm-2\" for=\"textinput\"> Skills:</label> \r\n");
      out.write("\t\t\t                <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${skills.skillset}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("\t\t\t<div align = center>\t\t\t<label></label>\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\t \t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<br>   \t\t\t \r\n");
      out.write("               \r\n");
      out.write("       </form>            \r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
