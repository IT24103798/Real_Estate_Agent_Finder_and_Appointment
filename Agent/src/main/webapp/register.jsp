<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Register - Real Estate Finder</title>
  <!-- Bootstrap CDN -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">

  <link rel="stylesheet" href="Register/CSS/style.css">
</head>
<body>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark fixed-top">
  <div class="container">
    <a class="navbar-brand" href="index.jsp">
      <i class="fas fa-home"></i> Real Estate Finder
    </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav ms-auto">
        <li class="nav-item">
          <a class="nav-link" href="index.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="About.jsp">About</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="Contact.jsp">Contact</a>
        </li>
      </ul>
    </div>
  </div>
</nav>

<div class="container">
  <div class="row justify-content-center">
    <div class="col-md-8">
      <!-- Current User Info -->
      <div class="current-info text-center fade-in">
        <i class="fas fa-user-circle"></i>
        Current User: IT24100087
        <span class="mx-3">|</span>
        <i class="far fa-clock"></i>
        <span class="datetime">2025-04-27 08:12:14</span>
      </div>

      <div class="register-card fade-in">
        <div class="text-center mb-4">
          <h2 class="mb-3" style="color: var(--primary-color);">Choose Your Role</h2>
          <p class="text-muted">Select the type of account you want to create</p>
        </div>

        <div class="row">
          <div class="col-md-6">
            <div class="role-selector h-100" onclick="selectRole('client')">
              <div class="card-body text-center p-4">
                <div class="role-icon">
                  <i class="fas fa-user"></i>
                </div>
                <h4 class="role-title">I'm a Client</h4>
                <p class="role-description">Looking for the perfect real estate agent</p>
                <a href="client.jsp" class="btn btn-choose-role">
                  Continue as Client
                  <i class="fas fa-arrow-right ms-2"></i>
                </a>
              </div>
            </div>
          </div>

          <div class="col-md-6">
            <div class="role-selector h-100" onclick="selectRole('agent')">
              <div class="card-body text-center p-4">
                <div class="role-icon">
                  <i class="fas fa-house-user"></i>
                </div>
                <h4 class="role-title">I'm an Agent</h4>
                <p class="role-description">Ready to connect with clients</p>
                <a href="agent.jsp" class="btn btn-choose-role">
                  Continue as Agent
                  <i class="fas fa-arrow-right ms-2"></i>
                </a>
              </div>
            </div>
          </div>
        </div>

        <div class="text-center mt-4">
          <p>Already have an account? <a href="login.jsp" class="text-decoration-none" style="color: var(--highlight-color);">Sign In</a></p>
        </div>
      </div>
    </div>
  </div>
</div>

<!-- Scripts -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="Register/JS/style.js"></script>
</body>
</html>