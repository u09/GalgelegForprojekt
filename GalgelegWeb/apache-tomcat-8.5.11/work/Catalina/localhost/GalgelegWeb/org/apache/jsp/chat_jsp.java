/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.11
 * Generated at: 2017-05-03 12:20:18 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import utils.connector;
import utils.functions;
import java.sql.ResultSet;
import java.util.ArrayList;

public final class chat_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("java.sql.ResultSet");
    _jspx_imports_classes.add("utils.functions");
    _jspx_imports_classes.add("utils.connector");
    _jspx_imports_classes.add("java.util.ArrayList");
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

String currName = (String) request.getSession().getAttribute("currName");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width = device-width, initial-scale = 1\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://getbootstrap.com/dist/css/bootstrap.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"cover.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"ajax.js\"></script>\n");
      out.write("        <script>\n");
      out.write("        function escapeHtml(text) {\n");
      out.write("            return text.replace(/&/g, \"&amp;\").replace(/</g, \"&lt;\").replace(/>/g, \"&gt;\").replace(/\"/g, \"&quot;\").replace(/'/g, \"&#039;\");\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        function setMsg(msg,sid,time)\n");
      out.write("        {\n");
      out.write("            $(\"div#chatbox\").append(\"<div class='mesg'><div class='name'>\"+sid+\":<span style='margin-left:1em'> </span></div><div class='msg'>\"+escapeHtml(msg)+\"</div></div><br/>\");\n");
      out.write("            $(\"#chatbox\").scrollTop($(\"#chatbox\").prop(\"scrollHeight\"));\n");
      out.write("        \n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        $(\"document\").ready(function(){\n");
      out.write("            $(\"form\").submit(function(){\n");
      out.write("                setMsg($(this).find(\"#usermsg\").val(),\"");
      out.print(currName);
      out.write("\",new Date() / 1000 | 0);\n");
      out.write("                $(\"#usermsg\").val(\"\");\n");
      out.write("            });\n");
      out.write("        });\n");
      out.write("        \n");
      out.write("        setInterval(function(){\n");
      out.write("            var date = (new Date() / 1000 | 0)-3;\n");
      out.write("            $.ajax({\n");
      out.write("                cache:false,\n");
      out.write("                type:\"POST\",\n");
      out.write("                dataType: \"json\",\n");
      out.write("                url:\"ChatServlet\",\n");
      out.write("                data:{type:\"getmessage\",date:date},\n");
      out.write("                success:function(data)\n");
      out.write("                {\n");
      out.write("                    for(var i=1; i<=data[0].length; i++) {\n");
      out.write("                        setMsg(data[1][i-1],data[0][i-1],data[2][i-1]);\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        },3000);\n");
      out.write("        </script>\n");
      out.write("        <link rel=\"icon\" type=\"image/x-icon\" href=\"/favicon.ico\"/>\n");
      out.write("        <title>Galgeleg</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <div class=\"site-wrapper\">\n");
      out.write("        <div class=\"site-wrapper-inner\">\n");
      out.write("            <div class=\"cover-container\">\n");
      out.write("                <div class=\"masthead clearfix\">\n");
      out.write("                    <div class=\"inner\">\n");
      out.write("                        <h3 class=\"masthead-brand\">Galgeleg</h3>\n");
      out.write("                        <nav>\n");
      out.write("                            <ul class=\"nav masthead-nav\">\n");
      out.write("                                <li><a href=\"admin.jsp\">Admin</a></li>\n");
      out.write("                                <li><a href=\"game.jsp\">Spil</a></li>\n");
      out.write("                                <li class=\"active\"><a href=\"#\">Chat</a></li>\n");
      out.write("                                <li><a href=\"challenges.jsp\">Chall</a></li>\n");
      out.write("                                <li><a href=\"highscore.jsp\">Highscore</a></li>\n");
      out.write("                                <li><a href=\"logout.jsp\">Log ud</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </nav>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <br/>\n");
      out.write("                <div class=\"inner cover\">\n");
      out.write("                    <h1>Chat</h1>\n");
      out.write("                    <div id=\"menu\">\n");
      out.write("                        <p class=\"welcome\">Galgelegs Chat <b></b></p>\n");
      out.write("                        <div style=\"clear:both\"></div>\n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"chatbox\" style=\"width:50%; height:500px; margin:auto; border:2px solid #929391; border-radius:20px;\"></div>\n");
      out.write("                    <br/>\n");
      out.write("                    <form action=\"ChatServlet\" method=\"post\" class=\"ajax\">\n");
      out.write("                        <input name=\"usermsg\" type=\"text\" id=\"usermsg\" style=\"width:400px\" />\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-lg btn-primary\" style=\"width:100px;\">Send</button>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"mastfoot\">\n");
      out.write("                    <div class=\"inner\">\n");
      out.write("                        <p>Lavet af gruppe <a href=\"http://quickconnect.dk/\">TS</a></p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
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
