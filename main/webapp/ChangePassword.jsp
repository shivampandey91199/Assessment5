<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
	<%
	int id = Integer.parseInt(request.getParameter("id"));
	%>
	<%
	String password = (String) request.getAttribute("password");
	if (password != null) {
		out.print(password);
	}
	%>
	<div class="container">
		<div class="row mx-0 justify-content-center">
			<div class="col-md-7 col-lg-5 px-lg-2 col-xl-4 px-xl-0 px-xxl-3">
				<form class="w-100 rounded-1 p-4 border bg-white"
					action="userController" method="post" id="reg">
					<h2 class="text-center">Update Password</h2>
					<label class="d-block mb-4"> <span
						class="form-label d-block"></span> <input type="hidden" name="id"
						value="<%=id%>"> <input name="password" type="password"
						class="form-control" placeholder="Password" required />
					</label> <label class="d-block mb-4"> <span
						class="form-label d-block"></span> <br><input name="cpassword"
						type="password" class="form-control"
						placeholder="Confirm Password" required />
					</label> <label class="d-block mb-4"> <span
						class="form-label d-block"></span> <br><input name="npassword"
						type="password" class="form-control" placeholder="New Password"
						required />
					</label>

					<div class="mb-3">
						<input type="submit" name="action" value="changePassword"
							class="btn btn-primary px-3 rounded-3" onclick="">
					</div>	
			</form>
			</div>
		</div>
	</div>
</body>
</html>