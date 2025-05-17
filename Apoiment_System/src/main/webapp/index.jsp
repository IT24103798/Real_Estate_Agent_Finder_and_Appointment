
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Appointment Booking</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="Dashboard/CSS/style.css">
    <link rel="stylesheet" href="Dashboard/CSS/booking.css">

</head>
<body>
<div class="admin-container">
    <!-- Sidebar Navigation -->
    <div class="sidebar">
        <div class="logo">
            <h2><i class="fas fa-home"></i> RealEstate Dashboard</h2>
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
                <li><a href="getAgents" class="active"><i class="fas fa-calendar-check"></i> Appointment Booking</a></li>
                <li><a href="RescheduleAppointment.jsp"><i class="fas fa-calendar-check"></i> Reschedule Appointment</a></li>
                <li><a href="AgentsReview"><i class="fas fa-star"></i> Review</a></li>
            </c:if>

            <c:if test="${role == 'Admin'}">
                <li><a href="agentsAdminDB"><i class="fas fa-user-tie"></i> Agents</a></li>
                <li><a href="appointmentOverview"><i class="fas fa-calendar-check"></i> Appointments</a></li>
                <li><a href="adminManagement"><i class="fas fa-user-shield"></i> Admins</a></li>
                <li><a href="ReadReviewData"><i class="fas fa-star"></i> Review</a></li>
            </c:if>

            <li><a href="#"><i class="fas fa-star"></i> Top Agent</a></li>
            <li><a href="logout"><i class="fas fa-star"></i> Logout</a></li>
        </ul>

    </div>

    <div class="main-content">
        <div class="container">
            <div class="card">
                <h2>Book Appointment</h2>

                <form action="bookAppointment" method="post">

                    <label for="client">Client Name</label>
                    <input type="text" name="client" id="client" />

                    <label for="agent">Agent Name</label>
                    <select id="type" name="agent" id="agent" >
                        <c:forEach var="agentname" items="${agents}">
                            <option value="${agentname}">${agentname}</option>
                        </c:forEach>

                    </select>

                    <label for="type">Type</label>
                    <select id="type" name="type">
                        <option value="virtual">Virtual</option>
                        <option value="in-person">In-Person</option>
                    </select>

                    <label for="datetime">Date & Time</label>
                    <input type="datetime-local" id="datetime" name="datetime"/>

                    <button type="submit">Book</button>
            </div>
        </div>
    </div>

</div>
<script src="Dashboard/JS/style.js"></script>
</body>
</html>