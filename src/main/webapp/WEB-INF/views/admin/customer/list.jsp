<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="homeUrl" value="/admin/home"/>
<c:url var="customerEditUrl" value="/admin/customers-edit"/>
<c:url var="customersUrl" value="/admin/customers"/>
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
                <li class="active">Danh sách khách hàng</li>
            </ul><!-- /.breadcrumb -->
        </div>

        <div class="page-content">
            <div class="page-header">
                <h1>
                    Danh sách khách hàng
                </h1>
            </div><!-- /.page-header -->
            <div class="row">
                <div class="col-xs-12">
                    <div class="widget-box ui-sortable-handle" id="widget-box-1">
                        <div class="widget-header">
                            <h5 class="widget-title">Tìm kiếm</h5>

                            <div class="widget-toolbar">
                                <a href="#" data-action="collapse">
                                    <i class="ace-icon fa fa-chevron-up"></i>
                                </a>
                            </div>
                        </div>

                        <div class="widget-body">
                            <div class="widget-main">
                                <form:form id="listForm" action="${customersUrl}" method="get" modelAttribute="search">
                                    <div class="row">
                                        <div class="col-xs-6">
                                            <label>Tên khách hàng</label>
                                            <form:input class="form-control" placeholder="Nhập tên khách hàng" path="name"/>
                                        </div>
                                        <div class="col-xs-6">
                                            <label>Số điện thoại</label>
                                            <form:input class="form-control" placeholder="Nhập số điện thoại" path="phone"/>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-xs-6">
                                            <label>Email</label>
                                            <form:input class="form-control" placeholder="Nhập email" path="email"/>
                                        </div>
                                        <div class="col-xs-3">
                                            <label for="status-field">Tình trạng</label>
                                            <form:select class="form-control" path="status" id="status-field">
                                                <form:option value="">--Chọn tình trạng--</form:option>
                                                <form:options items="${customerStatus}"/>
                                            </form:select>
                                        </div>
                                        <div class="col-xs-3">
                                            <c:if test="${fn:contains(sessionScope.user.roles, 'ADMIN')}">
                                                <label>Nhân viên phụ trách</label>
                                                <form:select class="form-control" path="id_staff">
                                                    <form:option value="">--Chọn nhân viên--</form:option>
                                                    <form:options items="${staffs}"/>
                                                </form:select>
                                            </c:if>
                                        </div>
                                    </div>

                                    <form:hidden path="pageNumber" id="pageNumber"/>
                                    <form:hidden path="pageSize" id="pageSize"/>
                                    <div class="row" style="margin-top: 1em">
                                        <div class="pull-left">
                                            <button type="button" class="btn btn-danger btn-xs" style="font-size: 16px; margin-left: 10px" id="btn-clear">Xoá tất cả</button>
                                        </div>
                                        <div class="pull-right">
                                            <button type="button" class="btn btn-primary btn-xs" style="font-size: 16px; margin-right: 10px" id="btn-search">
                                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="12" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                                                    <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"></path>
                                                </svg>
                                                Tìm kiếm
                                            </button>
                                        </div>
                                    </div>
                                </form:form>
                            </div>
                        </div>
                    </div>
                    <div class="pull-right">
                        <c:if test="${fn:contains(sessionScope.user.roles, 'ADMIN')}">
                            <a href="${customerEditUrl}">
                                <button class="flat-btn" title="Thêm khách hàng">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="blue" class="bi bi-customer-add" viewBox="0 0 16 16">
                                        <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7m.5-5v1h1a.5.5 0 0 1 0 1h-1v1a.5.5 0 0 1-1 0v-1h-1a.5.5 0 0 1 0-1h1v-1a.5.5 0 0 1 1 0"/>
                                        <path d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v6.5a.5.5 0 0 1-1 0V1H3v14h3v-2.5a.5.5 0 0 1 .5-.5H8v4H3a1 1 0 0 1-1-1z"/>
                                        <path d="M4.5 2a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"/>
                                    </svg>
                                </button>
                            </a>
                            <button class="flat-btn" title="Xoá khách hàng" id="btn-delete">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red" class="bi bi-customer-dash" viewBox="0 0 16 16">
                                    <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7M11 12h3a.5.5 0 0 1 0 1h-3a.5.5 0 0 1 0-1"/>
                                    <path d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v6.5a.5.5 0 0 1-1 0V1H3v14h3v-2.5a.5.5 0 0 1 .5-.5H8v4H3a1 1 0 0 1-1-1z"/>
                                    <path d="M4.5 2a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"/>
                                </svg>
                            </button>
                        </c:if>
                    </div>
                </div>
            </div>
            <hr>
            <!-- Table -->
            <div class="row">
                <div class="col-xs-12">
                    <table id="table" class="table table-bordered table-hover">
                        <thead>
                        <tr>
                            <th class="center">
                                <label class="pos-rel">
                                    <input type="checkbox" class="ace" name="checkList" id="checkAll">
                                    <span class="lbl"></span>
                                </label>
                            </th>
                            <th>Tên khách hàng</th>
                            <th>Số điện thoại</th>
                            <th>Email</th>
                            <th>Tình trạng</th>
