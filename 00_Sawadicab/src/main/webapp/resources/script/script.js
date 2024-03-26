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
            var today = new Date();

            var year = today.getFullYear();
            var month = ('0' + (today.getMonth() + 1)).slice(-2);
            var day = ('0' + today.getDate()).slice(-2);
            var nextday = ('0' + (today.getDate()+1)).slice(-2);

            var date = year + '-' + month + '-' + day;
            var nextDate = year + '-' + month + '-' + nextday;
            

            list.forEach (function (el, index) {
                var result = `
                <div onclick="location.href='/Sawadicab/detail.me?companyNum=${el.companyNum}&checkin=${date}&checkout=${nextDate}'">
                    <img src="/Sawadicab/resources/img/company/${el.companyNum}/${el.companypicture}" alt="img" draggable="false">
                    <div>
                        <div class="crtext-area">
                            <span class="title">${el.companyName}</span>
                            <span class="score">★<span>${el.score.toFixed(1)}</span></span>
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