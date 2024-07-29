<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="homeUrl" value="/admin/home"/>
<c:url var="buildingsUrl" value="/admin/buildings"/>
<html>

<head>
    <title>Danh sách toà nhà</title>
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
                    <a href="${buildingsUrl}">Danh sách toà nhà</a>
                </li>
                <li class="active">
                    <c:if test="${empty id}">Thêm toà nhà</c:if>
                    <c:if test="${not empty id}">Cập nhật thông tin toà nhà</c:if>
                </li>
            </ul><!-- /.breadcrumb -->
        </div>

        <div class="page-content">
            <div class="page-header">
                <h1>
                    <c:if test="${empty id}">Thêm toà nhà</c:if>
                    <c:if test="${not empty id}">Cập nhật thông tin toà nhà</c:if>
                </h1>
            </div>
            <div class="row" style="font-family: 'Times New Roman', Times, serif;">
                <div class="col-xs-12">
                    <form:form class="form-horizontal" role="form" id="addOrEditForm" modelAttribute="building" enctype="multipart/form-data" method="post">
                        <div class="row" style="margin-bottom: 2em;">
                            <label class="col-xs-3">Tên toà nhà</label>
                            <form:input class="col-xs-7" placeholder="Nhập tên toà nhà" path="name"/>
                        </div>
                        <div class="row" style="margin-bottom: 2em;">
                            <label class="col-xs-3">Quận</label>
                            <form:select class="col-xs-2" path="district">
                                <form:option value="">--Chọn quận--</form:option>
                                <form:options items="${districts}"/>
                            </form:select>
                        </div>
                        <div class="row" style="margin-bottom: 1em;">
                            <label class="col-xs-3">Phường</label>
                            <form:input class="col-xs-7" placeholder="Nhập phường" path="ward"/>
                        </div>
                        <div class="row" style="margin-bottom: 1em;">
                            <label class="col-xs-3">Đường</label>
                            <form:input class="col-xs-7" placeholder="Nhập đường" path="street"/>
                        </div>
                        <div class="row" style="margin-bottom: 1em;">
                            <label class="col-xs-3">Kết cấu</label>
                            <form:input class="col-xs-7" placeholder="Nhập kết cấu" path="struct"/>
                        </div>
                        <div class="row" style="margin-bottom: 1em;">
                            <label class="col-xs-3">Số tầng hầm</label>
                            <form:input class="col-xs-7" placeholder="Nhập số tầng hầm" path="numberOfBasements"/>
                        </div>
                        <div class="row" style="margin-bottom: 1em;">
                            <label class="col-xs-3">Diện tích sàn</label>
                            <form:input class="col-xs-7" placeholder="Nhập diện tích sàn" path="floorArea"/>
                        </div>
                        <div class="row" style="margin-bottom: 1em;">
                            <label class="col-xs-3">Hướng</label>
                            <form:input class="col-xs-7" placeholder="Nhập hướng" path="direction"/>
                        </div>
                        <div class="row" style="margin-bottom: 1em;">
                            <label class="col-xs-3">Hạng</label>
                            <form:input class="col-xs-7" placeholder="Nhập hạng" path="level"/>
                        </div>
                        <div class="row" style="margin-bottom: 1em;">
                            <label class="col-xs-3">Diện tích thuê</label>
                            <form:input class="col-xs-7" placeholder="Nhập diện tích thuê" path="rentAreas"/>
                        </div>
                        <div class="row" style="margin-bottom: 1em;">
                            <label class="col-xs-3">Giá thuê</label>
                            <form:input class="col-xs-7" placeholder="Nhập giá thuê" path="rentPrice"/>
                        </div>
                        <div class="row" style="margin-bottom: 1em;">
                            <label class="col-xs-3">Mô tả giá</label>
                            <form:input class="col-xs-7" placeholder="Nhập mô tả giá" path="rentPriceDescription"/>
                        </div>
                        <div class="row" style="margin-bottom: 1em;">
                            <label class="col-xs-3">Phí dịch vụ</label>
                            <form:input class="col-xs-7" placeholder="Nhập phí dịch vụ" path="serviceFee"/>
                        </div>
                        <div class="row" style="margin-bottom: 1em;">
                            <label class="col-xs-3">Phí ô tô</label>
                            <form:input class="col-xs-7" placeholder="Nhập phí ô tô" path="carFee"/>
                        </div>
                        <div class="row" style="margin-bottom: 1em;">
                            <label class="col-xs-3">Phí mô tô</label>
                            <form:input class="col-xs-7" placeholder="Nhập phí mô tô" path="motorFee"/>
                        </div>
                        <div class="row" style="margin-bottom: 1em;">
                            <label class="col-xs-3">Phí ngoài giờ</label>
                            <form:input class="col-xs-7" placeholder="Nhập phí ngoài giờ" path="overtimeFee"/>
                        </div>
                        <div class="row" style="margin-bottom: 1em;">
                            <label class="col-xs-3">Tiền điện</label>
                            <form:input class="col-xs-7" placeholder="Nhập tiền điện" path="electricBill"/>
                        </div>
                        <div class="row" style="margin-bottom: 1em;">
                            <label class="col-xs-3">Đặt cọc</label>
                            <form:input class="col-xs-7" placeholder="Nhập tiền đặt cọc" path="deposit"/>
                        </div>
                        <div class="row" style="margin-bottom: 1em;">
                            <label class="col-xs-3">Thanh toán</label>
                            <form:input class="col-xs-7" placeholder="Nhập tiền thanh toán" path="payment"/>
                        </div>
                        <div class="row" style="margin-bottom: 1em;">
                            <label class="col-xs-3">Thời hạn thuê</label>
                            <form:input class="col-xs-7" placeholder="Nhập thời hạn thuê" path="rentalTerm"/>
                        </div>
                        <div class="row" style="margin-bottom: 1em;">
                            <label class="col-xs-3">Thời gian trang trí</label>
                            <form:input class="col-xs-7" placeholder="Nhập thời gian trang trí" path="decorationTime"/>
                        </div>
                        <div class="row" style="margin-bottom: 1em;">
                            <label class="col-xs-3">Tên quản lý</label>
                            <form:input class="col-xs-7" placeholder="Nhập tên quản lý" path="managerName"/>
                        </div>
                        <div class="row" style="margin-bottom: 1em;">
                            <label class="col-xs-3">SĐT quản lý</label>
                            <form:input class="col-xs-7" placeholder="Nhập số điện thoại quản lý" path="managerPhone"/>
                        </div>
                        <div class="row" style="margin-bottom: 1em;">
                            <label class="col-xs-3">Phí môi giới</label>
                            <form:input class="col-xs-7" placeholder="Nhập phí môi giới" path="brokerageFee"/>
                        </div>
                        <div class="row" style="margin-bottom: 1em;">
                            <label class="col-xs-3">Loại toà nhà</label>
                            <div class="col-xs-9">
                                <form:checkboxes path="typeCodes" items="${typecodes}"/>
                            </div>
                        </div>
                        <div class="row" style="margin-bottom: 1em;">
                            <label class="col-xs-3">Ghi chú</label>
                            <form:input class="col-xs-7" placeholder="Nhập ghi chú" path="note"/>
                        </div>
                        <div class="row">
                            <label class="col-xs-3">Hình đại diện</label>
                            <form:input path="imageFile" class="col-xs-2" id="avatarInput" type="file" onchange="previewImage(this);" accept="image/*"/>
                            <button type="button" class="btn btn-xs btn-danger" onclick="clearImage()">Xóa ảnh</button>
                        </div>
                        <div class="row" style="margin-bottom: 1em; margin-top: 1em">
                            <div class="col-xs-3"></div>
                            <img id="avatarPreview" alt="Chưa chọn hình đại diện" width="300px" height="200px" src="data:image/jpeg;base64,${image}">
                        </div>
                        <div class="row center">
                            <button type="button" class="btn btn-xs btn-success" style="font-size: 16px; margin-right: 1em;" id="btn-submit">
                                Xác nhận
                            </button>
                            <a href="${buildingsUrl}">
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
            var typeCodes = [];
            var formFields = $('#addOrEditForm').serializeArray();
            $.each(formFields, function(i, v){
                if(v.name != 'typeCodes') {
                    formData.append(v.name, v.value);
                } else {
                    typeCodes.push(v.value);
                }
            });
            formData.append('typeCodes', JSON.stringify(typeCodes));
            var fileInput = $('#avatarInput')[0];
            if (fileInput.files.length > 0) {
                formData.append('imageFile', fileInput.files[0]);
            }
            $.ajax({
                type: "post",
                url: "${buildingsUrl}",
                data: formData,
                contentType: false,
                processData: false,
                success: function () {
                    console.log("Success");
                    let actionText = formData.get('id') !== "" ? "cập nhật thông tin" : "thêm";
                    showSuccessMessage('Đã ' + actionText + ' toà nhà thành công!', "${buildingsUrl}");
                },
                error: function () {
                    console.log("Error");
                    showErrorMessage("There was an error processing your request.");
                }
            });
        })
        function previewImage(input){
            let preview = document.getElementById('avatarPreview');
            if (input.files && input.files[0]) {
                var reader = new FileReader();
                reader.onload = function(e) {
                    preview.src = e.target.result;
                };
                reader.readAsDataURL(input.files[0]);
            } else {
                preview.src = "";
            }
        }
        function clearImage() {
            document.getElementById('avatarInput').value = "";
            document.getElementById('avatarPreview').src = "";
        }
    </script>

</body>
</html>

