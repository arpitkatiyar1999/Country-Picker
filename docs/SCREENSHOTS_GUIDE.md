# Screenshots Guide for Documentation

This guide will help you take and add screenshots to the documentation website.

## Screenshots Needed

### 1. CountryPicker Component (`screenshots/`)

**File: `country-picker-default.png`**
- Demo: CountryPickerWithoutTextField screen
- Show: Default view with flag + phone code + dropdown icon
- Size: 1080x400px (approx)

**File: `country-picker-dialog.png`**
- Demo: CountryPickerWithoutTextField screen
- Show: Dialog open with country list, search bar at top
- Highlight: Search functionality, scrollable list
- Size: 1080x1920px (full screen)

**File: `country-picker-bottomsheet.png`**
- Demo: CountryPickerWithoutTextField screen (set to BottomSheet mode)
- Show: BottomSheet sliding up from bottom
- Size: 1080x1920px (full screen)

**File: `country-picker-search.png`**
- Demo: CountryPickerWithoutTextField screen
- Show: Search in action with filtered results (e.g., search "united")
- Size: 1080x1920px

### 2. CountryPickerOutlinedTextField (`screenshots/`)

**File: `textfield-empty.png`**
- Demo: CountryPickerWithOutlinedTextField screen
- Show: Empty text field with placeholder
- Size: 1080x200px

**File: `textfield-valid.png`**
- Demo: CountryPickerWithOutlinedTextField screen
- Show: Valid phone number entered with green checkmark/success message
- Size: 1080x200px

**File: `textfield-invalid.png`**
- Demo: CountryPickerWithOutlinedTextField screen
- Show: Invalid phone number with error state (red border, error message)
- Size: 1080x200px

**File: `textfield-example.png`**
- Demo: CountryPickerWithOutlinedTextField screen
- Show: Placeholder showing example number format
- Size: 1080x200px

### 3. Customization Examples (`features/`)

**File: `customization-colors.png`**
- Demo: Modify colors in demo app
- Show: Custom themed picker (different colors)
- Size: 1080x400px

**File: `customization-shapes.png`**
- Demo: Change flag shapes
- Show: Rounded vs rectangle flag shapes side-by-side
- Size: 1080x400px

**File: `customization-text-styles.png`**
- Demo: Modify text styles
- Show: Different font sizes, weights
- Size: 1080x400px

### 4. Feature Highlights (`features/`)

**File: `feature-countries-grid.png`**
- Demo: Show multiple countries in list
- Show: Scrollable country list with flags
- Size: 1080x600px

**File: `feature-auto-detection.png`**
- Demo: First load showing auto-detected country
- Show: Country auto-selected based on device
- Size: 1080x400px

## How to Take Screenshots

### Using Android Studio

1. **Run the demo app:**
   ```bash
   ./gradlew installDebug
   # OR use Android Studio Run button
   ```

2. **Navigate to demo screens:**
   - MainActivity shows navigation buttons
   - Click "CountryPicker" or "CountryPickerOutlinedTextField"

3. **Take screenshot:**
   - **Android Studio**: Camera icon in device toolbar
   - **ADB**: `adb exec-out screencap -p > screenshot.png`
   - **Device**: Power + Volume Down (varies by device)

4. **Save to docs/assets/images/screenshots/**

### Image Optimization

After taking screenshots:

```bash
# Resize if needed (using ImageMagick)
convert screenshot.png -resize 1080x screenshot_resized.png

# Optimize file size
# Option 1: Using ImageOptim (Mac)
# Option 2: Using online tool like tinypng.com
# Option 3: Using CLI tools
pngquant screenshot.png --output screenshot_optimized.png
```

## Adding Screenshots to Documentation

Screenshots are already referenced in the HTML files. Just save your images with the correct filenames:

### File Naming Convention:
- Lowercase, hyphen-separated
- Descriptive names
- Format: `component-state-variant.png`
- Examples:
  - `country-picker-dialog.png`
  - `textfield-validation-error.png`
  - `customization-rounded-flags.png`

### Supported Image Locations:

All paths relative to `docs/assets/images/`:

- `screenshots/` - Component screenshots
- `features/` - Feature demonstrations
- `examples/` - Real-world examples

## Quick Checklist

Before screenshots:
- [ ] Clean demo app UI (remove unnecessary elements)
- [ ] Use consistent device/emulator (same size)
- [ ] Good lighting/contrast
- [ ] Focus on the relevant component
- [ ] Show realistic data (proper phone numbers, country names)

After screenshots:
- [ ] Optimize image sizes (< 200KB each)
- [ ] Use consistent dimensions
- [ ] Name files according to guide
- [ ] Place in correct directories
- [ ] Test in documentation (open index.html)

## Need Help?

The documentation is set up to automatically display images when you add them to the correct locations. If images don't appear:

1. Check file names match exactly (case-sensitive)
2. Ensure images are in `docs/assets/images/` subdirectories
3. Clear browser cache and refresh
4. Check browser console for 404 errors

---

**Tip:** You can start with just a few key screenshots and add more later. The most important ones are:
1. `country-picker-dialog.png`
2. `textfield-valid.png`
3. `textfield-invalid.png`
