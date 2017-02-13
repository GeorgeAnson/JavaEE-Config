
    $(document).ready(function () {
        $('#dataTables-example').dataTable();
        $(".selectbox").select2();
        $("#updateFream").hide();
        $("#serMessage").hide();

        $("#serRepairInfo").click(function(){
            updateFrameChk();
        });
        $("#delRepairLog").click(function(){
            delOp();
        });
    });

    function  getObjsByClass (param) {
        var tags = tags || document.getElementsByTagName("*");
        var list = [];
        for( var k in tags)
        {
            var tag = tags[k];
            if(tag.type == param) {
                //document.write(tag.innerHTML);
                list.push(tag);
            }
        }
        return list;
    }

    function showSerMessage(){
        $("#serMessage").fadeIn("fast");
    }

    function hideSerMessage(){
        $("#serMessage").fadeOut("fast");

    }

    function hideSerMessageTimer(){
        var timer = setTimeout("hideSerMessage()", 3000);
    }

function updateFrameChk(){
    var tabler = document.getElementById("dataTables-example");
    if(tabler.rows.length != 2){
        var objer = getObjsByClass("search");
        objer[0].focus();
        showSerMessage();
        hideSerMessageTimer();
    }else{
        var resId = document.getElementById("resId");
        resId.value = tabler.rows[1].cells[0].innerText;
        resId.click();

        var newResElement = document.getElementById("newResElement");
        newResElement.value = tabler.rows[1].cells[1].innerText;
        newResElement.click();

        var newQuestions = document.getElementById("newQuestions");
        newQuestions.value = tabler.rows[1].cells[2].innerText;
        newQuestions.click();

        var newResWay = document.getElementById("newResWay");
        newResWay.value = tabler.rows[1].cells[3].innerText;
        newResWay.click();

        var newResDate = document.getElementById("newResDate");
        newResDate.value = tabler.rows[1].cells[4].innerText;
        newResDate.click();

        var newResPersonal = document.getElementById("newResPersonal");
        newResPersonal.value = tabler.rows[1].cells[6].innerText;
        newResPersonal.click();

        $("#updateFream").slideDown("fast");
    }
    //rows[rowID].cells[colID].innerText
}
//tabler.rows.length


function delOp(){
    var tabler = document.getElementById("dataTables-example");
    if(tabler.rows.length != 2){
        var objer = getObjsByClass("search");
        objer[0].focus();
        showSerMessage();
        hideSerMessageTimer();
    }else{
        $.messager.confirm("删除", "确定删除吗!?", function() {
        //删除之后的跳转操作

        });
    }
}
