<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Management | Real Estate System</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="Admin/CSS/admin.css">
</head>
<body>
<div class="admin-container">
    <!-- Sidebar Navigation -->
    <div class="sidebar">
        <div class="logo">
            <h2><i class="fas fa-home"></i> RealEstate Admin</h2>
        </div>
        <ul class="nav-menu">
            <li><a href="index.jsp" class="active"><i class="fas fa-tachometer-alt"></i> Dashboard</a></li>
            <li><a href="Agents.jsp"><i class="fas fa-user-tie"></i> Agents</a></li>
            <li><a href="#"><i class="fas fa-users"></i> Users</a></li>
            <li><a href="appoinmentOverview.jsp"><i class="fas fa-calendar-check"></i> Appointments</a></li>
            <li><a href="#"><i class="fas fa-star"></i> Reviews</a></li>
            <li><a href="#"><i class="fas fa-user-shield"></i> Admins</a></li>
        </ul>
    </div>

    <!-- Main Content Area -->
    <div class="main-content">
        <div class="header">
            <h3>Admin Management</h3>
            <div class="user-actions">
                <span class="username">Admin User</span>
                <button class="btn-logout"><i class="fas fa-sign-out-alt"></i> Logout</button>
            </div>
        </div>

        <!-- Admin Management Section -->
        <div class="admin-management">
            <div class="section-header">
                <h4>System Admins</h4>
                <button class="btn-add-admin" onclick="Admin()" id="addAdminBtn">
                    <i class="fas fa-plus"></i> Add Admin
                </button>
            </div>

            <!-- Admin Listing Table -->
            <div class="admin-table-container">
                <table class="admin-table">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Role</th>
                        <th>Last Login</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody id="adminTableBody">
                    <!-- Will be populated by JavaScript -->
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<!-- Add Admin Modal -->
<div class="modal" id="adminModal">
    <div class="modal-content">
        <button onclick="Admin()">
            <span class="close-modal">&times;</span>
        </button>

        <h3>Add New Admin</h3>
        <form id="adminForm">
            <div class="form-group">
                <label for="adminName">Full Name</label>
                <input type="text" id="adminName" required>
            </div>
            <div class="form-group">
                <label for="adminEmail">Email</label>
                <input type="email" id="adminEmail" required>
            </div>
            <button type="submit" class="btn-submit">Create Admin</button>
        </form>
    </div>
</div>
<script src="Admin/JS/admin.js"></script>
</body>
</html>
