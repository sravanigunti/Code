<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleServiceProxyid" scope="session" class="Connection.ServiceProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleServiceProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleServiceProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleServiceProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        Connection.Service getService10mtemp = sampleServiceProxyid.getService();
if(getService10mtemp == null){
%>
<%=getService10mtemp %>
<%
}else{
        if(getService10mtemp!= null){
        String tempreturnp11 = getService10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String username_1id=  request.getParameter("username16");
            java.lang.String username_1idTemp = null;
        if(!username_1id.equals("")){
         username_1idTemp  = username_1id;
        }
        String password_2id=  request.getParameter("password18");
            java.lang.String password_2idTemp = null;
        if(!password_2id.equals("")){
         password_2idTemp  = password_2id;
        }
        int getUserId13mtemp = sampleServiceProxyid.getUserId(username_1idTemp,password_2idTemp);
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getUserId13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
break;
case 20:
        gotMethod = true;
        String username_3id=  request.getParameter("username23");
            java.lang.String username_3idTemp = null;
        if(!username_3id.equals("")){
         username_3idTemp  = username_3id;
        }
        String email_4id=  request.getParameter("email25");
            java.lang.String email_4idTemp = null;
        if(!email_4id.equals("")){
         email_4idTemp  = email_4id;
        }
        String password_5id=  request.getParameter("password27");
            java.lang.String password_5idTemp = null;
        if(!password_5id.equals("")){
         password_5idTemp  = password_5id;
        }
        java.lang.String signUp20mtemp = sampleServiceProxyid.signUp(username_3idTemp,email_4idTemp,password_5idTemp);
if(signUp20mtemp == null){
%>
<%=signUp20mtemp %>
<%
}else{
        String tempResultreturnp21 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(signUp20mtemp));
        %>
        <%= tempResultreturnp21 %>
        <%
}
break;
case 29:
        gotMethod = true;
        String userId_6id=  request.getParameter("userId32");
        int userId_6idTemp  = Integer.parseInt(userId_6id);
        java.lang.String getUserNameById29mtemp = sampleServiceProxyid.getUserNameById(userId_6idTemp);
if(getUserNameById29mtemp == null){
%>
<%=getUserNameById29mtemp %>
<%
}else{
        String tempResultreturnp30 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getUserNameById29mtemp));
        %>
        <%= tempResultreturnp30 %>
        <%
}
break;
case 34:
        gotMethod = true;
        String username_7id=  request.getParameter("username37");
            java.lang.String username_7idTemp = null;
        if(!username_7id.equals("")){
         username_7idTemp  = username_7id;
        }
        String password_8id=  request.getParameter("password39");
            java.lang.String password_8idTemp = null;
        if(!password_8id.equals("")){
         password_8idTemp  = password_8id;
        }
        java.lang.String signIn34mtemp = sampleServiceProxyid.signIn(username_7idTemp,password_8idTemp);
if(signIn34mtemp == null){
%>
<%=signIn34mtemp %>
<%
}else{
        String tempResultreturnp35 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(signIn34mtemp));
        %>
        <%= tempResultreturnp35 %>
        <%
}
break;
case 41:
        gotMethod = true;
        String field_9id=  request.getParameter("field44");
            java.lang.String field_9idTemp = null;
        if(!field_9id.equals("")){
         field_9idTemp  = field_9id;
        }
        String level_10id=  request.getParameter("level46");
            java.lang.String level_10idTemp = null;
        if(!level_10id.equals("")){
         level_10idTemp  = level_10id;
        }
        String univname_11id=  request.getParameter("univname48");
            java.lang.String univname_11idTemp = null;
        if(!univname_11id.equals("")){
         univname_11idTemp  = univname_11id;
        }
        String grade_12id=  request.getParameter("grade50");
        int grade_12idTemp  = Integer.parseInt(grade_12id);
        String description_13id=  request.getParameter("description52");
            java.lang.String description_13idTemp = null;
        if(!description_13id.equals("")){
         description_13idTemp  = description_13id;
        }
        String userId_14id=  request.getParameter("userId54");
        int userId_14idTemp  = Integer.parseInt(userId_14id);
        java.lang.String insertEducation41mtemp = sampleServiceProxyid.insertEducation(field_9idTemp,level_10idTemp,univname_11idTemp,grade_12idTemp,description_13idTemp,userId_14idTemp);
