
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Submit Agent Review</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="Dashboard/CSS/style.css">
    <link rel="stylesheet" href="Dashboard/CSS/review.css">

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
                <li><a href="appoinmentOverview.jsp"><i class="fas fa-user-tie"></i> Agents</a></li>
                <li><a href="userManager"><i class="fas fa-users"></i> Users</a></li>
                <li><a href="appointmentOverview"><i class="fas fa-calendar-check"></i> Appointments</a></li>
                <li><a href="#"><i class="fas fa-star"></i> Review</a></li>
            </c:if>

            <c:if test="${role == 'User'}">
                <li><a href="appoinmentOverview.jsp"><i class="fas fa-user-tie"></i> Agents</a></li>
                <li><a href="getAppointments"><i class="fas fa-calendar-check"></i> Appointment Calendar</a></li>
                <li><a href="getAgents"><i class="fas fa-calendar-check"></i> Appointment Booking</a></li>
                <li><a href="RescheduleAppointment.jsp"><i class="fas fa-calendar-check"></i> Reschedule Appointment</a></li>
                <li><a href="AgentsReview" class="active"><i class="fas fa-star"></i> Review</a></li>
            </c:if>

            <c:if test="${role == 'Admin'}">
                <li><a href="appoinmentOverview.jsp"><i class="fas fa-user-tie"></i> Agents</a></li>
                <li><a href="appointmentOverview"><i class="fas fa-calendar-check"></i> Appointments</a></li>
                <li><a href="adminManagement"><i class="fas fa-user-shield"></i> Admins</a></li>
                <li><a href="#"><i class="fas fa-star"></i> Review</a></li>
            </c:if>

            <li><a href="#"><i class="fas fa-star"></i> Top Agent</a></li>
            <li><a href="logout"><i class="fas fa-star"></i> Logout</a></li>
        </ul>

    </div>

    <div class="main-content">
        <h2>Submit Your Review</h2>

        <!-- Review Form -->
        <form action="submitReview" method="post">

            <label for="agent">Agent Name</label>
            <select id="type" name="agentName" id="agentName" >
                <c:forEach var="agentname" items="${agents}">
                    <option value="${agentname}">${agentname}</option>
                </c:forEach>
            </select>

            <label for="review">Your Review:</label>
            <textarea id="review" name="review" required></textarea>

            <label>Rating:</label>
            <div class="stars" id="starContainer"></div>
            <input type="hidden" id="rating" name="rating" required>

            <button type="submit">Submit Review</button>
        </form>

    </div>
    <script>
        const starContainer = document.getElementById("starContainer");
        const ratingInput = document.getElementById("rating");

        for (let i = 1; i <= 5; i++) {
            const star = document.createElement("span");
            star.textContent = "*";
            star.style.fontSize = "24px";
            star.style.cursor = "pointer";
            star.dataset.value = i;

            star.addEventListener("click", function () {
                ratingInput.value = this.dataset.value;
                highlightStars(i);
            });

            starContainer.appendChild(star);
        }

        function highlightStars(count) {
            const stars = document.querySelectorAll("#starContainer span");
            stars.forEach((star, index) => {
                star.style.color = index < count ? "orange" : "gray";
            });
        }
    </script>
    <script src="Dashboard/JS/style.js"></script>
</body>
</html>