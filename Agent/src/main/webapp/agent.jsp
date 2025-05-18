<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Create Agent Account - Real Estate Finder</title>
  <!-- Bootstrap CDN -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">

  <link rel="stylesheet" href="Agent/CSS/style.css">
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
        <span class="datetime">2025-04-27 10:42:51</span>
      </div>

      <div class="registration-card fade-in">
        <!-- Back Button -->
        <button onclick="window.location.href='register.jsp'" class="btn btn-back">
          <i class="fas fa-arrow-left me-2"></i> Back
        </button>

        <div class="text-center mb-4">
          <h2 style="color: var(--primary-color);">Create Agent Account</h2>
          <p class="text-muted">Join our network of professional agents!</p>
        </div>

        <form action="AgentRegistration" method="post" id="agentRegistrationForm">
          <div class="row">
            <div class="col-md-12">
              <div class="form-group">
                <input type="text" class="form-control" name="Username" placeholder="Username" required>
              </div>
            </div>

            <div class="col-md-12">
              <div class="form-group">
                <input type="text" class="form-control" name="fullName" placeholder="Full Name" required>
              </div>
            </div>

            <div class="col-md-6">
              <div class="form-group">
                <input type="email" class="form-control" name="email" placeholder="Email Address" required>
              </div>
            </div>

            <div class="col-md-6">
              <div class="form-group">
                <input type="tel" class="form-control" name="phone" placeholder="Phone Number" required>
              </div>
            </div>

            <div class="col-md-6">
              <div class="form-group">
                <input type="text" class="form-control" name="licenseNumber" placeholder="License Number" required>
              </div>
            </div>

            <div class="col-md-6">
              <div class="form-group">
                <input type="text" class="form-control" name="agencyName" placeholder="Agency Name" required>
              </div>
            </div>

            <div class="col-md-6">
              <div class="form-group">
                <input type="password" class="form-control" name="password" placeholder="Password" required>
              </div>
            </div>

            <div class="col-md-6">
              <div class="form-group">
                <input type="password" class="form-control" name="confirmPassword" placeholder="Confirm Password" required>
              </div>
            </div>

            <div class="col-md-12">
              <div class="form-group">
                <input type="text" class="form-control" name="areasServed" placeholder="Areas Served" required>
              </div>
            </div>

            <div class="col-md-12">
              <div class="form-group">
                <textarea class="form-control" name="bio" placeholder="Brief Bio" rows="3"></textarea>
              </div>
            </div>
          </div>

          <button type="submit" class="btn btn-signup">
            Sign Up <i class="fas fa-arrow-right ms-2"></i>
          </button>

          <div class="text-center mt-4">
            <p>Already have an account? <a href="login.jsp" class="text-decoration-none" style="color: var(--highlight-color);">Sign In</a></p>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>

<!-- Scripts -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

<script src="Agent/JS/style.js"></script>

</body>
</html>