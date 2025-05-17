// script.js

// Initialize AOS
AOS.init({
    duration: 1000,
    once: true
});

// Smooth scrolling
document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function (e) {
        e.preventDefault();
        document.querySelector(this.getAttribute('href')).scrollIntoView({
            behavior: 'smooth'
        });
    });
});

// Format and update time
function formatDate(date) {
    return date.getUTCFullYear() + '-' +
        String(date.getUTCMonth() + 1).padStart(2, '0') + '-' +
        String(date.getUTCDate()).padStart(2, '0') + ' ' +
        String(date.getUTCHours()).padStart(2, '0') + ':' +
        String(date.getUTCMinutes()).padStart(2, '0') + ':' +
        String(date.getUTCSeconds()).padStart(2, '0');
}

setInterval(() => {
    const now = new Date();
    document.querySelector('.datetime').textContent = formatDate(now);
}, 1000);

// Initialize time
document.querySelector('.datetime').textContent = formatDate(new Date());