if(insertEducation41mtemp == null){
%>
<%=insertEducation41mtemp %>
<%
}else{
        String tempResultreturnp42 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(insertEducation41mtemp));
        %>
        <%= tempResultreturnp42 %>
        <%
}
break;
case 56:
        gotMethod = true;
        String companyName_15id=  request.getParameter("companyName59");
            java.lang.String companyName_15idTemp = null;
        if(!companyName_15id.equals("")){
         companyName_15idTemp  = companyName_15id;
        }
        String userId_16id=  request.getParameter("userId61");
        int userId_16idTemp  = Integer.parseInt(userId_16id);
        String title_17id=  request.getParameter("title63");
            java.lang.String title_17idTemp = null;
        if(!title_17id.equals("")){
         title_17idTemp  = title_17id;
        }
        String location_18id=  request.getParameter("location65");
            java.lang.String location_18idTemp = null;
        if(!location_18id.equals("")){
         location_18idTemp  = location_18id;
        }
        String description_19id=  request.getParameter("description67");
            java.lang.String description_19idTemp = null;
        if(!description_19id.equals("")){
         description_19idTemp  = description_19id;
        }
        java.lang.String insertExperience56mtemp = sampleServiceProxyid.insertExperience(companyName_15idTemp,userId_16idTemp,title_17idTemp,location_18idTemp,description_19idTemp);
if(insertExperience56mtemp == null){
%>
<%=insertExperience56mtemp %>
<%
}else{
        String tempResultreturnp57 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(insertExperience56mtemp));
        %>
        <%= tempResultreturnp57 %>
        <%
}
break;
case 69:
        gotMethod = true;
        String summary_20id=  request.getParameter("summary72");
            java.lang.String summary_20idTemp = null;
        if(!summary_20id.equals("")){
         summary_20idTemp  = summary_20id;
        }
        String userId_21id=  request.getParameter("userId74");
        int userId_21idTemp  = Integer.parseInt(userId_21id);
        java.lang.String insertSummary69mtemp = sampleServiceProxyid.insertSummary(summary_20idTemp,userId_21idTemp);
if(insertSummary69mtemp == null){
%>
<%=insertSummary69mtemp %>
<%
}else{
        String tempResultreturnp70 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(insertSummary69mtemp));
        %>
        <%= tempResultreturnp70 %>
        <%
}
break;
case 76:
        gotMethod = true;
        String skills_22id=  request.getParameter("skills79");
            java.lang.String skills_22idTemp = null;
        if(!skills_22id.equals("")){
         skills_22idTemp  = skills_22id;
        }
        String userId_23id=  request.getParameter("userId81");
        int userId_23idTemp  = Integer.parseInt(userId_23id);
        java.lang.String insertSkills76mtemp = sampleServiceProxyid.insertSkills(skills_22idTemp,userId_23idTemp);
if(insertSkills76mtemp == null){
%>
<%=insertSkills76mtemp %>
<%
}else{
        String tempResultreturnp77 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(insertSkills76mtemp));
        %>
        <%= tempResultreturnp77 %>
        <%
}
break;
case 83:
        gotMethod = true;
        String userId_24id=  request.getParameter("userId104");
        int userId_24idTemp  = Integer.parseInt(userId_24id);
        Connection.Education getEducationById83mtemp = sampleServiceProxyid.getEducationById(userId_24idTemp);
if(getEducationById83mtemp == null){
%>
<%=getEducationById83mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">level:</TD>
<TD>
<%
if(getEducationById83mtemp != null){
java.lang.String typelevel86 = getEducationById83mtemp.getLevel();
        String tempResultlevel86 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typelevel86));
        %>
        <%= tempResultlevel86 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">end_date:</TD>
