// Theme Toggle
const themeToggle = document.getElementById('themeToggle');
const themeIcon = document.getElementById('themeIcon');
const html = document.documentElement;

// Check for saved theme preference or default to light mode
const currentTheme = localStorage.getItem('theme') || 'light';
html.setAttribute('data-theme', currentTheme);
updateThemeIcon(currentTheme);

themeToggle.addEventListener('click', () => {
    const currentTheme = html.getAttribute('data-theme');
    const newTheme = currentTheme === 'dark' ? 'light' : 'dark';

    html.setAttribute('data-theme', newTheme);
    localStorage.setItem('theme', newTheme);
    updateThemeIcon(newTheme);
});

function updateThemeIcon(theme) {
    themeIcon.textContent = theme === 'dark' ? '☀️' : '🌙';
}

// Mobile Menu Toggle
const mobileMenuToggle = document.getElementById('mobileMenuToggle');
const sidebar = document.getElementById('sidebar');

mobileMenuToggle.addEventListener('click', () => {
    sidebar.classList.toggle('open');
});

// Close sidebar when clicking outside on mobile
document.addEventListener('click', (e) => {
    if (window.innerWidth <= 968) {
        if (!sidebar.contains(e.target) && !mobileMenuToggle.contains(e.target)) {
            sidebar.classList.remove('open');
        }
    }
});

// Tab Functionality
document.querySelectorAll('.tab-button').forEach(button => {
    button.addEventListener('click', () => {
        const tabGroup = button.closest('.tabs').nextElementSibling;
        const targetTab = button.getAttribute('data-tab');

        // Remove active from all buttons in this group
        button.parentElement.querySelectorAll('.tab-button').forEach(btn => {
            btn.classList.remove('active');
        });

        // Add active to clicked button
        button.classList.add('active');

        // Hide all tab contents in this group
        let sibling = tabGroup;
        while (sibling && sibling.classList && sibling.classList.contains('tab-content')) {
            sibling.classList.remove('active');
            sibling = sibling.nextElementSibling;
        }

        // Show target tab
        document.getElementById(targetTab).classList.add('active');
    });
});

// Copy Code Button Functionality - Icon inside code block
document.querySelectorAll('pre code').forEach((codeBlock) => {
    const pre = codeBlock.parentElement;

    // Create copy button with icon
    const copyBtn = document.createElement('button');
    copyBtn.className = 'copy-btn-icon';
    copyBtn.innerHTML = '<svg width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"><rect x="9" y="9" width="13" height="13" rx="2" ry="2"></rect><path d="M5 15H4a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h9a2 2 0 0 1 2 2v1"></path></svg>';
    copyBtn.title = 'Copy code';

    copyBtn.addEventListener('click', async () => {
        try {
            await navigator.clipboard.writeText(codeBlock.textContent);
            copyBtn.innerHTML = '<svg width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"><polyline points="20 6 9 17 4 12"></polyline></svg>';
            copyBtn.classList.add('copied');
            setTimeout(() => {
                copyBtn.innerHTML = '<svg width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"><rect x="9" y="9" width="13" height="13" rx="2" ry="2"></rect><path d="M5 15H4a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h9a2 2 0 0 1 2 2v1"></path></svg>';
                copyBtn.classList.remove('copied');
            }, 2000);
        } catch (err) {
            console.error('Failed to copy:', err);
        }
    });

    pre.appendChild(copyBtn);
    pre.style.position = 'relative';
});

// Smooth Scroll for Anchor Links
document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function (e) {
        e.preventDefault();
        const target = document.querySelector(this.getAttribute('href'));
        if (target) {
            target.scrollIntoView({
                behavior: 'smooth',
                block: 'start'
            });

            // Close mobile menu after navigation
            if (window.innerWidth <= 968) {
                sidebar.classList.remove('open');
            }
        }
    });
});

// Highlight current section in sidebar on scroll
const observerOptions = {
    root: null,
    rootMargin: '-20% 0px -35% 0px',
    threshold: 0
};

const observer = new IntersectionObserver((entries) => {
    entries.forEach(entry => {
        if (entry.isIntersecting) {
            const id = entry.target.getAttribute('id');
            if (id) {
                // Remove active from all sidebar links
                document.querySelectorAll('.sidebar a').forEach(link => {
                    link.classList.remove('active');
                });

                // Add active to corresponding sidebar link
                const activeLink = document.querySelector(`.sidebar a[href*="#${id}"]`);
                if (activeLink) {
                    activeLink.classList.add('active');
                }
            }
        }
    });
}, observerOptions);

// Observe all sections with IDs
document.querySelectorAll('section[id], h2[id], h3[id]').forEach(section => {
    observer.observe(section);
});

// Add keyboard navigation
document.addEventListener('keydown', (e) => {
    // Close sidebar with Escape key on mobile
    if (e.key === 'Escape' && window.innerWidth <= 968) {
        sidebar.classList.remove('open');
    }
});

// Print current page setup
window.addEventListener('beforeprint', () => {
    sidebar.classList.add('print-hidden');
});

window.addEventListener('afterprint', () => {
    sidebar.classList.remove('print-hidden');
});

console.log('Country-Picker Documentation v2.1.5 - Loaded Successfully');
