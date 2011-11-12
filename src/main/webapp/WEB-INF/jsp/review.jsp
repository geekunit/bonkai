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
            
            <div>Please take the time to read the following translation and tell us, if you agree with it. This way we can evaluate user input and provide more precise and correct translations</div>

            <%-- Previous context Entries --%>
            <c:forEach var="entry" items="${it.previousContextEntries}">
                <div class="context_entry rounded">${entry.text}</div>
            </c:forEach>

                <div class="central_block">
                    
                    <div id="entries_container">
                    
                        <div class="row">
                            <div class="left_col lang rounded">
                                <div class="language_flag padding_53 ${it.sourceLanguage.language}">Original Text</div>
                            </div>
                            <div class="right_col original_entry rounded">${it.originalEntry.text}</div>
                        </div>
                    
                        <div class="row lang rounded">
                            <div class="left_col lang rounded">
                                <div class="language_flag padding_53 ${it.destinationLanguage.language}">Translated Text</div>
                            </div>
                            <div class="right_col translated_entry rounded">${it.translatedEntry.text}</div>
                        </div>
                    </div>

                    <div class="submit_buttons">
                        <a class="ok button rounded" href="#">I agree.</a>
                        <a class="not_ok button rounded" href="#">I do not agree.</a>
                    </div>
               </div>

            <%-- Next context Entries --%>
            <c:forEach var="entry" items="${it.nextContextEntries}">
                <div class="context_entry rounded">${entry.text}</div>
            </c:forEach>
                
        </div>
    </body>
</html>