<TD>
<%
if(getEducationById83mtemp != null){
java.util.Calendar typeend_date88 = getEducationById83mtemp.getEnd_date();
        java.text.DateFormat dateFormatend_date88 = java.text.DateFormat.getDateInstance();
        java.util.Date dateend_date88 = typeend_date88.getTime();
        String tempResultend_date88 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatend_date88.format(dateend_date88));
        %>
        <%= tempResultend_date88 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">id:</TD>
<TD>
<%
if(getEducationById83mtemp != null){
%>
<%=getEducationById83mtemp.getId()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">grade:</TD>
<TD>
<%
if(getEducationById83mtemp != null){
%>
<%=getEducationById83mtemp.getGrade()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">start_date:</TD>
<TD>
<%
if(getEducationById83mtemp != null){
java.util.Calendar typestart_date94 = getEducationById83mtemp.getStart_date();
        java.text.DateFormat dateFormatstart_date94 = java.text.DateFormat.getDateInstance();
        java.util.Date datestart_date94 = typestart_date94.getTime();
        String tempResultstart_date94 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatstart_date94.format(datestart_date94));
        %>
        <%= tempResultstart_date94 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">field:</TD>
<TD>
<%
if(getEducationById83mtemp != null){
java.lang.String typefield96 = getEducationById83mtemp.getField();
        String tempResultfield96 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typefield96));
        %>
        <%= tempResultfield96 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">univ_name:</TD>
<TD>
<%
if(getEducationById83mtemp != null){
java.lang.String typeuniv_name98 = getEducationById83mtemp.getUniv_name();
        String tempResultuniv_name98 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeuniv_name98));
        %>
        <%= tempResultuniv_name98 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">description:</TD>
<TD>
<%
if(getEducationById83mtemp != null){
java.lang.String typedescription100 = getEducationById83mtemp.getDescription();
        String tempResultdescription100 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescription100));
        %>
        <%= tempResultdescription100 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">user_id:</TD>
<TD>
<%
if(getEducationById83mtemp != null){
%>
<%=getEducationById83mtemp.getUser_id()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 106:
        gotMethod = true;
        String userId_25id=  request.getParameter("userId123");
        int userId_25idTemp  = Integer.parseInt(userId_25id);
        Connection.Users getSummaryById106mtemp = sampleServiceProxyid.getSummaryById(userId_25idTemp);
if(getSummaryById106mtemp == null){
%>
<%=getSummaryById106mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">user_id:</TD>
<TD>
<%
if(getSummaryById106mtemp != null){
%>
<%=getSummaryById106mtemp.getUser_id()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">email_id:</TD>
<TD>
<%
if(getSummaryById106mtemp != null){
java.lang.String typeemail_id111 = getSummaryById106mtemp.getEmail_id();
        String tempResultemail_id111 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeemail_id111));
        %>
        <%= tempResultemail_id111 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">summary:</TD>
<TD>
<%
if(getSummaryById106mtemp != null){
java.lang.String typesummary113 = getSummaryById106mtemp.getSummary();
        String tempResultsummary113 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typesummary113));
        %>
        <%= tempResultsummary113 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">password:</TD>
<TD>
<%
if(getSummaryById106mtemp != null){
java.lang.String typepassword115 = getSummaryById106mtemp.getPassword();
        String tempResultpassword115 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepassword115));
        %>
        <%= tempResultpassword115 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">lastLoginDate:</TD>
<TD>
<%
if(getSummaryById106mtemp != null){
java.lang.String typelastLoginDate117 = getSummaryById106mtemp.getLastLoginDate();
        String tempResultlastLoginDate117 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typelastLoginDate117));
        %>
        <%= tempResultlastLoginDate117 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">loginFlag:</TD>
<TD>
<%
if(getSummaryById106mtemp != null){
java.lang.String typeloginFlag119 = getSummaryById106mtemp.getLoginFlag();
        String tempResultloginFlag119 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeloginFlag119));
        %>
        <%= tempResultloginFlag119 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">username:</TD>
