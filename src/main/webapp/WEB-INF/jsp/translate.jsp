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
                <jsp:param name="title" value="Translate Challenge" />
            </jsp:include>
            
            <%-- Previous context Entries --%>
            <c:forEach var="entry" items="${it.previousContextEntries}">
                <div class="context_entry rounded">${entry.text}</div>
            </c:forEach>

                <div class="central_block">
                    <div class="entry_container">
                        <div class="language">
                            <div class="language_flag h_align ${it.sourceLanguage.language}"></div>
                            <div class="language_name h_align">${it.sourceLanguage.displayName}</div>
                        </div>
                        <div class="original_entry rounded">${it.entryToTranslate.text}</div>
                    </div>
                    <div class="entry_container">
                        <div class="language">
                            <div class="language_flag h_align ${it.destinationLanguage.language}"></div>
                            <div class="language_name h_align">${it.destinationLanguage.displayName}</div>
                        </div>
                        <textarea class="translate_input rounded"></textarea>
                    </div>

                    <div class="submit_buttons">
                        <a class="ok rounded" href="#">Submit</a>
                    </div>
               </div>

            <%-- Next context Entries --%>
            <c:forEach var="entry" items="${it.nextContextEntries}">
                <div class="context_entry rounded">${entry.text}</div>
            </c:forEach>

         </div>
    </body>
</html>
