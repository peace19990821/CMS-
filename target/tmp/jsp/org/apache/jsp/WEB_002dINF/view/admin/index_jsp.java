/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.4.9.v20180320
 * Generated at: 2020-02-18 03:54:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("file:/D:/tools/repository/org/apache/taglibs/taglibs-standard-impl/1.2.5/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1567840054114L));
    _jspx_dependants.put("jar:file:/D:/tools/repository/org/apache/taglibs/taglibs-standard-impl/1.2.5/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425949870000L));
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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"/resource/js/jquery-3.2.1.js\"></script>\r\n");
      out.write("<link href=\"/resource/css/bootstrap.css\" rel=\"stylesheet\">\r\n");
      out.write("<title>CMS后台管理系统</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("\t<!-- header -->\r\n");
      out.write("\t<div class=\"row\" style=\"height: 80px;margin-top: 20px\">\r\n");
      out.write("\t\t<div class=\"col-md-12\" style=\"background-color: skyblue\">\r\n");
      out.write("\t\t\t<img alt=\"\" src=\"/resource/images/logo.png\" style=\"height: 80px;\" class=\"rounded-circle\">\r\n");
      out.write("\t\t\t<font color=\"red\">CMS后台管理</font>\r\n");
      out.write("\t\t\t<span>\r\n");
      out.write("\t\t\t\t<font color=\"white\"> 登录人:");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.admin.username }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</font>\r\n");
      out.write("\t\t\t\t <a href=\"/passport/logout\">注销</a>\r\n");
      out.write("\t\t\t</span>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<hr style=\"height: 2px;border: none;border-top: 2px dotted #185598;\">\r\n");
      out.write("\t<div class=\"row\" style=\"height: 550px;margin-top: 20px\">\r\n");
      out.write("\t\t<!-- 中间区域 -->\r\n");
      out.write("\t\t<div class=\"col-md-3\" style=\"background-color: #ccc\">\r\n");
      out.write("\t\t\t<div style=\"margin-top: 18px;\">\r\n");
      out.write("\t\t\t\t<!-- As a link -->\r\n");
      out.write("\t\t\t\t<nav class=\"navbar navbar-light bg-light\">\r\n");
      out.write("\t \t\t\t\t <a class=\"navbar-brand\" href=\"#\" data=\"/admin/user/selects\">用户管理</a>\r\n");
      out.write("\t\t\t\t</nav>\r\n");
      out.write("\t\t\t\t<nav class=\"navbar navbar-light bg-light\" style=\"margin-top: 10px;\">\r\n");
      out.write("\t \t\t\t\t <a class=\"navbar-brand\" href=\"#\" data=\"/admin/article/selects\">文章管理</a>\r\n");
      out.write("\t\t\t\t</nav>\r\n");
      out.write("\t\t\t\t<nav class=\"navbar navbar-light bg-light\" style=\"margin-top: 10px;\">\r\n");
      out.write("\t \t\t\t\t <a class=\"navbar-brand\" href=\"#\" data=\"/admin/article/complains\">举报管理</a>\r\n");
      out.write("\t\t\t\t</nav>\r\n");
      out.write("\t\t\t\t<nav class=\"navbar navbar-light bg-light\" style=\"margin-top: 10px;\">\r\n");
      out.write("\t \t\t\t\t <a class=\"navbar-brand\" href=\"#\">栏目管理</a>\r\n");
      out.write("\t\t\t\t</nav>\r\n");
      out.write("\t\t\t\t<nav class=\"navbar navbar-light bg-light\" style=\"margin-top: 10px;\">\r\n");
      out.write("\t \t\t\t\t <a class=\"navbar-brand\" href=\"#\">分类管理</a>\r\n");
      out.write("\t\t\t\t</nav>\r\n");
      out.write("\t\t\t\t<nav class=\"navbar navbar-light bg-light\" style=\"margin-top: 10px;\">\r\n");
      out.write("\t \t\t\t\t <a class=\"navbar-brand\" href=\"#\">系统管理</a>\r\n");
      out.write("\t\t\t\t</nav>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- 中间内容区域 -->\r\n");
      out.write("\t\t<div class=\"col-md-9\" id=\"center\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(function () {\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 默认显示用户列表\r\n");
      out.write("\t\t$(\"#center\").load(\"/admin/user/selects\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t/* 为a标签添加点击事件 */\r\n");
      out.write("\t\t$(\"a\").click(function () {\r\n");
      out.write("\t\t\t var url = $(this).attr(\"data\");\r\n");
      out.write("\t\t\t $(\"a\").removeClass(\"list-group-item-info\");\r\n");
      out.write("\t\t\t // 为点击的a标签添加点击样式\r\n");
      out.write("\t\t\t $(this).addClass(\"list-group-item-info\");\r\n");
      out.write("\t\t\t // 在中间区域加载url\r\n");
      out.write("\t\t\t $(\"#center\").load(url);\r\n");
      out.write("\t\t})\t\r\n");
      out.write("\t})\r\n");
      out.write("</script>\r\n");
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
