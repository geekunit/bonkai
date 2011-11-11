<%-- 
    Document   : translationBlock
    Created on : Nov 10, 2011, 9:42:28 PM
    Author     : pmcosta
--%>

<%@page contentType="text/html" pageEncoding="MacRoman"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=MacRoman">
        <title>Review Challenge</title>
       
        <%-- CSS includes --%>
        <link rel="stylesheet" type="text/css" href="css/base.css" />
       
    </head>
    <body>
        
        <div class="centered_content">

            <div class="title">
                <h1>Review Challenge</h1>
            </div>

            <%-- Previous context Entries --%>
            <c:forEach var="entry" items="${it.previousContextEntries}">
                <div class="context_entry">${entry.text}</div>
            </c:forEach>

                <div id="review_block">
                    
                    <div class="entry_container">
                        <div class="language ${it.sourceLanguage.language}">${it.sourceLanguage.language}</div>
                        <div class="original_entry">${it.originalEntry.text}</div>
                    </div>
                    <div class="entry_container">
                        <div class="language ${it.destinationLanguage.language}">${it.destinationLanguage.language}</div>
                        <div class="translated_entry">${it.translatedEntry.text}</div>
                    </div>

                    <div class="submit_buttons">
                        <a class="ok">I agree.</a>
                        <a class="not_ok">I do not agree.</a>
                    </div>
               </div>

            <%-- Next context Entries --%>
            <c:forEach var="entry" items="${it.nextContextEntries}">
                <div class="context_entry">${entry.text}</div>
            </c:forEach>
        </div>
        
    </body>
</html>
