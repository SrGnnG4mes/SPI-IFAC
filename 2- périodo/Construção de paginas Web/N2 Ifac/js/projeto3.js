const images = document.querySelectorAll(".carousel-container img");
const prevBtn = document.querySelector(".prev");
const nextBtn = document.querySelector(".next");

let index = 0;

function showImage(index) {
    images.forEach(img => img.classList.remove("active"));
    images[index].classList.add("active");
}

prevBtn.addEventListener("click", () => {
    index = (index - 1 + images.length) % images.length;
    showImage(index);
});

nextBtn.addEventListener("click", () => {
    index = (index + 1) % images.length;
    showImage(index);
});

showImage(index);