<TD>
<%
if(getSummaryById106mtemp != null){
java.lang.String typeusername121 = getSummaryById106mtemp.getUsername();
        String tempResultusername121 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeusername121));
        %>
        <%= tempResultusername121 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 125:
        gotMethod = true;
        String userId_26id=  request.getParameter("userId134");
        int userId_26idTemp  = Integer.parseInt(userId_26id);
        Connection.Skills getSkillsById125mtemp = sampleServiceProxyid.getSkillsById(userId_26idTemp);
if(getSkillsById125mtemp == null){
%>
<%=getSkillsById125mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">user_id:</TD>
<TD>
<%
if(getSkillsById125mtemp != null){
%>
<%=getSkillsById125mtemp.getUser_id()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">skillset:</TD>
<TD>
<%
if(getSkillsById125mtemp != null){
java.lang.String typeskillset130 = getSkillsById125mtemp.getSkillset();
        String tempResultskillset130 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeskillset130));
        %>
        <%= tempResultskillset130 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">id:</TD>
<TD>
<%
if(getSkillsById125mtemp != null){
%>
<%=getSkillsById125mtemp.getId()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 136:
        gotMethod = true;
        String text_27id=  request.getParameter("text139");
            java.lang.String text_27idTemp = null;
        if(!text_27id.equals("")){
         text_27idTemp  = text_27id;
        }
        java.lang.String[] getAllUsers136mtemp = sampleServiceProxyid.getAllUsers(text_27idTemp);
if(getAllUsers136mtemp == null){
%>
<%=getAllUsers136mtemp %>
<%
}else{
        String tempreturnp137 = null;
        if(getAllUsers136mtemp != null){
        java.util.List listreturnp137= java.util.Arrays.asList(getAllUsers136mtemp);
        tempreturnp137 = listreturnp137.toString();
        }
        %>
        <%=tempreturnp137%>
        <%
}
break;
case 141:
        gotMethod = true;
        String username_28id=  request.getParameter("username144");
            java.lang.String username_28idTemp = null;
        if(!username_28id.equals("")){
         username_28idTemp  = username_28id;
        }
        int getUserIdByName141mtemp = sampleServiceProxyid.getUserIdByName(username_28idTemp);
        String tempResultreturnp142 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getUserIdByName141mtemp));
        %>
        <%= tempResultreturnp142 %>
        <%
break;
case 146:
        gotMethod = true;
        String fromId_29id=  request.getParameter("fromId149");
        int fromId_29idTemp  = Integer.parseInt(fromId_29id);
        String toId_30id=  request.getParameter("toId151");
        int toId_30idTemp  = Integer.parseInt(toId_30id);
        java.lang.String sendInvitations146mtemp = sampleServiceProxyid.sendInvitations(fromId_29idTemp,toId_30idTemp);
if(sendInvitations146mtemp == null){
%>
<%=sendInvitations146mtemp %>
<%
}else{
        String tempResultreturnp147 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(sendInvitations146mtemp));
        %>
        <%= tempResultreturnp147 %>
        <%
}
break;
case 153:
        gotMethod = true;
        String userId_31id=  request.getParameter("userId156");
        int userId_31idTemp  = Integer.parseInt(userId_31id);
        int getConnectionID153mtemp = sampleServiceProxyid.getConnectionID(userId_31idTemp);
        String tempResultreturnp154 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getConnectionID153mtemp));
        %>
        <%= tempResultreturnp154 %>
        <%
break;
case 158:
        gotMethod = true;
        String data_32id=  request.getParameter("data161");
            java.lang.String data_32idTemp = null;
        if(!data_32id.equals("")){
         data_32idTemp  = data_32id;
        }
        java.lang.String getMD5158mtemp = sampleServiceProxyid.getMD5(data_32idTemp);
if(getMD5158mtemp == null){
%>
<%=getMD5158mtemp %>
<%
}else{
        String tempResultreturnp159 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getMD5158mtemp));
        %>
        <%= tempResultreturnp159 %>
        <%
}
break;
case 163:
        gotMethod = true;
        String userId_33id=  request.getParameter("userId178");
        int userId_33idTemp  = Integer.parseInt(userId_33id);
        Connection.Experience getExperienceById163mtemp = sampleServiceProxyid.getExperienceById(userId_33idTemp);
