/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.11
 * Generated at: 2017-05-11 20:48:35 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.SimpleDateFormat;
import utils.connector;
import utils.functions;
import java.sql.ResultSet;
import java.util.ArrayList;
import utils.functions;
import java.text.Format;
import java.sql.Date;
import java.sql.Timestamp;

public final class challenges_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.text.Format");
    _jspx_imports_classes.add("java.sql.ResultSet");
    _jspx_imports_classes.add("java.sql.Timestamp");
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
    _jspx_imports_classes.add("utils.functions");
    _jspx_imports_classes.add("utils.connector");
    _jspx_imports_classes.add("java.util.ArrayList");
    _jspx_imports_classes.add("java.sql.Date");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width = device-width, initial-scale = 1\">\n");
      out.write("        <!-- Bootstrap core CSS -->\n");
      out.write("        <link href=\"http://getbootstrap.com/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <!-- Custom styles for this template -->\n");
      out.write("        <link href=\"cover.css\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"icon\" type=\"image/x-icon\" href=\"/favicon.ico\"/>\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js\"></script>\n");
      out.write("        <title>Galgeleg</title>\n");
      out.write("        <style>\n");
      out.write("            table {\n");
      out.write("                counter-reset: rowNumber;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            table tr.notfirst {\n");
      out.write("                counter-increment: rowNumber;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            table tr.notfirst td:first-child::before {\n");
      out.write("                content: counter(rowNumber);\n");
      out.write("                min-width: 1em;\n");
      out.write("                margin-right: 0.5em;\n");
      out.write("            }\n");
      out.write("            th {\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            String currUser = (String) request.getSession().getAttribute("currUser");
        
      out.write("\n");
      out.write("        <div class=\"site-wrapper\">\n");
      out.write("\n");
      out.write("            <div class=\"site-wrapper-inner\">\n");
      out.write("\n");
      out.write("                <div class=\"cover-container\">\n");
      out.write("\n");
      out.write("                    <div class=\"masthead clearfix\">\n");
      out.write("                        <div class=\"inner\">\n");
      out.write("                            <h3 class=\"masthead-brand\">Galgeleg</h3>\n");
      out.write("                            <nav>\n");
      out.write("                                <ul class=\"nav masthead-nav\">\n");
      out.write("                                    <li><a href=\"admin.jsp\">Admin</a></li>\n");
      out.write("                                    <li><a href=\"game.jsp\">Spil</a></li>\n");
      out.write("                                    <li><a href=\"chat.jsp\">Chat</a></li>\n");
      out.write("                                    <li class=\"active\"><a href=\"#\">Udfordringer</a></li>\n");
      out.write("                                    <li><a href=\"highscore.jsp\">Highscore</a></li>\n");
      out.write("                                    <li><a href=\"logout.jsp\">Log ud</a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </nav>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    </br>\n");
      out.write("                    <div class=\"inner cover\">\n");
      out.write("                        <h1 class=\"cover-heading\">Challenges</h1>\n");
      out.write("                        <hr/>\n");
      out.write("                        <div id=\"tab\" class=\"container\">\t\n");
      out.write("                            <ul  class=\"nav nav-pills\">\n");
      out.write("                                <li class=\"active\">\n");
      out.write("                                    <a  href=\"#1b\" data-toggle=\"tab\">Send udfordring</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li><a href=\"#2b\" data-toggle=\"tab\">Sendte udfordringer</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li><a href=\"#3b\" data-toggle=\"tab\">Mine udfordringer</a>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("\n");
      out.write("                            <div class=\"tab-content clearfix\">\n");
      out.write("                                <div class=\"tab-pane active\" id=\"1b\">\n");
      out.write("                                    <table style=\"width:850px\" class=\"lead\">\n");
      out.write("                                        <tr class=\"a\">\n");
      out.write("                                            <th>Navn</th>\n");
      out.write("                                            <th>Efternavn</th>\n");
      out.write("                                            <th></th>\n");
      out.write("                                        </tr>\n");
      out.write("                                        ");

                                            connector con = new connector();
                                            
                                            ResultSet rUser = con.select("SELECT sid,name,surname FROM users");
                                            while (rUser.next()) {
                                                if(!con.check("SELECT p1,p2 FROM challenges WHERE p1='"+currUser+"' "
                                                        + "AND p2='" + rUser.getString("sid")+ "' AND acceptchl=0")){
                                                    out.println("<tr>");
                                                    out.println("<form action='ChallengeServlet' method='post' style='margin:5px 0px;'>");
                                                    out.print("<td>" + rUser.getString("name") + "</td>");
                                                    out.print("<td>" + rUser.getString("surname") + "</td>"); 
      out.write("\n");
      out.write("                                                    <input type=\"hidden\" name=\"sid\" value=\"");
  out.print(rUser.getString("sid")); 
      out.write("\" />\n");
      out.write("                                                    <td style='width:350px;margin-left:-150px;'>\n");
      out.write("                                                        <input type='submit'>\n");
      out.write("                                                    </td>\n");
      out.write("                                                    ");

                                                    out.println("</form>");
                                                    out.println("</tr>");
                                                }
                                            }
                                        
      out.write("\n");
      out.write("\n");
      out.write("                                    </table>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"tab-pane\" id=\"2b\">\n");
      out.write("                                    <table style=\"width:850px\" class=\"lead\">\n");
      out.write("                                        <tr class=\"a\">\n");
      out.write("                                            <th>Studienummer</th>\n");
      out.write("                                            <th>Tidspunkt</th>\n");
      out.write("                                            <th></th>\n");
      out.write("                                        </tr>\n");
      out.write("                                        ");

                                            ResultSet cUser = con.select("SELECT p2,timestamp FROM challenges WHERE p1 ='"+currUser+"'");
                                            
                                            while (cUser.next()) {
                                                out.println("<tr>");
                                                out.println("<form action='ChallengeServlet' method='post' style='margin:5px 0px;'>");
                                                out.print("<td>" + cUser.getString("p2") + "</td>");
                                                Timestamp stamp = new Timestamp(cUser.getInt("timestamp")*1000L);
                                                Date date = new Date(stamp.getTime());
                                                Format format = new SimpleDateFormat("dd/MM-yyyy HH:mm");
                                                out.print("<td>"+format.format(date)+"</td>");
                                                                                                
                                                out.println("</form>");
                                                out.println("</tr>");
                                            }
                                        
      out.write("\n");
      out.write("\n");
      out.write("                                    </table>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"tab-pane\" id=\"3b\">\n");
      out.write("                                    \n");
      out.write("                                     <table style=\"width:850px\" class=\"lead\">\n");
      out.write("                                        <tr class=\"a\">\n");
      out.write("                                            <th>Navn</th>\n");
      out.write("                                            <th>Dato</th>\n");
      out.write("                                            <th></th>\n");
      out.write("                                        </tr>\n");
      out.write("                                        ");

                                            ResultSet myChallenges = con.select("SELECT challenges.id,p1,users.name,timestamp FROM challenges INNER JOIN users ON p1=users.sid WHERE p2='"+currUser+"' AND acceptchl=0");
                                            
                                            while (myChallenges.next()) {
                                                    out.println("<tr>");
                                                    out.println("<form action='AcceptChallengeServlet' method='post' style='margin:5px 0px;'>");
                                                    out.print("<td>" + myChallenges.getString("users.name") + "</td>");
                                                    Timestamp stamp = new Timestamp(myChallenges.getInt("timestamp")*1000L);
                                                    Date date = new Date(stamp.getTime());
                                                    Format format = new SimpleDateFormat("dd/MM-yyyy HH:mm");
                                                    out.print("<td>"+format.format(date)+"</td>");
                                                     
      out.write("\n");
      out.write("                                                    <input type=\"hidden\" name=\"id\" value=\"");
  out.print(myChallenges.getString("challenges.id")); 
      out.write("\" />\n");
      out.write("                                                    <td style='width:350px;margin-left:-150px;'>\n");
      out.write("                                                        <input type='submit' value=\"Accepter\" >\n");
      out.write("                                                    </td>\n");
      out.write("                                                    ");

                                                    out.println("</form>");
                                                    out.println("</tr>");
                                                }
                                            
                                        
      out.write("\n");
      out.write("\n");
      out.write("                                    </table>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"mastfoot\">\n");
      out.write("                    <div class=\"inner\">\n");
      out.write("                        <p>Lavet af gruppe <a href=\"http://tourneo.dk/\">TS</a></p>\n");
      out.write("                    </div\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("</body>\n");
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
