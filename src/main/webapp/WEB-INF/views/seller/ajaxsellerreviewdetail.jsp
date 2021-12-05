<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
			<c:if test="${review.rev_filename ne null }"> 
					<img src="<%=request.getContextPath() %>/resources/images/reviewimage/${review.rev_filename}"/> <br><br>
			</c:if>
				${review.rev_content}