<%--                            <th>Người tạo</th>--%>
<%--                            <th>Ngày tạo</th>--%>
<%--                            <th>Người chỉnh sửa</th>--%>
<%--                            <th>Ngày chỉnh sửa</th>--%>
                            <th>Thao tác</th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach var="customer" items="${result.content}">
                            <tr data-id="${customer.id}">
                                <td class="center">
                                    <label class="pos-rel">
                                        <input type="checkbox" class="ace" name="checkList" value="${customer.id}">
                                        <span class="lbl"></span>
                                    </label>
                                </td>
                                <td>${customer.name}</td>
                                <td>${customer.phone}</td>
                                <td>${customer.email}</td>
                                <td>${customer.status}</td>
                                <td>
                                    <div class="hidden-sm hidden-xs btn-group">
                                        <c:if test="${fn:contains(sessionScope.user.roles, 'ADMIN')}">
                                            <button class="btn btn-xs btn-success" title="Giao khách hàng" onclick="assignCustomer(${customer.id})">
                                                <i class="ace-icon glyphicon glyphicon-list"></i>
                                            </button>
                                        </c:if>
                                        <a class="btn btn-xs btn-info" href="${customerEditUrl}-${customer.id}">
                                            <i class="ace-icon fa fa-pencil bigger-120" title="Chỉnh sửa thông tin khách hàng"></i>
                                        </a>
                                        <c:if test="${fn:contains(sessionScope.user.roles, 'ADMIN')}">
                                            <button class="btn btn-xs btn-danger" title="Xoá khách hàng" onclick="deleteCustomer(${customer.id})">
                                                <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                            </button>
                                        </c:if>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <ul class="pagination pull-right">
                        <c:if test="${result.totalPages >= 2}">
                            <li class="${result.pageable.pageNumber == 0 ? 'disabled' : ''}">
                                <a onclick="pagin(${result.pageable.pageNumber - 1})">
                                    <i class="ace-icon fa fa-angle-double-left"></i>
                                </a>
                            </li>
                        </c:if>
                        <c:forEach begin="1" end="${result.totalPages}" var="page">
                            <li class="${result.pageable.pageNumber == page - 1 ? 'active' : ''}">
                                <a onclick="pagin(${page - 1})">${page}</a>
                            </li>
                        </c:forEach>
                        <c:if test="${result.totalPages >= 2}">
                            <li class="${result.pageable.pageNumber == result.totalPages - 1 ? 'disabled' : ''}">
                                <a onclick="pagin(${result.pageable.pageNumber + 1})">
                                    <i class="ace-icon fa fa-angle-double-right"></i>
                                </a>
                            </li>
                        </c:if>
                    </ul>
                </div><!-- /.span -->
            </div>
        </div><!-- /.page-content -->
    </div>
    <div id="assignCustomerModal" class="modal fade" role="dialog" style="font-family: 'Times New Roman', Times, serif;">
        <div class="modal-dialog">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Danh sách nhân viên</h4>
                </div>
                <div class="modal-body">
                    <table class="table  table-bordered table-hover" id="staffList">
                        <thead>
                        <tr>
                            <th class="center">Chọn</th>
                            <th class="center">Tên nhân viên</th>
                        </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                    <input type="hidden" id="customerId">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-success" id="btn-assign-customer">Giao khách hàng</button>
                    <button type="button" class="btn btn-info" data-dismiss="modal" id="btn-close-modal">Đóng</button>
                </div>
            </div>
        </div>
    </div>


    <script>
        function assignCustomer(customerId){
            $('#assignCustomerModal').modal();
            getStaffs(customerId);
            $('#customerId').val(customerId);
        }
        function getStaffs(customerId){
            $.ajax({
                type:"get",
                url:"${customersUrl}/" + customerId + "/staffs",
                datatype:"JSON",
                success: function (response) {
                    let row = '';
                    $.each(response.data, function (index, value){
                        row += '<tr>' +
                            '<td class="center"><input type="checkbox"  value=' + value.id + ' ' + value.checked + '></td>' +
                            '<td class="center">' + value.fullName + '</td>' +
                            '</tr>';
                        $('#staffList tbody').html(row);
                    });
                    console.log("Success");
                },
                error: function () {
                    console.log("Error");
                }
            })
        }
        function assignCustomerQuery(data){
            $.ajax({
                type : "PUT",
                url : "${customersUrl}/assignment",
                data: JSON.stringify(data),
                contentType : "Application/JSON",
                success:function (){
                    $('#btn-close-modal').click();
                    showSuccessMessage("Giao khách hàng thành công!", '');
                },
                error:function (){
                    showErrorMessage('There was an error processing your request.');
                }
            })
        }
        $('#btn-assign-customer').click(function(e){
            e.preventDefault();
            var data = {};
            data['id'] = $('#customerId').val();
            data['staffIds'] = $('#staffList').find('tbody input[type = checkbox]:checked').map(function () {
                return $(this).val();
            }).get();
            if(data['staffIds'].length > 0) assignCustomerQuery(data);
        });
        function pagin(pageNumber){
            $('#pageNumber').val(pageNumber);
            $('#listForm').submit();
        }
        $('#btn-search').click(function (e){
            e.preventDefault();
            $('#pageNumber').val(0);
            $('#listForm').submit();
        });
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
                if (result.isConfirmed) deleteCustomers(ids);
            });
        }
        $('#btn-delete').click(function () {
            let ids = $('#table').find('tbody input[type=checkbox]:checked').map(function () {
                return $(this).val();
            }).get();
            if (ids.length > 0) confirmDelete(ids);
        });
        function deleteCustomer(id){
            confirmDelete([id]);
        }
        function deleteCustomers(ids){
            $.ajax({
                type:"delete",
                url:"${customersUrl}/" + ids,
                data:JSON.stringify(ids),
                contentType:"Application/JSON",
                datatype:"JSON",
                success: function () {
                    console.log("Success");
                    showSuccessMessage("Đã xoá khách hàng thành công!", '${customersUrl}');
                },
                error: function () {
                    console.log("Error");
                    showErrorMessage('There was an error processing your request.');
                }
            })
        }
        document.addEventListener('DOMContentLoaded', function() {
            const checkAll = document.getElementById('checkAll');
            const checkboxes = document.querySelectorAll('input[name="checkList"]');

            checkAll.addEventListener('change', function() {
                checkboxes.forEach(checkbox => checkbox.checked = checkAll.checked);
            });
        });
        $('#btn-clear').click(function (){
            $('#listForm').find('input[type="text"], input[type="number"], input[type="email"], select, textarea').val('');
            $('#listForm').find('input[type="checkbox"]').prop('checked', false);
        })
    </script>
</body>
</html>