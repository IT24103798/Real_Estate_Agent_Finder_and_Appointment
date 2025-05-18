<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Real Estate Agent Finder</title>

    <!-- Bootstrap CSS CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Font Awesome for icons -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">

    <!-- AOS Animation Library -->
    <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="HomePage/CSS/style.css">
</head>
<body>

<!-- Current User Info -->
<div class="current-info">
    <i class="fas fa-user-circle"></i>
    Current User: IT24100087
    <span class="mx-3">|</span>
    <i class="far fa-clock"></i>
    <span class="datetime">Loading...</span>
</div>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">
            <i class="fas fa-home"></i> RealEstate Finder
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp"><i class="fas fa-home"></i> Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="login.jsp"><i class="fas fa-sign-in-alt"></i> Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="register.jsp"><i class="fas fa-user-plus"></i> Register</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Hero Section -->
<section class="hero-section d-flex align-items-center">
    <div class="container text-center" data-aos="fade-up">
        <h1 class="display-4 mb-4"><b>Find Your Perfect Real Estate Agent</b></h1>
        <p class="lead mb-4">Connect with top-rated agents in your area and schedule appointments instantly</p>
        <a href="register.jsp" class="btn btn-lg btn-custom" style="background-color: #ff4d4d; color: white;">
            <i class="fas fa-search"></i> Find an Agent
        </a>
    </div>
</section>

<!-- Features Section -->
<section class="py-5">
    <div class="container">
        <h2 class="text-center mb-5" data-aos="fade-up">Why Choose Us</h2>
        <div class="row">
            <div class="col-md-4 mb-4" data-aos="fade-up" data-aos-delay="100">
                <div class="card text-center h-100 featured-agent-card">
                    <div class="card-body"><a href="#" style="text-decoration: none; color: #000;">
                        <i class="fas fa-star fa-3x mb-3" style="color: #ff4d4d;"></i>
                        <h5 class="card-title">Top-Rated Agents</h5>
                        <p class="card-text">Access to the best real estate professionals in your area.</p>
                    </div></a>
                </div>
            </div>
            <div class="col-md-4 mb-4" data-aos="fade-up" data-aos-delay="200">
                <div class="card text-center h-100 featured-agent-card">
                    <div class="card-body"><a href="AppointmentBooking.jsp" style="text-decoration: none; color: #000;">
                        <i class="fas fa-calendar-alt fa-3x mb-3" style="color: #ff4d4d;"></i>
                        <h5 class="card-title">Easy Scheduling</h5>
                        <p class="card-text">Book appointments with agents instantly online.</p>
                    </div></a>
                </div>
            </div>
            <div class="col-md-4 mb-4" data-aos="fade-up" data-aos-delay="300">
                <div class="card text-center h-100 featured-agent-card">
                    <div class="card-body"><a href="#" style="text-decoration: none; color: #000;">
                        <i class="fas fa-shield-alt fa-3x mb-3" style="color: #ff4d4d;"></i>
                        <h5 class="card-title">Verified Agents</h5>
                        <p class="card-text">All agents are verified and trustworthy.</p>
                    </div></a>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Footer -->
<footer class="bg-dark text-white py-4">
    <div class="container text-center">
        <p>&copy; 2025 Real Estate Agent Finder. All rights reserved.</p>
    </div>
</footer>

<!-- Bootstrap JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

<!-- AOS JS -->
<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>

<!-- Custom JS -->
<script src="HomePage/JS/style.js"></script>
</body>
</html>
