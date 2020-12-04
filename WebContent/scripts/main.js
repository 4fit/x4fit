// $(function (){
//     $('[data-toggle="popover"]').popover();
// });



$(document).ready(function () {
	
document.getElementById("btnWrite").onclick();

    // ANIMATEDLY DISPLAY THE NOTIFICATION COUNTER.
    $('#noti_Counter')
        .css({ opacity: 0 })
        .text('7')      // ADD DYNAMIC VALUE (YOU CAN EXTRACT DATA FROM DATABASE OR XML).
        .css({ top: '-10px' })
        .animate({ top: '-2px', opacity: 1 }, 500);

    $('#btnNotication').click(function () {

        // TOGGLE (SHOW OR HIDE) NOTIFICATION WINDOW.
        $('#notifications').fadeToggle('fast', 'linear', function () {
            if ($('#notifications').is(':hidden')) {
                $('#btnNotication').css('background-color', 'transparent');
            }
            // CHANGE BACKGROUND COLOR OF THE BUTTON.
            else $('#btnNotication').css('background-color', 'transparent');
        });

        $('#noti_Counter').fadeOut('slow');     // HIDE THE COUNTER.

        return false;
    });

    $('#btnInfoWeb').click(function () {

        // TOGGLE (SHOW OR HIDE) INFOWWEB WINDOW.
        $('#infoWeb').fadeToggle('fast', 'linear', function () {
            if ($('#infoWeb').is(':hidden')) {
                $('#infoWeb').css('background-color', 'transparent');
            }
            // CHANGE BACKGROUND COLOR OF THE BUTTON.
            else $('#btnInfoWeb').css('background-color', 'transparent');
        });
        return false;
    });


     // HIDE INFOWWEB WHEN CLICKED ANYWHERE ON THE PAGE.
     $(document).click(function () {
        $('#infoWeb').hide();
    });

    $('#notifications').click(function () {
        return false;       // DO NOTHING WHEN CONTAINER IS CLICKED.
    });

    // HIDE NOTIFICATIONS WHEN CLICKED ANYWHERE ON THE PAGE.
    $(document).click(function () {
        $('#notifications').hide();

        // CHECK IF NOTIFICATION COUNTER IS HIDDEN.
        if ($('#noti_Counter').is(':hidden')) {
            // CHANGE BACKGROUND COLOR OF THE BUTTON.
            $('#btnNotication').css('background-color', 'transparent');
        }
    });

    $('#notifications').click(function () {
        return false;       // DO NOTHING WHEN CONTAINER IS CLICKED.
    });
});

const inputs = document.querySelectorAll(".form-control");

function AddClass(){
    let parent = this.parentNode.parentNode;
    parent.classList.add("focus");
}

function RemoveClass(){
   let parent = this.parentNode.parentNode;
   if(this.value == ''){
       parent.classList.remove("focus");
   }
}

inputs.forEach(input => {
   input.addEventListener("focus", AddClass);
   input.addEventListener("blur", RemoveClass);
});



function openComment(evt, nameAct) {
    // Declare all variables
    var i, tabcontent, tablinks;
  //alert(nameAct);
    // Get all elements with class="tabcontent" and hide them
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
  
    // Get all elements with class="tablinks" and remove the class "active"
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
      tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
  
    // Show the current tab, and add an "active" class to the button that opened the tab
    document.getElementById(nameAct).style.display = "block";
    evt.currentTarget.className += " active";
  }

