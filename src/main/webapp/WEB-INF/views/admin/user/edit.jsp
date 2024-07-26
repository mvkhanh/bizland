<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="homeUrl" value="/admin/home"/>
<c:url var="usersUrl" value="/admin/users"/>
<html>

<head>
    <title>Danh sách người dùng</title>
</head>

<body>
<div class="main-content-inner">
    <div class="breadcrumbs ace-save-state" id="breadcrumbs">
        <ul class="breadcrumb">
            <li>
                <a href="${homeUrl}">
                    <i class="ace-icon fa fa-home home-icon"></i>
                    Trang chủ
                </a>
            </li>
            <li>
                <a href="${usersUrl}">Danh sách người dùng</a>
            </li>
            <li class="active">
                <c:if test="${empty id}">Thêm người dùng</c:if>
                <c:if test="${not empty id}">Cập nhật thông tin người dùng</c:if>
            </li>
        </ul><!-- /.breadcrumb -->
    </div>

    <div class="page-content">
        <div class="page-header">
            <h1>
                <c:if test="${empty id}">Thêm người dùng</c:if>
                <c:if test="${not empty id}">Cập nhật thông tin người dùng</c:if>
            </h1>
        </div>
        <div class="row" style="font-family: 'Times New Roman', Times, serif;">
            <div class="col-xs-12">
<%--                enctype="multipart/form-data" cho hinh dai dien--%>
                <form:form class="form-horizontal" role="form" id="addOrEditForm" modelAttribute="user" method="post">
                    <div class="row" style="margin-bottom: 2em;">
                        <label class="col-xs-3">Tên người dùng</label>
                        <form:input class="col-xs-7" placeholder="Nhập tên người dùng" path="fullName"/>
                    </div>
                    <div class="row" style="margin-bottom: 2em;">
                        <label class="col-xs-3">Vai trò</label>
                        <form:select class="col-xs-2" path="roles">
                            <form:option value="">--Chọn vai trò--</form:option>
                            <form:options items="${roles}"/>
                        </form:select>
                    </div>
                    <div class="row" style="margin-bottom: 1em;">
                        <label class="col-xs-3">Tài khoản</label>
                        <form:input class="col-xs-7" placeholder="Nhập tài khoản" path="username"/>
                    </div>
                    <div class="row" style="margin-bottom: 1em;">
                        <label class="col-xs-3">Email</label>
                        <form:input class="col-xs-7" placeholder="Nhập email" path="email"/>
                    </div>
                    <div class="row" style="margin-bottom: 1em;">
                        <label class="col-xs-3">Số điện thoại</label>
                        <form:input class="col-xs-7" placeholder="Nhập số điện thoại" path="phone"/>
                    </div>
<%--                    <div class="row">--%>
<%--                        <label class="col-xs-3">Hình đại diện</label>--%>
<%--                        <form:input path="imageFile" class="col-xs-7" id="avatarInput" type="file" onchange="previewImage(this);" accept="image/*"/>--%>
<%--                    </div>--%>
<%--                    <div class="row" style="margin-bottom: 1em;">--%>
<%--                        <div class="col-xs-3"></div>--%>
<%--                        <img id="avatarPreview" alt="Chưa chọn hình đại diện" width="300px" height="200px" src="data:image/jpeg;base64,${image}">--%>
<%--                    </div>--%>
                    <div class="row center">
                        <button type="button" class="btn btn-xs btn-success" style="font-size: 16px; margin-right: 1em;" id="btn-submit">
                            Xác nhận
                        </button>
                        <a href="${usersUrl}">
                            <button type="button" class="btn btn-danger btn-xs"  style="font-size: 16px;">
                                Huỷ
                            </button>
                        </a>
                    </div>
                    <form:hidden path="id"/>
                </form:form>
            </div><!-- /.col -->
        </div>
    </div><!-- /.page-content -->
</div>
<script>
    $('#btn-submit').click(function(){
        var formData = new FormData();
        var formFields = $('#addOrEditForm').serializeArray();
        $.each(formFields, function(i, v){
            formData.append(v.name, v.value);
        });
        // var fileInput = $('#avatarInput')[0];
        // if (fileInput.files.length > 0) {
        //     formData.append('imageFile', fileInput.files[0]);
        // }
        $.ajax({
            type: "post",
            url: "${usersUrl}",
            data: formData,
            contentType: false,
            processData: false,
            success: function () {
                console.log("Success");
                let actionText = formData.get('id') !== "" ? "cập nhật thông tin" : "thêm";
                showSuccessMessage('Đã ' + actionText + ' người dùng thành công!', "${usersUrl}");
            },
            error: function () {
                console.log("Error");
                showErrorMessage("There was an error processing your request.");
            }
        });
    })
    // function previewImage(input){
    //     let preview = document.getElementById('avatarPreview');
    //     if (input.files && input.files[0]) {
    //         var reader = new FileReader();
    //         reader.onload = function(e) {
    //             preview.src = e.target.result;
    //         };
    //         reader.readAsDataURL(input.files[0]);
    //     } else {
    //         preview.src = "";
    //     }
    // }
</script>

</body>
</html>

