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

// Copy Code Button Functionality
document.querySelectorAll('pre code').forEach((codeBlock) => {
    const pre = codeBlock.parentElement;
    const wrapper = document.createElement('div');
    wrapper.className = 'code-wrapper';

    const header = document.createElement('div');
    header.className = 'code-header';

    const language = codeBlock.className.replace('language-', '') || 'code';
    const langLabel = document.createElement('span');
    langLabel.className = 'code-language';
    langLabel.textContent = language;

    const copyBtn = document.createElement('button');
    copyBtn.className = 'copy-btn';
    copyBtn.textContent = 'Copy';
    copyBtn.addEventListener('click', async () => {
        try {
            await navigator.clipboard.writeText(codeBlock.textContent);
            copyBtn.textContent = 'Copied!';
            copyBtn.classList.add('copied');
            setTimeout(() => {
                copyBtn.textContent = 'Copy';
                copyBtn.classList.remove('copied');
            }, 2000);
        } catch (err) {
            console.error('Failed to copy:', err);
            copyBtn.textContent = 'Error';
            setTimeout(() => {
                copyBtn.textContent = 'Copy';
            }, 2000);
        }
    });

    header.appendChild(langLabel);
    header.appendChild(copyBtn);

    pre.parentElement.insertBefore(header, pre);
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
