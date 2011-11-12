<%@page contentType="text/html" pageEncoding="MacRoman"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Bonkai</title>
        <jsp:include page="common_head.jsp" />
        
        <script type="text/javascript">
            if(window.jQuery) {
                var heightText=50;
                $(document).ready(function() {
                    
                    $('textarea').click(function(){
                        if($(this).val()=='Enter text here ...') {
                            $(this).css('color','#000');
                            $(this).val(''); 
                        }
                        
                    });
                    
                    $('textarea').blur(function(){
                        if($(this).val().length==0) {
                            heightText=50;
                            $(this).css('height',heightText+'px');
                            $(this).css('color','#aaa');
                            $(this).val('Enter text here ...');
                        } else {
                            if($(this).val().match(/^(\n+)$/ig)) {
                                heightText=50;
                                $(this).css('height',heightText+'px');
                                $(this).css('color','#aaa');
                                $(this).val('Enter text here ...');
                            } else {
                                $(this).css('color','#000');
                            }
                            
                        }
                    });
                    $('textarea').scroll(function() {
                        heightText+=11;
                        $(this).css('height',heightText+'px');
                    });
                    
                    $('a.ok').click(function() {
                        if($('textarea').val().length==0) {
                            console.log('validation failed.');
                            return false;
                        }
                        if($('textarea').val()=='Enter text here ...') {
                            console.log('validation failed.');
                            return false;
                            
                        }
                        if($('textarea').val().match(/^(\n+)$/ig)) {
                            console.log('validation failed.');
                            return false;
                        }
                        console.log('validation passed.');
                        return false;
                    });
                });
            }
        </script>
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
                    <div id="entries_container">
                        <div class="row">
                            <div class="left_col lang rounded">
                                <div class="language_flag padding_53 ${it.sourceLanguage.language}">Original Text</div>
                            </div>
                            <div class="right_col original_entry rounded">${it.entryToTranslate.text}</div>
                        </div>
                    
                        <div class="row">
                            <div class="left_col lang rounded">
                                <div class="language_flag padding_53 ${it.destinationLanguage.language}">Translate Text</div>
                            </div>
                            <div class="right_col">
                                <textarea class="right_col translate_input rounded">Enter text here ...</textarea>
                            </div>
                        </div>
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
