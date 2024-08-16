<%@ page contentType="text/html;charset=UTF-8"%>
<header id="header" class="header sticky-top">

    <div class="topbar d-flex align-items-center">
        <div class="container d-flex justify-content-center justify-content-md-between">
            <div class="contact-info d-flex align-items-center">
                <i class="bi bi-envelope d-flex align-items-center"><a href="mailto:contact@example.com">mvkhanh100204@gmail.com</a></i>
                <i class="bi bi-phone d-flex align-items-center ms-4"><span>+84 364 441 833</span></i>
            </div>
            <div class="social-links d-none d-md-flex align-items-center">
                <a href="#" class="twitter"><i class="bi bi-twitter-x"></i></a>
                <a href="#" class="facebook"><i class="bi bi-facebook"></i></a>
                <a href="#" class="instagram"><i class="bi bi-instagram"></i></a>
                <a href="#" class="linkedin"><i class="bi bi-linkedin"></i></a>
            </div>
        </div>
    </div><!-- End Top Bar -->

    <div class="branding d-flex align-items-cente">

        <div class="container position-relative d-flex align-items-center justify-content-between">
            <a href="/" class="logo d-flex align-items-center">
                <!-- Uncomment the line below if you also wish to use an image logo -->
                <!-- <img src="static/assets/img/logo.png" alt=""> -->
                <h1 class="sitename">BizLand</h1>
            </a>

            <nav id="navmenu" class="navmenu">
                <ul>
                    <li><a href="#hero" class="active">Trang chủ</a></li>
                    <li><a href="#about">Về chúng tôi</a></li>
                    <li><a href="#services">Dịch vụ</a></li>
                    <li><a href="#portfolio">Danh mục toà nhà</a></li>
                    <li><a href="#team">Đội ngũ nhân viên</a></li>
                    <li><a href="#contact">Liên hệ</a></li>
                    <c:if test="${empty sessionScope.user}">
                        <li>
                            <a href="/login">Đăng nhập</a>
                        </li>
                    </c:if>
                    <c:if test="${not empty sessionScope.user}">
                        <li class="dropdown">
                            <a href="#">
                                 <img class="nav-user-photo" src="static/assets/images/avatars/user.jpg" alt="Jason's Photo" />
                                <i class="bi bi-chevron-down toggle-dropdown"></i>
                            </a>
                            <ul>
<%--                                <li><a href="#">Dropdown 1</a></li>--%>
<%--                                <li class="dropdown"><a href="#"><span>Deep Dropdown</span> <i class="bi bi-chevron-down toggle-dropdown"></i></a>--%>
<%--                                    <ul>--%>
<%--                                        <li><a href="#">Deep Dropdown 1</a></li>--%>
<%--                                        <li><a href="#">Deep Dropdown 2</a></li>--%>
<%--                                        <li><a href="#">Deep Dropdown 3</a></li>--%>
<%--                                        <li><a href="#">Deep Dropdown 4</a></li>--%>
<%--                                        <li><a href="#">Deep Dropdown 5</a></li>--%>
<%--                                    </ul>--%>
<%--                                </li>--%>
                                <li><a href="#">Thông tin cá nhân</a></li>
                                <li><a href="#">Cài đặt</a></li>
                                <li><a href="/logout">Đăng xuất</a></li>
                            </ul>
                        </li>
                    </c:if>
                </ul>
                <i class="mobile-nav-toggle d-xl-none bi bi-list"></i>
            </nav>

        </div>

    </div>

</header>
