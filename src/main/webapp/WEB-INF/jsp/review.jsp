<%@page contentType="text/html" pageEncoding="MacRoman"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Bonkai</title>
        <jsp:include page="common_head.jsp" />
    </head>
    <body>
        <div class="centered_content">
            <jsp:include page="common_header.jsp">
                <jsp:param name="title" value="Review Challenge" />
            </jsp:include>

            <%-- Previous context Entries --%>
            <c:forEach var="entry" items="${it.previousContextEntries}">
                <div class="context_entry rounded">${entry.text}</div>
            </c:forEach>

                <div class="central_block">
                    
                    <div class="entry_container">
                        <div class="language ${it.sourceLanguage.language}">${it.sourceLanguage.displayName}</div>
                        <div class="original_entry rounded">${it.originalEntry.text}</div>
                    </div>
                    <div class="entry_container">
                        <div class="language ${it.destinationLanguage.language}">${it.destinationLanguage.displayName}</div>
                        <div class="translated_entry rounded">${it.translatedEntry.text}</div>
                    </div>

                    <div class="submit_buttons">
                        <a class="ok rounded" href="#">I agree.</a>
                        <a class="not_ok rounded" href="#">I do not agree.</a>
                    </div>
               </div>

            <%-- Next context Entries --%>
            <c:forEach var="entry" items="${it.nextContextEntries}">
                <div class="context_entry rounded">${entry.text}</div>
            </c:forEach>
                
        </div>
    </body>
</html>
