document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("signupForm");
    const password = document.getElementById("password");
    const confirmPassword = document.getElementById("confirmPassword");

    form.addEventListener("submit", function (event) {
        if (password.value !== confirmPassword.value) {
            event.preventDefault(); // prevent form from submitting
            alert("Passwords do not match. Please try again.");
            confirmPassword.focus();
        }
    });
});
