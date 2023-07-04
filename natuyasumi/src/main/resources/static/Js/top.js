
$(function(){
  $(".has-sub").mouseover(function(){
    $(this).children(".sub").stop().slideDown();
  });
  $(".has-sub").mouseout(function(){
    $(".sub").stop().slideUp();
  });
});

$(document).ready(function() {
  $('#user_container').submit(function(event) {
    event.preventDefault();
    $('#sessionmessage').hide();
    this.submit();
  });
});

