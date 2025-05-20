<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String role = (String) session.getAttribute("role");
    if (role == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Management | Real Estate System</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="Dashboard/CSS/style.css">
    <link rel="stylesheet" href="Dashboard/CSS/appoinmentOverview.css">
</head>
<body>
<div class="admin-container">
    <!-- Sidebar Navigation -->
    <div class="sidebar">
        <div class="logo">
            <h2><i class="fas fa-home"></i> RealEstate Admin</h2>
        </div>
        <ul class="nav-menu">
		    <li><a href="dashboard.jsp"><i class="fas fa-tachometer-alt"></i> Dashboard</a></li>
		
		    <c:if test="${role == 'Agent'}">
		        <li><a href="userManager"><i class="fas fa-users"></i> Users</a></li>
		        <li><a href="ReadAppointmentData"><i class="fas fa-calendar-check"></i> Appointments</a></li>
		        <li><a href="ReadReviewAgent"><i class="fas fa-star"></i> Review</a></li>
		    </c:if>
		        
		    <c:if test="${role == 'User'}">
		    	<li><a href="agentsuserDB"><i class="fas fa-user-tie"></i> Agents</a></li>
		        <li><a href="getAppointments"><i class="fas fa-calendar-check"></i> Appointment Calendar</a></li>
		    	<li><a href="getAgents"><i class="fas fa-calendar-check"></i> Appointment Booking</a></li>
		    	<li><a href="RescheduleAppointment.jsp"><i class="fas fa-calendar-check"></i> Reschedule Appointment</a></li>
		    	<li><a href="AgentsReview"><i class="fas fa-star"></i> Review</a></li>
		    </c:if>
		    
		    <c:if test="${role == 'Admin'}">
		    <li><a href="agentsAdminDB"><i class="fas fa-user-tie"></i> Agents</a></li>
		    	<li><a href="appointmentOverview" class="active"><i class="fas fa-calendar-check"></i> Appointments</a></li>
		        <li><a href="adminManagement"><i class="fas fa-user-shield"></i> Admins</a></li>
		        <li><a href="ReadReviewData"><i class="fas fa-star"></i> Review</a></li>
		    </c:if>
		    
		    	<li><a href="#"><i class="fas fa-star"></i> Top Agent</a></li>
		    	<li><a href="logout"><i class="fas fa-star"></i> Logout</a></li>
		</ul>
    </div>

    <!-- Main Content Area -->
    <div class="main-content">
        <div class="header">
            <h3>Appointment Overview</h3>
        </div>

        <div class="controls">
            <input type="text" placeholder="Search appointments...">
            <div class="sort-dropdown">
                <label for="sort">Sort by Status</label>
                <select id="sort">
                    <option value="all">All</option>
                    <option value="pending">Pending</option>
                    <option value="completed">Completed</option>
                    <option value="cancelled">Cancelled</option>
                </select>
            </div>
        </div>
        <div class="appointments-grid">
         <c:forEach var="appo" items="${appointments}">  
        <div class="appointment-card cancelled">
            <h3>${appo.agent}</h3>
            <p><strong>Client:</strong>${appo.client}</p>
            <p><strong>Date AND Time :</strong> ${appo.datetime}</p>
           <c:choose>
            	<c:when test="${appo.status == 'Cancelled'}">
            		<span class="status cancelled">cancelled</span>
            	</c:when>
            	<c:when test="${appo.status == 'Completed'}">
            		<span class="status completed">completed</span>
            	</c:when>
            	<c:when test="${appo.status == 'Pending'}">
            		<span class="status pending">pending</span>
            	</c:when>
            </c:choose>
        </div>
 		</c:forEach>
        </div>
        </div>


    </div>
</div>
<script src="Dashboard/JS/appoinmentOverview.js"></script>
</body>
</html>
