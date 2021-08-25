<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>TỜ KHAI Y TẾ</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div align="center">
  <h2><b>TỜ KHAI Y TẾ</b></h2>
  <h4>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ
    PHÒNG CHÓNG DỊCH</h4>
  <b style="color: red">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật</b>
  <h3 style="color: palegreen"><c:if test="${msg!=null}">
    ${msg}
  </c:if>
  </h3>
</div>
<div class="container-fluid col-lg-12">
  <form:form modelAttribute="peoples" cssClass="row g-3" method="post" action="/peoples/edit">
    <div class="col-12">
      <label for="input-id" class="form-label">ID</label>
      <form:input path="id" id="input-id" cssClass="form-control"/>
    </div>
    <div class="col-12">
      <label for="input-name" class="form-label">Họ và tên</label>
      <form:input path="name" id="input-name" cssClass="form-control"/>
    </div>
    <div class="col-md-4">
      <label for="input-year" class="form-label">Năm sinh</label>
      <form:input path="year" id="input-year" cssClass="form-control"/>
    </div>
    <div class="col-md-4">
      <label for="choose-gender" class="form-label">Giới tính</label>
      <form:select path="gender" id="choose-gender" cssClass="form-control">
        <form:option value="Nam">Nam</form:option>
        <form:option value="Nữ">Nữ</form:option>
        <form:option value="Other">Other</form:option>
      </form:select>
    </div>
    <div class="col-md-4">
      <label for="input-nationality" class="form-label">Quốc tịch</label>
      <form:input path="nationality" id="input-nationality" cssClass="form-control"/>
    </div>
    <div class="col-12">
      <label for="input-cmnd" class="form-label">Số hộ chiếu hoặc CMND</label>
      <form:input path="idCard" id="input-cmnd" cssClass="form-control"/>
    </div>
    <div class="col-12">
      <label class="form-label">Thông tin đi lại</label>
      <br>
      <form:radiobutton path="travelInformation" value="Tàu bay" label="Tàu bay"/>
      <form:radiobutton path="travelInformation" value="Tàu thuyền" label="Tàu thuyền"/>
      <form:radiobutton path="travelInformation" value="Ô tô" label="Ô tô"/>
      <form:radiobutton path="travelInformation" value="Khác" label="Khác"/>
    </div>
    <div class="col-md-6">
      <label for="input-shpt" class="form-label">Số hiệu phương tiện </label>
      <form:input path="vehicleNumber" id="input-shpt" cssClass="form-control"/>
    </div>
    <div class="col-md-6">
      <label for="input-soghe" class="form-label">Số ghế</label>
      <form:input path="seats" id="input-soghe" cssClass="form-control"/>
    </div>
    <div class="col-md-6">
      <label for="date-start" class="form-label">Ngày khởi hành</label>
      <form:input path="startDay" id="date-start" cssClass="form-control"/>
    </div>
    <div class="col-md-6">
      <label for="day-end" class="form-label">Ngày kết thúc </label>
      <form:input path="endDay" id="day-end" cssClass="form-control"/>
    </div>
    <div class="col-12">
      <label for="di-chuyen" class="form-label">Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh thành phố
        nào? </label><br>
      <form:textarea path="information" id="di-chuyen" rows="3" cssClass="form-control"/>
    </div>
    <div class="col-12">
      <h4>Địa chỉ liên lạc</h4>
    </div>
    <div class="col-md-4">
      <label for="input-city" class="form-label">Tỉnh/Thành phố</label>
      <form:input path="city" id="input-city" cssClass="form-control"/>
    </div>
    <div class="col-md-4">
      <label for="input-district" class="form-label">Quận/huyện</label>
      <form:input path="district" id="input-district" cssClass="form-control"/>
    </div>
    <div class="col-md-4">
      <label for="input-commune" class="form-label">Xã/phường</label>
      <form:input path="commune" id="input-commune" cssClass="form-control"/>
    </div>
    <div class="col-12">
      <label for="address" class="form-label">Địa chỉ nơi ở</label>
      <form:input path="address" id="address" cssClass="form-control"/>
    </div>
    <div class="col-md-6">
      <label for="input-phone" class="form-label">Điện thoại</label>
      <form:input path="phoneNumber" id="input-phone" cssClass="form-control"/>
    </div>
    <div class="col-md-6">
      <label for="input-email" class="form-label">Email</label>
      <form:input path="email" id="input-email" cssClass="form-control"/>
    </div>

    <div class="col-12">
      <b>Trong vòng 14  ngày qua, Anh/Chị có xuất hiện triệu chứng nào sau đây không</b><br>
      <label for="input-symptom" class="form-label">Sốt, ho, khó thở, đau họng, nôn/buồn nôn,
        tiêu chảy, xuất huyết ngoài da, nổi ban</label>
      <form:textarea path="symptom" id="input-symptom" cssClass="form-control"/>
    </div>
    <div class="col-12">
      <b>Lịch sữ phơi nhiễm:Trong vòng 14 ngày qua, Anh/Chị có?</b><br>
      <label for="input-exposureHistory" class="form-label">Đến trang trại chăn nuôi buôn bán giết mổ động vật<br>
        Tiếp xúc gần(<2m) với bệnh nhân</label>
      <form:textarea path="exposureHistory" id="input-exposureHistory" cssClass="form-control"/>
    </div>
    <div class="col-12">
      <p style="color: red">Dữ liệu bạn cung cấp hoàn toàn bảo mật và chỉ phục vụ cho việc phòng chống dịch,
        thuộc quản lý của Ban chỉ đạo quốc gia về Phòng chống dịch Covid-19.<br>
        Khi bạn nhấn núi "Gửi" là bạn đã hiểu và đồng ý</p>
    </div>
    <div class="col-12">
      <div align="center">
        <input id="${peoples.id}" style="background-color: palegreen"  type="submit" value="Gửi tờ khai">
      </div>

    </div>
  </form:form>
</div>
</body>
</html>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>