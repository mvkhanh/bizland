<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="homeUrl" value="/admin/home"/>
<c:url var="buildingEditUrl" value="/admin/buildings-edit"/>
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
                <li class="active">Danh sách toà nhà</li>
            </ul><!-- /.breadcrumb -->
        </div>

        <div class="page-content">
            <div class="page-header">
                <h1>
                    Danh sách toà nhà
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
                                <form:form id="listForm" action="${buildingsUrl}" method="get" modelAttribute="search">
                                    <div class="row">
                                        <div class="col-xs-6">
                                            <label>Tên toà nhà</label>
                                            <form:input class="form-control" placeholder="Nhập tên toà nhà" path="name"/>
                                        </div>
                                        <div class="col-xs-6">
                                            <label>Diện tích sàn</label>
                                            <form:input class="form-control" placeholder="Nhập diện tích sàn" path="floorArea"/>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-xs-2">
                                            <label>Quận</label>
                                            <form:select class="form-control" path="district">
                                                <form:option value="">--Chọn quận--</form:option>
                                                <form:options items="${districts}"/>
                                            </form:select>
                                        </div>
                                        <div class="col-xs-5">
                                            <label>Phường</label>
                                            <form:input class="form-control" placeholder="Nhập phường" path="ward"/>
                                        </div>
                                        <div class="col-xs-5">
                                            <label>Đường</label>
                                            <form:input class="form-control" placeholder="Nhập đường" path="street"/>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-xs-4">
                                            <label>Số tầng hầm</label>
                                            <form:input class="form-control" placeholder="Nhập số tầng hầm" path="numberOfBasements"/>
                                        </div>
                                        <div class="col-xs-4">
                                            <label>Hướng</label>
                                            <form:input class="form-control" placeholder="Nhập hướng" path="direction"/>
                                        </div>
                                        <div class="col-xs-4">
                                            <label>Hạng</label>
                                            <form:input class="form-control" placeholder="Nhập hạng" path="level"/>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-xs-3">
                                            <label>Diện tích từ</label>
                                            <form:input class="form-control" placeholder="Nhập diện tích từ" path="areaFrom"/>
                                        </div>
                                        <div class="col-xs-3">
                                            <label>Diện tích đến</label>
                                            <form:input class="form-control" placeholder="Nhập diện tích đến" path="areaTo"/>
                                        </div>
                                        <div class="col-xs-3">
                                            <label>Giá thuê từ</label>
                                            <form:input class="form-control" placeholder="Nhập giá thuê từ" path="rentPriceFrom"/>
                                        </div>
                                        <div class="col-xs-3">
                                            <label>Giá thuê đến</label>
                                            <form:input class="form-control" placeholder="Nhập giá thuê đến" path="rentPriceTo"/>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-xs-4">
                                            <label>Tên quản lý</label>
                                            <form:input class="form-control" placeholder="Nhập tên quản lý" path="managerName"/>
                                        </div>
                                        <div class="col-xs-4">
                                            <label>SĐT quản lý</label>
                                            <form:input class="form-control" placeholder="Nhập số điện thoại quản lý" path="managerPhone"/>
                                        </div>
                                        <div class="col-xs-2">
                                            <label>Nhân viên phụ trách</label>
                                            <form:select class="form-control" path="id_staff">
                                                <form:option value="">--Chọn nhân viên--</form:option>
                                                <form:options items="${staffs}"/>
                                            </form:select>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-xs-12">
                                            <form:checkboxes path="typeCodes" items="${typecodes}"/>
                                        </div>
                                    </div>
                                    <div class="row">
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
                        <a href="${buildingEditUrl}">
                            <button class="flat-btn" title="Thêm toà nhà">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="blue" class="bi bi-building-add" viewBox="0 0 16 16">
                                    <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7m.5-5v1h1a.5.5 0 0 1 0 1h-1v1a.5.5 0 0 1-1 0v-1h-1a.5.5 0 0 1 0-1h1v-1a.5.5 0 0 1 1 0"/>
                                    <path d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v6.5a.5.5 0 0 1-1 0V1H3v14h3v-2.5a.5.5 0 0 1 .5-.5H8v4H3a1 1 0 0 1-1-1z"/>
                                    <path d="M4.5 2a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"/>
                                </svg>
                            </button>
                        </a>
                        <button class="flat-btn" title="Xoá toà nhà" id="btn-delete">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="red" class="bi bi-building-dash" viewBox="0 0 16 16">
                                <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7M11 12h3a.5.5 0 0 1 0 1h-3a.5.5 0 0 1 0-1"/>
                                <path d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v6.5a.5.5 0 0 1-1 0V1H3v14h3v-2.5a.5.5 0 0 1 .5-.5H8v4H3a1 1 0 0 1-1-1z"/>
                                <path d="M4.5 2a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"/>
                            </svg>
                        </button>
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
                            <th>Tên toà nhà</th>
                            <th>Địa chỉ</th>
                            <th>Số tầng hầm</th>
                            <th>Tên quản lý</th>
                            <th>Số điện thoại</th>
                            <th>Diện tích sàn</th>
                            <th>Diện tích trống</th>
                            <th>Diện tích thuê</th>
                            <th>Giá thuê</th>
                            <th>Phí dịch vụ</th>
                            <th>Phí môi giới</th>
                            <th>Thao tác</th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach var="building" items="${result}">
                            <tr data-id="${building.id}">
                                <td class="center">
                                    <label class="pos-rel">
                                        <input type="checkbox" class="ace" name="checkList" value="${building.id}">
                                        <span class="lbl"></span>
                                    </label>
                                </td>

                                <td>${building.name}</td>

                                <td>${building.address}</td>
                                <td>${building.numberOfBasements}</td>
                                <td>${building.managerName}</td>
                                <td>${building.managerPhone}</td>
                                <td>${building.floorArea}</td>
                                <td>${building.leftArea}</td>
                                <td>${building.rentAreas}</td>
                                <td>${building.rentPrice}</td>
                                <td>${building.serviceFee}</td>
                                <td>${building.brokerageFee}</td>
                                <td>
                                    <div class="hidden-sm hidden-xs btn-group">
                                        <button class="btn btn-xs btn-success" title="Giao toà nhà" onclick="assignBuidling(${building.id})">
                                            <i class="ace-icon glyphicon glyphicon-list"></i>
                                        </button>

                                        <a class="btn btn-xs btn-info" href="${buildingEditUrl}-${building.id}">
                                            <i class="ace-icon fa fa-pencil bigger-120" title="Chỉnh sửa thông tin toà nhà"></i>
                                        </a>
                                        <button class="btn btn-xs btn-danger" title="Xoá toà nhà" onclick="deleteBuilding(${building.id})">
                                            <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div><!-- /.span -->
            </div>
        </div><!-- /.page-content -->
    </div>
    <div id="assignBuidlingModal" class="modal fade" role="dialog" style="font-family: 'Times New Roman', Times, serif;">
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
                    <input type="hidden" id="buildingId">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-success" id="btn-assign-building">Giao toà nhà</button>
                    <button type="button" class="btn btn-info" data-dismiss="modal" id="btn-close-modal">Đóng</button>
                </div>
            </div>
        </div>
    </div>


    <script>
        function assignBuidling(buildingId){
            $('#assignBuidlingModal').modal();
            getStaffs(buildingId);
            $('#buildingId').val(buildingId);
        }
        function getStaffs(buildingId){
            $.ajax({
                type:"get",
                url:"${buildingsUrl}/" + buildingId + "/staffs",
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
        function assignBuildingQuery(data){
            $.ajax({
                type : "PUT",
                url : "${buildingsUrl}/assignment",
                data: JSON.stringify(data),
                contentType : "Application/JSON",
                success:function (){
                    $('#btn-close-modal').click();
                    showSuccessMessage("Giao toà nhà thành công!", '');
                },
                error:function (){
                    showErrorMessage('There was an error processing your request.');
                }
            })
        }
        $('#btn-assign-building').click(function(e){
            e.preventDefault();
            var data = {};
            data['buildingId'] = $('#buildingId').val();
            data['staffIds'] = $('#staffList').find('tbody input[type = checkbox]:checked').map(function () {
                return $(this).val();
            }).get();
            if(data['staffIds'].length > 0) assignBuildingQuery(data);
        });

        $('#btn-search').click(function (e){
            e.preventDefault();
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
                if (result.isConfirmed) deleteBuildings(ids);
            });
        }
        $('#btn-delete').click(function () {
            let ids = $('#table').find('tbody input[type=checkbox]:checked').map(function () {
                return $(this).val();
            }).get();
            if (ids.length > 0) confirmDelete(ids);
        });
        function deleteBuilding(id){
            confirmDelete([id]);
        }
        function deleteBuildings(ids){
            $.ajax({
                type:"delete",
                url:"${buildingsUrl}/" + ids,
                data:JSON.stringify(ids),
                contentType:"Application/JSON",
                datatype:"JSON",
                success: function () {
                    console.log("Success");
                    ids.forEach(id => $('#table tbody tr[data-id="' + id + '"]').remove());
                    showSuccessMessage("Đã xoá toà nhà thành công!", '');
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
    </script>
</body>
</html>