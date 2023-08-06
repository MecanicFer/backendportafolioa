const ovniImg = document.getElementById("ovni");

      function flyOvni() {
         ovniImg.classList.add("ovni");

          setTimeout(() => {
            ovniImg.classList.remove("ovni");
            ovniImg.classList.add("ovni-positioned");
          }, 2000);
      }

      flyOvni();