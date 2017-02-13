
    $(document).ready(function () {
        $('#dataTables-example').dataTable();
        $("#serMessage").hide();
        $(".selectbox").select2();
        $("#updateFream").hide();
        $("#serProjectInfo").click(function(){
            updateFrameChk();
        });
        $("#delProjectInfo").click(function(){
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
        var ProjectId = document.getElementById("ProjectId");
        ProjectId.value = tabler.rows[1].cells[0].innerText;
        ProjectId.click();

        var newProjectName = document.getElementById("newProjectName");
        newProjectName.value = tabler.rows[1].cells[1].innerText;
        newProjectName.click();

        var newProjectEntruster = document.getElementById("newProjectEntruster");
        newProjectEntruster.value = tabler.rows[1].cells[2].innerText;
        newProjectEntruster.click();
        
        var newProjectStartDate = document.getElementById("newProjectStartDate");
        newProjectStartDate.value = tabler.rows[1].cells[4].innerText;
        newProjectStartDate.click();

        var newProjectEndDate = document.getElementById("newProjectEndDate");
        newProjectEndDate.value = tabler.rows[1].cells[5].innerText;
        newProjectEndDate.click();
 
        $("#updateFream").slideDown("fast");
    }
}


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
        	 var projectId=document.getElementById("ProjectId");
        	 projectId.value=tabler.rows[1].cells[0].innerText;
        	 projectId.click();
        	$.get('/EasyShare/projects.html?type=delete&id='+projectId.value);
        });
    }
}
