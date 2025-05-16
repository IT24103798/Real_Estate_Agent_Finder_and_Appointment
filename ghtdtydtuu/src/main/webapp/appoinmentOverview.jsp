<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Management | Real Estate System</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="Admin/CSS/admin.css">
    <link rel="stylesheet" href="Admin/CSS/appoinmentOverview.css">
</head>
<body>
<div class="admin-container">
    <!-- Sidebar Navigation -->
    <div class="sidebar">
        <div class="logo">
            <h2><i class="fas fa-home"></i> RealEstate Admin</h2>
        </div>
        <ul class="nav-menu">
            <li><a href="index.jsp"><i class="fas fa-tachometer-alt"></i> Dashboard</a></li>
            <li><a href="Agents.jsp" ><i class="fas fa-user-tie"></i> Agents</a></li>
            <li><a href="#"><i class="fas fa-users"></i> Users</a></li>
            <li><a href="appoinmentOverview.jsp" class="active"><i class="fas fa-calendar-check"></i> Appointments</a></li>
            <li><a href="#"><i class="fas fa-star"></i> Reviews</a></li>
            <li><a href="#"><i class="fas fa-user-shield"></i> Admins</a></li>
        </ul>
    </div>

    <!-- Main Content Area -->
    <div class="main-content">
        <div class="header">
            <h3>Appointment Overview</h3>
            <div class="user-actions">
                <span class="username">Admin User</span>
                <button class="btn-logout"><i class="fas fa-sign-out-alt"></i> Logout</button>
            </div>
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
        <div class="appointment-card cancelled">
            <h3>Tom Brown</h3>
            <p><strong>Client:</strong> Lisa White</p>
            <p><strong>Date:</strong> 2025-05-08</p>
            <p><strong>Time:</strong> 11:00 AM</p>
            <span class="status cancelled">cancelled</span>
        </div>

        <div class="appointment-card completed">
            <h3>Jane Lee</h3>
            <p><strong>Client:</strong> Mark Taylor</p>
            <p><strong>Date:</strong> 2025-05-07</p>
            <p><strong>Time:</strong> 2:00 PM</p>
            <span class="status completed">completed</span>
        </div>

        <div class="appointment-card pending">
            <h3>John Doe</h3>
            <p><strong>Client:</strong> Alice Smith</p>
            <p><strong>Date:</strong> 2025-05-06</p>
            <p><strong>Time:</strong> 10:00 AM</p>
            <span class="status pending">pending</span>
        </div>
        </div>
        </div>


    </div>
</div>
<script src="Admin/JS/appoinmentOverview.js"></script>
</body>
</html>
