<!-- index.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Index Page</title>
    <script type="text/javascript">
        window.location.href = "/login";
    </script>
<%--    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>--%>
<%--    <script type="text/javascript">--%>
<%--        $(document).ready(function() {--%>
<%--            $.ajax({--%>
<%--                url: "/login",--%>
<%--                type: "GET",--%>
<%--                success: function(response) {--%>
<%--                    window.location.href = "/login";--%>
<%--                },--%>
<%--                error: function(xhr, status, error) {--%>
<%--                    alert("Có lỗi xảy ra: " + error);--%>
<%--                }--%>
<%--            });--%>
<%--        });--%>
    </script>
</head>
<body>
<p>Nếu bạn không được chuyển hướng, hãy nhấp vào <a href="/login">đây</a>.</p>
</body>
</html>
