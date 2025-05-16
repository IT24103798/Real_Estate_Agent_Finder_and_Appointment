document.addEventListener('DOMContentLoaded', function() {
    const searchInput = document.querySelector('input[type="text"]');
    const sortSelect = document.getElementById('sort');
    const appointmentCards = document.querySelectorAll('.appointment-card');

    searchInput.addEventListener('input', function() {
        const searchTerm = this.value.toLowerCase();
        appointmentCards.forEach(card => {
            const title = card.querySelector('h3').textContent.toLowerCase();
            const client = card.querySelector('p:first-child').textContent.toLowerCase();
            if (title.includes(searchTerm) || client.includes(searchTerm)) {
                card.style.display = 'block';
            } else {
                card.style.display = 'none';
            }
        });
    });

    sortSelect.addEventListener('change', function() {
        const selectedStatus = this.value;
        appointmentCards.forEach(card => {
            const status = card.querySelector('.status').textContent.toLowerCase();
            if (selectedStatus === 'all' || status === selectedStatus) {
                card.style.display = 'block';
            } else {
                card.style.display = 'none';
            }
        });
    });
});