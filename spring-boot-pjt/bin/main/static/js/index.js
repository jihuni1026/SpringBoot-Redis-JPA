var main = {
    init : function () {
        var _this = this;
        $('#btn-req').on('click', function () {
            var originalurl =  $("#original-url").val();
            if (_this.validation_url(originalurl)) {
                _this.make_url(originalurl);             
            } else {
                alert("URL을 확인해주세요.");
            }
            
        })
    },
    // Shortening URL Request
    make_url : function (originalurl) {
        $.ajax({
            type : 'POST',
            cache : false,
            url : '/shortening',
            data : { 
                'originalurl' : originalurl
            },
            dataType : 'json'
        }).done(function (data) {
            alert('단축 URL 생성이 완료되었습니다.');
            $("#shortening-url").text("");
            $("#shortening-url").append(window.location.origin + "/" + data.shorteningurl);
            $("#shortening-url").parent().show();
        }).fail(function (error) {
            console.log(JSON.stringify(error));
        })
    },
    // URL validate
    validation_url : function (originalurl) {
        let regex = /(http|https):\/\/(\w+:{0,1}\w*@)?(\S+)(:[0-9]+)?(\/|\/([\w#!:.?+=&%@!\-\/]))?/
        return regex.test(originalurl);
    }
 };
 
 main.init();