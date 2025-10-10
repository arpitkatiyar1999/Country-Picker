# Country-Picker Documentation Website

This directory contains the static documentation website for the Country-Picker library.

## 📁 Structure

```
docs/
├── index.html                  # Landing page
├── getting-started.html        # Installation guide
├── components.html             # Component documentation
├── utilities.html              # Utility functions reference
├── customization.html          # Styling and customization guide
├── models.html                 # Data models reference
├── examples.html               # Code examples
├── api-reference.html          # Complete API documentation
├── assets/
│   ├── css/
│   │   └── style.css          # Main stylesheet
│   └── js/
│       └── main.js            # Interactive features
└── README.md                   # This file
```

## 🚀 Deployment Options

### Option 1: GitHub Pages (Recommended)

1. **Push docs to GitHub:**
   ```bash
   git add docs/
   git commit -m "Add documentation website"
   git push origin master
   ```

2. **Enable GitHub Pages:**
   - Go to your repository settings
   - Navigate to "Pages" section
   - Under "Source", select branch `master` and folder `/docs`
   - Click "Save"

3. **Access your site:**
   - Your documentation will be available at:
   - `https://arpitkatiyar1999.github.io/Country-Picker/`

### Option 2: Netlify

1. **Deploy via Netlify CLI:**
   ```bash
   npm install -g netlify-cli
   cd docs
   netlify deploy --prod --dir=.
   ```

2. **Or drag and drop:**
   - Go to https://app.netlify.com/drop
   - Drag the `docs` folder onto the page
   - Your site will be live instantly

### Option 3: Vercel

1. **Install Vercel CLI:**
   ```bash
   npm i -g vercel
   ```

2. **Deploy:**
   ```bash
   cd docs
   vercel --prod
   ```

### Option 4: Local Preview

For local development and testing:

```bash
# Using Python 3
cd docs
python3 -m http.server 8000

# Using Node.js
npx serve .

# Using PHP
php -S localhost:8000
```

Then visit: `http://localhost:8000`

## 🎨 Features

- ✅ **Responsive Design** - Works on desktop, tablet, and mobile
- ✅ **Dark/Light Mode** - Toggle between themes (preference saved)
- ✅ **Search Navigation** - Easy sidebar navigation
- ✅ **Copy Code Buttons** - One-click code copying
- ✅ **Smooth Animations** - Professional transitions and effects
- ✅ **Mobile Menu** - Hamburger menu for small screens
- ✅ **SEO Optimized** - Proper meta tags and structure

## 🛠️ Customization

### Changing Colors

Edit `assets/css/style.css` and modify the CSS variables in `:root`:

```css
:root {
  --primary-color: #2563eb;      /* Change primary color */
  --secondary-color: #10b981;    /* Change secondary color */
  /* ... more variables ... */
}
```

### Adding New Pages

1. Create new HTML file in `docs/` directory
2. Copy structure from existing pages
3. Update navigation in sidebar
4. Add link to header navigation if needed

### Modifying Navigation

Edit the sidebar navigation in each HTML file:

```html
<aside class="sidebar" id="sidebar">
    <nav>
        <!-- Add your navigation items here -->
    </nav>
</aside>
```

## 📝 Content Updates

### Updating Version

Update version badges in `index.html`:

```html
<span class="badge badge-primary">Version X.X.X</span>
```

### Updating Code Examples

Code blocks use syntax highlighting. Format:

```html
<pre><code class="language-kotlin">
// Your Kotlin code here
</code></pre>
```

Supported languages: `kotlin`, `groovy`, `xml`, `json`, `bash`

## 🧪 Testing Checklist

Before deploying, test:

- [ ] All pages load correctly
- [ ] Navigation links work
- [ ] Dark/Light mode toggle works
- [ ] Mobile menu functions properly
- [ ] Code copy buttons work
- [ ] All examples are accurate
- [ ] Links to GitHub/JitPack work
- [ ] Responsive design on mobile/tablet
- [ ] Cross-browser compatibility

## 📱 Mobile Testing

Test on:
- iOS Safari
- Android Chrome
- Mobile Firefox
- Tablet devices

## 🔍 SEO

Each page includes:
- Descriptive `<title>` tags
- Meta descriptions
- Open Graph tags (can be added)
- Semantic HTML structure

## 🐛 Known Issues

None currently. Report issues at:
https://github.com/arpitkatiyar1999/Country-Picker/issues

## 📄 License

The documentation is part of the Country-Picker project and follows the same Apache 2.0 license.

## 🤝 Contributing

To improve documentation:

1. Fork the repository
2. Create a branch for your changes
3. Update documentation files
4. Test thoroughly
5. Submit a pull request

## 📞 Support

For questions or issues:
- GitHub Issues: https://github.com/arpitkatiyar1999/Country-Picker/issues
- Documentation: https://arpitkatiyar1999.github.io/Country-Picker/

---

Built with ❤️ for the Country-Picker library
