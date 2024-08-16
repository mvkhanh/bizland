<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="homeUrl" value="/admin/home"/>
<c:url var="customersUrl" value="/admin/customers"/>
<c:url var="transactionsUrl" value="/admin/transactions"/>
<html>

<head>
    <title>Danh sách khách hàng</title>
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
                    <a href="${customersUrl}">Danh sách khách hàng</a>
                </li>
                <li class="active">
                    <c:if test="${empty id}">Thêm khách hàng</c:if>
                    <c:if test="${not empty id}">Cập nhật thông tin khách hàng</c:if>
                </li>
            </ul><!-- /.breadcrumb -->
        </div>

        <div class="page-content">
            <div class="page-header">
                <h1>
                    <c:if test="${empty id}">Thêm khách hàng</c:if>
                    <c:if test="${not empty id}">Cập nhật thông tin khách hàng</c:if>
                </h1>
            </div>
            <div class="row" style="font-family: 'Times New Roman', Times, serif;">
                <div class="col-xs-12">
                    <form:form class="form-horizontal" role="form" id="addOrEditForm" modelAttribute="customer" method="post">
                        <div class="row" style="margin-bottom: 2em;">
                            <label class="col-xs-3">Tên khách hàng</label>
                            <form:input class="col-xs-7" placeholder="Nhập tên khách hàng" path="name"/>
                        </div>
                        <div class="row" style="margin-bottom: 1em;">
                            <label class="col-xs-3">Số điện thoại</label>
                            <form:input class="col-xs-7" placeholder="Nhập số điện thoại" path="phone"/>
                        </div>
                        <div class="row" style="margin-bottom: 1em;">
                            <label class="col-xs-3">Email</label>
                            <form:input class="col-xs-7" placeholder="Nhập email" path="email"/>
                        </div>
                        <div class="row" style="margin-bottom: 1em;">
                            <label class="col-xs-3">Nhu cầu</label>
                            <form:input class="col-xs-7" placeholder="Nhập nhu cầu" path="need"/>
                        </div>
                        <div class="row" style="margin-bottom: 1em;">
                            <label class="col-xs-3" for="note-field">Ghi chú</label>
                            <form:input class="col-xs-7" placeholder="Nhập ghi chú" path="note" id="note-field"/>
                        </div>
                        <div class="row" style="margin-bottom: 1em;">
                            <label class="col-xs-3" for="status-field">Tình trạng</label>
                            <form:select path="status" class="col-xs-2" id="status-field">
                                <form:option value="">--Chọn tình trạng--</form:option>
                                <form:options items="${customerStatus}"/>
                            </form:select>
                        </div>
                        <div class="row center">
                            <button type="button" class="btn btn-xs btn-success" style="font-size: 16px; margin-right: 1em;" id="btn-submit">
                                Xác nhận
                            </button>
                            <a href="${customersUrl}">
                                <button type="button" class="btn btn-danger btn-xs"  style="font-size: 16px;">
                                    Huỷ
                                </button>
                            </a>
                        </div>
                        <form:hidden path="id"/>
                        <c:if test="${not empty id}">
                            <c:forEach var="entry" items="${customer.transactions}">
                            <div class="row col-sm-12">
                                <div class="hr hr32 hr-dotted"></div>
                                <div class="widget-box transparent">
                                    <div class="widget-header widget-header-flat">
                                        <h3 class="widget-title lighter">
                                            <i class="ace-icon fa fa-star orange"></i>
                                            ${entry.key.second}
                                        </h3>

                                        <div class="widget-toolbar">
                                            <a href="#" data-action="collapse">
                                                <i class="ace-icon fa fa-chevron-up"></i>
                                            </a>
                                        </div>
                                    </div>

                                    <div class="widget-body" style="display: block; margin-top: 1em;">
                                        <div style="margin-bottom: 1em">
                                            <button class="btn btn-sm btn-success no-radius" type="button" onclick="addOrEditTransaction(null, null, '${entry.key.first}')">
                                                <i class="ace-icon fa fa-plus"></i>
                                                Thêm
                                            </button>
                                            <c:if test="${fn:contains(sessionScope.user.roles, 'ADMIN')}">
                                                <button class="btn btn-sm btn-danger no-radius" type="button" onclick="clickBtnDeleteTransactions('${entry.key.first}')">
                                                    <i class="ace-icon fa fa-remove"></i>
                                                    Xoá
                                                </button>
                                            </c:if>
                                        </div>
                                        <div class="widget-main no-padding">
                                            <table class="table table-bordered table-striped" id="table-${entry.key.first}">
                                                <thead class="thin-border-bottom">
                                                    <tr>
                                                        <th class="center">
                                                            <label class="pos-rel">
                                                                <input type="checkbox" class="ace" name="checkList-${entry.key.first}" id="checkAll-${entry.key.first}">
                                                                <span class="lbl"></span>
                                                            </label>
                                                        </th>
                                                        <th>
                                                            <i class="ace-icon fa fa-caret-right blue"></i>Ngày tạo
                                                        </th>

                                                        <th>
                                                            <i class="ace-icon fa fa-caret-right blue"></i>Người tạo
                                                        </th>

                                                        <th>
                                                            <i class="ace-icon fa fa-caret-right blue"></i>Ngày chỉnh sửa
                                                        </th>

                                                        <th>
                                                            <i class="ace-icon fa fa-caret-right blue"></i>Người chỉnh sửa
                                                        </th>

                                                        <th>
                                                            <i class="ace-icon fa fa-caret-right blue"></i>Chi tiết giao dịch
                                                        </th>

                                                        <th>
                                                            <i class="ace-icon fa fa-caret-right blue"></i>Thao tác
                                                        </th>
                                                    </tr>
                                                </thead>

                                                <tbody>
                                                    <c:forEach var="item" items="${entry.value}">
                                                        <tr>
                                                            <td class="center">
                                                                <label class="pos-rel">
                                                                    <input type="checkbox" class="ace" name="checkList-${entry.key.first}" value="${item.id}">
                                                                    <span class="lbl"></span>
                                                                </label>
                                                            </td>
                                                            <td>${item.createdDate}</td>
                                                            <td>${item.createdBy}</td>
                                                            <td>${item.modifiedDate}</td>
                                                            <td>${item.modifiedBy}</td>
                                                            <td>${item.detail}</td>
                                                            <td>
                                                                <div class="hidden-sm hidden-xs btn-group">
                                                                    <btn class="btn btn-xs btn-info" onclick="addOrEditTransaction('${item.id}', '${item.detail}', '${entry.key.first}')">
                                                                        <i class="ace-icon fa fa-pencil bigger-120" title="Chỉnh sửa thông tin giao dịch"></i>
                                                                    </btn>
                                                                    <c:if test="${fn:contains(sessionScope.user.roles, 'ADMIN')}">
                                                                        <button class="btn btn-xs btn-danger" type="button" title="Xoá giao dịch" onclick="deleteTransaction(${item.id})">
                                                                            <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                                                        </button>
                                                                    </c:if>
                                                                </div>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div><!-- /.widget-main -->
                                    </div><!-- /.widget-body -->
                                </div><!-- /.widget-box -->
                            </div>
                        </c:forEach>
                        </c:if>
                    </form:form>
                </div><!-- /.col -->
            </div>
        </div><!-- /.page-content -->
    </div>

    <script>
        $(document).ready(function() {
            $('table[id^="table-"]').each(function() {
                $(this).DataTable({
                    "paging": true,        // Kích hoạt phân trang
                    "lengthChange": true,  // Cho phép thay đổi số lượng hàng trên mỗi trang
                    "searching": true,     // Kích hoạt ô tìm kiếm
                    "ordering": true,      // Cho phép sắp xếp
                    "info": true,          // Hiển thị thông tin bảng
                    "autoWidth": false,    // Không tự động điều chỉnh độ rộng cột
                    "pageLength": 5,
                    "lengthMenu": [ [5, 10, 25, 50, 100], [5, 10, 25, 50, 100] ],
                    "language": {
                        "lengthMenu": "Hiển thị _MENU_ bản ghi mỗi trang",
                        "zeroRecords": "Không tìm thấy bản ghi nào",
                        "info": "_PAGE_ trong tổng số _PAGES_",
                        "infoEmpty": "Không có dữ liệu",
                        "infoFiltered": "(lọc từ _MAX_ tổng số bản ghi)"
                    },
                    "columnDefs": [
                        { "orderable": false, "targets": 0 },
                        { "orderable": false, "targets": -1 }
                    ],
                    "order": [[1, 'desc']]
                });
            });
        });
    </script>
    <script>
        $('#btn-submit').click(function(){
            var formData = new FormData();
            var formFields = $('#addOrEditForm').serializeArray();
            $.each(formFields, function(i, v){
                formData.append(v.name, v.value);
            });
            $.ajax({
                type: "post",
                url: "${customersUrl}",
                data: formData,
                contentType: false,
                processData: false,
                success: function () {
                    console.log("Success");
                    let actionText = formData.get('id') !== "" ? "cập nhật thông tin" : "thêm";
                    showSuccessMessage('Đã ' + actionText + ' khách hàng thành công!', "${customersUrl}");
                },
                error: function () {
                    console.log("Error");
                    showErrorMessage("There was an error processing your request.");
                }
            });
        });
        function addOrEditTransaction(id, detail, code){
            let data = {};
            data['code'] = code;
            data['customerId'] = '${id}';
            data['id'] = id;
            data['detail'] = detail;
            Swal.fire({
                title: "Nhập chi tiết giao dịch",
                input: "text",
                inputAttributes: {
                    autocapitalize: "off"
                },
                inputValue: detail,
                showCancelButton: true,
                confirmButtonText: "Xác nhận",
                showLoaderOnConfirm: true,
                allowOutsideClick: () => !Swal.isLoading()
            }).then((result) => {
                data['detail'] = result.value;
                if (result.isConfirmed) {
                    $.ajax({
                        type: "POST",
                        url: "${transactionsUrl}",
                        data: JSON.stringify(data),
                        contentType: "application/json",
                        success: function () {
                            console.log("Success");
                            let actionText = data['id'] !== null ? "cập nhật thông tin" : "thêm";
                            showSuccessMessage('Đã ' + actionText + ' giao dịch thành công!', "/admin/customers-edit-" + "${id}");
                        },
                        error: function () {
                            console.log("Error");
                            showErrorMessage("There was an error processing your request.");
                        }
                    });
                }
            });
        }
        function confirmDelete(ids){
            Swal.fire({
                title: "Are you sure?",
                text: "You won't be able to revert this!",
                icon: "warning",
                showCancelButton: true,
                confirmButtonColor: "#3085d6",
                cancelButtonColor: "#d33",
                confirmButtonText: "Yes, delete it!"
            }).then((result) => {
                if (result.isConfirmed) deleteTransactions(ids);
            });
        }
        function clickBtnDeleteTransactions(code) {
            const tableId = '#table-' + code;
            let ids = $(tableId).find('tbody input[type=checkbox]:checked').map(function () {
                return $(this).val();
            }).get();
            if (ids.length > 0) confirmDelete(ids);
        };
        function deleteTransaction(id){
            confirmDelete([id]);
        }
        function deleteTransactions(ids){
            $.ajax({
                type:"delete",
                url:"${transactionsUrl}/" + ids,
                data:JSON.stringify(ids),
                contentType:"Application/JSON",
                datatype:"JSON",
                success: function () {
                    console.log("Success");
                    showSuccessMessage("Đã xoá toà nhà thành công!", "/admin/customers-edit-" + "${id}");
                },
                error: function () {
                    console.log("Error");
                    showErrorMessage('There was an error processing your request.');
                }
            })
        }
        document.addEventListener('DOMContentLoaded', function() {
            document.querySelectorAll('input[id^="checkAll-"]').forEach(checkAll => {
                const selector = 'input[name="checkList-' + checkAll.id.replace('checkAll-', '') + '"]';
                const checkboxes = document.querySelectorAll(selector);

                checkAll.addEventListener('change', function() {
                    checkboxes.forEach(checkbox => checkbox.checked = checkAll.checked);
                });

                checkboxes.forEach(checkbox => checkbox.addEventListener('change', function() {
                        if (!this.checked) checkAll.checked = false;
                        else if (Array.from(checkboxes).every(cb => cb.checked)) checkAll.checked = true;
                    })
                );
            });
        });

    </script>
</body>
</html>

