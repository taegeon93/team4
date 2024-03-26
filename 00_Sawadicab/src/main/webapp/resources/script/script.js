const carousel = document.querySelector(".carousel"),
arrowIcons = document.querySelectorAll(".wrapper i");
let firstImg = carousel.querySelectorAll("img")[0];

let isDragStart = false, isDragging = false, prevPageX, prevScrollLeft, positionDiff;

const showHideIcons = () => {
    let scrollWidth = carousel.scrollWidth - carousel.clientWidth;
    arrowIcons[0].style.display = carousel.scrollLeft == 0 ? "none" : "block";
    arrowIcons[1].style.display = carousel.scrollLeft == scrollWidth ? "none" : "block";
}

arrowIcons.forEach(icon => {
    icon.addEventListener("click", () => {
        let firstImgWidth = firstImg.clientWidth + 65;
        carousel.scrollLeft += icon.id == "left" ? -firstImgWidth : firstImgWidth;
        setTimeout(() => showHideIcons(), 60);
    });
});

const autoSlide = () => {
    if(carousel.scrollLeft - (carousel.scrollWidth - carousel.clientWidth) > -1 || carousel.scrollLeft <= 0) return;

    positionDiff = Math.abs(positionDiff);
    let firstImgWidth = firstImg.clientWidth + 14;
    let valDifference = firstImgWidth - positionDiff;

    if(carousel.scrollLeft > prevScrollLeft) {
        return carousel.scrollLeft += positionDiff > firstImgWidth / 3 ? valDifference : -positionDiff;
    }
    carousel.scrollLeft -= positionDiff > firstImgWidth / 3 ? valDifference : -positionDiff;
}

$(function(){
    $.ajax({
        url: 'select.co',
        type: 'get',
        success: function(list){
            console.log(typeof list, list);
            console.log("성공");

            list.forEach (function (el, index) {
                var result = `
                <div>
                    <img src="/Sawadicab/resources/img/company/${el.companyNum}/${el.companypicture}" alt="img" draggable="false">
                    <div>
                        <div class="crtext-area">
                            <span class="title">${el.companyName}</span>
                            <span class="score">★<span>${el.score}</span></span>
                        </div>
                        ${el.companyAddress}
                    </div>
                </div>
                `;

                // $(".carousel").html(result);
                document.getElementById("test11").innerHTML += result;

                firstImg = carousel.querySelectorAll("img")[0];
              });
        },
        error:function (error) {
            console.log(error);
        }
    });
})