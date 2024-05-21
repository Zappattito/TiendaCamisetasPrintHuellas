document.getElementById('imageInput').addEventListener('change', function(event) {
    const file = event.target.files[0];
    const reader = new FileReader();
    const imageContainer = document.getElementById('diseno');

    reader.onload = function(e) {
        const img = document.createElement('img');
        img.src = e.target.result;
        imageContainer.innerHTML = ''; // Clear any existing content
        imageContainer.appendChild(img); // Add the new image
    };

    if (file) {
        reader.readAsDataURL(file); // Read the file as a data URL
    }
});
