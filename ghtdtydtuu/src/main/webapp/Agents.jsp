<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Admin Management | Real Estate System</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
  <link rel="stylesheet" href="Admin/CSS/admin.css">
  <link rel="stylesheet" href="Admin/CSS/Agents.css">
</head>
<body>
<div class="admin-container">
  <!-- Sidebar Navigation -->
  <div class="sidebar">
    <div class="logo">
      <h2><i class="fas fa-home"></i> RealEstate Admin</h2>
    </div>
    <ul class="nav-menu">
      <li><a href="Admin.jsp"><i class="fas fa-tachometer-alt"></i> Dashboard</a></li>
      <li><a href="Agents.jsp"  class="active"><i class="fas fa-user-tie"></i> Agents</a></li>
      <li><a href="#"><i class="fas fa-users"></i> Users</a></li>
      <li><a href="appoinmentOverview.jsp"><i class="fas fa-calendar-check"></i> Appointments</a></li>
      <li><a href="#"><i class="fas fa-star"></i> Reviews</a></li>
      <li><a href="#"><i class="fas fa-user-shield"></i> Admins</a></li>
    </ul>
  </div>

  <!-- Main Content Area -->
  <div class="main-content">
    <div class="header">
      <h3>Agent Management Panel</h3>
      <div class="user-actions">
        <span class="username">Admin User</span>
        <button class="btn-logout"><i class="fas fa-sign-out-alt"></i> Logout</button>
      </div>
    </div>

    <section class="agent-overview">
      <h2>Agent Overview</h2>
      <div class="agent-cards-grid">
        <div class="agent-card active">
          <h3>John Doe</h3>
          <p><strong>Status:</strong> <span class="status active">Active</span></p>
          <p><strong>Appointments:</strong> 5</p>
        </div>
        <div class="agent-card inactive">
          <h3>Jane Lee</h3>
          <p><strong>Status:</strong> <span class="status inactive">Inactive</span></p>
          <p><strong>Appointments:</strong> 3</p>
        </div>
        <div class="agent-card active">
          <h3>Tom Brown</h3>
          <p><strong>Status:</strong> <span class="status active">Active</span></p>
          <p><strong>Appointments:</strong> 7</p>
        </div>
      </div>
    </section>

  </div>


</div>
</div>
<script src="Admin/JS/appoinmentOverview.js"></script>
</body>
</html>
