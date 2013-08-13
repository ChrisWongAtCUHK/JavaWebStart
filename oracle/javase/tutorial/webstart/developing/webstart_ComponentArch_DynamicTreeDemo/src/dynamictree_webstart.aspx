<%@ Page Language="C#" aspcompat=true %>
<%@ Import Namespace="System" %>
<%@ Import Namespace="System.Data" %>
<%@ Import Namespace="System.Web" %>
<%
	int loop1, loop2;
	// Load NameValueCollection object.
	NameValueCollection coll=Request.QueryString; 
	// Get names of all keys into a string array.
	String[] arr1 = coll.AllKeys;
	for (loop1 = 0; loop1 < arr1.Length; loop1++) {
		//Response.Write("Key: " + Server.HtmlEncode(arr1[loop1]) + "<br>");
		String[] arr2 = coll.GetValues(arr1[loop1]);
		for (loop2 = 0; loop2 < arr2.Length; loop2++) {
		  //Response.Write("Value " + loop2 + ": " + Server.HtmlEncode(arr2[loop2]) + "<br>");
		}
	}
	String languageCode = Server.HtmlEncode(coll.GetValues(arr1[0])[0]);
	//Response.Write("languageCode :" + languageCode + "<br>");
	Response.ContentType = "application/x-java-jnlp-file";
	String jnlphref = "dynamictree_webstart.aspx?languageCode=" + languageCode;
%>
<?xml version="1.0" encoding="UTF-8"?>
<jnlp spec="1.0+" 
        codebase="http://uat22/JavaWebStart/DynamicTreeDemo"
        href=<%= jnlphref %> >
    <information>
        <title>Dynamic Tree Demo</title>
        <vendor>Dynamic Team</vendor>
    </information>
	<security>
		<j2ee-application-client-permissions />
	</security>
  
    <resources>
        <!-- Application Resources -->
        <j2se version="1.7+"
              href="http://java.sun.com/products/autodl/j2se"/>
        <jar href="DynamicTreeDemo.jar" main="true" />
		<property name="test" value="accost" />
    </resources>
    <application-desc
         name="Dynamic Tree Demo Application"
         main-class="webstartComponentArch.DynamicTreeApplication">
		<argument><%= "languageCode" %></argument>
		<argument><%= languageCode %></argument>
     </application-desc>
     <update check="background"/>
</jnlp>

