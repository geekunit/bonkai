<%-- 
    Document   : translationBlock
    Created on : Nov 10, 2011, 9:42:28 PM
    Author     : pmcosta
--%>

<%@page contentType="text/html" pageEncoding="MacRoman"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=MacRoman">
        <title>Translation Challenge</title>
        
         <%-- CSS includes --%>
        <link rel="stylesheet" type="text/css" href="css/base.css" />
    </head>
    <body>
        
         <div class="centered_content">

            <div class="title">
                <h1>Translation Challenge</h1>
            </div>
        
            <%-- Previous context Entries --%>
            <c:forEach var="entry" items="${it.previousContextEntries}">
                <div class="context_entry">${entry.text}</div>
            </c:forEach>

                <div id="review_block">
                    
                    <div class="entry_container">
                        <div class="language ${it.sourceLanguage.language}">${it.sourceLanguage.language}</div>
                        <div class="original_entry">${it.entryToTranslate.text}</div>
                    </div>
                    <div class="entry_container">
                        <div class="language ${it.destinationLanguage.language}">${it.sourceLanguage.language}</div>
                        <div class="translate_entry">
                            <input type="text" />
                        </div>
                    </div>

                    <div class="submit_buttons">
                        <a class="ok">Submmit</a>
                    </div>
               </div>

            <%-- Next context Entries --%>
            <c:forEach var="entry" items="${it.nextContextEntries}">
                <div class="context_entry">${entry.text}</div>
            </c:forEach>

         </div>
            
    </body>
</html>