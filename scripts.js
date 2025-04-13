// Wait for the DOM to be fully loaded
document.addEventListener('DOMContentLoaded', function() {
    // Add active class to current nav item
    const currentPath = window.location.pathname;
    document.querySelectorAll('.nav-link').forEach(link => {
        if (link.getAttribute('href') === currentPath) {
            link.classList.add('active');
        }
    });

    // Initialize tooltips
    var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'));
    var tooltipList = tooltipTriggerList.map(function (tooltipTriggerEl) {
        return new bootstrap.Tooltip(tooltipTriggerEl);
    });

    // Simple function to check if element is in viewport
    function isInViewport(element) {
        const rect = element.getBoundingClientRect();
        return (
            rect.top >= 0 &&
            rect.left >= 0 &&
            rect.bottom <= (window.innerHeight || document.documentElement.clientHeight) &&
            rect.right <= (window.innerWidth || document.documentElement.clientWidth)
        );
    }

    // Function to add animation class to visible cards
    function animateVisibleCards() {
        document.querySelectorAll('.card').forEach(card => {
            if (isInViewport(card) && !card.classList.contains('has-animated')) {
                card.classList.add('animate__animated', 'animate__fadeIn', 'has-animated');
            }
        });
    }

    // Initial check for card animations
    animateVisibleCards();
    
    // Check animations on scroll
    window.addEventListener('scroll', animateVisibleCards);

    // Form validation for create mood form
    const moodForm = document.querySelector('form');
    if (moodForm) {
        moodForm.addEventListener('submit', function(event) {
            const moodSelect = document.getElementById('mood');
            const caption = document.getElementById('caption');
            
            if (!moodSelect.value) {
                event.preventDefault();
                alert('Please select a mood!');
                return false;
            }
            
            if (!caption.value.trim()) {
                event.preventDefault();
                alert('Please enter a caption!');
                return false;
            }

            if (!moodForm.checkValidity()) {
                event.preventDefault();
                event.stopPropagation();
            }
            moodForm.classList.add('was-validated');
        });

        // Preview image URL if provided
        const imageUrlInput = document.getElementById('imageUrl');
        if (imageUrlInput) {
            imageUrlInput.addEventListener('change', function() {
                const previewContainer = document.getElementById('imagePreview');
                if (previewContainer) {
                    if (this.value) {
                        previewContainer.innerHTML = `
                            <img src="${this.value}" class="img-fluid rounded mt-2" 
                                 alt="Preview" style="max-height: 200px;"
                                 onerror="this.onerror=null; this.src='/images/placeholder.jpg';">`;
                    } else {
                        previewContainer.innerHTML = '';
                    }
                }
            });
        }

        // Mood selection preview
        const moodSelect = document.getElementById('mood');
        if (moodSelect) {
            moodSelect.addEventListener('change', function() {
                console.log('Selected mood:', this.value);
                // Update the image preview with a default mood image
                const imageUrlInput = document.getElementById('imageUrl');
                if (imageUrlInput && !imageUrlInput.value) {
                    imageUrlInput.value = `/images/${this.value.toLowerCase()}.jpg`;
                    // Trigger the change event to update preview
                    imageUrlInput.dispatchEvent(new Event('change'));
                }
            });
        }
    }

    // Add mood color classes to badges
    document.querySelectorAll('.badge').forEach(badge => {
        const mood = badge.textContent.toLowerCase();
        badge.classList.add(`mood-${mood}`);
    });

    // Lazy loading for images
    document.querySelectorAll('img[data-src]').forEach(img => {
        img.setAttribute('src', img.getAttribute('data-src'));
        img.onload = function() {
            img.removeAttribute('data-src');
        };
    });

    // Smooth scroll to top
    const scrollTopBtn = document.getElementById('scrollTopBtn');
    if (scrollTopBtn) {
        window.onscroll = function() {
            if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
                scrollTopBtn.style.display = 'block';
            } else {
                scrollTopBtn.style.display = 'none';
            }
        };

        scrollTopBtn.addEventListener('click', function() {
            window.scrollTo({
                top: 0,
                behavior: 'smooth'
            });
        });
    }

    // Add loading state to buttons when clicked
    document.querySelectorAll('.btn').forEach(button => {
        button.addEventListener('click', function() {
            if (!this.classList.contains('dropdown-toggle')) {
                const originalText = this.innerHTML;
                this.innerHTML = '<span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span> Loading...';
                this.disabled = true;

                // Reset button after 2 seconds if not part of a form submission
                if (!this.closest('form')) {
                    setTimeout(() => {
                        this.innerHTML = originalText;
                        this.disabled = false;
                    }, 2000);
                }
            }
        });
    });
}); 