if(getExperienceById163mtemp == null){
%>
<%=getExperienceById163mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">company_name:</TD>
<TD>
<%
if(getExperienceById163mtemp != null){
java.lang.String typecompany_name166 = getExperienceById163mtemp.getCompany_name();
        String tempResultcompany_name166 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typecompany_name166));
        %>
        <%= tempResultcompany_name166 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">user_id:</TD>
<TD>
<%
if(getExperienceById163mtemp != null){
%>
<%=getExperienceById163mtemp.getUser_id()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">location:</TD>
<TD>
<%
if(getExperienceById163mtemp != null){
java.lang.String typelocation170 = getExperienceById163mtemp.getLocation();
        String tempResultlocation170 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typelocation170));
        %>
        <%= tempResultlocation170 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">description:</TD>
<TD>
<%
if(getExperienceById163mtemp != null){
java.lang.String typedescription172 = getExperienceById163mtemp.getDescription();
        String tempResultdescription172 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescription172));
        %>
        <%= tempResultdescription172 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">title:</TD>
<TD>
<%
if(getExperienceById163mtemp != null){
java.lang.String typetitle174 = getExperienceById163mtemp.getTitle();
        String tempResulttitle174 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typetitle174));
        %>
        <%= tempResulttitle174 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">id:</TD>
<TD>
<%
if(getExperienceById163mtemp != null){
%>
<%=getExperienceById163mtemp.getId()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 180:
        gotMethod = true;
        String userId_34id=  request.getParameter("userId183");
        int userId_34idTemp  = Integer.parseInt(userId_34id);
        java.lang.String[] displayInvitation180mtemp = sampleServiceProxyid.displayInvitation(userId_34idTemp);
if(displayInvitation180mtemp == null){
%>
<%=displayInvitation180mtemp %>
<%
}else{
        String tempreturnp181 = null;
        if(displayInvitation180mtemp != null){
        java.util.List listreturnp181= java.util.Arrays.asList(displayInvitation180mtemp);
        tempreturnp181 = listreturnp181.toString();
        }
        %>
        <%=tempreturnp181%>
        <%
}
break;
case 185:
        gotMethod = true;
        String connectionId_35id=  request.getParameter("connectionId188");
        int connectionId_35idTemp  = Integer.parseInt(connectionId_35id);
        java.lang.String acceptInvitations185mtemp = sampleServiceProxyid.acceptInvitations(connectionId_35idTemp);
if(acceptInvitations185mtemp == null){
%>
<%=acceptInvitations185mtemp %>
<%
}else{
        String tempResultreturnp186 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(acceptInvitations185mtemp));
        %>
        <%= tempResultreturnp186 %>
        <%
}
break;
case 190:
        gotMethod = true;
        String connectionId_36id=  request.getParameter("connectionId193");
        int connectionId_36idTemp  = Integer.parseInt(connectionId_36id);
        java.lang.String rejectInvitations190mtemp = sampleServiceProxyid.rejectInvitations(connectionId_36idTemp);
if(rejectInvitations190mtemp == null){
%>
<%=rejectInvitations190mtemp %>
<%
}else{
        String tempResultreturnp191 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(rejectInvitations190mtemp));
        %>
        <%= tempResultreturnp191 %>
        <%
}
break;
case 195:
        gotMethod = true;
        String userId_37id=  request.getParameter("userId198");
        int userId_37idTemp  = Integer.parseInt(userId_37id);
        java.lang.String[] displayConnections195mtemp = sampleServiceProxyid.displayConnections(userId_37idTemp);
if(displayConnections195mtemp == null){
%>
<%=displayConnections195mtemp %>
<%
}else{
        String tempreturnp196 = null;
        if(displayConnections195mtemp != null){
        java.util.List listreturnp196= java.util.Arrays.asList(displayConnections195mtemp);
        tempreturnp196 = listreturnp196.toString();
        }
        %>
        <%=tempreturnp196%>
        <%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>